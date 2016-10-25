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
import java.util.StringTokenizer;
import java.util.Vector;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;


/**
* La seguente classe consente all'amministratore del sistema di poter assegnare un dato
* corso di insegnamento ad un docente del Dipartiemnto di Informatica.
* Ad un docente del Dipartiemnto di Informatica, l'amministratore può assegnare uno o
* più corsi di insegnamento.
* I dati relativi all'assegnamento di un corso di laurea verso un docente del Diapartimento
* verranno salvati all'interno del database del sistema. 
*/
public class AssociaDocente extends javax.swing.JFrame implements ActionListener {
	private JPanel jPanel1;
	private JLabel jLabelTitolo;
	private JLabel jLabelCorso;
	private JButton jButtonIndice;
	private JButton jButtonSalva;
	private JPanel jPanel5;
	private JLabel jLabelITPS;
	private JLabel jLabelICD;
	private JLabel jLabelLegenda;
	private JComboBox jComboBoxDocente;
	private JLabel jLabelDocente;
	private JComboBox jComboBoxInsegnamento;
	private JLabel jLabelInsegnamenti;
	private JPanel jPanel4;
	private JButton jButtonVediInsegnamenti;
	private JComboBox jComboBoxCorsoLaurea;
	private JPanel jPanel3;
	private JLabel jLabelSottotitolo;
	private JPanel jPanel2;
	public String[] corsi;
    public Vector<String> vettore, vins, vdoc; 
	
	public AssociaDocente() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("ASSOCIA DOCENTE-INSEGNAMENTO");
			{
				jPanel1 = new JPanel();
				BorderLayout jPanel1Layout = new BorderLayout();
				jPanel1.setLayout(jPanel1Layout);
				getContentPane().add(jPanel1, BorderLayout.CENTER);
				{
					jPanel2 = new JPanel();
					GridBagLayout jPanel2Layout = new GridBagLayout();
					jPanel1.add(jPanel2, BorderLayout.NORTH);
					jPanel2.setPreferredSize(new java.awt.Dimension(692, 85));
					jPanel2Layout.rowWeights = new double[] {0.1, 0.1};
					jPanel2Layout.rowHeights = new int[] {7, 7};
					jPanel2Layout.columnWeights = new double[] {0.1};
					jPanel2Layout.columnWidths = new int[] {7};
					jPanel2.setLayout(jPanel2Layout);
					{
						jLabelTitolo = new JLabel();
						jPanel2.add(jLabelTitolo, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						jLabelTitolo.setText("Associa Docente-Insegnamento");
						jLabelTitolo.setFont(new java.awt.Font("Arial",0,18));
					}
					{
						jLabelSottotitolo = new JLabel();
						jPanel2.add(jLabelSottotitolo, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						jLabelSottotitolo.setText("Associa a ciascun docente uno o più insegnamenti del \"dib\"");
						jLabelSottotitolo.setFont(new java.awt.Font("Tahoma",0,16));
					}
				}
				{
					jPanel3 = new JPanel();
					GridBagLayout jPanel3Layout = new GridBagLayout();
					jPanel1.add(jPanel3, BorderLayout.WEST);
					jPanel3.setPreferredSize(new java.awt.Dimension(351, 481));
					jPanel3Layout.rowWeights = new double[] {0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1};
					jPanel3Layout.rowHeights = new int[] {7, 7, 7, 7, 20, 20, 20};
					jPanel3Layout.columnWeights = new double[] {0.0, 0.1, 0.0};
					jPanel3Layout.columnWidths = new int[] {7, 7, 7};
					jPanel3.setLayout(jPanel3Layout);
					{
						jLabelCorso = new JLabel();
						jPanel3.add(jLabelCorso, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						jLabelCorso.setText("Seleziona il corso di laurea:");
					}
					
					
					{
						jLabelInsegnamenti = new JLabel();
						jPanel3.add(jLabelInsegnamenti, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						jLabelInsegnamenti.setText("Seleziona il corso d'insegnamento:");
					}
					
					{
						jLabelDocente = new JLabel();
						jPanel3.add(jLabelDocente, new GridBagConstraints(1, 5, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						jLabelDocente.setText("Seleziona il docente:");
					}
					
				}
				{
					jPanel4 = new JPanel();
					GridBagLayout jPanel4Layout = new GridBagLayout();
					jPanel1.add(jPanel4, BorderLayout.SOUTH);
					jPanel4.setPreferredSize(new java.awt.Dimension(692, 79));
					jPanel4Layout.rowWeights = new double[] {0.1, 0.1, 0.1};
					jPanel4Layout.rowHeights = new int[] {7, 7, 7};
					jPanel4Layout.columnWeights = new double[] {0.0, 0.1};
					jPanel4Layout.columnWidths = new int[] {7, 7};
					jPanel4.setLayout(jPanel4Layout);
					{
						jLabelLegenda = new JLabel();
						jPanel4.add(jLabelLegenda, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						jLabelLegenda.setText("Legenda, CORSI DI LAUREA:");
					}
					{
						jLabelICD = new JLabel();
						jPanel4.add(jLabelICD, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						jLabelICD.setText("ICD: Informatica e Comunicazione Digitale");
					}
					{
						jLabelITPS = new JLabel();
						jPanel4.add(jLabelITPS, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						jLabelITPS.setText("ITPS: Informatica  e Tecnologie per la Produzione del Software");
					}
				}
				{
					jPanel5 = new JPanel();
					GridBagLayout jPanel5Layout = new GridBagLayout();
					jPanel1.add(jPanel5, BorderLayout.CENTER);
					jPanel5Layout.rowWeights = new double[] {0.0, 0.0, 0.0, 0.1, 0.1};
					jPanel5Layout.rowHeights = new int[] {50, 50, 50, 7, 7};
					jPanel5Layout.columnWeights = new double[] {0.0, 0.0, 0.1};
					jPanel5Layout.columnWidths = new int[] {120, 120, 7};
					jPanel5.setLayout(jPanel5Layout);
					{
						jButtonSalva = new JButton();
						jPanel5.add(jButtonSalva, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
						jButtonSalva.setText("Salva");
						jButtonSalva.addActionListener(this);
						jButtonSalva.setVisible(false);
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
							jPanel3.add(jComboBoxInsegnamento, new GridBagConstraints(1, 4, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
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
							
							query="Select * from corsi";
							ResultSet rs=stmt.executeQuery(query);
							Vector<String> v=new Vector <String>();
							v.add(" ");
							while(rs.next())
							{
								v.add(rs.getString("Corso_laurea"));
							}
							
							{
								ComboBoxModel jComboBoxCorsoLaureaModel = 
									new DefaultComboBoxModel(v);
								jComboBoxCorsoLaurea = new JComboBox();
								jPanel3.add(jComboBoxCorsoLaurea, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
								jComboBoxCorsoLaurea.setModel(jComboBoxCorsoLaureaModel);
							}
							
							vettore=v;
							
							query="Select Nome, Cognome from dati_docenti, ruoli where dati_docenti.Password=ruoli.Password and dati_docenti.Login=ruoli.Login and Ruolo='docente'";
							rs=stmt.executeQuery(query);
							Vector<String> v1=new Vector<String>();
							v1.add(" ");
							while(rs.next())
							{
								v1.add(rs.getString("Nome")+"  "+rs.getString("Cognome"));
							}
							
							{
								ComboBoxModel jComboBoxDocenteModel = 
									new DefaultComboBoxModel(v1);
								jComboBoxDocente = new JComboBox();
								jPanel3.add(jComboBoxDocente, new GridBagConstraints(1, 6, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
								jComboBoxDocente.setModel(jComboBoxDocenteModel);
								vdoc=v1;
							}
							
							conn.commit();
							stmt.close();
							conn.close();
							
	
						}
						catch(Exception exc)
						{
							JOptionPane.showMessageDialog(null, "Errore aggiornamneto database..."+exc.getMessage());
						}	
						
						
					}
					
					{
						jButtonVediInsegnamenti = new JButton();
						jPanel3.add(jButtonVediInsegnamenti, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						jButtonVediInsegnamenti.setText("Vedi insegnamenti");
						jButtonVediInsegnamenti.addActionListener(this);
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
			dispose();
		}
		
		if(e.getActionCommand().equalsIgnoreCase("Salva"))
		{
			String pCorso=vettore.get(jComboBoxCorsoLaurea.getSelectedIndex());
			String pIns=vins.get(jComboBoxInsegnamento.getSelectedIndex());
			String parzial=vdoc.get(jComboBoxDocente.getSelectedIndex());
			StringTokenizer t=new StringTokenizer(parzial, " ");
			String pNome=t.nextToken().trim();
			String pCognome=t.nextToken().trim();
			String pLogin=null;
			String pPassword=null;
			
			if(!pCorso.equals(" ")&& !pIns.equals(" ")&& !pNome.equals(" ")&& !pCognome.equals(" "))
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
					
					query="SELECT * from dati_docenti where Nome='"+pNome+"' and Cognome='"+pCognome+"'";
					ResultSet rs=stmt.executeQuery(query);
					
					while(rs.next())
					{
						pLogin=rs.getString("Login");
						pPassword=rs.getString("Password");
					}
					
					query="Insert into `associa_doc`(`Login`,`Password`,`Corso_laurea`,`Nome_insegn`) values ('"+pLogin+"','"+pPassword+"','"+pCorso+"','"+pIns+"')";
					
					int righe=stmt.executeUpdate(query);
					if(righe != 1)
						JOptionPane.showMessageDialog(null, "Errore aggiornamneto database...");
					else
					{
						conn.commit();
						stmt.close();
						conn.close();
						JOptionPane.showMessageDialog(null, "Operazione avvenuta con successo");
					}
				}
				catch(Exception exc)
				{
					JOptionPane.showMessageDialog(null, "Il seguente corso d'insegnamento è stato già assegnato precedentemente..."+exc.getMessage());
				}
			}
			
			jComboBoxCorsoLaurea.setSelectedIndex(0);
			jComboBoxInsegnamento.setSelectedIndex(0);
			jComboBoxDocente.setSelectedIndex(0);
			
		}
		
		if(e.getActionCommand().equals("Vedi insegnamenti"))
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
				
				query="Select Nome_insegn from dati_insegnamento where Corso_laurea='"+vettore.get(jComboBoxCorsoLaurea.getSelectedIndex())+"'";
				ResultSet rs=stmt.executeQuery(query);
				Vector<String> v=new Vector<String>();
				v.add(" ");
				while(rs.next())
				{
					v.add(rs.getString("Nome_insegn"));
				}
				
				ComboBoxModel jComboBoxjComboBoxInsegnamentoModel =
					new DefaultComboBoxModel(v);
				jComboBoxInsegnamento.setModel(jComboBoxjComboBoxInsegnamentoModel);
			    jComboBoxInsegnamento.enable(true);
			    
				jButtonSalva.setVisible(true);
				
				vins=v;
				
				conn.commit();
				stmt.close();
				conn.close();
			}
			catch(Exception exc)
			{
				JOptionPane.showMessageDialog(null, "Errore aggiornamneto database..."+exc.getMessage());
			}
		}
		
		
	}

}
