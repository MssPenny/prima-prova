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
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;
import java.io.*;

/**
* Nella seguente classe, dopo aver selezionato il corso di insegnamento a cui si desidera 
* associare il relativo preogramma didattico, il docente inserisce i dati del programma 
* didattico. I dati relativi al programma didattico, inseriti dal docente, sono l'elenco
* degli argomenti che il docente svolge durante il corso di insegnamento.
* Alcuni dei dati, relativi al progarmma didattico di un determinato corso di insegnamento,
* vengono salvati all'interno di un database; mentre la parte testuale del progarmma didattico
* viene salvata in un file con estensione (.txt).   
*/
public class InserimentoProgramma extends javax.swing.JFrame implements ActionListener {
	private JPanel jPanel1;
	private JLabel jLabelTitolo;
	private JLabel jLabelPropedeutico;
	private JLabel jLabelNcrediti;
	private JLabel jLabelAnno;
	private JLabel jLabelInfoCorso;
	private JTextArea jTextArea;
	private JLabel jLabelProgramma;
	private JComboBox jComboBoxCorsoLaurea;
	private JButton jButtonIndietro;
	private JLabel jLabelDocente;
	private JLabel jLabelCorsoLaurea;
	private JButton jButtonInfo;
	private JLabel jLabelValutazione;
	private JLabel jLabelLaboratorio;
	private JButton jButtonSalva;
	private JComboBox jComboBoxInsegnamento;
	private JButton jButtonVediInsegnamento;
	private JPanel jPanel5;
	private JPanel jPanel4;
	private JPanel jPanel3;
	private JLabel jLabelSottotitolo;
	private JPanel jPanel2;
	public Seleziona_InserimentoProgramma z1;
	public String p,h,login,password;

	public InserimentoProgramma(Seleziona_InserimentoProgramma z, String p1, String h1, String pLogin1, String pPassword1) {
		super();
		z1=z;
		initGUI();
		p=p1; // Nome insegnamento
		h=h1; // Corso di laurea
		
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
			
			query="SELECT * FROM dati_insegnamento WHERE Nome_insegn='"+p+"' and Corso_laurea='"+h+"'";
			
			
			ResultSet rs = stmt.executeQuery(query);
			
			while (rs.next())
			{
				
				jLabelInfoCorso.setText("Info corso d'insegnamento: " + rs.getString("Nome_insegn"));
				jLabelCorsoLaurea.setText("Corso di laurea: " + rs.getString("Corso_laurea"));
				jLabelNcrediti.setText("N° crediti: " + rs.getString("Ncrediti"));
				jLabelAnno.setText("Anno: " +rs.getString("Anno"));
				jLabelPropedeutico.setText("Propedeutico: " +rs.getString("Propedeutico"));
				jLabelLaboratorio.setText("Laboratorio: " +rs.getString("Laboratorio"));
				jLabelValutazione.setText("Valutazione: " +rs.getString("Valutazione"));
			
		   }
			conn.commit();
			stmt.close();
			conn.close();

		}
		catch(Exception exc)
		{
			System.err.println("Errore" +exc);
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
		
	}
	
	private void initGUI() {
	

		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("INSERIMENTO PROGRAMMA DIDATTICO");
			{
				jPanel1 = new JPanel();
				BorderLayout jPanel1Layout = new BorderLayout();
				jPanel1.setLayout(jPanel1Layout);
				getContentPane().add(jPanel1, BorderLayout.CENTER);
				{
					jPanel2 = new JPanel();
					GridBagLayout jPanel2Layout = new GridBagLayout();
					jPanel1.add(jPanel2, BorderLayout.NORTH);
					jPanel2.setPreferredSize(new java.awt.Dimension(692, 78));
					jPanel2Layout.rowWeights = new double[] {0.1, 0.1};
					jPanel2Layout.rowHeights = new int[] {7, 7};
					jPanel2Layout.columnWeights = new double[] {0.1};
					jPanel2Layout.columnWidths = new int[] {7};
					jPanel2.setLayout(jPanel2Layout);
					{
						jLabelTitolo = new JLabel();
						jPanel2.add(jLabelTitolo, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						jLabelTitolo.setText("Inserimento Programma Didattico");
						jLabelTitolo.setFont(new java.awt.Font("Arial",0,18));
					}
					{
						jLabelSottotitolo = new JLabel();
						jPanel2.add(jLabelSottotitolo, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						jLabelSottotitolo.setText("Inserisci il programma didattico relativo all'insegnamento selezionato");
						jLabelSottotitolo.setFont(new java.awt.Font("Tahoma",0,16));
					}
				}
				{
					jPanel3 = new JPanel();
					GridBagLayout jPanel3Layout = new GridBagLayout();
					jPanel1.add(jPanel3, BorderLayout.WEST);
					jPanel3.setPreferredSize(new java.awt.Dimension(351, 365));
					jPanel3Layout.rowWeights = new double[] {0.0, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.0};
					jPanel3Layout.rowHeights = new int[] {7, 20, 20, 20, 20, 20, 20, 20, 7};
					jPanel3Layout.columnWeights = new double[] {0.0, 0.1};
					jPanel3Layout.columnWidths = new int[] {7, 7};
					jPanel3.setLayout(jPanel3Layout);
					{
						jLabelInfoCorso = new JLabel();
						jPanel3.add(jLabelInfoCorso, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						jLabelInfoCorso.setText("Info corso d'insegnamento:");
						jLabelInfoCorso.setFont(new java.awt.Font("Arial",0,12));
					}
					{
						jLabelCorsoLaurea = new JLabel();
						jPanel3.add(jLabelCorsoLaurea, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						jLabelCorsoLaurea.setText("Corso di laurea:");
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
						jLabelLaboratorio.setText("Laboratorio");
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
					jPanel5Layout.rowWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.1};
					jPanel5Layout.rowHeights = new int[] {50, 50, 50, 50, 7};
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
		
		if(e.getActionCommand().equalsIgnoreCase("Indietro"))
		{
			setVisible(false);
			z1.setVisible(true);
		}
		
	
		
		if(e.getActionCommand().equalsIgnoreCase("Salva"))
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
				String nome_file;
				
			
			      
				//apertura al database
				
				Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/schedule_dib","root","");
				conn.setAutoCommit(false);
				Statement stmt=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
				String query;
				
				query="Insert into `programma_did` (`Corso_laurea`,`Nome_insegn`)values('"+h+"', '"+p+"')";
				
				int righe=stmt.executeUpdate(query);
				if(righe != 1)
				{
					JOptionPane.showMessageDialog(null, "Errore aggiornamento database...");
					
				}
				else
				{
					
					nome_file = p + h;
					PrintWriter out=new PrintWriter(new FileOutputStream("c:/" + nome_file + ".txt"), true);
					out.print(jTextArea.getText());
					out.close();
					
					
					conn.commit();
					stmt.close();
					conn.close();
					JOptionPane.showMessageDialog(null, "Documento creato con successo");
				}
				
			//per poter imbiancare i campi è necessario aggiungere il codice nello spazio sottostante
				
				
				
				
			
		   
			}
			catch(Exception exc)
			{
				JOptionPane.showMessageDialog(null, "Il programma didattico per tale corso d'insegnamento è stato già inserito precedentemente..."+exc.getMessage());
			}
			
		}
			
		
		
	}
}


