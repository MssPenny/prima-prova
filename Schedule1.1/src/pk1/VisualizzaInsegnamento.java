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
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import business.entity.BO;
import business.entity.Corso;
import business.entity.Insegnamento;
import dao.Dao;
import dao.DaoCorso;
import dao.DaoInsegnamento;

import javax.swing.SwingUtilities;

/**
 * La seguente classe visualizza le informazioni in dettaglio dei corsi di
 * insegnamento che sono presenti all'interno del Dipartimento di Informatica;
 * inoltre, una volta visualizzati tali dati, l'amministratore del sistema può
 * decidere di modificare le informazioni relative al corso di insegnamento
 * visualizzato e salvare nuovamente le modifiche apportate. Le modifiche,
 * relative ai dati del corso di insegnamento visualizzato, verranno salvate
 * all'interno del database del sistema.
 */
public class VisualizzaInsegnamento extends javax.swing.JFrame implements ActionListener {
	private JPanel jPanel1;
	private JLabel jLabelTitolo;
	private JComboBox jComboBoxLaboratorio;
	private JButton jButtonIndietro;
	private JButton jButtonSalva;
	private JPanel jPanel5;
	private JLabel jLabelITPS;
	private JLabel jLabelICD;
	private JLabel jLabelLegenda;
	private JLabel jLabelValutazione;
	private JLabel jLabelLaboratorio;
	private JComboBox jComboBoxPropedeutico;
	private JLabel jLabelPropedeutico;
	private JComboBox jComboBoxAnno;
	private JComboBox jComboBoxCorsoLaurea;
	private JComboBox jComboBoxValutazione;
	private JLabel jLabelAnno;
	private JTextField jTextFieldCrediti;
	private JLabel jLabelCrediti;
	private JLabel jLabelCorsoLaurea;
	private JTextField jTextFieldNomeInsegn;
	private JLabel jLabelNomeInseg;
	private JPanel jPanel4;
	private JPanel jPanel3;
	private JLabel jLabelSottotitolo;
	private JPanel jPanel2;
	public String[] a2, a3, a4, a5;
	public String h, c;
	public Object[] vettore;
	ApplicationController ac = new ApplicationController();

	public VisualizzaInsegnamento(String h1, String c1) {
		super();
		h = h1;
		c = c1;
		initGUI();
	}

	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("VISUALIZZA INSEGNAMENTO");
			{
				jPanel1 = new JPanel();
				BorderLayout jPanel1Layout = new BorderLayout();
				jPanel1.setLayout(jPanel1Layout);
				getContentPane().add(jPanel1, BorderLayout.CENTER);
				{
					jPanel2 = new JPanel();
					GridBagLayout jPanel2Layout = new GridBagLayout();
					jPanel1.add(jPanel2, BorderLayout.NORTH);
					jPanel2.setPreferredSize(new java.awt.Dimension(692, 78));
					jPanel2Layout.rowWeights = new double[] { 0.1, 0.1 };
					jPanel2Layout.rowHeights = new int[] { 7, 7 };
					jPanel2Layout.columnWeights = new double[] { 0.1 };
					jPanel2Layout.columnWidths = new int[] { 7 };
					jPanel2.setLayout(jPanel2Layout);
					{
						jLabelTitolo = new JLabel();
						jPanel2.add(jLabelTitolo, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
								GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						jLabelTitolo.setText("Visualizza Insegnamento");
						jLabelTitolo.setFont(new java.awt.Font("Arial", 0, 18));
					}
					{
						jLabelSottotitolo = new JLabel();
						jPanel2.add(jLabelSottotitolo, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
								GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						jLabelSottotitolo.setText("Visualizza/Modifica i dati dell'insegnamento selezionato");
						jLabelSottotitolo.setFont(new java.awt.Font("Tahoma", 0, 16));
					}
				}
				{
					jPanel3 = new JPanel();
					GridBagLayout jPanel3Layout = new GridBagLayout();
					jPanel1.add(jPanel3, BorderLayout.WEST);
					jPanel3.setPreferredSize(new java.awt.Dimension(351, 488));
					jPanel3Layout.rowWeights = new double[] { 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1 };
					jPanel3Layout.rowHeights = new int[] { 20, 7, 7, 7, 7, 20, 20, 20, 20 };
					jPanel3Layout.columnWeights = new double[] { 0.1, 0.1 };
					jPanel3Layout.columnWidths = new int[] { 7, 7 };
					jPanel3.setLayout(jPanel3Layout);
					{
						jLabelNomeInseg = new JLabel();
						jPanel3.add(jLabelNomeInseg, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
								GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						jLabelNomeInseg.setText("Nome insegnamento");
					}
					{
						jTextFieldNomeInsegn = new JTextField();
						jPanel3.add(jTextFieldNomeInsegn,
								new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
										GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
					}
					{
						jLabelCorsoLaurea = new JLabel();
						jPanel3.add(jLabelCorsoLaurea, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
								GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						jLabelCorsoLaurea.setText("Corso di laurea");
					}

					{
						jLabelCrediti = new JLabel();
						jPanel3.add(jLabelCrediti, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0,
								GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						jLabelCrediti.setText("Crediti");
					}
					{
						jTextFieldCrediti = new JTextField();
						jPanel3.add(jTextFieldCrediti,
								new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
										GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
					}
					{
						jLabelAnno = new JLabel();
						jPanel3.add(jLabelAnno, new GridBagConstraints(0, 4, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
								GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						jLabelAnno.setText("Anno");
					}
					{
						a2 = new String[] { " ", "1°", "2°", "3°", "1° Spec.", "2° Spec." };
						ComboBoxModel jComboBoxAnnoModel = new DefaultComboBoxModel(a2);

						jComboBoxAnno = new JComboBox();
						jPanel3.add(jComboBoxAnno,
								new GridBagConstraints(1, 4, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
										GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
						jComboBoxAnno.setModel(jComboBoxAnnoModel);
					}
					{
						jLabelPropedeutico = new JLabel();
						jPanel3.add(jLabelPropedeutico, new GridBagConstraints(0, 5, 1, 1, 0.0, 0.0,
								GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						jLabelPropedeutico.setText("Propedeutico");
					}
					{
						a3 = new String[] { " ", "SI", "NO" };
						ComboBoxModel jComboBoxPropedeuticoModel = new DefaultComboBoxModel(a3);

						jComboBoxPropedeutico = new JComboBox();
						jPanel3.add(jComboBoxPropedeutico,
								new GridBagConstraints(1, 5, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
										GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
						jComboBoxPropedeutico.setModel(jComboBoxPropedeuticoModel);
					}
					{
						jLabelLaboratorio = new JLabel();
						jPanel3.add(jLabelLaboratorio, new GridBagConstraints(0, 6, 1, 1, 0.0, 0.0,
								GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						jLabelLaboratorio.setText("Laboratorio");
					}
					{
						jLabelValutazione = new JLabel();
						jPanel3.add(jLabelValutazione, new GridBagConstraints(0, 7, 1, 1, 0.0, 0.0,
								GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						jLabelValutazione.setText("Prova di valutazione");
					}
					{
						a4 = new String[] { " ", "SI", "NO" };
						ComboBoxModel jComboBoxLaboratorioModel = new DefaultComboBoxModel(a4);

						jComboBoxLaboratorio = new JComboBox();
						jPanel3.add(jComboBoxLaboratorio,
								new GridBagConstraints(1, 6, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
										GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
						jComboBoxLaboratorio.setModel(jComboBoxLaboratorioModel);
					}
					{
						a5 = new String[] { " ", "Esame", "Idonietà" };
						ComboBoxModel jComboBoxValutazioneModel = new DefaultComboBoxModel(a5);

						jComboBoxValutazione = new JComboBox();
						jPanel3.add(jComboBoxValutazione,
								new GridBagConstraints(1, 7, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
										GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
						jComboBoxValutazione.setModel(jComboBoxValutazioneModel);
					}
				}
				{
					jPanel4 = new JPanel();
					GridBagLayout jPanel4Layout = new GridBagLayout();
					jPanel1.add(jPanel4, BorderLayout.SOUTH);
					jPanel4.setPreferredSize(new java.awt.Dimension(692, 78));
					jPanel4Layout.rowWeights = new double[] { 0.1, 0.1, 0.1 };
					jPanel4Layout.rowHeights = new int[] { 7, 7, 7 };
					jPanel4Layout.columnWeights = new double[] { 0.0, 0.1 };
					jPanel4Layout.columnWidths = new int[] { 7, 7 };
					jPanel4.setLayout(jPanel4Layout);
					{
						jLabelLegenda = new JLabel();
						jPanel4.add(jLabelLegenda, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST,
								GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						jLabelLegenda.setText("Legenda, CORSI DI LAUREA:");
					}
					{
						jLabelICD = new JLabel();
						jPanel4.add(jLabelICD, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.WEST,
								GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						jLabelICD.setText("ICD: Informatica e Comunicazione Digitale");
					}
					{
						jLabelITPS = new JLabel();
						jPanel4.add(jLabelITPS, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0, GridBagConstraints.WEST,
								GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						jLabelITPS.setText("ITPS: Informatica e Tecnologie per la Produzione del Software");
					}
				}
				{
					jPanel5 = new JPanel();
					GridBagLayout jPanel5Layout = new GridBagLayout();
					jPanel1.add(jPanel5, BorderLayout.CENTER);
					jPanel5Layout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.1, 0.1 };
					jPanel5Layout.rowHeights = new int[] { 50, 50, 50, 7, 7 };
					jPanel5Layout.columnWeights = new double[] { 0.0, 0.0, 0.1 };
					jPanel5Layout.columnWidths = new int[] { 120, 120, 7 };
					jPanel5.setLayout(jPanel5Layout);
					{
						jButtonSalva = new JButton();
						jPanel5.add(jButtonSalva,
								new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
										GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
						jButtonSalva.setText("Salva");
						jButtonSalva.addActionListener(this);
					}
					{
						jButtonIndietro = new JButton();
						jPanel5.add(jButtonIndietro,
								new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
										GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
						jButtonIndietro.setText("Indietro");
						jButtonIndietro.addActionListener(this);

						try {
							Class.forName("com.mysql.jdbc.Driver");
						} catch (Exception e1) {
							System.err.println("Errore nel caricamento del Driver");
						}

						try {
							LinkedHashMap<String, Object> p = new LinkedHashMap<>();
							p.put("nomeCorso", " ");
							List<BO> v = (List<BO>) ac.handleRequest("VisualizzaInsegnamento", p);
							{
								ComboBoxModel jComboBoxCorsoLaureaModel = new DefaultComboBoxModel(v.toArray());

								jComboBoxCorsoLaurea = new JComboBox();
								jPanel3.add(jComboBoxCorsoLaurea,
										new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
												GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
								jComboBoxCorsoLaurea.setModel(jComboBoxCorsoLaureaModel);
							}

							vettore = v.toArray();

						} catch (Exception exc) {
							JOptionPane.showMessageDialog(null, "Errore aggiornamento database..." + exc.getMessage());
						}

					}

					try {
						Class.forName("com.mysql.jdbc.Driver");
					} catch (Exception e1) {
						System.err.println("Errore nel caricamento del driver ");
					}

					try {
						LinkedHashMap<String, Object> pi = new LinkedHashMap<>();
						pi.put("corsoLaurea", h);
						pi.put("nomeCorso", c);
						List<Insegnamento> listaI = (List<Insegnamento>) ac
								.handleRequest("VisualizzaInsegnamentoConNomeCorso", pi);
						for (int i = 0; i < listaI.size(); i++) {
							jTextFieldNomeInsegn.setText(listaI.get(i).getNome());
							jTextFieldCrediti.setText(String.valueOf(listaI.get(i).getnCrediti()));

							// deve restituire il valore del vettore come
							// stringa

							int p = 0, posizione = 0;
							while (posizione == 0) {
								if (listaI.get(0).getNome()
										.compareTo((String) jComboBoxCorsoLaurea.getItemAt(p)) == 0) {
									posizione = p;
								} else
									p++;
							}

							jComboBoxCorsoLaurea.setSelectedIndex(posizione);

							int index;
							if (listaI.get(0).getAnno().equalsIgnoreCase("1°"))
								index = 1;
							else if (listaI.get(0).getAnno().equalsIgnoreCase("2°"))
								index = 2;
							else if (listaI.get(0).getAnno().equalsIgnoreCase("3°"))
								index = 3;
							else if (listaI.get(0).getAnno().equalsIgnoreCase("1° Spec."))
								index = 4;
							else if (listaI.get(0).getAnno().equalsIgnoreCase("2° Spec."))
								index = 5;
							else
								index = 0;
							jComboBoxAnno.setSelectedIndex(index);

							if (listaI.get(0).getPropedeutico().equalsIgnoreCase("SI"))
								index = 1;
							else if (listaI.get(0).getPropedeutico().equalsIgnoreCase("NO"))
								index = 2;
							else
								index = 0;
							jComboBoxPropedeutico.setSelectedIndex(index);

							if (listaI.get(0).getLaboratorio().equalsIgnoreCase("SI"))
								index = 1;
							else if (listaI.get(0).getLaboratorio().equalsIgnoreCase("NO"))
								index = 2;
							else
								index = 0;
							jComboBoxLaboratorio.setSelectedIndex(index);

							if (listaI.get(0).getValutazione().equalsIgnoreCase("Esame"))
								index = 1;
							else if (listaI.get(0).getValutazione().equalsIgnoreCase("Idonietà"))
								index = 2;
							else
								index = 0;
							jComboBoxValutazione.setSelectedIndex(index);

						}

					} catch (Exception exc) {
						System.err.println("Errore" + exc);
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

		if (e.getActionCommand().equalsIgnoreCase("Indietro")) {
			dispose();
		}

		if (e.getActionCommand().equalsIgnoreCase("Salva")) {

			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (Exception e1) {
				System.err.println("Errore nel caricamento del Driver");
			}

			try {
				LinkedHashMap<String, Object> qc = new LinkedHashMap<>();
				qc.put("corsoLaurea", h);
				qc.put("nomeCorso", c);
				List<Insegnamento> v = (List<Insegnamento>) ac.handleRequest("UpdateInsegnamento", qc);
				Insegnamento ins = new Insegnamento(jTextFieldNomeInsegn.getText(),
						vettore[jComboBoxCorsoLaurea.getSelectedIndex()].toString(),
						Integer.parseInt(jTextFieldCrediti.getText()), a2[jComboBoxAnno.getSelectedIndex()],
						a3[jComboBoxPropedeutico.getSelectedIndex()], a4[jComboBoxLaboratorio.getSelectedIndex()],
						a5[jComboBoxValutazione.getSelectedIndex()]);

				DaoInsegnamento dao = new DaoInsegnamento();
				boolean errore = dao.update(ins);

				if (errore) {
					JOptionPane.showMessageDialog(null, "Errore aggiornamento database...");
				}
				JOptionPane.showMessageDialog(null, "Operazione avvenuta con successo");

			} catch (Exception exc) {
				JOptionPane.showMessageDialog(null, "Errore aggiornamneto database..." + exc.getMessage());
			}
		}
	}

}
