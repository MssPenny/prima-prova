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
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.SwingUtilities;


/**
* All'interno della seguente classe sono visualizate tutte le prenotazioni, relative
* alla giornata odierna, delle aule del Dipartimento di Informatica e del Palazzo 
* delle Aule. Inoltre dalla seguente classe è possibile visualizzare le prenotazioni
* delle aule effettuate per i giorni successivi o precedenti rispetto a quello corrente.
* Il docente, all'interno della seguente classe, può selezionare una prenotazione esistente
* ed apportare delle modifiche alla prenotazione relativa ad un proprio corso di
* insegnamento.  
*/
public class VisualizzaPrenotazioneAula_Giorno extends javax.swing.JFrame implements ActionListener {
	private JPanel jPanel1;
	private JLabel jLabelTitolo;
	private JButton jButtonModifica;
	private JTable jTablePrenota;
	private JButton jButtonSuccessivo;
	private JButton jButtonPrecedente;
	private JButton jButtonIndietro;
	private JLabel jLabelData;
	private JLabel jLabelSottotitolo;
	private JPanel jPanel4;
	private JPanel jPanel3;
	private JPanel jPanel2;
	public Modalita_visualizzazione_prenotazioni w2;
	
	public int num_aule = 0;
	public ArrayList nome_aule = new ArrayList();
	public String[] prova =new String[11];
	int pos;
	String ora_in;
	String ora_out;
	
	
	public VisualizzaPrenotazioneAula_Giorno(Modalita_visualizzazione_prenotazioni w) {
		super();
		w2=w;
		
		initGUI();
	}
	

	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			
			GregorianCalendar now=new GregorianCalendar();
			int mese=now.get(Calendar.MONTH);
			mese++;
			int giorno1=now.get(Calendar.DAY_OF_MONTH);
			int anno=now.get(Calendar.YEAR);
			
			
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
				
				query="Select * from prenota_aula where Tipologia='Aula' and data='" + anno + "-" + mese + "-" + giorno1 + "' group by Aula";
				System.out.println(query);
				ResultSet rs=stmt.executeQuery(query);
				
				
				while(rs.next()) {
					//nome_aule[num_aule]=(rs.getString("Aula"));
					nome_aule.add(rs.getString("Aula"));
					num_aule++;
					ora_in = rs.getString("Ora_inizio");
					ora_out = rs.getString("Ora_fine");
					
				
					if( ora_in.equals("8:00:00")) 
						pos= 0;
						
					else if(ora_in.equals("9:00:00"))
						pos=1;
					
					else if(ora_in.equals("10:00:00"))
						pos=2;
					
					else if(ora_in.equals("11:00:00"))
						pos=3;
					else if(ora_in.equals("12:00:00"))
						pos=4;
					else if(ora_in.equals("13:00:00"))
						pos=5;
					else if(ora_in.equals("14:00:00"))
						pos=6;
					else if(ora_in.equals("15:00:00"))
						pos=7;
					else if(ora_in.equals("16:00:00"))
						pos=8;
					else if(ora_in.equals("17:00:00"))
						pos=9;
					else if(ora_in.equals("18:00:00"))
						pos=10;
					
					prova[pos] = rs.getString("Nome_insegn");
					
					
				}
				
				
		
			
		    conn.commit();
			stmt.close();
			conn.close();
			
		}
		catch(Exception exc)
		{
			JOptionPane.showMessageDialog(null, "Errore aggiornamento database..."+exc.getMessage());
		}
			
			
			
			this.setTitle("SITUAZIONE OCCUPAZIOANLE GIORNALIERA");
			{
				jPanel1 = new JPanel();
				BorderLayout jPanel1Layout = new BorderLayout();
				jPanel1.setLayout(jPanel1Layout);
				getContentPane().add(jPanel1, BorderLayout.CENTER);
				{
					jPanel2 = new JPanel();
					GridBagLayout jPanel2Layout = new GridBagLayout();
					jPanel1.add(jPanel2, BorderLayout.NORTH);
					jPanel2.setPreferredSize(new java.awt.Dimension(1016, 75));
					jPanel2Layout.rowWeights = new double[] {0.1, 0.1};
					jPanel2Layout.rowHeights = new int[] {7, 7};
					jPanel2Layout.columnWeights = new double[] {0.1};
					jPanel2Layout.columnWidths = new int[] {7};
					jPanel2.setLayout(jPanel2Layout);
					{
						jLabelTitolo = new JLabel();
						jPanel2.add(jLabelTitolo, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						jLabelTitolo.setText("Situazione occupazionale giornaliera");
						jLabelTitolo.setFont(new java.awt.Font("Arial",0,18));
					}
					{
						jLabelSottotitolo = new JLabel();
						jPanel2.add(jLabelSottotitolo, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						jLabelSottotitolo.setText("Situazione occupazionale giornaliera delle aule del Dipartimento di informatica");
						jLabelSottotitolo.setFont(new java.awt.Font("Tahoma",0,16));
					}
				}
				{
					jPanel3 = new JPanel();
					GridBagLayout jPanel3Layout = new GridBagLayout();
					jPanel1.add(jPanel3, BorderLayout.CENTER);
					jPanel3Layout.rowWeights = new double[] {0.0, 0.0, 0.1};
					jPanel3Layout.rowHeights = new int[] {50, 314, 7};
					jPanel3Layout.columnWeights = new double[] {0.0, 0.1, 0.0};
					jPanel3Layout.columnWidths = new int[] {7, 7, 7};
					jPanel3.setLayout(jPanel3Layout);
					{
						jLabelData = new JLabel();
						jPanel3.add(jLabelData, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						jLabelData.setText("Prenotazioni aule in data:" + giorno1 + "/" + mese + "/" + anno);
						jLabelData.setFont(new java.awt.Font("Tahoma",0,14));
					}
					{
						String[] orari = { "08:00", "09:00", "10:00", "11:00", "12:00", "13:00","14:00", "15:00", "16:00", "17:00", "18:00"};
						PrenotazioneModel modello = new PrenotazioneModel(nome_aule,orari, prova);
											
									
						JTable jTablePrenota = new JTable(modello);
						JScrollPane pane = new JScrollPane(jTablePrenota);
						jPanel3.add(pane, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
						
					}
				}
				{
					jPanel4 = new JPanel();
					GridBagLayout jPanel4Layout = new GridBagLayout();
					jPanel1.add(jPanel4, BorderLayout.SOUTH);
					jPanel4.setPreferredSize(new java.awt.Dimension(1016, 74));
					jPanel4Layout.rowWeights = new double[] {0.1, 0.1, 0.1};
					jPanel4Layout.rowHeights = new int[] {7, 7, 7};
					jPanel4Layout.columnWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.1, 0.0, 0.1};
					jPanel4Layout.columnWidths = new int[] {7, 182, 7, 181, 7, 7, 7};
					jPanel4.setLayout(jPanel4Layout);
					{
						jButtonIndietro = new JButton();
						jPanel4.add(jButtonIndietro, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
						jButtonIndietro.setText("Indietro");
						jButtonIndietro.addActionListener(this);
					}
					{
						jButtonModifica = new JButton();
						jPanel4.add(jButtonModifica, new GridBagConstraints(3, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
						jButtonModifica.setText("Modifica prenotazione");
						jButtonModifica.addActionListener(this);
					}
					{
						jButtonPrecedente = new JButton();
						jPanel4.add(jButtonPrecedente, new GridBagConstraints(4, 1, 1, 1, 0.0, 0.0, GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						jButtonPrecedente.setText("<");
					}
					{
						jButtonSuccessivo = new JButton();
						jPanel4.add(jButtonSuccessivo, new GridBagConstraints(6, 1, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						jButtonSuccessivo.setText(">");
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
		
		if(e.getActionCommand().equalsIgnoreCase("Indietro"))
		{
			setVisible(false);
			w2.setVisible(true);
		}
		
	}

}
