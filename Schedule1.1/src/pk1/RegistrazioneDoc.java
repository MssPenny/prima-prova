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

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;


/**
* La seguente classe definisce il modulo di registrazione che il docente utilizza per
* poter effettuare la registazione al sistema e di conseguenza l'accesso al proprio
* profilo. I dati inseriti all'interno del seguente modulo di registrazione verranno
* salvati all'interno di un database.
*/
public class RegistrazioneDoc extends javax.swing.JFrame implements ActionListener  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel jPanel1;
	private JLabel jLabelTitolo;
	private JButton jButtonIndietro;
	private JLabel jLabelTelefono;
	private JTextField jTextFieldEmail;
	private JButton jButtonSalva;
	private JPanel jPanel4;
	private JTextField jTextFieldPassword;
	private JTextField jTextFieldResidente;
	private JLabel jLabelFormatoData;
	private JLabel jLabelCitta;
	private JLabel jLabelIndirizzoAb;
	private JTextField jTextFieldIndirizzo;
	private JTextField jTextFieldNascita;
	private JLabel jLabelDNascita;
	private JTextField jTextFieldLogin;
	private JComboBox jComboBoxUbicUff;
	private JTextField jTextFieldNpiano;
	private JTextField jTextFieldIndWeb;
	private JTextField jTextFieldTelefono;
	private JTextField jTextFieldCognome;
	private JTextField jTextFieldNome;
	private JLabel jLabelPassword;
	private JLabel jLabelIndWeb;
	private JLabel jLabelLogin;
	private JLabel jLabelUbicazUff;
	private JLabel jLabelNpiano;
	private JLabel jLabelEmail;
	private JLabel jLabelCognome;
	private JLabel jLabelNome;
	private JPanel jPanel3;
	private JLabel jLabelSottotitolo;
	private JPanel jPanel2;
	public Login login;
	public String[] l;
	public String pNome, pCognome, pLogin, pPassword;
	public MenuDocente gestione;
	public String data_it, giorno, mese,anno, data_en;

	public RegistrazioneDoc(Login l) {
		super();
		login=l;
		initGUI();
	}
	

	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("REGISTRATI");
			{
				jPanel1 = new JPanel();
				BorderLayout jPanel1Layout = new BorderLayout();
				jPanel1.setLayout(jPanel1Layout);
				getContentPane().add(jPanel1, BorderLayout.CENTER);
				{
					jPanel2 = new JPanel();
					GridBagLayout jPanel2Layout = new GridBagLayout();
					jPanel1.add(jPanel2, BorderLayout.NORTH);
					jPanel2.setPreferredSize(new java.awt.Dimension(692, 70));
					jPanel2Layout.rowWeights = new double[] {0.1, 0.1};
					jPanel2Layout.rowHeights = new int[] {7, 7};
					jPanel2Layout.columnWeights = new double[] {0.1};
					jPanel2Layout.columnWidths = new int[] {7};
					jPanel2.setLayout(jPanel2Layout);
					{
						jLabelTitolo = new JLabel();
						jPanel2.add(jLabelTitolo, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						jLabelTitolo.setText("Registrati");
						jLabelTitolo.setFont(new java.awt.Font("Arial",0,18));
					}
					{
						jLabelSottotitolo = new JLabel();
						jPanel2.add(jLabelSottotitolo, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						jLabelSottotitolo.setText("Compila i campi per effettuare la registrazione al sistema");
						jLabelSottotitolo.setFont(new java.awt.Font("Tahoma",0,16));
					}
				}
				{
					jPanel4 = new JPanel();
					GridBagLayout jPanel4Layout = new GridBagLayout();
					jPanel1.add(jPanel4, BorderLayout.CENTER);
					jPanel4Layout.rowWeights = new double[] {0.0, 0.0, 0.0, 0.1, 0.1};
					jPanel4Layout.rowHeights = new int[] {52, 52, 52, 7, 7};
					jPanel4Layout.columnWeights = new double[] {0.0, 0.0, 0.1};
					jPanel4Layout.columnWidths = new int[] {127, 112, 7};
					jPanel4.setLayout(jPanel4Layout);
					{
						jButtonSalva = new JButton();
						jPanel4.add(jButtonSalva, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
						jButtonSalva.setText("Salva");
						jButtonSalva.addActionListener(this);
					}
					{
						jButtonIndietro = new JButton();
						jPanel4.add(jButtonIndietro, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
						jButtonIndietro.setText("Indietro");
						jButtonIndietro.addActionListener(this);
					}
				}
				{
					jPanel3 = new JPanel();
					jPanel1.add(jPanel3, BorderLayout.WEST);
					GridBagLayout jPanel3Layout = new GridBagLayout();
					jPanel3.setPreferredSize(new java.awt.Dimension(351, 496));
					jPanel3Layout.rowWeights = new double[] {0.0, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1};
					jPanel3Layout.rowHeights = new int[] {35, 7, 20, 20, 20, 7, 7, 20, 20, 20, 20, 20, 20, 20};
					jPanel3Layout.columnWeights = new double[] {0.0, 0.1};
					jPanel3Layout.columnWidths = new int[] {148, 7};
					jPanel3.setLayout(jPanel3Layout);
					{
						jLabelNome = new JLabel();
						jPanel3.add(jLabelNome, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						jLabelNome.setText("Nome");
					}
					{
						jLabelCognome = new JLabel();
						jPanel3.add(jLabelCognome, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						jLabelCognome.setText("Cognome");
					}
					{
						jLabelTelefono = new JLabel();
						jPanel3.add(jLabelTelefono, new GridBagConstraints(0, 5, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						jLabelTelefono.setText("Telefono");
					}
					{
						jLabelEmail = new JLabel();
						jPanel3.add(jLabelEmail, new GridBagConstraints(0, 6, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						jLabelEmail.setText("e-mail");
					}
					{
						jLabelIndWeb = new JLabel();
						jPanel3.add(jLabelIndWeb, new GridBagConstraints(0, 7, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						jLabelIndWeb.setText("Indirizzo Web");
					}
					{
						jLabelNpiano = new JLabel();
						jPanel3.add(jLabelNpiano, new GridBagConstraints(0, 9, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						jLabelNpiano.setText("N° piano (ufficio)");
					}
					{
						jLabelUbicazUff = new JLabel();
						jPanel3.add(jLabelUbicazUff, new GridBagConstraints(0, 8, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						jLabelUbicazUff.setText("Ubicazione Ufficio");
					}
					{
						jLabelLogin = new JLabel();
						jPanel3.add(jLabelLogin, new GridBagConstraints(0, 11, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						jLabelLogin.setText("Login");
					}
					{
						jLabelPassword = new JLabel();
						jPanel3.add(jLabelPassword, new GridBagConstraints(0, 12, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						jLabelPassword.setText("Password");
					}
					{
						jTextFieldNome = new JTextField();
						jPanel3.add(jTextFieldNome, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
					}
					{
						jTextFieldCognome = new JTextField();
						jPanel3.add(jTextFieldCognome, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
					}
					{
						jTextFieldTelefono = new JTextField();
						jPanel3.add(jTextFieldTelefono, new GridBagConstraints(1, 5, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
					}
					{
						jTextFieldEmail = new JTextField();
						jPanel3.add(jTextFieldEmail, new GridBagConstraints(1, 6, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
					}
					{
						jTextFieldIndWeb = new JTextField();
						jPanel3.add(jTextFieldIndWeb, new GridBagConstraints(1, 7, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
					}
					{
						jTextFieldNpiano = new JTextField();
						jPanel3.add(jTextFieldNpiano, new GridBagConstraints(1, 9, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
					}
					{
						l=new String[] { " ", "Dipartimento Informatica", "Palazzo delle aule" }; 
						ComboBoxModel jComboBoxUbicUffModel = new DefaultComboBoxModel(l);
						jComboBoxUbicUff = new JComboBox();
						jComboBoxUbicUff.addItem("Dipartimento Informatica");
						jPanel3.add(jComboBoxUbicUff, new GridBagConstraints(1, 8, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
						jComboBoxUbicUff.setModel(jComboBoxUbicUffModel);
					}
					{
						jTextFieldLogin = new JTextField();
						jPanel3.add(jTextFieldLogin, new GridBagConstraints(1, 11, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
					}
					{
						jTextFieldPassword = new JTextField();
						jPanel3.add(jTextFieldPassword, new GridBagConstraints(1, 12, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
					}
					{
						jLabelDNascita = new JLabel();
						jPanel3.add(jLabelDNascita, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						jLabelDNascita.setText("Data di nascita");
					}
					{
						jTextFieldNascita = new JTextField();
						jPanel3.add(jTextFieldNascita, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 100), 0, 0));
					}
					{
						jTextFieldIndirizzo = new JTextField();
						jPanel3.add(jTextFieldIndirizzo, new GridBagConstraints(1, 4, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
					}
					{
						jLabelIndirizzoAb = new JLabel();
						jPanel3.add(jLabelIndirizzoAb, new GridBagConstraints(0, 4, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						jLabelIndirizzoAb.setText("Inidirizzo abitazione");
					}
					{
						jLabelCitta = new JLabel();
						jPanel3.add(jLabelCitta, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						jLabelCitta.setText("Residente a...");
					}
					{
						jTextFieldResidente = new JTextField();
						jPanel3.add(jTextFieldResidente, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
					}
					{
						jLabelFormatoData = new JLabel();
						jPanel3.add(jLabelFormatoData, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0, GridBagConstraints.EAST, GridBagConstraints.HORIZONTAL, new Insets(0, 120, 0, 0), 0, 0));
						jLabelFormatoData.setText("(aaaa-mm-gg)");
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
	
	/**
	 * Con la seguente funzione il docente salva i propri dati, inseriti all'interno
	 * del modulo di registrazione, in un database denominato "schedule_dib" ed accede
	 * al proprio profilo; creato all'interno del sistema di schedulazione.
	 */
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if (e.getActionCommand().equalsIgnoreCase("Indietro"))
		{
		login.setVisible(true);	
		setVisible(false);			
		}
		
		if(e.getActionCommand().equalsIgnoreCase("Salva"))
		{
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
			}
			
			catch(Exception e1)
			{
				System.err.println("Errore nel caricamento del dricer");
			}
			
			try
			{
				Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/schedule_dib","root","");
				conn.setAutoCommit(false);
				Statement stmt=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
				String text = jTextFieldPassword.getText();
				
                String indirizzo, indirizzo2, cognome, cognome2, residenza, residenza2;
				
				data_it=jTextFieldNascita.getText();
				giorno = data_it.substring(0, 2);
				mese = data_it.substring(3,5);
				anno = data_it.substring(6, 10);
				data_en = anno + "-" + mese + "-" + giorno;
				
				indirizzo = jTextFieldIndirizzo.getText();
				int posapice = indirizzo.indexOf("'");
				if(posapice != -1) {
					indirizzo2 = indirizzo.substring(0, posapice+1) + "'" + indirizzo.substring(posapice+1, indirizzo.length()); 
				}
				else
					indirizzo2 = indirizzo;
	
				cognome = jTextFieldCognome.getText();
			    posapice = cognome.indexOf("'");
				if(posapice != -1) {
					cognome2 = cognome.substring(0, posapice+1) + "'" + cognome.substring(posapice+1, cognome.length()); 
				}
				else
					cognome2 = cognome;
				
				residenza = jTextFieldResidente.getText();
			    posapice = residenza.indexOf("'");
				if(posapice != -1) {
					residenza2 = residenza.substring(0, posapice+1) + "'" + residenza.substring(posapice+1, cognome.length()); 
				}
				else
					residenza2 = residenza;
				
				
				
				
				
				String query = "INSERT INTO `dati_docenti` ( `Password` , `Nome` , `Cognome` , `DNascita` , `ResidenzaAb` , `IndirizzoAb` , `Telefono` , `Email` , `IndWeb` , `Npiano` , `UbiUfficio` , `Login` ) VALUES ('"+text+"', '"+jTextFieldNome.getText()+"', '"+ cognome2 +"', '"+ data_en+"', '"+ residenza2 +"', '"+ indirizzo2 +"', '"+jTextFieldTelefono.getText()+"', '"+jTextFieldEmail.getText()+"', '"+jTextFieldIndWeb.getText()+"', '"+jTextFieldNpiano.getText()+"', '"+l[jComboBoxUbicUff.getSelectedIndex()]+"', '"+jTextFieldLogin.getText()+"')";
				
				int righe=stmt.executeUpdate(query);
				
				if (righe != 1)
				{
					JOptionPane.showMessageDialog(null, "Errore aggiornamento database...");
				}
				
				
				
				query= "INSERT INTO `Ruoli` (`Login`,`Ruolo`,`Password`) values ('"+jTextFieldLogin.getText()+"', 'Docente', '"+text+"')";
				
				righe=stmt.executeUpdate(query);
				
				if (righe != 1)
				{
					JOptionPane.showMessageDialog(null, "Errore aggiornamento database...");
				}
				
				
				
				
				conn.commit();
				stmt.close();
				conn.close();
				pNome=jTextFieldNome.getText();
				pCognome=jTextFieldCognome.getText();
				pLogin=jTextFieldLogin.getText();
				pPassword=text;
				JOptionPane.showMessageDialog(null, "Operazione avvenuta con successo...");
				
				   jTextFieldNome.setText("");
				   jTextFieldCognome.setText("");
				   jTextFieldNascita.setText("");
				   jTextFieldResidente.setText("");
				   jTextFieldIndirizzo.setText("");
				   jTextFieldTelefono.setText("");
				   jTextFieldEmail.setText("");
				   jTextFieldIndWeb.setText("");
				   jTextFieldNpiano.setText("");
				   jTextFieldLogin.setText("");
				   jTextFieldPassword.setText("");
				   
				   setVisible(false);
				   MenuDocente menu= new MenuDocente(this);
				   menu.setVisible(true);
			}
			
			catch(Exception exc)
			{
				JOptionPane.showMessageDialog(null, "Errore aggiornamento database..."+exc.getMessage());
			}
		}
		
		
		
	}

}
