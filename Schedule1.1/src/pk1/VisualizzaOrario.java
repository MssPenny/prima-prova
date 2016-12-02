package pk1;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import javax.swing.WindowConstants;

import business.entity.BO;
import business.entity.Identificato;
import business.entity.Orario;
import dao.DaoOrario;

import javax.swing.SwingUtilities;

/**
 * All'interno della seguente classe è possibile selezionere il corso di laurea
 * ed il relativo corso d'insegnamento, in modo da poter visualizzare l'orario
 * di ricevimento che è stato associato a tale corso d'insegnamento.
 */
public class VisualizzaOrario extends javax.swing.JFrame implements ActionListener {
	private JPanel jPanel1;
	private JLabel jLabelTitolo;
	private JComboBox jComboBoxCorsoLaurea;
	private JButton jButtonIndice;
	private JButton jButtonVediOrario;
	private JPanel jPanel4;
	private JComboBox jComboBoxInsegnamento;
	private JLabel jLabelInsegnamento;
	private JButton jButtonVediInsegnamento;
	private JLabel jLabelCorsiLaurea;
	private JPanel jPanel3;
	private JLabel jLabelSottotitolo;
	private JPanel jPanel2;
	public MenuGestioneOrario g2;
	public Vector<String> vettore, vins;
	public String pLogin, pPassword;
	ApplicationController ac = new ApplicationController();
	public Object[] vetto;

	public VisualizzaOrario(MenuGestioneOrario g) {
		super();
		g2 = g;
		initGUI();
	}

	private void initGUI() {
		pLogin = g2.pLogin;
		pPassword = g2.pPassword;

		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("VISUALIZZA ORARIO");
			{
				jPanel1 = new JPanel();
				BorderLayout jPanel1Layout = new BorderLayout();
				jPanel1.setLayout(jPanel1Layout);
				getContentPane().add(jPanel1, BorderLayout.CENTER);
				{
					jPanel2 = new JPanel();
					GridBagLayout jPanel2Layout = new GridBagLayout();
					jPanel1.add(jPanel2, BorderLayout.NORTH);
					jPanel2.setPreferredSize(new java.awt.Dimension(692, 83));
					jPanel2Layout.rowWeights = new double[] { 0.1, 0.1 };
					jPanel2Layout.rowHeights = new int[] { 7, 7 };
					jPanel2Layout.columnWeights = new double[] { 0.1 };
					jPanel2Layout.columnWidths = new int[] { 7 };
					jPanel2.setLayout(jPanel2Layout);
					{
						jLabelTitolo = new JLabel();
						jPanel2.add(jLabelTitolo, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
								GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						jLabelTitolo.setText("Visualizza orario");
						jLabelTitolo.setFont(new java.awt.Font("Arial", 0, 18));
					}
					{
						jLabelSottotitolo = new JLabel();
						jPanel2.add(jLabelSottotitolo, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
								GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						jLabelSottotitolo.setText("Visualizza l'orario di ciascun insegnamento selezionato");
						jLabelSottotitolo.setFont(new java.awt.Font("Tahoma", 0, 16));
					}
				}
				{
					jPanel3 = new JPanel();
					GridBagLayout jPanel3Layout = new GridBagLayout();
					jPanel1.add(jPanel3, BorderLayout.WEST);
					jPanel3.setPreferredSize(new java.awt.Dimension(351, 483));
					jPanel3Layout.rowWeights = new double[] { 0.1, 0.1, 0.1, 0.1, 0.1, 0.1 };
					jPanel3Layout.rowHeights = new int[] { 7, 7, 7, 7, 20, 20 };
					jPanel3Layout.columnWeights = new double[] { 0.0, 0.1 };
					jPanel3Layout.columnWidths = new int[] { 7, 7 };
					jPanel3.setLayout(jPanel3Layout);
					{
						jLabelCorsiLaurea = new JLabel();
						jPanel3.add(jLabelCorsiLaurea, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
								GridBagConstraints.SOUTHWEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						jLabelCorsiLaurea.setText("Seleziona il corso di laurea:");
					}

					{
						jLabelInsegnamento = new JLabel();
						jPanel3.add(jLabelInsegnamento, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0,
								GridBagConstraints.SOUTHWEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						jLabelInsegnamento.setText("Seleziona il corso d'insegnamento:");
					}

				}
				{
					jPanel4 = new JPanel();
					GridBagLayout jPanel4Layout = new GridBagLayout();
					jPanel1.add(jPanel4, BorderLayout.CENTER);
					jPanel4Layout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.1, 0.1 };
					jPanel4Layout.rowHeights = new int[] { 50, 50, 50, 50, 20, 7 };
					jPanel4Layout.columnWeights = new double[] { 0.0, 0.0, 0.1 };
					jPanel4Layout.columnWidths = new int[] { 120, 120, 7 };
					jPanel4.setLayout(jPanel4Layout);

					{
						jButtonIndice = new JButton();
						jPanel4.add(jButtonIndice,
								new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
										GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
						jButtonIndice.setText("Indice");
						jButtonIndice.addActionListener(this);

						{
							ComboBoxModel jComboBoxInsegnamentoModel = new DefaultComboBoxModel();
							jComboBoxInsegnamento = new JComboBox();
							jPanel3.add(jComboBoxInsegnamento,
									new GridBagConstraints(1, 4, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
											GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
							jComboBoxInsegnamento.setModel(jComboBoxInsegnamentoModel);
							jComboBoxInsegnamento.enable(false);
						}

						try {

							LinkedHashMap<String, Object> p = new LinkedHashMap<>();
							p.put("Login", pLogin);
							p.put("Password", pPassword);
							List<Identificato> b = (List<Identificato>) ac.handleRequest("VisualizzaAssociaDoc", p);
							Vector<String> bv = new Vector<>();
							for (Identificato identificato : b) {
								bv.add(identificato.getCorsoLaurea());

							}
							{
								ComboBoxModel jComboBoxCorsoLaureaModel = new DefaultComboBoxModel(bv);
								jComboBoxCorsoLaurea = new JComboBox();
								jPanel3.add(jComboBoxCorsoLaurea,
										new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
												GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
								jComboBoxCorsoLaurea.setModel(jComboBoxCorsoLaureaModel);
							}

							vetto = b.toArray();

						} catch (Exception exc) {
							JOptionPane.showMessageDialog(null, "Primo errore" + exc.getMessage());
						}

						{
							String pCorso = vettore.get(jComboBoxCorsoLaurea.getSelectedIndex());
							int indiceIns;
							indiceIns = jComboBoxInsegnamento.getSelectedIndex();
							String pIns = (String) jComboBoxInsegnamento.getItemAt(indiceIns);

							String pLogin = null;
							String pPassword = null;
							{

								try {
									LinkedHashMap<String, Object> pi = new LinkedHashMap<>();
									pi.put("corsoLaurea", pCorso);
									pi.put("nomeInse", pIns);
									List<Orario> listaO = (List<Orario>) ac.handleRequest("VisualizzaOrari", pi);
								}

								catch (Exception exc) {
									System.err.println("Errore" + exc);
								}

							}

						}

						{
							jButtonVediOrario = new JButton();
							jPanel4.add(jButtonVediOrario,
									new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
											GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
							jButtonVediOrario.setText("Vedi orario");
							jButtonVediOrario.setVisible(false);
							jButtonVediOrario.addActionListener(this);

						}

						{
							jButtonVediInsegnamento = new JButton();
							jPanel3.add(jButtonVediInsegnamento, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0,
									GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
							jButtonVediInsegnamento.setText("Vedi insegnamento");
							jButtonVediInsegnamento.addActionListener(this);
						}

					}
				}
			}
			pack();
			this.setSize(700, 600);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if (e.getActionCommand().equalsIgnoreCase("Indice")) {
			setVisible(false);
			g2.setVisible(true);
		}

		if (e.getActionCommand().equalsIgnoreCase("Vedi orario")) {
			String pCorso = vettore.get(jComboBoxCorsoLaurea.getSelectedIndex());
			String pIns = vins.get(jComboBoxInsegnamento.getSelectedIndex());

			if (pCorso.equals(" ") && pIns.equals(" ")) {
				JOptionPane.showMessageDialog(null, "Seleziona sia il corso di laurea che l'insegnamento...");
			} else {
				OrarioRicevimento orario = new OrarioRicevimento(pIns, pCorso);
				orario.setVisible(true);
			}
		}

		if (e.getActionCommand().equalsIgnoreCase("Vedi insegnamento")) {
			String pCorso = vettore.get(jComboBoxCorsoLaurea.getSelectedIndex());

			try {
				DaoOrario daoo = new DaoOrario();
				LinkedHashMap<String, Object> hash = new LinkedHashMap<>();
				hash.put("identificato", new Identificato(pLogin, pPassword));
				hash.put("orario", new Orario(pCorso));
				// List<BO> v=(List<BO>)
				// ac.handleRequest("VisualizzaOrariCorso", hash);
				LinkedList<Orario> l = (LinkedList<Orario>) ac.handleRequest("VisualizzaOrariCorso", hash);

				Vector<String> v = new Vector<>();
				v.add(" ");
				for (Orario orario : l) {
					v.add(orario.getNomeInsegn());
				}

				ComboBoxModel jComboBoxjComboBoxInsegnamentoModel = new DefaultComboBoxModel(v.toArray());
				jComboBoxInsegnamento.setModel(jComboBoxjComboBoxInsegnamentoModel);

				jComboBoxInsegnamento.enable(true);

				jButtonVediOrario.setVisible(true);

				vetto = v.toArray();

			} catch (Exception exc) {
				JOptionPane.showMessageDialog(null, "Errore nel caricamento del driver..." + exc.getMessage());
			}
		}

	}

}
