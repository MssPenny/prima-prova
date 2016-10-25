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
import java.util.StringTokenizer;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListModel;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


/**
* La seguente classe visualizza, all'interno di un elenco, tutti i corsi di insegnamento 
* con i rispettivi corsi di laurea che sono presenti all'interno del Dipartimento di
* Informatica. 
*/
public class VisualizzaElencoInsegnamenti extends javax.swing.JFrame implements ActionListener, ListSelectionListener {
	private JPanel jPanel1;
	private JLabel jLabelTitolo;
	private JButton jButtonIndice;
	private JButton jButtonVisualizza;
	private JPanel jPanel5;
	private JLabel jLabelITPS;
	private JLabel jLabelICD;
	private JLabel jLabelLegenda;
	private JLabel jLabelIntestazione;
	private JPanel jPanel4;
	private JPanel jPanel3;
	private JLabel jLabelSottotitolo;
	private JPanel jPanel2;
	public Vector vettore=new Vector();
	public String pInsegnamento, pCorso;
	private JList jList;

	public VisualizzaElencoInsegnamenti() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("ELENCO INSEGNAMENTI");
			{
				jPanel1 = new JPanel();
				BorderLayout jPanel1Layout = new BorderLayout();
				jPanel1.setLayout(jPanel1Layout);
				getContentPane().add(jPanel1, BorderLayout.CENTER);
				{
					jPanel2 = new JPanel();
					GridBagLayout jPanel2Layout = new GridBagLayout();
					jPanel1.add(jPanel2, BorderLayout.NORTH);
					jPanel2.setPreferredSize(new java.awt.Dimension(692, 75));
					jPanel2Layout.rowWeights = new double[] {0.1, 0.1};
					jPanel2Layout.rowHeights = new int[] {7, 7};
					jPanel2Layout.columnWeights = new double[] {0.1};
					jPanel2Layout.columnWidths = new int[] {7};
					jPanel2.setLayout(jPanel2Layout);
					{
						jLabelTitolo = new JLabel();
						jPanel2.add(jLabelTitolo, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						jLabelTitolo.setText("Elenco Insegnamenti");
						jLabelTitolo.setFont(new java.awt.Font("Arial",0,18));
					}
					{
						jLabelSottotitolo = new JLabel();
						jPanel2.add(jLabelSottotitolo, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						jLabelSottotitolo.setText("Elenco degli insegnamenti presenti all'interno del \"dib\"");
						jLabelSottotitolo.setFont(new java.awt.Font("Tahoma",0,16));
					}
				}
				{
					jPanel3 = new JPanel();
					GridBagLayout jPanel3Layout = new GridBagLayout();
					jPanel1.add(jPanel3, BorderLayout.WEST);
					jPanel3.setPreferredSize(new java.awt.Dimension(350, 491));
					jPanel3Layout.rowWeights = new double[] {0.0, 0.0, 0.1};
					jPanel3Layout.rowHeights = new int[] {40, 347, 7};
					jPanel3Layout.columnWeights = new double[] {0.0, 0.1, 0.0};
					jPanel3Layout.columnWidths = new int[] {7, 7, 7};
					jPanel3.setLayout(jPanel3Layout);
					{
						jLabelIntestazione = new JLabel();
						jPanel3.add(jLabelIntestazione, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						jLabelIntestazione.setText("Corso di laurea,          Nome insegnamento");
					}
					{
						ListModel jListModel = 
							new DefaultComboBoxModel(
									new String[] { "Item One", "Item Two" });
						jList = new JList();
						jList.setVisibleRowCount(0);
						jList.addListSelectionListener((ListSelectionListener)this);
						jPanel3.add(jList, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
						jList.setModel(jListModel);
						JScrollPane scroll=new JScrollPane(jList);
						jPanel3.add(scroll, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
					}
					
					
					try
					{
						Class.forName("com.mysql.jdbc.Driver");
					}
					catch (Exception e1)
					{
						System.err.println("Errore nel caricamento del Driver");
					}
					
					
					try
					{
						Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/schedule_dib","root","");
						conn.setAutoCommit(false);
						Statement stmt=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
						String query;
						
						query="SELECT * FROM dati_insegnamento";
						ResultSet rs=stmt.executeQuery(query);
						
						while(rs.next())
						{
							vettore.add(rs.getString("Corso_laurea")+",   "+rs.getString("Nome_insegn"));
						}
						
						conn.commit();
						stmt.close();
						conn.close();
					}
					catch(Exception exc)
					{
						System.err.println("Errore" +exc);
					}
					
					jList.setListData(vettore);
					
				}
				{
					jPanel4 = new JPanel();
					GridBagLayout jPanel4Layout = new GridBagLayout();
					jPanel1.add(jPanel4, BorderLayout.SOUTH);
					jPanel4.setPreferredSize(new java.awt.Dimension(692, 76));
					jPanel4Layout.rowWeights = new double[] {0.1, 0.1, 0.1};
					jPanel4Layout.rowHeights = new int[] {7, 7, 7};
					jPanel4Layout.columnWeights = new double[] {0.0, 0.1};
					jPanel4Layout.columnWidths = new int[] {7, 7};
					jPanel4.setLayout(jPanel4Layout);
					{
						jLabelLegenda = new JLabel();
						jPanel4.add(jLabelLegenda, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						jLabelLegenda.setText("Legenda, CORSI DI LAUREA:");
					}
					{
						jLabelICD = new JLabel();
						jPanel4.add(jLabelICD, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						jLabelICD.setText("ICD: Informatica e Comunicazione Digitale");
					}
					{
						jLabelITPS = new JLabel();
						jPanel4.add(jLabelITPS, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						jLabelITPS.setText("ITPS: Informatica e Tecnologie per la Produzione del Software");
					}
				}
				{
					jPanel5 = new JPanel();
					GridBagLayout jPanel5Layout = new GridBagLayout();
					jPanel1.add(jPanel5, BorderLayout.CENTER);
					jPanel5Layout.rowWeights = new double[] {0.0, 0.0, 0.0, 0.1, 0.1};
					jPanel5Layout.rowHeights = new int[] {50, 50, 50, 7, 7};
					jPanel5Layout.columnWeights = new double[] {0.0, 0.0, 0.1};
					jPanel5Layout.columnWidths = new int[] {120, 120, 7};
					jPanel5.setLayout(jPanel5Layout);
					{
						jButtonVisualizza = new JButton();
						jPanel5.add(jButtonVisualizza, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
						jButtonVisualizza.setText("Visualizza info");
						jButtonVisualizza.addActionListener(this);
					}
					{
						jButtonIndice = new JButton();
						jPanel5.add(jButtonIndice, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
						jButtonIndice.setText("Indice");
						jButtonIndice.addActionListener(this);
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
			if(pCorso==null || pInsegnamento==null)
				JOptionPane.showMessageDialog(null, "Selezionare almeno un insegnamento");
			else
			{
				VisualizzaInsegnamento insegnamento = new VisualizzaInsegnamento(pInsegnamento, pCorso);
				insegnamento.setVisible(true);
			}
				
		}
		
		if(e.getActionCommand().equalsIgnoreCase("Indice"))
		{
			dispose();
		}
		
	}

	@Override
	public void valueChanged(ListSelectionEvent arg0) {
		// TODO Auto-generated method stub
		
		String totale=(String)jList.getSelectedValue();
		StringTokenizer t=new StringTokenizer(totale, ",");
		
		pInsegnamento=t.nextToken().trim();
		pCorso=t.nextToken().trim();
	}

}
