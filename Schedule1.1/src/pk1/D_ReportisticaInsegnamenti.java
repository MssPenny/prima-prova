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
* dei dati inerenti agli insegnamenti che gli sono stati assegnati dall'amministratore
* del sistema. I file verranno salvati all'interno del computer ed in particolare all'interno
* di "c:".
*/
public class D_ReportisticaInsegnamenti extends javax.swing.JFrame implements ActionListener {
	private JPanel jPanel1;
	private JLabel jLabelTitolo;
	private JButton jButtonIndice;
	private JButton jButtonStampaPdf;
	private JButton jButtonStampaHtml;
	private JPanel jPanel4;
	private JPanel jPanel3;
	private JLabel jLabelSottotitolo;
	private JPanel jPanel2;
	public MenuReportisticaDocente j2;
	public String pLogin, pPassword, pNome, pCognome;

	
	
	public D_ReportisticaInsegnamenti(MenuReportisticaDocente j) {
		super();
		j2=j;
		initGUI();
	}
	
	private void initGUI() {
		pLogin=j2.pLogin;
		pPassword=j2.pPassword;
		pNome=j2.pNome;
		pCognome=j2.pCognome;
		
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("REPORTISTICA INSEGNAMENTI");
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
						jLabelTitolo.setText("Reportistica Insegnamenti");
						jLabelTitolo.setFont(new java.awt.Font("Arial",0,18));
					}
					{
						jLabelSottotitolo = new JLabel();
						jPanel2.add(jLabelSottotitolo, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						jLabelSottotitolo.setText("Stampa di tutti gli insegnamenti in formato .html  ed in .pdf");
						jLabelSottotitolo.setFont(new java.awt.Font("Tahoma",0,16));
					}
				}
				{
					jPanel3 = new JPanel();
					jPanel1.add(jPanel3, BorderLayout.WEST);
					jPanel3.setPreferredSize(new java.awt.Dimension(350, 486));
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
			j2.setVisible(true);
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
				
				query="Select * from dati_insegnamento di, associa_doc ad where ad.Login='"+pLogin+"' and ad.Password='"+pPassword+"' and di.Nome_insegn=ad.Nome_insegn and di.Corso_laurea=ad.Corso_laurea";
				System.out.println(query);
				ResultSet rs=stmt.executeQuery(query);
				
				Document doc=new Document();
				try
				{
					PdfWriter.getInstance(doc, new FileOutputStream("C:/Dati insegnamenti.pdf"));
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
					doc.add(new Paragraph("                               Dipartimento di Informatica dell'Universit� degli studi di Bari             "));
					doc.add(new Paragraph("                                       Facolt� di scienze metmetiche, fisiche e naturali                    "));
					doc.add(new Paragraph("                                               Campus, Via Orabona n�4 - 70126 Bari                          "));
					doc.add(new Paragraph(" "));
					doc.add(new Paragraph(" "));
					doc.add(new Paragraph ("Al docente " +pNome+" "+pCognome+" sono stati associati i seguenti corsi d'insegnamento:"));
					doc.add(new Paragraph(" "));
				}
				catch(DocumentException e4)
				{
					e4.printStackTrace();
				}
					while(rs.next())
				{
					
					
					try
					{
						
						doc.add(new Paragraph(" "));
						doc.add(new Paragraph("DATI INSEGNAMENTO"));
						doc.add(new Paragraph ("Nome insegnamento: " + rs.getString("Nome_insegn")));
						doc.add(new Paragraph ("Corso di laurea: " + rs.getString("Corso_laurea")));
						doc.add(new Paragraph ("Numero di crediti: " + rs.getString("Ncrediti")));
						doc.add(new Paragraph ("Anno di appartenenza: " + rs.getString("Anno")));
						doc.add(new Paragraph ("Esame propedeutico: " + rs.getString("Propedeutico")));
						doc.add(new Paragraph ("Laboratorio: " + rs.getString("Laboratorio")));
						doc.add(new Paragraph ("Tipologia di valutazione: " + rs.getString("Valutazione")));
						
						
					}
					catch(DocumentException e4)
					{
						e4.printStackTrace();
					}
					
				}
				doc.close();
				JOptionPane.showMessageDialog(null, "Documento creato con successo");
				
				conn.commit();
				stmt.close();
				conn.close();
			}
			catch(Exception exc)
			{
				JOptionPane.showMessageDialog(null, "Errore aggiornamento database"+exc.getMessage());
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
			    
			    query="Select * from dati_insegnamento di, associa_doc ad where ad.Login='"+pLogin+"' and ad.Password='"+pPassword+"' and di.Nome_insegn=ad.Nome_insegn and di.Corso_laurea=ad.Corso_laurea";
			    
			    System.out.println(query);
			    ResultSet rs=stmt.executeQuery(query);
			    
			    
			    
			    
			   
			    	Document doc=new Document();
			    	try
			    	{
			    		HtmlWriter.getInstance(doc, new FileOutputStream("C:/Dati insegnamenti.html"));
			    	}
			    	catch(FileNotFoundException e2)
			    	{
			    		e2.printStackTrace();
			    	}
			    	
			    	doc.open();
			    	try
			    	{
			    		doc.add(new Paragraph(" "));
			    		doc.add(new Paragraph(" "));
			    		doc.add(new Paragraph ("Al docente " +pNome+" "+pCognome+" sono stati associati i seguenti corsi d'insegnamento:"));
						doc.add(new Paragraph(" "));
			    	}
			    	catch(Exception e4)
			    	{
			    		e4.printStackTrace();
			    	}
			    	
			    	
			    	while(rs.next())
			    	{
			    	try
			    	{
			    		doc.add(new Paragraph(" "));
			    		doc.add(new Paragraph(" "));
			    		doc.add(new Paragraph("DATI INSEGNAMENTO"));
						doc.add(new Paragraph ("Nome insegnamento: " + rs.getString("Nome_insegn")));
						doc.add(new Paragraph ("Corso di laurea: " + rs.getString("Corso_laurea")));
						doc.add(new Paragraph ("Numero di crediti: " + rs.getString("Ncrediti")));
						doc.add(new Paragraph ("Anno di appartenenza: " + rs.getString("Anno")));
						doc.add(new Paragraph ("Esame propedeutico: " + rs.getString("Propedeutico")));
						doc.add(new Paragraph ("Laboratorio: " + rs.getString("Laboratorio")));
						doc.add(new Paragraph ("Tipologia di valutazione: " + rs.getString("Valutazione")));
						doc.add(new Paragraph ("________________________________________________________"));
			    	}
			    	catch(Exception e4)
			    	{
			    		e4.printStackTrace();
			    	}
			    	
			    }
			    doc.close();
			    JOptionPane.showMessageDialog(null, "Documento creato con successo");	
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

}
