package pk1;
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;
import java.util.*;
import java.util.StringTokenizer;


/**
* All'interno della seguente classe viene visualizzato il progarmma didattico di un dato 
* corso di insegnamento, associato al docente corrispondente. Il testo relativo al programma
* didattico, una volta visulizzato, può essere modificato dal docente stesso all'interno
* dell'area di visualizzazione dei dati. Le modifiche apportate al testo, relativo al programma
* didattico, vengono salvate su un file di estensione (.txt). 
*/
public class VisualizModificaProgramma extends javax.swing.JFrame implements ActionListener {
	private JPanel jPanel1;
	private JLabel jLabelTitolo;
	private JLabel jLabelDocente;
	private JLabel jLabelCorsoLaurea;
	private JLabel jLabelSottotitolo;
	private JPanel jPanel3;
	private JPanel jPanel2;
	public VisualizzaProgramma g6;
	public String pCorso, pIns;
	private JLabel jLabelValutazione;
	private JLabel jLabelLaboratorio;
	private JLabel jLabelPropedeutico;
	private JLabel jLabelAnno;
	private JLabel jLabelNcrediti;
	private JLabel jLabelInfoCorso;
	private JTextArea jTextArea;
	private JLabel jLabelProgramma;
	private JButton jButtonIndietro;
	private JButton jButtonSalva;
	private JPanel jPanel5;
	private JPanel jPanel4;
	public String nome_file;
	public String login, password;

	
	
	public VisualizModificaProgramma(VisualizzaProgramma g, String nome_f, String pIns1, String pCorso1, String pLogin1, String pPassword1) {
		super();
		
		g6=g;
		nome_file=nome_f;
		
		initGUI();
		pIns=pIns1;
		pCorso=pCorso1;
		
		login=pLogin1;
		password=pPassword1;
	
		
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
			
			query="SELECT * FROM dati_insegnamento WHERE Nome_insegn='"+pIns+"' and Corso_laurea='"+pCorso+"'";
			
			ResultSet rs= stmt.executeQuery(query);
			while(rs.next())
			{
				jLabelInfoCorso.setText("Info corso d'insegnamento: "+rs.getString("Nome_insegn"));
				jLabelCorsoLaurea.setText("Corso di laurea: "+rs.getString("Corso_laurea"));
				jLabelNcrediti.setText("N° crediti: "+rs.getString("Ncrediti"));
				jLabelAnno.setText("Anno: "+rs.getString("Anno"));
				jLabelPropedeutico.setText("Propedeutico: "+rs.getString("Propedeutico"));
				jLabelLaboratorio.setText("Laboratorio: "+rs.getString("Laboratorio"));
				jLabelValutazione.setText("Valutazione: "+rs.getString("Valutazione"));
			}
			conn.commit();
			stmt.close();
			conn.close();
			
		}
		catch(Exception exc)
		{
			System.err.println("Errore"+exc);
		}
		
		
		
		
		
		//nome e cognome del docente assegnatario
		
		try
		{
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/schedule_dib","root","");
			conn.setAutoCommit(false);
			Statement stmt=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			String query;
			
			query="SELECT Nome, Cognome FROM dati_docenti where Login='"+login+"' and Password='"+password+"'";
			
			ResultSet rs1 = stmt.executeQuery(query);
			
			while (rs1.next())
			{
				jLabelDocente.setText("Docente assegnatario del corso d'insegnamento: " + rs1.getString("Nome")+ " "+rs1.getString("Cognome"));
			}	
			
			conn.commit();
			stmt.close();
			conn.close();
			
		}
		catch(Exception exc)
		{
			System.err.println("Errore" +exc);
		}
		
		
		
	
		
		try
		{
			BufferedReader in = new BufferedReader (new FileReader("c:/" + nome_file + ".txt"));
			String line;
			
			
			StringTokenizer t=null;
			while((line=in.readLine())!=null)
			{
				t = new StringTokenizer(line, "\n\r");
				for(int k=0; k< t.countTokens(); k++)
				{
							jTextArea.append(t.nextToken());
				} 
			   
			}
			in.close();
			
		}
		catch(Exception exc)
		{
			
		}
		
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("VISUALIZZA/MODIFICA IL PROGRAMMA DIDATTICO");
			{
				jPanel1 = new JPanel();
				BorderLayout jPanel1Layout = new BorderLayout();
				jPanel1.setLayout(jPanel1Layout);
				getContentPane().add(jPanel1, BorderLayout.CENTER);
				{
					jPanel2 = new JPanel();
					GridBagLayout jPanel2Layout = new GridBagLayout();
					jPanel1.add(jPanel2, BorderLayout.NORTH);
					jPanel2.setPreferredSize(new java.awt.Dimension(692, 81));
					jPanel2Layout.rowWeights = new double[] {0.1, 0.1};
					jPanel2Layout.rowHeights = new int[] {7, 7};
					jPanel2Layout.columnWeights = new double[] {0.1};
					jPanel2Layout.columnWidths = new int[] {7};
					jPanel2.setLayout(jPanel2Layout);
					{
						jLabelTitolo = new JLabel();
						jPanel2.add(jLabelTitolo, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						jLabelTitolo.setText("Programma didattico");
						jLabelTitolo.setFont(new java.awt.Font("Arial",0,18));
					}
					{
						jLabelSottotitolo = new JLabel();
						jPanel2.add(jLabelSottotitolo, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						jLabelSottotitolo.setText("Visualizza/Modifica il programma didattico");
						jLabelSottotitolo.setFont(new java.awt.Font("Tahoma",0,16));
					}
				}
				{
					jPanel3 = new JPanel();
					GridBagLayout jPanel3Layout = new GridBagLayout();
					jPanel1.add(jPanel3, BorderLayout.WEST);
					jPanel3.setPreferredSize(new java.awt.Dimension(351, 365));
					jPanel3Layout.rowWeights = new double[] {0.0, 0.1, 0.0, 0.1, 0.1, 0.1, 0.0, 0.1, 0.0};
					jPanel3Layout.rowHeights = new int[] {7, 20, 20, 20, 20, 20, 20, 20, 7};
					jPanel3Layout.columnWeights = new double[] {0.0, 0.1};
					jPanel3Layout.columnWidths = new int[] {7, 7};
					jPanel3.setLayout(jPanel3Layout);
					
					{
						jLabelCorsoLaurea = new JLabel();
						jPanel3.add(jLabelCorsoLaurea, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						jLabelCorsoLaurea.setText("Corso di laurea: ");
					}
					{
						jLabelInfoCorso = new JLabel();
						jPanel3.add(jLabelInfoCorso, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						jLabelInfoCorso.setText("Info corso d'insegnamento:");
						jLabelInfoCorso.setFont(new java.awt.Font("Arial",0,12));
					}
					{
						jLabelNcrediti = new JLabel();
						jPanel3.add(jLabelNcrediti, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						jLabelNcrediti.setText("N° crediti:");
					}
					{
						jLabelAnno = new JLabel();
						jPanel3.add(jLabelAnno, new GridBagConstraints(1, 4, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						jLabelAnno.setText("Anno:");
					}
					{
						jLabelPropedeutico = new JLabel();
						jPanel3.add(jLabelPropedeutico, new GridBagConstraints(1, 5, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						jLabelPropedeutico.setText("Propedeutico:");
					}
					{
						jLabelLaboratorio = new JLabel();
						jPanel3.add(jLabelLaboratorio, new GridBagConstraints(1, 6, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						jLabelLaboratorio.setText("Laboratorio:");
					}
					{
						jLabelValutazione = new JLabel();
						jPanel3.add(jLabelValutazione, new GridBagConstraints(1, 7, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						jLabelValutazione.setText("Valutazione:");
					}
				}
				{
					jPanel4 = new JPanel();
					GridBagLayout jPanel4Layout = new GridBagLayout();
					jPanel1.add(jPanel4, BorderLayout.SOUTH);
					jPanel4.setPreferredSize(new java.awt.Dimension(692, 462));
					jPanel4Layout.rowWeights = new double[] {0.0, 0.0, 0.1, 0.0};
					jPanel4Layout.rowHeights = new int[] {36, 395, 20, 7};
					jPanel4Layout.columnWeights = new double[] {0.0, 0.1, 0.0};
					jPanel4Layout.columnWidths = new int[] {7, 7, 7};
					jPanel4.setLayout(jPanel4Layout);
					{
						jLabelProgramma = new JLabel();
						jPanel4.add(jLabelProgramma, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						jLabelProgramma.setText("Inserisci gli argomenti svolti durante il corso d'insegnamento ed eventuali informazioni aggiuntive:");
					}
					{
						jTextArea = new JTextArea();
						jPanel4.add(jTextArea, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
						JScrollPane scroll=new JScrollPane(jTextArea);
						jPanel4.add(scroll, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
						jTextArea.setLineWrap(true);
					}
					{
						jLabelDocente = new JLabel();
						jPanel4.add(jLabelDocente, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						jLabelDocente.setText("Docente assegnatario del corso d'insegnamento:");
						jLabelDocente.setFont(new java.awt.Font("Arial",0,14));
					}
				}
				{
					jPanel5 = new JPanel();
					GridBagLayout jPanel5Layout = new GridBagLayout();
					jPanel1.add(jPanel5, BorderLayout.CENTER);
					jPanel5Layout.rowWeights = new double[] {0.0, 0.0, 0.0, 0.1};
					jPanel5Layout.rowHeights = new int[] {50, 50, 50, 7};
					jPanel5Layout.columnWeights = new double[] {0.0, 0.0, 0.1};
					jPanel5Layout.columnWidths = new int[] {120, 120, 7};
					jPanel5.setLayout(jPanel5Layout);
					{
						jButtonSalva = new JButton();
						jPanel5.add(jButtonSalva, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
						jButtonSalva.setText("Salva");
						jButtonSalva.addActionListener(this);
					}
					{
						jButtonIndietro = new JButton();
						jPanel5.add(jButtonIndietro, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
						jButtonIndietro.setText("Indietro");
						jButtonIndietro.addActionListener(this);
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
		
		if(e.getActionCommand().equalsIgnoreCase("Salva"))
		{
			try
			{
		
				String nome_file;
				nome_file = pIns + pCorso;
				
						
				PrintWriter out=new PrintWriter (new FileOutputStream("c:/" + nome_file + ".txt"), true);
				out.print(jTextArea.getText());
				out.close();
				
				JOptionPane.showMessageDialog(null, "Le modifiche sono state salvate...");
			}
			catch(Exception e1)
			{
				
			}
		}
		
		if(e.getActionCommand().equalsIgnoreCase("Indietro"))
		{
			dispose();
		}
		
	}

}
