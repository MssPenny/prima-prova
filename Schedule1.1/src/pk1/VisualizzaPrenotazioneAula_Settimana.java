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

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;

import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.SwingUtilities;


/**
* All'interno della seguente classe viene visualizzata la situazione occupazionale settimanale 
* di un aula del Diaprtimento di Informatica oppure del Palazzo delle Aule, selezionata 
* precedentemente, in cui si desidera conoscere la propria situazione occupazionale 
* riguardo all'intera settimana corrente. Dalla seguente classe è possibile selezionare
* e modificare la prenotazione relativa ad un corso di insegnamento effettuata dal docente
* stesso.
*/
public class VisualizzaPrenotazioneAula_Settimana extends javax.swing.JFrame implements ActionListener {
	private JPanel jPanel1;
	private JLabel jLabelTitolo;
	private JTable jTableOccupazioneSet;
	private JButton jButtonModificaPrenotazione;
	private JLabel jLabelData;
	private JLabel jLabelUbicazione;
	private JButton jButtonElenco;
	private JLabel jLabelSottotitolo;
	private JPanel jPanel4;
	private JPanel jPanel3;
	private JPanel jPanel2;
	public VisualizzaElancoAule_Prenotazione g2;
	
	
	public String p, n;
	

	
	
	public VisualizzaPrenotazioneAula_Settimana(VisualizzaElancoAule_Prenotazione g, String n1, String p1) {
		super();
		g2=g;
		
		p=p1;
		n=n1;
		initGUI();
		
		//inizio
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch(Exception e1)
		{
			System.err.println("Errore nel caricamento del driver");
		}
		
		try
		{
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/schedule_dib","root","");
			conn.setAutoCommit(false);
			Statement stmt=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			String query;
			
			query="SELECT * FROM dati_aule WHERE Nome='"+n+"' and Npiano='"+p+"'";
			
			ResultSet rs = stmt.executeQuery(query);
			
			while (rs.next())
			{
				jLabelUbicazione.setText("Ubicazione: " + rs.getString("Ubicazione"));
			}
			
			conn.commit();
			stmt.close();
			conn.close();
		}
		catch(Exception exc)
		{
			System.err.println("Errore" +exc);
		}
			
	}
	

	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("SITUAZIONE OCCUPAZIONE SETTIMANALE");
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
						jLabelTitolo.setText("Situazione occupazionale settimanale");
						jLabelTitolo.setFont(new java.awt.Font("Arial",0,18));
					}
					{
						jLabelSottotitolo = new JLabel();
						jPanel2.add(jLabelSottotitolo, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						jLabelSottotitolo.setText("Situazione occupazionale settimanale dell'aula "+n+" del "+p+"° piano");
						jLabelSottotitolo.setFont(new java.awt.Font("Tahoma",0,16));
					}
				}
				{
					jPanel3 = new JPanel();
					GridBagLayout jPanel3Layout = new GridBagLayout();
					jPanel1.add(jPanel3, BorderLayout.CENTER);
					jPanel3Layout.rowWeights = new double[] {0.0, 0.0, 0.1};
					jPanel3Layout.rowHeights = new int[] {50, 320, 20};
					jPanel3Layout.columnWeights = new double[] {0.0, 0.1, 0.0};
					jPanel3Layout.columnWidths = new int[] {7, 7, 7};
					jPanel3.setLayout(jPanel3Layout);
					{
						TableModel jTableOccupazioneSetModel = 
							new DefaultTableModel(
									new String[][] { { " ", "Lunedì", "Martedì", "Mercoledì", "Giovedì", "Venerdì", "Sabato", "Domenica" }, 
											{ "08:00", "Four" }, 
											{ "09:00", "Four" },
											{ "10:00", "Four" },
											{ "11:00", "Four" },
											{ "12:00", "Four" },
											{ "13:00", "Four" },
											{ "14:00", "Four" },
											{ "15:00", "Four" },
											{ "16:00", "Four" },
											{ "17:00", "Four" },
											{ "18:00", "Four" },},
											
									new String[] { "Column 1", "Column 2", "Column 3", "Column 4", "Column 5", "Column 6", "Column 7", "Column 8" });
						jTableOccupazioneSet = new JTable();
						jPanel3.add(jTableOccupazioneSet, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
						jTableOccupazioneSet.setModel(jTableOccupazioneSetModel);
						jTableOccupazioneSet.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, true));
					}
					{
						jLabelUbicazione = new JLabel();
						jPanel3.add(jLabelUbicazione, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						jLabelUbicazione.setText("Ubicazione:");
						jLabelUbicazione.setFont(new java.awt.Font("Tahoma",0,14));
					}
					{
						jLabelData = new JLabel();
						jPanel3.add(jLabelData, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						jLabelData.setText("Aggiornamento in data: ");
						jLabelData.setFont(new java.awt.Font("Tahoma",0,14));
					}
				}
				{
					jPanel4 = new JPanel();
					GridBagLayout jPanel4Layout = new GridBagLayout();
					jPanel1.add(jPanel4, BorderLayout.SOUTH);
					jPanel4.setPreferredSize(new java.awt.Dimension(692, 69));
					jPanel4Layout.rowWeights = new double[] {0.1, 0.1, 0.1};
					jPanel4Layout.rowHeights = new int[] {7, 7, 7};
					jPanel4Layout.columnWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.1};
					jPanel4Layout.columnWidths = new int[] {7, 182, 7, 181, 7};
					jPanel4.setLayout(jPanel4Layout);
					{
						jButtonElenco = new JButton();
						jPanel4.add(jButtonElenco, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
						jButtonElenco.setText("Elenco aule");
						jButtonElenco.addActionListener(this);
					}
					{
						jButtonModificaPrenotazione = new JButton();
						jPanel4.add(jButtonModificaPrenotazione, new GridBagConstraints(3, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
						jButtonModificaPrenotazione.setText("Modifica Prenotazione");
						jButtonModificaPrenotazione.addActionListener(this);
					}
				}
			}
			pack();
			this.setSize(1024, 600);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getActionCommand().equalsIgnoreCase("Elenco aule"));
		{
		 dispose();
		}
		
	}

}
