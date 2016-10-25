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

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Paragraph;
import com.lowagie.text.html.HtmlWriter;
import com.lowagie.text.pdf.PdfWriter;


/**
* La seguente classe consente all'amministratore di poter effettuare la stampa su file 
* (.pdf e .html) delle informazioni personali solo dei docenti seleziaonti.
* I file verranno salvati nell'elaboratore ed in particolare in "c:".
*/
public class A_ReportisticaDatiPersonali2 extends javax.swing.JFrame implements ActionListener, ListSelectionListener {
	private JPanel jPanel1;
	private JLabel jLabelTitolo;
	private JLabel jLabelNomeCognome;
	private JList jListDocenti;
	private JButton jButtonIndietro;
	private JButton jButtonStampaPdf;
	private JButton jButtonStampaHtml;
	private JPanel jPanel4;
	private JPanel jPanel3;
	private JLabel jLabelSottotitolo;
	private JPanel jPanel2;
	public A_ReportisticaDatiPersonali t3;
	public Vector vettore=new Vector();
	public String pNome, pCognome;

	
	
	public A_ReportisticaDatiPersonali2(A_ReportisticaDatiPersonali t) {
		super();
		t3=t;
		initGUI();
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
					jPanel2.setPreferredSize(new java.awt.Dimension(692, 83));
					jPanel2Layout.rowWeights = new double[] {0.1, 0.1};
					jPanel2Layout.rowHeights = new int[] {7, 7};
					jPanel2Layout.columnWeights = new double[] {0.1};
					jPanel2Layout.columnWidths = new int[] {7};
					jPanel2.setLayout(jPanel2Layout);
					{
						jLabelTitolo = new JLabel();
						jPanel2.add(jLabelTitolo, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						jLabelTitolo.setText("Reportistica Dati Personali");
						jLabelTitolo.setFont(new java.awt.Font("Arial",0,18));
					}
					{
						jLabelSottotitolo = new JLabel();
						jPanel2.add(jLabelSottotitolo, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						jLabelSottotitolo.setText("Stampa dei dati persoanli di un singolo docente in formato .html e .pdf");
						jLabelSottotitolo.setFont(new java.awt.Font("Tahoma",0,16));
					}
				}
				{
					jPanel3 = new JPanel();
					GridBagLayout jPanel3Layout = new GridBagLayout();
					jPanel1.add(jPanel3, BorderLayout.WEST);
					jPanel3.setPreferredSize(new java.awt.Dimension(344, 483));
					jPanel3Layout.rowWeights = new double[] {0.0, 0.0, 0.1};
					jPanel3Layout.rowHeights = new int[] {35, 410, 7};
					jPanel3Layout.columnWeights = new double[] {0.0, 0.1};
					jPanel3Layout.columnWidths = new int[] {7, 7};
					jPanel3.setLayout(jPanel3Layout);
					{
						jLabelNomeCognome = new JLabel();
						jPanel3.add(jLabelNomeCognome, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						jLabelNomeCognome.setText("Nome e Cognome");
					}
					{
						ListModel jListDocentiModel = 
							new DefaultComboBoxModel(
									new String[] { "Item One", "Item Two" });
						jListDocenti = new JList();
						jListDocenti.setVisibleRowCount(0);
						jListDocenti.addListSelectionListener((ListSelectionListener)this);
						jPanel3.add(jListDocenti, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
						jListDocenti.setModel(jListDocentiModel);
						JScrollPane scroll=new JScrollPane(jListDocenti);
						jPanel3.add(scroll, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
					}
					
					try
					{
						Class.forName("com.mysql.jdbc.Driver");
					}
					catch(Exception e1)
					{
						System.err.println("Errore nel caricamento del Driver");
					}
					
					try
					{
						Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/schedule_dib","root","");
						conn.setAutoCommit(false);
						Statement stmt=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
						String query;
						
						query="Select Nome, Cognome from dati_docenti, ruoli where dati_docenti.Password=ruoli.Password and dati_docenti.Login=ruoli.Login and Ruolo='docente'";
						ResultSet rs=stmt.executeQuery(query);
						
						while(rs.next())
						{
							vettore.add(rs.getString("Nome")+"     "+rs.getString("Cognome"));
						}
						conn.commit();
						stmt.close();
						conn.close();
					}
					catch(Exception exc)
					{
						System.err.println("Errore"+exc);
					}
					jListDocenti.setListData(vettore);
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
						jButtonStampaHtml = new JButton();
						jPanel4.add(jButtonStampaHtml, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
						jButtonStampaHtml.setText("Stampa .html");
						jButtonStampaHtml.addActionListener(this);
					}
					{
						jButtonStampaPdf = new JButton();
						jPanel4.add(jButtonStampaPdf, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
						jButtonStampaPdf.setText("Stampa .pdf");
						jButtonStampaPdf.addActionListener(this);
					}
					{
						jButtonIndietro = new JButton();
						jPanel4.add(jButtonIndietro, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
						jButtonIndietro.setText("Indietro");
						jButtonIndietro.addActionListener(this);
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
		
		if(e.getActionCommand().equalsIgnoreCase("Indietro"))
		{
			setVisible(false);
			t3.setVisible(true);
		}
		
		if(e.getActionCommand().equalsIgnoreCase("Stampa .pdf"))
		{
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
				
				query="Select * from dati_docenti, ruoli where dati_docenti.Nome='"+pNome+"' and dati_docenti.Cognome='"+pCognome+"' and dati_docenti.Login=ruoli.Login and dati_docenti.Password=ruoli.Password and ruoli.ruolo='Docente'";
				
				System.out.println(query);
				ResultSet rs=stmt.executeQuery(query);
				
				while(rs.next())
				{
					Document doc=new Document();
					try
					{
						PdfWriter.getInstance(doc, new FileOutputStream("C:/Amm_Dati personali(i).pdf"));
					}
					catch(FileNotFoundException e2)
					{
						e2.printStackTrace();
					}
					catch(DocumentException e3)
					{
						e3.printStackTrace();
					}
					
					doc.open();
					
					try
					{
						doc.add(new Paragraph("                                                                   SCHEDULE                                       "));
						doc.add(new Paragraph("                               Dipartimento di Informatica dell'Università degli studi di Bari             "));
						doc.add(new Paragraph("                                       Facoltà di scienze metmetiche, fisiche e naturali                    "));
						doc.add(new Paragraph("                                               Campus, Via Orabona n°4 - 70126 Bari                          "));
						doc.add(new Paragraph(" "));
						doc.add(new Paragraph(" "));
						doc.add(new Paragraph("Origine documento: Area amministrativa "));
						doc.add(new Paragraph(" "));
						doc.add(new Paragraph ("I dati personali del docente " +pNome+" "+pCognome+",  sono:"));
						doc.add(new Paragraph(" "));
						doc.add(new Paragraph("DATI DOCENTE"));
						doc.add(new Paragraph ("Nome: " + rs.getString("Nome")));
						doc.add(new Paragraph ("Cognome: " + rs.getString("Cognome")));
						doc.add(new Paragraph ("Data di nascita: " + rs.getString("DNascita")));
						doc.add(new Paragraph ("Residenza: " + rs.getString("ResidenzaAb")));
						doc.add(new Paragraph ("Indirizzo abitazione: " + rs.getString("IndirizzoAb")));
						doc.add(new Paragraph ("Telefono: " + rs.getString("Telefono")));
						doc.add(new Paragraph ("e-mail: " + rs.getString("Email")));
						doc.add(new Paragraph ("Indirizzo web: " + rs.getString("IndWeb")));
						doc.add(new Paragraph ("N° piano: " + rs.getString("Npiano")));
						doc.add(new Paragraph ("Ubicazione ufficio: " + rs.getString("UbiUfficio")));
						doc.add(new Paragraph ("Login schedule: " + rs.getString("Login")));
						doc.add(new Paragraph ("Password schedule: " + rs.getString("Password")));
						
					}
					catch(DocumentException e4)
					{
						e4.printStackTrace();
					}
					doc.close();
					JOptionPane.showMessageDialog(null, "Documento creato con successo");
				}
				conn.commit();
				stmt.close();
				conn.close();
			}
			catch(Exception exc)
			{
				JOptionPane.showMessageDialog(null, "Errore aggionamento database"+exc.getMessage());
			}
		}
		
		
		if(e.getActionCommand().equalsIgnoreCase("Stampa .html"))
		{
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
				
				query="Select * from dati_docenti, ruoli where dati_docenti.Nome='"+pNome+"' and dati_docenti.Cognome='"+pCognome+"' and dati_docenti.Login=ruoli.Login and dati_docenti.Password=ruoli.Password and ruoli.ruolo='Docente'";
				
				System.out.println(query);
				ResultSet rs=stmt.executeQuery(query);
				
				while(rs.next())
				{
					Document doc=new Document();
					try
					{
						HtmlWriter.getInstance(doc, new FileOutputStream("C:/Amm_Dati personali(i).html"));
					}
					catch(FileNotFoundException e2)
					{
						e2.printStackTrace();
					}
					
					doc.open();
					
					try
					{
						doc.add(new Paragraph("Origine documento: Area amministrativa "));
						doc.add(new Paragraph(" "));
						doc.add(new Paragraph ("I dati personali del docente " +pNome+" "+pCognome+",  sono:"));
						doc.add(new Paragraph(" "));
						doc.add(new Paragraph("DATI DOCENTE"));
						doc.add(new Paragraph ("Nome: " + rs.getString("Nome")));
						doc.add(new Paragraph ("Cognome: " + rs.getString("Cognome")));
						doc.add(new Paragraph ("Data di nascita: " + rs.getString("DNascita")));
						doc.add(new Paragraph ("Residenza: " + rs.getString("ResidenzaAb")));
						doc.add(new Paragraph ("Indirizzo abitazione: " + rs.getString("IndirizzoAb")));
						doc.add(new Paragraph ("Telefono: " + rs.getString("Telefono")));
						doc.add(new Paragraph ("e-mail: " + rs.getString("Email")));
						doc.add(new Paragraph ("Indirizzo web: " + rs.getString("IndWeb")));
						doc.add(new Paragraph ("N° piano: " + rs.getString("Npiano")));
						doc.add(new Paragraph ("Ubicazione ufficio: " + rs.getString("UbiUfficio")));
						doc.add(new Paragraph ("Login schedule: " + rs.getString("Login")));
						doc.add(new Paragraph ("Password schedule: " + rs.getString("Password")));
						
					}
					catch(Exception e4)
					{
						e4.printStackTrace();
					}
					
					doc.close();
					JOptionPane.showMessageDialog(null, "Documento creato con successo");
					
				}
				conn.commit();
				stmt.close();
				conn.close();
			}
			catch(Exception exc)
			{
				JOptionPane.showMessageDialog(null, "Errore aggiornamento database"+exc.getMessage());
			}
		}
			
	}

	@Override
	public void valueChanged(ListSelectionEvent arg0) {
		// TODO Auto-generated method stub
		
		String totale=(String)jListDocenti.getSelectedValue();
		StringTokenizer t=new StringTokenizer(totale, " ");
		pNome=t.nextToken().trim();
		pCognome=t.nextToken().trim();
		
	}

}
