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
import java.io.InputStreamReader;
import java.io.PrintWriter;
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

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;


/**
* All'interno della seguente classe è possibile selezionare il corso di laurea ed il 
* relativo corso d'insegnamento, in modo da poter visualizzare il programma didattico 
* che è stato associato a tale corso d'insegnamento.
*/
public class VisualizzaProgramma extends javax.swing.JFrame implements ActionListener {
	private JPanel jPanel1;
	private JLabel jLabelTitolo;
	private JComboBox jComboBoxCorsoLaurea;
	private JButton jButtonVediProgramma;
	private JButton jButtonIndice;
	private JPanel jPanel4;
	private JComboBox jComboBoxInsegnamento;
	private JLabel jLabelInsegnamento;
	private JButton jButtonVediInsegnamenti;
	private JLabel jLabelCorsoLaurea;
	private JPanel jPanel3;
	private JLabel jLabelSottotitolo;
	private JPanel jPanel2;
	public MenuGestioneProgrammiDidattici j1;
	public Vector<String> vettore, vins;
	public String pLogin, pPassword;

	
	
	public VisualizzaProgramma(MenuGestioneProgrammiDidattici j) {
		super();
		j1=j;
		initGUI();
	}
	
	private void initGUI() {
		pLogin=j1.pLogin;
		pPassword=j1.pPassword;
		
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
					jPanel2.setPreferredSize(new java.awt.Dimension(692, 73));
					jPanel2Layout.rowWeights = new double[] {0.1, 0.1};
					jPanel2Layout.rowHeights = new int[] {7, 7};
					jPanel2Layout.columnWeights = new double[] {0.1};
					jPanel2Layout.columnWidths = new int[] {7};
					jPanel2.setLayout(jPanel2Layout);
					{
						jLabelTitolo = new JLabel();
						jPanel2.add(jLabelTitolo, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						jLabelTitolo.setText("Visualizza Programma Didattico");
						jLabelTitolo.setFont(new java.awt.Font("Arial",0,18));
					}
					{
						jLabelSottotitolo = new JLabel();
						jPanel2.add(jLabelSottotitolo, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						jLabelSottotitolo.setText("Visualizza il programma didattico di un determinato insegnamento");
						jLabelSottotitolo.setFont(new java.awt.Font("Tahoma",0,16));
					}
				}
				{
					jPanel3 = new JPanel();
					GridBagLayout jPanel3Layout = new GridBagLayout();
					jPanel1.add(jPanel3, BorderLayout.WEST);
					jPanel3.setPreferredSize(new java.awt.Dimension(351, 483));
					jPanel3Layout.rowWeights = new double[] {0.1, 0.1, 0.1, 0.1, 0.1, 0.1};
					jPanel3Layout.rowHeights = new int[] {7, 7, 7, 7, 20, 20};
					jPanel3Layout.columnWeights = new double[] {0.0, 0.1};
					jPanel3Layout.columnWidths = new int[] {7, 7};
					jPanel3.setLayout(jPanel3Layout);
					{
						jLabelCorsoLaurea = new JLabel();
						jPanel3.add(jLabelCorsoLaurea, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.SOUTHWEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						jLabelCorsoLaurea.setText("Seleziona il corso di laurea:");
					}
					
					
					{
						jLabelInsegnamento = new JLabel();
						jPanel3.add(jLabelInsegnamento, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0, GridBagConstraints.SOUTHWEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						jLabelInsegnamento.setText("Seleziona il corso d'insegnamento:");
					}
					
				}
				{
					jPanel4 = new JPanel();
					GridBagLayout jPanel4Layout = new GridBagLayout();
					jPanel1.add(jPanel4, BorderLayout.EAST);
					jPanel4Layout.rowWeights = new double[] {0.0, 0.0, 0.0, 0.1, 0.1};
					jPanel4Layout.rowHeights = new int[] {50, 50, 50, 7, 7};
					jPanel4Layout.columnWeights = new double[] {0.0, 0.0, 0.1};
					jPanel4Layout.columnWidths = new int[] {120, 120, 7};
					jPanel4.setLayout(jPanel4Layout);
					jPanel4.setPreferredSize(new java.awt.Dimension(340, 395));
					{
						jButtonVediProgramma = new JButton();
						jPanel4.add(jButtonVediProgramma, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
						jButtonVediProgramma.setText("Vedi programma");
						jButtonVediProgramma.addActionListener(this);
						jButtonVediProgramma.setVisible(false);
						
					}
					{
						jButtonIndice = new JButton();
						jPanel4.add(jButtonIndice, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
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
							
							query="SELECT DISTINCT Corso_laurea from associa_doc where Login='"+pLogin+"' and Password='"+pPassword+"'";
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
								jPanel3.add(jComboBoxCorsoLaurea, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
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
						
						{
							jButtonVediInsegnamenti = new JButton();
							jPanel3.add(jButtonVediInsegnamenti, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
							jButtonVediInsegnamenti.setText("Vedi insegnamenti");
							jButtonVediInsegnamenti.addActionListener(this);
						}

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
			j1.setVisible(true);
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
				
				query="Select * from programma_did, associa_doc where programma_did.Corso_laurea='"+pCorso+"' and programma_did.Nome_insegn=associa_doc.Nome_insegn and associa_doc.Login='"+pLogin+"' and associa_doc.Password='"+pPassword+"'";
				System.out.println(query);
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
				jButtonVediProgramma.setVisible(true);
				
				vins=v;
				
				conn.commit();
				stmt.close();
				conn.close();
			}
			catch(Exception exc)
			{
				JOptionPane.showMessageDialog(null, "Errore aggiornamento del database..."+exc.getMessage());
			}
		}
		
		if(e.getActionCommand().equalsIgnoreCase("Vedi programma"))
		{
			
			
			try
			{
			String nome_file;
			
			int indiceCorso;
		      indiceCorso = jComboBoxCorsoLaurea.getSelectedIndex();
		      String pCorso=(String) jComboBoxCorsoLaurea.getItemAt(indiceCorso);
			int indiceIns;
		      indiceIns = jComboBoxInsegnamento.getSelectedIndex();
		      String pIns=(String) jComboBoxInsegnamento.getItemAt(indiceIns);
		      
		    nome_file = pIns + pCorso;
		    
		    VisualizModificaProgramma programma = new VisualizModificaProgramma(this, nome_file, pIns, pCorso, pLogin, pPassword);
		    programma.setVisible(true);
			
		    
			}
			catch(Exception e1)
			{
			}
			
			
	
		}
		
		
	
	}

}
