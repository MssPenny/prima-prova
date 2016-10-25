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
import java.util.Vector;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;


/**
* All'interno della seguente classe è possibile effettuare l'inserimento della prenotazione
* di un aula oppure di un laboratorio del Dipartimento di Informatica oppure del Palazzo delle
* Aule per poter svolgere esami, lezioni oppure convegni.
* Il docente inserisce i dati relativi alla prenotazione, come ad esempio: l'intervallo occupazionale
* dell'aula oppure del laboratorio prenotato, l'aula o il laboratorio da prenotare, il corso
* di insegnamento con il relativo corso di laurea, ecc...
* I dati relativi alla prenotazione verranno inseriti all'interno del database del sistema.
*/
public class InserimentoPrenotazioneAulaLab extends javax.swing.JFrame implements ActionListener {
	private JPanel jPanel1;
	private JLabel jLabelTitolo;
	private JLabel jLabelInfoAula;
	private JButton jButtonInfoAulaLab;
	private JLabel jLabelInfo;
	private JButton jButtonIndice;
	private JButton jButtonSalva;
	private JLabel jLabelNpiano;
	private JLabel jLabelUbicazione;
	private JLabel jLabelTipologia;
	private JLabel jLabelNposti;
	private JTextArea jTextAreaNote;
	private JLabel jLabelNote;
	private JComboBox jComboBoxAula;
	private JLabel jLabelSeleziona;
	private JButton jButtonAula;
	private JLabel jLabelPrenota;
	private JComboBox jComboBoxPiano;
	private JLabel jLabelPiano;
	private JComboBox jComboBoxOraFine;
	private JLabel jLabelFineOra;
	private JComboBox jComboBoxOraInizio;
	private JLabel jLabelInizioOra;
	private JLabel jLabelOraPrenotazione;
	private JLabel jLabelEsData;
	private JTextField jTextFieldDataPrenotazione;
	private JComboBox jComboBoxCorsoLaurea;
	private JLabel jLabelDataPrenotazione;
	private JButton jButtonLaboratorio;
	private JComboBox jComboBoxInsegnamento;
	private JLabel jLabelInsegnamento;
	private JButton jButtonVediInsegnamenti;
	private JLabel jLabelCorsoLaurea;
	private JLabel jLabelSottotitolo;
	private JPanel jPanel5;
	private JPanel jPanel4;
	private JPanel jPanel3;
	private JPanel jPanel2;
	public MenuGestionePrenotazione m2;
	public String pLogin, pPassword;
	public String [] a1, a2;
	public Vector<String> vettore, vettore_piano, vettore_lab, vins;
	public String data_it, giorno, mese,anno, data_en;

	
	
	public InserimentoPrenotazioneAulaLab(MenuGestionePrenotazione m) {
		super();
		m2=m;
		initGUI();
	}
	
	private void initGUI() {
		pLogin=m2.pLogin;
		pPassword=m2.pPassword;
		
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("INSERIMENTO PRENOTAZIONE");
			{
				jPanel1 = new JPanel();
				BorderLayout jPanel1Layout = new BorderLayout();
				jPanel1.setLayout(jPanel1Layout);
				getContentPane().add(jPanel1, BorderLayout.CENTER);
				{
					jPanel2 = new JPanel();
					GridBagLayout jPanel2Layout = new GridBagLayout();
					jPanel1.add(jPanel2, BorderLayout.NORTH);
					jPanel2.setPreferredSize(new java.awt.Dimension(692, 72));
					jPanel2Layout.rowWeights = new double[] {0.1, 0.1};
					jPanel2Layout.rowHeights = new int[] {7, 7};
					jPanel2Layout.columnWeights = new double[] {0.1};
					jPanel2Layout.columnWidths = new int[] {7};
					jPanel2.setLayout(jPanel2Layout);
					{
						jLabelTitolo = new JLabel();
						jPanel2.add(jLabelTitolo, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						jLabelTitolo.setText("Inserimento Prenotazione");
						jLabelTitolo.setFont(new java.awt.Font("Arial",0,18));
					}
					{
						jLabelSottotitolo = new JLabel();
						jPanel2.add(jLabelSottotitolo, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						jLabelSottotitolo.setText("Effettua la prenotazione di un aula oppure di un laboratorio compilando i seguenti campi");
						jLabelSottotitolo.setFont(new java.awt.Font("Tahoma",0,16));
					}
				}
				{
					jPanel3 = new JPanel();
					GridBagLayout jPanel3Layout = new GridBagLayout();
					jPanel1.add(jPanel3, BorderLayout.WEST);
					jPanel3.setPreferredSize(new java.awt.Dimension(375, 644));
					jPanel3Layout.rowWeights = new double[] {0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.0};
					jPanel3Layout.rowHeights = new int[] {7, 7, 7, 7, 20, 20, 20, 20, 20, 20, 20, 7};
					jPanel3Layout.columnWeights = new double[] {0.0, 0.1};
					jPanel3Layout.columnWidths = new int[] {7, 7};
					jPanel3.setLayout(jPanel3Layout);
					{
						jLabelCorsoLaurea = new JLabel();
						jPanel3.add(jLabelCorsoLaurea, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						jLabelCorsoLaurea.setText("Seleziona il corso di laurea:");
					}
					
					{
						jButtonVediInsegnamenti = new JButton();
						jPanel3.add(jButtonVediInsegnamenti, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						jButtonVediInsegnamenti.setText("Vedi insegnamenti");
						jButtonVediInsegnamenti.addActionListener(this);
					}
					{
						jLabelInsegnamento = new JLabel();
						jPanel3.add(jLabelInsegnamento, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						jLabelInsegnamento.setText("Seleziona il corso d'insegnamento:");
					}
					
					{
						jLabelDataPrenotazione = new JLabel();
						jPanel3.add(jLabelDataPrenotazione, new GridBagConstraints(1, 4, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						jLabelDataPrenotazione.setText("Data di prenotazione:");
					}
					{
						jTextFieldDataPrenotazione = new JTextField();
						jPanel3.add(jTextFieldDataPrenotazione, new GridBagConstraints(1, 4, 1, 1, 0.0, 0.0, GridBagConstraints.EAST, GridBagConstraints.HORIZONTAL, new Insets(0, 125, 0, 130), 0, 0));
					}
					{
						jLabelEsData = new JLabel();
						jPanel3.add(jLabelEsData, new GridBagConstraints(1, 4, 1, 1, 0.0, 0.0, GridBagConstraints.EAST, GridBagConstraints.HORIZONTAL, new Insets(0, 255, 0, 0), 0, 0));
						jLabelEsData.setText("(gg-mm-aaaa)");
					}
					{
						jLabelOraPrenotazione = new JLabel();
						jPanel3.add(jLabelOraPrenotazione, new GridBagConstraints(1, 5, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						jLabelOraPrenotazione.setText("Intervallo di tempo:");
					}
					{
						jLabelInizioOra = new JLabel();
						jPanel3.add(jLabelInizioOra, new GridBagConstraints(1, 5, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 120), 0, 0));
						jLabelInizioOra.setText("dalle");
					}
					{
						a1 = new String [] {" ", "08:00", "09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00"};
						ComboBoxModel jComboBoxOraInizioModel = 
							new DefaultComboBoxModel(a1);
						jComboBoxOraInizio = new JComboBox();
						jPanel3.add(jComboBoxOraInizio, new GridBagConstraints(1, 5, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 10, 0, 0), 0, 0));
						jComboBoxOraInizio.setModel(jComboBoxOraInizioModel);
					}
					{
						jLabelFineOra = new JLabel();
						jPanel3.add(jLabelFineOra, new GridBagConstraints(1, 5, 1, 1, 0.0, 0.0, GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(0, 0, 0, 100), 0, 0));
						jLabelFineOra.setText("alle");
					}
					{
						a2 = new String [] {" ", "08:00", "09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00"};
						ComboBoxModel jComboBoxOraFineModel = 
							new DefaultComboBoxModel(a2);
						jComboBoxOraFine = new JComboBox();
						jPanel3.add(jComboBoxOraFine, new GridBagConstraints(1, 5, 1, 1, 0.0, 0.0, GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						jComboBoxOraFine.setModel(jComboBoxOraFineModel);
					}
					{
						jLabelPiano = new JLabel();
						jPanel3.add(jLabelPiano, new GridBagConstraints(1, 6, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						jLabelPiano.setText("N° piano:");
					}
					
					{
						jLabelPrenota = new JLabel();
						jPanel3.add(jLabelPrenota, new GridBagConstraints(1, 7, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						jLabelPrenota.setText("Prenota:");
					}
					{
						jButtonAula = new JButton();
						jPanel3.add(jButtonAula, new GridBagConstraints(1, 7, 1, 1, 0.0, 0.0, GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(0, 0, 0, 233), 0, 0));
						jButtonAula.setText("Aula");
						jButtonAula.addActionListener(this);
					}
					{
						jButtonLaboratorio = new JButton();
						jPanel3.add(jButtonLaboratorio, new GridBagConstraints(1, 7, 1, 1, 0.0, 0.0, GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(0, 0, 0, 100), 0, 0));
						jButtonLaboratorio.setText("Laboratorio");
						jButtonLaboratorio.addActionListener(this);
					}
					{
						jLabelSeleziona = new JLabel();
						jPanel3.add(jLabelSeleziona, new GridBagConstraints(1, 8, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						jLabelSeleziona.setText("Seleziona aula/laboratorio:");
					}
					{
						ComboBoxModel jComboBoxAulaModel = 
							new DefaultComboBoxModel();
						jComboBoxAula = new JComboBox();
						jPanel3.add(jComboBoxAula, new GridBagConstraints(1, 8, 1, 1, 0.0, 0.0, GridBagConstraints.EAST, GridBagConstraints.HORIZONTAL, new Insets(0, 160, 0, 0), 0, 0));
						jComboBoxAula.setModel(jComboBoxAulaModel);
						jComboBoxAula.enable(false);
					}
					{
						jLabelNote = new JLabel();
						jPanel3.add(jLabelNote, new GridBagConstraints(1, 9, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						jLabelNote.setText("Note:");
					}
					{
						jTextAreaNote = new JTextArea();
						jPanel3.add(jTextAreaNote, new GridBagConstraints(1, 10, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
						jTextAreaNote.setText("Inserisci una nota inerente alla prenotazione...");
					}
				}
				{
					jPanel4 = new JPanel();
					GridBagLayout jPanel4Layout = new GridBagLayout();
					jPanel1.add(jPanel4, BorderLayout.SOUTH);
					jPanel4.setPreferredSize(new java.awt.Dimension(692, 77));
					jPanel4Layout.rowWeights = new double[] {0.1, 0.1, 0.1, 0.0};
					jPanel4Layout.rowHeights = new int[] {7, 7, 7, 7};
					jPanel4Layout.columnWeights = new double[] {0.0, 0.1, 0.1, 0.1, 0.0};
					jPanel4Layout.columnWidths = new int[] {7, 7, 7, 7, 7};
					jPanel4.setLayout(jPanel4Layout);
					{
						jLabelNposti = new JLabel();
						jPanel4.add(jLabelNposti, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						jLabelNposti.setText("N° posti:");
						jLabelNposti.setFont(new java.awt.Font("Tahoma",0,12));
					}
					{
						jLabelTipologia = new JLabel();
						jPanel4.add(jLabelTipologia, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						jLabelTipologia.setText("Tipologia:");
						jLabelTipologia.setFont(new java.awt.Font("Tahoma",0,12));
					}
					{
						jLabelUbicazione = new JLabel();
						jPanel4.add(jLabelUbicazione, new GridBagConstraints(3, 1, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						jLabelUbicazione.setText("Ubicazione:");
						jLabelUbicazione.setFont(new java.awt.Font("Tahoma",0,12));
					}
					{
						jLabelNpiano = new JLabel();
						jPanel4.add(jLabelNpiano, new GridBagConstraints(3, 2, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						jLabelNpiano.setText("N° piano:");
						jLabelNpiano.setFont(new java.awt.Font("Tahoma",0,12));
					}
					{
						jLabelInfoAula = new JLabel();
						jPanel4.add(jLabelInfoAula, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						jLabelInfoAula.setText("Info:");
						jLabelInfoAula.setFont(new java.awt.Font("Tahoma",0,16));
					}
				}
				{
					jPanel5 = new JPanel();
					GridBagLayout jPanel5Layout = new GridBagLayout();
					jPanel1.add(jPanel5, BorderLayout.CENTER);
					jPanel5Layout.rowWeights = new double[] {0.0, 0.0, 0.0, 0.1, 0.1};
					jPanel5Layout.rowHeights = new int[] {50, 50, 50, 20, 7};
					jPanel5Layout.columnWeights = new double[] {0.0, 0.0, 0.1};
					jPanel5Layout.columnWidths = new int[] {120, 120, 7};
					jPanel5.setLayout(jPanel5Layout);
					{
						jButtonSalva = new JButton();
						jPanel5.add(jButtonSalva, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
						jButtonSalva.setText("Salva prenotazione");
						jButtonSalva.addActionListener(this);
					}
					{
						jButtonIndice = new JButton();
						jPanel5.add(jButtonIndice, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
						jButtonIndice.setText("Indice");
						jButtonIndice.addActionListener(this);
						
						
						{
							ComboBoxModel jComboBoxInsegnamentoModel = 
								new DefaultComboBoxModel();
							jComboBoxInsegnamento = new JComboBox();
							jPanel3.add(jComboBoxInsegnamento, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
							jComboBoxInsegnamento.setModel(jComboBoxInsegnamentoModel);
							jComboBoxInsegnamento.enable(false);
						}
						
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
							
							query="Select DISTINCT Corso_laurea from associa_doc where Login='"+pLogin+"' and Password='"+pPassword+"'";
							System.out.print(query);
							ResultSet rs=stmt.executeQuery(query);
							
							Vector<String> b=new Vector<String>();
							b.add(" ");
							
							while(rs.next())
							{
							     b.add(rs.getString("Corso_laurea"));
							}
							
							{
								ComboBoxModel jComboBoxCorsoLaureaModel = 
									new DefaultComboBoxModel(b);
								jComboBoxCorsoLaurea = new JComboBox();
								jPanel3.add(jComboBoxCorsoLaurea, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.EAST, GridBagConstraints.HORIZONTAL, new Insets(0, 160, 0, 0), 0, 0));
								jComboBoxCorsoLaurea.setModel(jComboBoxCorsoLaureaModel);
							}
							
							vettore=b;
							
							conn.commit();
							stmt.close();
							conn.close();
							
						}
						catch(Exception exc)
						{
							JOptionPane.showMessageDialog(null, "Errore aggiornamento database..."+exc.getMessage());
						}
						
					}
					{
						jLabelInfo = new JLabel();
						jPanel5.add(jLabelInfo, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0, GridBagConstraints.SOUTHEAST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						jLabelInfo.setText("Info Aula/Lab:");
					}
					{
						jButtonInfoAulaLab = new JButton();
						jPanel5.add(jButtonInfoAulaLab, new GridBagConstraints(1, 4, 1, 1, 0.0, 0.0, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
						jButtonInfoAulaLab.setText("Info...");
						jButtonInfoAulaLab.addActionListener(this);
						
						
						try
						{
							Class.forName("com.mysql.jdbc.Driver");
						}
						catch(Exception e1)
						{
							System.err.println("Errore aggiornamento database");
						}
						
						try
						{
							Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/schedule_dib","root","");
							conn.setAutoCommit(false);
							Statement stmt=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
							String query;
							
							query="Select DISTINCT Npiano from dati_aule";
							
							ResultSet rs=stmt.executeQuery(query);
							Vector<String>p=new Vector<String>();
							p.add(" ");
							
							while(rs.next())
							{
								p.add(rs.getString("Npiano"));
							}
							
							{
								ComboBoxModel jComboBoxPianoModel = 
									new DefaultComboBoxModel(p);
								jComboBoxPiano = new JComboBox();
								jPanel3.add(jComboBoxPiano, new GridBagConstraints(1, 6, 1, 1, 0.0, 0.0, GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(0, 0, 0, 230), 0, 0));
								jComboBoxPiano.setModel(jComboBoxPianoModel);
							}
							
                            vettore_piano=p;
							
							conn.commit();
							stmt.close();
							conn.close();
			
						}
						catch(Exception exc)
						{
							JOptionPane.showMessageDialog(null, "Errore aggiornamento database..."+exc.getMessage());
						}
						
					}
				}
			}
			pack();
			this.setSize(700, 750);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getActionCommand().equalsIgnoreCase("Indice"))
		{
			setVisible(false);
			m2.setVisible(true);
		}
		
		if(e.getActionCommand().equalsIgnoreCase("Aula"))
		{
			String pPiano=vettore_piano.get(jComboBoxPiano.getSelectedIndex());
			
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
			}
			catch(Exception e1)
			{
				System.err.println("Errore aggiornamento database");
			}
			
			try
			{
				Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/schedule_dib","root","");
				conn.setAutoCommit(false);
				Statement stmt=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
				String query;
				
				query="Select * from dati_aule where Tipologia='Aula' and Npiano='"+pPiano+"'";
				
				ResultSet rs=stmt.executeQuery(query);
				Vector<String> m=new Vector<String>();
				m.add(" ");
				
				while(rs.next())
				{
					m.add(rs.getString("Nome"));
				}
				
				{
					ComboBoxModel jComboBoxjComboBoxAulaModel=
						new DefaultComboBoxModel(m);
					jComboBoxAula.setModel(jComboBoxjComboBoxAulaModel);
					jComboBoxAula.enable(true);
				}
				
				vettore_lab=m;
				
				conn.commit();
				stmt.close();
				conn.close();
				
			}
			catch(Exception exc)
			{
				JOptionPane.showMessageDialog(null, "Errore nell'aggiornamento del database"+exc.getMessage());
			}
			
		}
		
		if(e.getActionCommand().equalsIgnoreCase("Laboratorio"))
		{
			String pPiano=vettore_piano.get(jComboBoxPiano.getSelectedIndex());
			
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
			}
			catch(Exception e1)
			{
				System.err.println("Errore aggiornamento database");
			}
			
			try
			{
				Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/schedule_dib","root","");
				conn.setAutoCommit(false);
				Statement stmt=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
				String query;
				
				query="Select * from dati_aule where Tipologia='Laboratorio' and Npiano='"+pPiano+"'";
				
				ResultSet rs=stmt.executeQuery(query);
				Vector<String> f=new Vector<String>();
				f.add(" ");
				
				while(rs.next())
				{
					f.add(rs.getString("Nome"));
				}
				
				{
					ComboBoxModel jComboBoxComboBoxAulaModel=
						new DefaultComboBoxModel(f);
					jComboBoxAula.setModel(jComboBoxComboBoxAulaModel);
					jComboBoxAula.enable(true);
				}
				
				vettore_lab=f;
				
				conn.commit();
				stmt.close();
				conn.close();
				
			}
			catch(Exception exc)
			{
				JOptionPane.showMessageDialog(null, "Errore aggiornamento database..."+exc.getMessage());
			}
			
		}
		
		if(e.getActionCommand().equalsIgnoreCase("Vedi insegnamenti"))
		{
			String pCorso=vettore.get(jComboBoxCorsoLaurea.getSelectedIndex());
			
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
				
				query="Select Nome_insegn from associa_doc where Login='"+pLogin+"' and Password='"+pPassword+"' and Corso_laurea='"+pCorso+"'";
				
				ResultSet rs=stmt.executeQuery(query);
				Vector<String> v=new Vector<String>();
				v.add(" ");
				
				while(rs.next())
				{
					v.add(rs.getString("Nome_insegn"));
				}
				
				ComboBoxModel jComboBoxjComboBoxInsegnamentoModel=
					new DefaultComboBoxModel(v);
				jComboBoxInsegnamento.setModel(jComboBoxjComboBoxInsegnamentoModel);
				jComboBoxInsegnamento.enable(true);
				
				vins=v;
				
			}
			catch(Exception exc)
			{
				JOptionPane.showMessageDialog(null, "Errore aggiornamento del database..."+exc.getMessage());
			}
			
		}
		
		if(e.getActionCommand().equalsIgnoreCase("Info..."))
		{
			String pLaboratorio=vettore_lab.get(jComboBoxAula.getSelectedIndex());
			String pPiano=vettore_piano.get(jComboBoxPiano.getSelectedIndex());
			
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
			}
			catch(Exception e1)
			{
				System.err.println("Errore nel caricamento del database");
			}
			
			try
			{
				Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/schedule_dib","root","");
				conn.setAutoCommit(false);
				Statement stmt=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
				String query;
				
				query="Select * from dati_aule where Nome='"+pLaboratorio+"' and Npiano='"+pPiano+"'";
				
				System.out.println(query);
				
				ResultSet rs=stmt.executeQuery(query);
				
				while(rs.next())
				{
					jLabelNposti.setText("N° posti: "+rs.getString("Nposti"));
					jLabelTipologia.setText("Tipologia: "+rs.getString("Tipologia"));
					jLabelUbicazione.setText("Ubicazione: "+rs.getString("Ubicazione"));
					jLabelNpiano.setText("N° piano: "+rs.getString("Npiano"));
				}
				
				conn.commit();
				stmt.close();
				conn.close();
				
			}
			catch(Exception exc)
			{
				JOptionPane.showMessageDialog(null, "Errore aggiornamento database..."+exc.getMessage());
			}
			
			
		}
		
		if(e.getActionCommand().equalsIgnoreCase("Salva prenotazione"))
		{
			String pCorso=vettore.get(jComboBoxCorsoLaurea.getSelectedIndex());
			String pIns=vins.get(jComboBoxInsegnamento.getSelectedIndex());
			String pLaboratorio=vettore_lab.get(jComboBoxAula.getSelectedIndex());
			String pPiano=vettore_piano.get(jComboBoxPiano.getSelectedIndex());
			String pLogin=null;
			String pPassword=null;
			
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
				
				query="Select * from associa_doc where Login='"+pLogin+"' and Password='"+pPassword+"'";
				
				ResultSet rs=stmt.executeQuery(query);
				
				while(rs.next())
				{
					pLogin=rs.getString("Login");
					pPassword=rs.getString("Password");
				}
				
				
				
				//Per acquisire il valore dal campo Tipologia delle tabella dati_aule
				
				String pTipologia=null;
				query="Select Tipologia from dati_aule where Nome='"+pLaboratorio+"' and Npiano='"+pPiano+"'";
				
				System.out.println(query);
				
				ResultSet rs1=stmt.executeQuery(query);
				while(rs1.next())
				{
					pTipologia=rs1.getString("Tipologia");
				}
				
				//Tipologia
				
				
				data_it=jTextFieldDataPrenotazione.getText();
				giorno = data_it.substring(0, 2);
				mese = data_it.substring(3,5);
				anno = data_it.substring(6, 10);
				data_en = anno + "-" + mese + "-" + giorno;
				
				
				
				
				
				query="Insert into `prenota_aula`(`Corso_laurea`,`Nome_insegn`,`Data`,`Ora_inizio`,`Ora_fine`,`Aula`,`Npiano`,`Tipologia`,`Note`)values('"+pCorso+"', '"+pIns+"', '"+ data_en +"', '"+a1[jComboBoxOraInizio.getSelectedIndex()]+"', '"+a2[jComboBoxOraFine.getSelectedIndex()]+"', '"+pLaboratorio+"', '"+pPiano+"', '"+pTipologia+"', '"+jTextAreaNote.getText()+"')";
				
				System.out.println(query);
				
				int righe=stmt.executeUpdate(query);
				
				if(righe!=1)
				{
					JOptionPane.showMessageDialog(null, "Errore aggiornamento database...");
				}
				else
				{
					conn.commit();
					stmt.close();
					conn.close();
					JOptionPane.showMessageDialog(null, "La prenotazione è stata effettuata");
				}
				
			}
			catch(Exception exc)
			{
				JOptionPane.showMessageDialog(null, "L'aula selezionata è stata già prenotata..."+exc.getMessage());
			}
			
			
		}
		
	}

}
