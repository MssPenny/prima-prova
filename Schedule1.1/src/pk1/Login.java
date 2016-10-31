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

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import javax.swing.WindowConstants;

import dao.Dao;

import javax.swing.SwingUtilities;


/**
* La seguente classe consente agli utenti del sistema di autenticarsi per
* poter accedere al sistema di schedulazione.
* Le tipologie di utenti, individuate per l'utilizzo di tale sistema, 
* sono i docenti del Dipartimento di Informtaica e l'Amministratore del sistema.
* Se il docente accede per la prima volta al sistema è necessario che effettui la
* funzione di registrazione al sistema, altrimenti se è gia registrato sarà necessario
* compilare i due campi, contenuti all'interno della scheramta, che consentono di 
* identificarlo all'interno del sistema, cioè: login e password; l'immissione di tali
* dati gli consentono di accedere al proprio profilo all'interno del sistema. 
* Per quando riguarda l'amministratore non è necessario che effettui l'operazione di 
* registrazione per poter accedere al sistema.
*/
public class Login extends javax.swing.JFrame implements ActionListener {
	/**
	 * 
	 */
	public static Dao d= new Dao();
	private static final long serialVersionUID = 1L;
	private JPanel jPanel1;
	private JLabel jLabelTitolo;
	private JTextField jTextFieldPassword;
	private JButton jButtonRegistrati;
	private JButton jButtonEntra;
	private JRadioButton jRadioButtonAmministratore;
	private JTextField jTextFieldLogin;
	private JLabel jLabelPassword;
	private JLabel jLabelLogin;
	private JLabel jLabelInserimento;
	private JRadioButton jRadioButtonDocente;
	private JLabel jLabelTipologia;
	private JPanel jPanel4;
	private JPanel jPanel3;
	private JLabel jLabelSottotitolo;
	private JPanel jPanel2;
	private ButtonGroup bg;          //dichiarazione della variabile "bg" di tipo ButtonGroup
	public boolean doc=false;        //inizializzazione della variabile "doc" di tipo booleana
	public boolean admin=false;      //inizializzazione della variabile "admin" di tipo booleana
	

	
	
	public Login() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("SCHEDULE - Dipartimento di Informatica (Bari)");
			{
				jPanel1 = new JPanel();
				BorderLayout jPanel1Layout = new BorderLayout();
				jPanel1.setLayout(jPanel1Layout);
				getContentPane().add(jPanel1, BorderLayout.CENTER);
				{
					jPanel2 = new JPanel();
					GridBagLayout jPanel2Layout = new GridBagLayout();
					jPanel1.add(jPanel2, BorderLayout.NORTH);
					jPanel2.setPreferredSize(new java.awt.Dimension(692, 69));
					jPanel2Layout.rowWeights = new double[] {0.1, 0.1};
					jPanel2Layout.rowHeights = new int[] {7, 7};
					jPanel2Layout.columnWeights = new double[] {0.1};
					jPanel2Layout.columnWidths = new int[] {7};
					jPanel2.setLayout(jPanel2Layout);
					{
						jLabelTitolo = new JLabel();
						jPanel2.add(jLabelTitolo, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						jLabelTitolo.setText("SCHEDULE");
						jLabelTitolo.setFont(new java.awt.Font("Arial",0,18));
					}
					{
						jLabelSottotitolo = new JLabel();
						jPanel2.add(jLabelSottotitolo, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						jLabelSottotitolo.setText("Sistema per la schedulezione dei corsi del Dipartimento di Informatica");
						jLabelSottotitolo.setFont(new java.awt.Font("Tahoma",0,16));
					}
				}
				{
					jPanel3 = new JPanel();
					GridBagLayout jPanel3Layout = new GridBagLayout();
					jPanel1.add(jPanel3, BorderLayout.WEST);
					jPanel3.setPreferredSize(new java.awt.Dimension(351, 497));
					jPanel3Layout.rowWeights = new double[] {0.1, 0.1, 0.1, 0.1};
					jPanel3Layout.rowHeights = new int[] {7, 7, 7, 7};
					jPanel3Layout.columnWeights = new double[] {0.1, 0.1, 0.1, 0.1};
					jPanel3Layout.columnWidths = new int[] {7, 7, 7, 7};
					jPanel3.setLayout(jPanel3Layout);
				}
				{
					jPanel4 = new JPanel();
					GridBagLayout jPanel4Layout = new GridBagLayout();
					jPanel1.add(jPanel4, BorderLayout.CENTER);
					jPanel4Layout.rowWeights = new double[] {0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1};
					jPanel4Layout.rowHeights = new int[] {7, 7, 7, 7, 20, 20, 20, 20, 20, 20, 20};
					jPanel4Layout.columnWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.1};
					jPanel4Layout.columnWidths = new int[] {7, 138, 43, 142, 7};
					jPanel4.setLayout(jPanel4Layout);
					{
						jLabelTipologia = new JLabel();
						jPanel4.add(jLabelTipologia, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						jLabelTipologia.setText("Tipologia di utente:");
					}
					{
						jRadioButtonDocente = new JRadioButton();
						jPanel4.add(jRadioButtonDocente, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						jRadioButtonDocente.setText("Docente");
						jRadioButtonDocente.setActionCommand("Docente");
						jRadioButtonDocente.addActionListener(new radioAction());
					
					}
					{
						jRadioButtonAmministratore = new JRadioButton();
						jPanel4.add(jRadioButtonAmministratore, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						jRadioButtonAmministratore.setText("Amministratore");
						jRadioButtonAmministratore.setActionCommand("Amministratore");
						jRadioButtonAmministratore.addActionListener(new radioActiondue());
						
						bg=new ButtonGroup();
						bg.add(jRadioButtonDocente);
						bg.add(jRadioButtonAmministratore);
					}
					{
						jLabelInserimento = new JLabel();
						jPanel4.add(jLabelInserimento, new GridBagConstraints(1, 5, 1, 1, 0.0, 0.0, GridBagConstraints.SOUTHWEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						jLabelInserimento.setText("Inserisci i tuoi dati:");
					}
					{
						jLabelLogin = new JLabel();
						jPanel4.add(jLabelLogin, new GridBagConstraints(1, 6, 1, 1, 0.0, 0.0, GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						jLabelLogin.setText("Login");
					}
					{
						jLabelPassword = new JLabel();
						jPanel4.add(jLabelPassword, new GridBagConstraints(1, 7, 1, 1, 0.0, 0.0, GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						jLabelPassword.setText("Password");
					}
					{
						jTextFieldLogin = new JTextField();
						jPanel4.add(jTextFieldLogin, new GridBagConstraints(3, 6, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
					}
					{
						jTextFieldPassword = new JPasswordField();
						jPanel4.add(jTextFieldPassword, new GridBagConstraints(3, 7, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
					}
					{
						jButtonEntra = new JButton();
						jPanel4.add(jButtonEntra, new GridBagConstraints(1, 9, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
						jButtonEntra.setText("Entra");
						jButtonEntra.addActionListener(this);
					}
					{
						jButtonRegistrati = new JButton("Registrati");
						jButtonRegistrati.addActionListener(this);
						jPanel4.add(jButtonRegistrati, new GridBagConstraints(3, 9, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
					
					}
				}
			}
			pack();
			this.setSize(700, 600);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public class radioAction implements ActionListener 
	{
		public void actionPerformed(ActionEvent e)
		{
		
			doc=true;
			admin=false;
			//JOptionPane.showMessageDialog(null, "Docente");
		}	
	}
	
	public class radioActiondue implements ActionListener 
	{
		public void actionPerformed(ActionEvent e)
		{
			doc=false;
			admin=true;
		}	
	}
	
	
	

	@Override
	
	/**
	 * Il docente per potersi registrare al sistema è necessario che scelga prima la 
	 * tipologia di utente adatta al proprio ruolo e dopo, cliccando sul tasto "Registrati"
	 * compilare il modulo di registrazione al sistema. Se il docente ha già fatto 
	 * precedentemente la registrazione la registrazione al sistema, per poter accedere
	 * al proprio profilo è necessario che inserisca i dati che lo identificano (login
	 * e password e cliccando sul tasto "Entra" potrà accedere al proprio profilo.
	 * I dati relativi alla registrazione verranno salvati all'interno di un database.
	 */
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equalsIgnoreCase("Registrati"))
		{
			if(doc==true)
			{
				setVisible(false);
				RegistrazioneDoc rGUI =new RegistrazioneDoc(this);
				rGUI.setVisible(true);
			}
			else
				
				JOptionPane.showMessageDialog(null, "Funzione ammessa solo per i docenti...");
		}
		
		if (e.getActionCommand().equalsIgnoreCase("Entra"))
		{
			if(jTextFieldLogin.getText().equalsIgnoreCase("") || jTextFieldPassword.getText().equalsIgnoreCase(""))
			{
				JOptionPane.showMessageDialog(null, "Compilare entrambi i campi");
			}
			else
			{
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
				}
				catch (Exception e1)
				{
					System.err.println("Errore di caricamento del driver");
				}
				
				
				
				try
				{
//					Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/schedule_dib","root","root");
//					conn.setAutoCommit(false);
					
					Connection conn=d.getInstance();
					conn.setAutoCommit(false);
					Statement stmt=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
					
					
					
					String query="select Login, Password, Nome, Cognome From dati_docenti where Login='"+jTextFieldLogin.getText()+"' and Password='"+jTextFieldPassword.getText()+"'";
					
					
					ResultSet rs=stmt.executeQuery(query);
					int count=0;
					while (rs.next())
						count++;
					
					if (count!= 1)
					{
						JOptionPane.showMessageDialog(null, "Login o Password errate...");
						
						conn.commit();
						stmt.close();
						conn.close();
					}
					else
					{
						rs.first();
						String pNome=rs.getString("Nome");
						String pCognome=rs.getString("Cognome");
						String pPassword=rs.getString("Password");
						String pLogin=rs.getString("Login");
						
						query= "select ruolo from Ruoli where Login='"+jTextFieldLogin.getText()+"' and Password='"+jTextFieldPassword.getText()+"'";
						
						ResultSet rs1=stmt.executeQuery(query);
						
						rs1.next();
						if (rs1.getString("ruolo").equalsIgnoreCase("docente") && admin==false && doc==true)
						{
							conn.commit();
							stmt.close();
							conn.close();
							
							JOptionPane.showMessageDialog(null, "Login e Password corrette...");
							setVisible(false);
							
							MenuDocente menu= new MenuDocente(this, pNome, pCognome, pPassword, pLogin);
							menu.setVisible(true);
						}
						
						else
							if(rs1.getString("ruolo").equalsIgnoreCase("amministratore") && admin==true && doc==false)
							{
								conn.commit();
								stmt.close();
								conn.close();
								JOptionPane.showMessageDialog(null, "Login e Password corrette...");
								setVisible(false);
								MenuAmministratore menu= new MenuAmministratore(this);
								menu.setVisible(true);
							}
							else
								JOptionPane.showMessageDialog(null, "Tipo di utente non corretto...");
								
							
						}
					}
				
				catch(Exception exc)
				{
					JOptionPane.showMessageDialog(null, "Errore aggiornamento database..."+exc.getMessage());
				}
				
				
				}
			}
		}
	}


