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
import java.util.StringTokenizer;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.ListModel;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.mysql.jdbc.Statement;


/**
* Nella seguente classe vengono visualizzate, all'interno di un elenco, le aule e i 
* laboratori presenti all'interno del Dipartimento di Informatica e del Palazzo delle 
* Aule. Ciascun nominativo dell'aula oppure del laboratorio viene associato al piano
* di ubicazione in cui è situata.
*/
public class VisualizzaElencoAule extends javax.swing.JFrame implements ActionListener, ListSelectionListener {
	private JPanel jPanel1;
	private JLabel jLabelTitolo;
	private JLabel jLabelPianoTerra;
	private JButton jButtonTornaMenu;
	private JButton jButtonVisualizza;
	private JPanel jPanel4;
	private JList jListAule;
	private JLabel jLabelIntestazione;
	private JPanel jPanel3;
	private JLabel jLabelSottotitolo;
	private JPanel jPanel2;
    public Vector vettore=new Vector();
	public String pNome, pPiano;
	
	public VisualizzaElencoAule() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("VISUALIZZA ELENCO AULE/LABORATORI");
			{
				jPanel1 = new JPanel();
				BorderLayout jPanel1Layout = new BorderLayout();
				jPanel1.setLayout(jPanel1Layout);
				getContentPane().add(jPanel1, BorderLayout.CENTER);
				{
					jPanel2 = new JPanel();
					GridBagLayout jPanel2Layout = new GridBagLayout();
					jPanel1.add(jPanel2, BorderLayout.NORTH);
					jPanel2.setPreferredSize(new java.awt.Dimension(692, 79));
					jPanel2Layout.rowWeights = new double[] {0.1, 0.1};
					jPanel2Layout.rowHeights = new int[] {7, 7};
					jPanel2Layout.columnWeights = new double[] {0.1};
					jPanel2Layout.columnWidths = new int[] {7};
					jPanel2.setLayout(jPanel2Layout);
					{
						jLabelTitolo = new JLabel();
						jPanel2.add(jLabelTitolo, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						jLabelTitolo.setText("Visualizza elenco aule/laboratori");
						jLabelTitolo.setFont(new java.awt.Font("Arial",0,18));
					}
					{
						jLabelSottotitolo = new JLabel();
						jPanel2.add(jLabelSottotitolo, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						jLabelSottotitolo.setText("Viene visualizzato l'elenco delle aule e dei laboratori");
						jLabelSottotitolo.setFont(new java.awt.Font("Tahoma",0,16));
					}
				}
				{
					jPanel3 = new JPanel();
					GridBagLayout jPanel3Layout = new GridBagLayout();
					jPanel1.add(jPanel3, BorderLayout.WEST);
					jPanel3.setPreferredSize(new java.awt.Dimension(351, 487));
					jPanel3Layout.rowWeights = new double[] {0.0, 0.0, 0.0, 0.1};
					jPanel3Layout.rowHeights = new int[] {33, 295, 8, 7};
					jPanel3Layout.columnWeights = new double[] {0.0, 0.1, 0.0};
					jPanel3Layout.columnWidths = new int[] {7, 7, 7};
					jPanel3.setLayout(jPanel3Layout);
					{
						jLabelIntestazione = new JLabel();
						jPanel3.add(jLabelIntestazione, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						jLabelIntestazione.setText("N°piano                    Nome aula/lab.");
					}
					{
						ListModel jListAuleModel = 
							new DefaultComboBoxModel(
									new String[] { "Item One", "Item Two" });
						jListAule = new JList();
						jListAule.setVisibleRowCount(0);
						jListAule.addListSelectionListener((ListSelectionListener)this);
						jPanel3.add(jListAule, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
						jListAule.setModel(jListAuleModel);
						
						//codice per visualizzare la barra di scorrimento nella jList
						JScrollPane scroll=new JScrollPane(jListAule);
						jPanel3.add(scroll, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
					
						
						try
						{
							Class.forName("com.mysql.jdbc.Driver");
						}
						catch (Exception e1)
						{
							System.err.println("Errore nel caricamento del driver");
						}
						
						
						
						try
						{
							Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/schedule_dib","root","");
							conn.setAutoCommit(false);
							Statement stmt=(Statement) conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
							String query;
							
							query="SELECT * FROM dati_aule";
							ResultSet rs =stmt.executeQuery(query);
							
							while (rs.next())
							{
								vettore.add(rs.getInt("Npiano")+"                                "+rs.getString("Nome"));
							}
							
							conn.commit();
							stmt.close();
							conn.close();	
						}
						catch (Exception exc)
						{
							System.err.println("Errore"+exc);
						}
						
						jListAule.setListData(vettore);						
						jListAule.setMaximumSize(new java.awt.Dimension(0, 0));

					}
					{
						jLabelPianoTerra = new JLabel();
						jPanel3.add(jLabelPianoTerra, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0, GridBagConstraints.NORTHWEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						jLabelPianoTerra.setText("N.B: 0 = Piano terra");
					}
				}
				{
					jPanel4 = new JPanel();
					GridBagLayout jPanel4Layout = new GridBagLayout();
					jPanel1.add(jPanel4, BorderLayout.CENTER);
					jPanel4Layout.rowWeights = new double[] {0.0, 0.0, 0.0, 0.1};
					jPanel4Layout.rowHeights = new int[] {43, 65, 65, 7};
					jPanel4Layout.columnWeights = new double[] {0.0, 0.0, 0.1};
					jPanel4Layout.columnWidths = new int[] {120, 124, 7};
					jPanel4.setLayout(jPanel4Layout);
					{
						jButtonVisualizza = new JButton();
						jPanel4.add(jButtonVisualizza, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
						jButtonVisualizza.setText("Visualizza info");
						jButtonVisualizza.addActionListener(this);
					}
					{
						jButtonTornaMenu = new JButton();
						jPanel4.add(jButtonTornaMenu, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
						jButtonTornaMenu.setText("Indice");
						jButtonTornaMenu.addActionListener(this);
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
		
		if(e.getActionCommand().equalsIgnoreCase("Visualizza info"))
		{
			if(pPiano ==null || pNome==null)
				JOptionPane.showMessageDialog(null, "Selezionare almeno un aula/laboratorio...");
			else
			{
				VisualizzaAula aula = new VisualizzaAula(pNome, pPiano);
				aula.setVisible(true);	
			}
		}
		
		if(e.getActionCommand().equalsIgnoreCase("Indice"))
		{
			dispose();
		}
	}
	
	public void valueChanged(ListSelectionEvent arg0) {
		String totale=(String)jListAule.getSelectedValue();
		StringTokenizer t=new StringTokenizer(totale, "   ");
		pPiano=t.nextToken().trim();
		pNome=t.nextToken().trim();
	
	

}
}
