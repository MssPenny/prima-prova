package pk1;
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Paragraph;
import com.lowagie.text.html.HtmlWriter;
import com.lowagie.text.pdf.PdfWriter;


/**
* La seguente classe consente al docente di poter effettuare la stampa su file (.pdf e .html)
* dei propri dati personali. I file verranno salvati nella memoria del computer ed in
* particolare in "c:".
*/
public class D_ReportisticaDatiPersonali extends javax.swing.JFrame implements ActionListener {
	private JPanel jPanel1;
	private JLabel jLabelTitolo;
	private JLabel jLabelTelefono;
	private JLabel jLabelIndirizzoAb;
	private JLabel jLabelCitta;
	private JLabel jLabelDNascita;
	private JLabel jLabelPassword;
	private JLabel jLabelLogin;
	private JLabel jLabelUbicazione;
	private JLabel jLabelNpiano;
	private JLabel jLabelIndWeb;
	private JLabel jLabelEmail;
	private JLabel jLabelCognome;
	private JLabel jLabelNome;
	private JButton jButtonIndice;
	private JButton jButtonStampaHtml;
	private JButton jButtonStampaPdf;
	private JPanel jPanel4;
	private JPanel jPanel3;
	private JLabel jLabelSottotitolo;
	private JPanel jPanel2;
	public MenuReportisticaDocente k2;
	public String Password;
	public String data_it, giorno, mese,anno, data_en, data;

	public D_ReportisticaDatiPersonali(MenuReportisticaDocente k, String pwd) {
		super();
		k2=k;
		initGUI();
		Password = pwd;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch(Exception e1) {
			System.err.println("Errore nel caricamento del driver");
		}
		
		
		try {
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/schedule_dib","root","");
			conn.setAutoCommit(false);
			Statement stmt=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			String query;
			query="SELECT * FROM dati_docenti WHERE Password='"+Password+"'";
			
			ResultSet rs = stmt.executeQuery(query);
			
			while (rs.next())
			{
				jLabelNome.setText("Nome: " + rs.getString("Nome"));
				jLabelCognome.setText("Cognome: " + rs.getString("Cognome"));
				
				data= rs.getString("DNascita");
				giorno = data.substring(8, 10);
				mese = data.substring(5, 7);
				anno = data.substring(0, 4);
				data_it = giorno + "/" + mese + "/" + anno;
				
				jLabelDNascita.setText("Data di nascita: " + data_it);
				jLabelCitta.setText("Residente a : " + rs.getString("ResidenzaAb"));
				jLabelIndirizzoAb.setText("Indirizzo abitazione: " + rs.getString("IndirizzoAb"));
				jLabelTelefono.setText("Telefono: " + rs.getString("Telefono"));
				jLabelEmail.setText("e-mail: " +rs.getString("Email"));
				jLabelIndWeb.setText("Indirizzo Web: " +rs.getString("IndWeb"));
				jLabelNpiano.setText("N° piano: " +rs.getString("Npiano"));
				jLabelUbicazione.setText("Ubicazione: " +rs.getString("UbiUfficio"));
				jLabelLogin.setText("Login: " + rs.getString("Login"));
				jLabelPassword.setText("Password: " + rs.getString("Password"));
			
		}
			conn.commit();
			stmt.close();
			conn.close();	
		}
		catch(Exception exc) {
			System.err.println("Errore" +exc);
			
		}
		
		
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("REPORTISTICA DATI PERSONALI");
			{
				jPanel1 = new JPanel();
				BorderLayout jPanel1Layout = new BorderLayout();
				jPanel1.setLayout(jPanel1Layout);
				getContentPane().add(jPanel1, BorderLayout.CENTER);
				{
					jPanel2 = new JPanel();
					GridBagLayout jPanel2Layout = new GridBagLayout();
					jPanel1.add(jPanel2, BorderLayout.NORTH);
					jPanel2.setPreferredSize(new java.awt.Dimension(692, 76));
					jPanel2Layout.rowWeights = new double[] {0.1, 0.1};
					jPanel2Layout.rowHeights = new int[] {7, 7};
					jPanel2Layout.columnWeights = new double[] {0.1};
					jPanel2Layout.columnWidths = new int[] {7};
					jPanel2.setLayout(jPanel2Layout);
					{
						jLabelTitolo = new JLabel();
						jPanel2.add(jLabelTitolo, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						jLabelTitolo.setText("Dati personali");
						jLabelTitolo.setFont(new java.awt.Font("Arial",0,18));
					}
					{
						jLabelSottotitolo = new JLabel();
						jPanel2.add(jLabelSottotitolo, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						jLabelSottotitolo.setText("Stampa dei dati personali");
						jLabelSottotitolo.setFont(new java.awt.Font("Tahoma",0,16));
					}
				}
				{
					jPanel3 = new JPanel();
					GridBagLayout jPanel3Layout = new GridBagLayout();
					jPanel1.add(jPanel3, BorderLayout.WEST);
					jPanel3.setPreferredSize(new java.awt.Dimension(350, 492));
					jPanel3Layout.rowWeights = new double[] {0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1};
					jPanel3Layout.rowHeights = new int[] {20, 7, 7, 20, 20, 20, 7, 7, 20, 20, 20, 20, 20, 20};
					jPanel3Layout.columnWeights = new double[] {0.0, 0.1, 0.1};
					jPanel3Layout.columnWidths = new int[] {7, 7, 7};
					jPanel3.setLayout(jPanel3Layout);
					{
						jLabelNome = new JLabel();
						jPanel3.add(jLabelNome, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						jLabelNome.setText("Nome");
					}
					{
						jLabelCognome = new JLabel();
						jPanel3.add(jLabelCognome, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						jLabelCognome.setText("Cognome");
					}
					{
						jLabelTelefono = new JLabel();
						jPanel3.add(jLabelTelefono, new GridBagConstraints(1, 6, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						jLabelTelefono.setText("Telefono");
					}
					{
						jLabelEmail = new JLabel();
						jPanel3.add(jLabelEmail, new GridBagConstraints(1, 7, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						jLabelEmail.setText("e-mail");
					}
					{
						jLabelIndWeb = new JLabel();
						jPanel3.add(jLabelIndWeb, new GridBagConstraints(1, 8, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						jLabelIndWeb.setText("Indirizzo web");
					}
					{
						jLabelNpiano = new JLabel();
						jPanel3.add(jLabelNpiano, new GridBagConstraints(1, 9, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						jLabelNpiano.setText("N° piano");
					}
					{
						jLabelUbicazione = new JLabel();
						jPanel3.add(jLabelUbicazione, new GridBagConstraints(1, 10, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						jLabelUbicazione.setText("Ubicazione ufficio");
					}
					{
						jLabelLogin = new JLabel();
						jPanel3.add(jLabelLogin, new GridBagConstraints(1, 11, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						jLabelLogin.setText("Login");
					}
					{
						jLabelPassword = new JLabel();
						jPanel3.add(jLabelPassword, new GridBagConstraints(1, 12, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						jLabelPassword.setText("Password");
					}
					{
						jLabelDNascita = new JLabel();
						jPanel3.add(jLabelDNascita, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						jLabelDNascita.setText("Data di nascita");
					}
					{
						jLabelCitta = new JLabel();
						jPanel3.add(jLabelCitta, new GridBagConstraints(1, 4, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						jLabelCitta.setText("Residente a...");
					}
					{
						jLabelIndirizzoAb = new JLabel();
						jPanel3.add(jLabelIndirizzoAb, new GridBagConstraints(1, 5, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						jLabelIndirizzoAb.setText("Indirizzo abitazione");
					}
				}
				{
					jPanel4 = new JPanel();
					GridBagLayout jPanel4Layout = new GridBagLayout();
					jPanel1.add(jPanel4, BorderLayout.CENTER);
					jPanel4Layout.rowWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.1};
					jPanel4Layout.rowHeights = new int[] {50, 50, 50, 50, 7};
					jPanel4Layout.columnWeights = new double[] {0.0, 0.0, 0.1};
					jPanel4Layout.columnWidths = new int[] {120, 120, 7};
					jPanel4.setLayout(jPanel4Layout);
					{
						jButtonStampaPdf = new JButton();
						jPanel4.add(jButtonStampaPdf, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
						jButtonStampaPdf.setText("Stampa .pdf");
						jButtonStampaPdf.addActionListener(this);
					}
					{
						jButtonStampaHtml = new JButton();
						jPanel4.add(jButtonStampaHtml, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
						jButtonStampaHtml.setText("Stampa .html");
						jButtonStampaHtml.addActionListener(this);
					}
					{
						jButtonIndice = new JButton();
						jPanel4.add(jButtonIndice, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
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
		
		if(e.getActionCommand().equalsIgnoreCase("Indice"))
		{
			setVisible(false);
			k2.setVisible(true);
		}
		
		if (e.getActionCommand().equalsIgnoreCase("Stampa .pdf")) //Stampa in pdf
		{
			Document doc=new Document();
			try {
				PdfWriter.getInstance(doc, new FileOutputStream("C:/Dati docenti.pdf"));				
				
			} catch (FileNotFoundException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			} catch (DocumentException e3) {
				// TODO Auto-generated catch block
				e3.printStackTrace();
			}
			
			doc.open();
			try {
				doc.add(new Paragraph("                                                                   SCHEDULE                                       "));
				doc.add(new Paragraph("                               Dipartimento di Informatica dell'Università degli studi di Bari             "));
				doc.add(new Paragraph("                                       Facoltà di scienze metmetiche, fisiche e naturali                    "));
				doc.add(new Paragraph("                                               Campus, Via Orabona n°4 - 70126 Bari                          "));
				doc.add(new Paragraph(" "));
				doc.add(new Paragraph(" "));
				doc.add(new Paragraph("DATI DOCENTE"));
				doc.add(new Paragraph (jLabelNome.getText()));
				doc.add(new Paragraph (jLabelCognome.getText()));
				doc.add(new Paragraph (jLabelDNascita.getText()));
				doc.add(new Paragraph (jLabelCitta.getText()));
				doc.add(new Paragraph (jLabelIndirizzoAb.getText()));
				doc.add(new Paragraph (jLabelTelefono.getText()));
				doc.add(new Paragraph (jLabelEmail.getText()));
				doc.add(new Paragraph (jLabelIndWeb.getText()));
				doc.add(new Paragraph (jLabelNpiano.getText()));
				doc.add(new Paragraph (jLabelUbicazione.getText()));
				doc.add(new Paragraph (jLabelLogin.getText()));
				doc.add(new Paragraph (jLabelPassword.getText()));
			
			} catch (DocumentException e4) {
				// TODO Auto-generated catch block
				e4.printStackTrace();
			}
			
			doc.close();
			JOptionPane.showMessageDialog(null, "Documento creato con successo");
		}
		
		
		if (e.getActionCommand().equalsIgnoreCase("Stampa .html")) //Stampa in html
		{
			Document doc=new Document();
			try {
				HtmlWriter.getInstance(doc, new FileOutputStream("C:/Dati docenti.html"));				
				
			} catch (FileNotFoundException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			
			doc.open();
			try {
				doc.add(new Paragraph("DATI DOCENTE"));
				doc.add(new Paragraph (jLabelNome.getText()));
				doc.add(new Paragraph (jLabelCognome.getText()));
				doc.add(new Paragraph (jLabelDNascita.getText()));
				doc.add(new Paragraph (jLabelCitta.getText()));
				doc.add(new Paragraph (jLabelIndirizzoAb.getText()));
				doc.add(new Paragraph (jLabelTelefono.getText()));
				doc.add(new Paragraph (jLabelEmail.getText()));
				doc.add(new Paragraph (jLabelIndWeb.getText()));
				doc.add(new Paragraph (jLabelNpiano.getText()));
				doc.add(new Paragraph (jLabelUbicazione.getText()));
				doc.add(new Paragraph (jLabelLogin.getText()));
				doc.add(new Paragraph (jLabelPassword.getText()));
			
		
			} catch (DocumentException e4) {
				// TODO Auto-generated catch block
				e4.printStackTrace();
			}
			
			doc.close();
			JOptionPane.showMessageDialog(null, "Documento creato con successo");
		}
		
	}

}
