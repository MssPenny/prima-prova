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
import javax.swing.JTextField;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;


/**
* All'intero della seguente classe è possibile selezionare il corso di laurea ed il 
* relativo corso di insegnamento a cui il docente desidera inserire l'orario di 
* ricevimento. 
*/
public class InserimentoOrario extends javax.swing.JFrame implements ActionListener {
	private JPanel jPanel1;
	private JLabel jLabelTitolo;
	private JComboBox jComboBoxCorsoLaurea;
	private JButton jButtonInserimento;
	private JComboBox jComboBoxOraFine3;
	private JLabel jLabelSeparatoreIntervallo3;
	private JComboBox jComboBoxOraInizio3;
	private JComboBox jComboBoxOraFine2;
	private JLabel jLabelSeparatoreIntervallo2;
	private JComboBox jComboBoxOraInizio2;
	private JLabel jLabelSeparatoreIntervallo1;
	private JComboBox jComboBoxOraFine1;
	private JComboBox jComboBoxOraInizio1;
	private JLabel jLabelGiorno1;
	private JButton jButtonIndice;
	private JButton jButtonSalva;
	private JPanel jPanel5;
	private JLabel jLabelOrarioRicevimento3;
	private JComboBox jComboBoxGiorno3;
	private JLabel jLabelGiorno3;
	private JLabel jLabelOrarioRicevimento2;
	private JLabel jLabelOrarioRicevimento1;
	private JComboBox jComboBoxGiorno2;
	private JLabel jLabelGiorno2;
	private JComboBox jComboBoxGiorno1;
	private JButton jButtonVediInsegnamento;
	private JComboBox jComboBoxInsegnamento;
	private JLabel jLabelInsegnamento;
	private JLabel jLabelCorsiLaurea;
	private JPanel jPanel4;
	private JPanel jPanel3;
	private JLabel jLabelSottotitolo;
	private JPanel jPanel2;
	public MenuGestioneOrario g2;
	public String[] a1,a2,a3,a4,a5,a6,a7,a8,a9;
	public Vector<String> vettore, vins;
	public String pLogin, pPassword;
	
	public InserimentoOrario(MenuGestioneOrario g) {
		super();
		g2=g;
		initGUI();
	}
	
	private void initGUI() {
		pLogin=g2.pLogin;
		pPassword=g2.pPassword;

	
	
		
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("INSERIMENTO ORARIO");
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
						jLabelTitolo.setText("Inserimento orario di ricevimento");
						jLabelTitolo.setFont(new java.awt.Font("Arial",0,18));
					}
					{
						jLabelSottotitolo = new JLabel();
						jPanel2.add(jLabelSottotitolo, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						jLabelSottotitolo.setText("Inserisci l'orario di ricevimento per ciascun insegnamento asseganto");
						jLabelSottotitolo.setFont(new java.awt.Font("Tahoma",0,16));
					}
				}
				{
					jPanel3 = new JPanel();
					GridBagLayout jPanel3Layout = new GridBagLayout();
					jPanel1.add(jPanel3, BorderLayout.WEST);
					jPanel3.setPreferredSize(new java.awt.Dimension(351, 483));
					jPanel3Layout.rowWeights = new double[] {0.1, 0.1, 0.1, 0.1, 0.1, 0.1};
					jPanel3Layout.rowHeights = new int[] {7, 7, 20, 7, 7, 20};
					jPanel3Layout.columnWeights = new double[] {0.0, 0.1};
					jPanel3Layout.columnWidths = new int[] {7, 7};
					jPanel3.setLayout(jPanel3Layout);
					{
						jLabelCorsiLaurea = new JLabel();
						jPanel3.add(jLabelCorsiLaurea, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.SOUTHWEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						jLabelCorsiLaurea.setText("Seleziona il corso di laurea:");
					}
					
					{
						jLabelInsegnamento = new JLabel();
						jPanel3.add(jLabelInsegnamento, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0, GridBagConstraints.SOUTHWEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						jLabelInsegnamento.setText("Seleziona il corso d'insegnamento:");
					}
					
					
				}
				
				
				
			
				
				
				{
					jPanel5 = new JPanel();
					GridBagLayout jPanel5Layout = new GridBagLayout();
					jPanel1.add(jPanel5, BorderLayout.CENTER);
					jPanel5Layout.rowWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 0.1, 0.1};
					jPanel5Layout.rowHeights = new int[] {50, 50, 50, 50, 50, 20, 7};
					jPanel5Layout.columnWeights = new double[] {0.0, 0.0, 0.1};
					jPanel5Layout.columnWidths = new int[] {120, 120, 7};
					jPanel5.setLayout(jPanel5Layout);
					
					
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
							
							//query per la visualizzazione dei corsi di laurea all'interno della combo box
							
							query="SELECT DISTINCT Corso_laurea from associa_doc where Login='"+pLogin+"' and Password='"+pPassword+"'";
							System.out.print(query);
							ResultSet rs=stmt.executeQuery(query);
							
							Vector<String> b=new Vector <String>();
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
							JOptionPane.showMessageDialog(null, "Errore aggionamento database..."+exc.getMessage());
						}
						
						{
							jButtonVediInsegnamento = new JButton();
							jPanel3.add(jButtonVediInsegnamento, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
							jButtonVediInsegnamento.setText("Vedi insegnamento");
							jButtonVediInsegnamento.addActionListener(this);
						}
						
						
					}
					{
						jButtonInserimento = new JButton();
						jPanel5.add(jButtonInserimento, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
						jButtonInserimento.setText("Inserimento");
						jButtonInserimento.setVisible(false);
						jButtonInserimento.addActionListener(this);
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
			g2.setVisible(true);
		}
		
		if(e.getActionCommand().equalsIgnoreCase("Inserimento"))
		{
			String pCorso=vettore.get(jComboBoxCorsoLaurea.getSelectedIndex());
			String pIns=vins.get(jComboBoxInsegnamento.getSelectedIndex());
			
			if(pCorso.equals(" ")&& pIns.equals(" "))
			{
				JOptionPane.showMessageDialog(null, "Seleziona sia il corso di laurea che l'insegnamento");
			}
			else
			{
				InserimentoOrario_Ric inserimento_orario = new InserimentoOrario_Ric(pIns, pCorso);
				inserimento_orario.setVisible(true);
			}
		}
		
		if(e.getActionCommand().equals("Salva"))
		{
			String pCorso=vettore.get(jComboBoxCorsoLaurea.getSelectedIndex());
			String pIns=vins.get(jComboBoxInsegnamento.getSelectedIndex());
			String pLogin=null;
			String pPassword=null;
			
			if(!pCorso.equals(" ")&& !pIns.equals(" "))
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
					
					query="SELECT * from associa_doc where Login='"+pLogin+"' and Password='"+pPassword+"'";
					ResultSet rs=stmt.executeQuery(query);
					
					while(rs.next())
					{
						pLogin=rs.getString("Login");
						pPassword=rs.getString("Password");
					}
					
					query="Insert into `orario`(`Giorno1`,`Ora_inizio1`,`Ora_fine1`,`Giorno2`,`Ora_inizio2`,`Ora_fine2`,`Giorno3`,`Ora_inizio3`,`Ora_fine3`,`Nome_insegn`,`Corso_laurea`)values('"+a1[jComboBoxGiorno1.getSelectedIndex()]+"','"+a2[jComboBoxOraInizio1.getSelectedIndex()]+"','"+a3[jComboBoxOraFine1.getSelectedIndex()]+"','"+a4[jComboBoxGiorno2.getSelectedIndex()]+"','"+a5[jComboBoxOraInizio2.getSelectedIndex()]+"','"+a6[jComboBoxOraFine2.getSelectedIndex()]+"','"+a7[jComboBoxGiorno3.getSelectedIndex()]+"','"+a8[jComboBoxOraInizio3.getSelectedIndex()]+"','"+a9[jComboBoxOraFine3.getSelectedIndex()]+"','"+pIns+"','"+pCorso+"')";
					
					int righe=stmt.executeUpdate(query);
					if(righe != 1)
						JOptionPane.showMessageDialog(null, "Errore aggiornamento database...");
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
					JOptionPane.showMessageDialog(null, "L'orario di ricevimento per il seguente corso è stato già inserito precedentemente..."+exc.getMessage());
				}
			}
			
			jComboBoxCorsoLaurea.setSelectedIndex(0);
			jComboBoxInsegnamento.setSelectedIndex(0);
			jComboBoxGiorno1.setSelectedIndex(0);
			jComboBoxOraInizio1.setSelectedIndex(0);
			jComboBoxOraFine1.setSelectedIndex(0);
			jComboBoxGiorno2.setSelectedIndex(0);
			jComboBoxOraInizio2.setSelectedIndex(0);
			jComboBoxOraFine2.setSelectedIndex(0);
			jComboBoxGiorno3.setSelectedIndex(0);
			jComboBoxOraInizio3.setSelectedIndex(0);
			jComboBoxOraFine3.setSelectedIndex(0);
		}
		
		
		if(e.getActionCommand().equalsIgnoreCase("Vedi insegnamento"))
		{
			String pCorso=vettore.get(jComboBoxCorsoLaurea.getSelectedIndex());
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
			}
			catch(Exception e1)
			{
				System.err.println("Errore di caricamento del driver");
			}
			
			try
			{
				Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/schedule_dib","root","");
				conn.setAutoCommit(false);
				Statement stmt=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
				String query;
				
				query="Select Nome_insegn from associa_doc where Login='"+pLogin+"' and Password='"+pPassword+"' and Corso_laurea='"+pCorso+"'";
				ResultSet rs=stmt.executeQuery(query);
				Vector <String> v=new Vector <String>();
				
				v.add(" ");
				
				while(rs.next())
				{
					v.add(rs.getString("Nome_insegn"));
				}
				
				ComboBoxModel jComboBoxjComboBoxInsegnamentoModel=
					new DefaultComboBoxModel(v);
				jComboBoxInsegnamento.setModel(jComboBoxjComboBoxInsegnamentoModel);
				
				jComboBoxInsegnamento.enable(true);
				
				jButtonInserimento.setVisible(true);
				
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
		
		
		
		
		
	}

}
