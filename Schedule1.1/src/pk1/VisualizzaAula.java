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
* All'inteno della seguente classe sono visualizzate tutte le informazioni relative 
* ad un'aula specifica oppure ad un laboratorio, che si desidera conoscere. 
* Inoltre è possibile modificare i dati relativi all'aula oppure al laboratorio e 
* salvarli nuovamente all'interno del database del sistema.
*/
public class VisualizzaAula extends javax.swing.JFrame implements ActionListener {
	private JPanel jPanel1;
	private JLabel jLabelTitolo;
	private JLabel jLabelPianoTerra;
	private JButton jButtonElencoAule;
	private JButton jButtonSalva;
	private JPanel jPanel4;
	private JComboBox jComboBoxTipologia;
	private JComboBox jComboBoxUbicazioneaula;
	private JTextField jTextFieldNpiano;
	private JTextField jTextFieldNposti;
	private JTextField jTextFieldNomeAula;
	private JLabel jLabelTipologia;
	private JLabel jLabelUbicazioneaula;
	private JLabel jLabelNpiano;
	private JLabel jLabelNposti;
	private JLabel jLabelNomeAula;
	private JPanel jPanel3;
	private JLabel jLabelSottotitolo;
	private JPanel jPanel2;
	public String p,n;
	public String[] l1,l2;

	
	
	public VisualizzaAula(String n1, String p1) {
		super();
		p=p1;
		n=n1;
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("VISUALIZZA AULA");
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
						jLabelTitolo.setText("Visualizza aula/laboratorio");
						jLabelTitolo.setFont(new java.awt.Font("Arial",0,18));
					}
					{
						jLabelSottotitolo = new JLabel();
						jPanel2.add(jLabelSottotitolo, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						jLabelSottotitolo.setText("Visualizza/modifica tutti i dati dell'aula o del laboratorio");
						jLabelSottotitolo.setFont(new java.awt.Font("Tahoma",0,16));
					}
				}
				{
					jPanel3 = new JPanel();
					GridBagLayout jPanel3Layout = new GridBagLayout();
					jPanel1.add(jPanel3, BorderLayout.WEST);
					jPanel3.setPreferredSize(new java.awt.Dimension(351, 485));
					jPanel3Layout.rowWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.1};
					jPanel3Layout.rowHeights = new int[] {50, 45, 45, 45, 30, 45, 45, 20};
					jPanel3Layout.columnWeights = new double[] {0.0, 0.1};
					jPanel3Layout.columnWidths = new int[] {145, 7};
					jPanel3.setLayout(jPanel3Layout);
					{
						jLabelNomeAula = new JLabel();
						jPanel3.add(jLabelNomeAula, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						jLabelNomeAula.setText("Nome");
					}
					{
						jLabelNposti = new JLabel();
						jPanel3.add(jLabelNposti, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						jLabelNposti.setText("N° posti");
					}
					{
						jLabelNpiano = new JLabel();
						jPanel3.add(jLabelNpiano, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						jLabelNpiano.setText("N° piano");
					}
					{
						jLabelUbicazioneaula = new JLabel();
						jPanel3.add(jLabelUbicazioneaula, new GridBagConstraints(0, 5, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						jLabelUbicazioneaula.setText("Ubicazione");
					}
					{
						jLabelTipologia = new JLabel();
						jPanel3.add(jLabelTipologia, new GridBagConstraints(0, 6, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						jLabelTipologia.setText("Tipologia struttura");
					}
					{
						jTextFieldNomeAula = new JTextField();
						jPanel3.add(jTextFieldNomeAula, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
					}
					{
						jTextFieldNposti = new JTextField();
						jPanel3.add(jTextFieldNposti, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
					}
					{
						jTextFieldNpiano = new JTextField();
						jPanel3.add(jTextFieldNpiano, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
					}
					{
						l1=new String[]{ " ", "Dipartimento Informatica", "Palazzo delle Aule" };
						ComboBoxModel jComboBoxUbicazioneaulaModel = new DefaultComboBoxModel(l1);		
						jComboBoxUbicazioneaula = new JComboBox();
						jPanel3.add(jComboBoxUbicazioneaula, new GridBagConstraints(1, 5, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
						jComboBoxUbicazioneaula.setModel(jComboBoxUbicazioneaulaModel);
					}
					{
						l2=new String[]{ " ", "Aula", "Laboratorio" };
						ComboBoxModel jComboBoxTipologiaModel = new DefaultComboBoxModel(l2);
						jComboBoxTipologia = new JComboBox();
						jPanel3.add(jComboBoxTipologia, new GridBagConstraints(1, 6, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
						jComboBoxTipologia.setModel(jComboBoxTipologiaModel);
					}
					{
						jLabelPianoTerra = new JLabel();
						jPanel3.add(jLabelPianoTerra, new GridBagConstraints(1, 4, 1, 1, 0.0, 0.0, GridBagConstraints.NORTHWEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						jLabelPianoTerra.setText("N.B: 0 = Piano terra");
					}
				}
				{
					jPanel4 = new JPanel();
					GridBagLayout jPanel4Layout = new GridBagLayout();
					jPanel1.add(jPanel4, BorderLayout.CENTER);
					jPanel4Layout.rowWeights = new double[] {0.0, 0.0, 0.0, 0.1};
					jPanel4Layout.rowHeights = new int[] {50, 60, 60, 7};
					jPanel4Layout.columnWeights = new double[] {0.0, 0.0, 0.1};
					jPanel4Layout.columnWidths = new int[] {122, 124, 7};
					jPanel4.setLayout(jPanel4Layout);
					{
						jButtonSalva = new JButton();
						jPanel4.add(jButtonSalva, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
						jButtonSalva.setText("Salva");
						jButtonSalva.addActionListener(this);
					}
					{
						jButtonElencoAule = new JButton();
						jPanel4.add(jButtonElencoAule, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
						jButtonElencoAule.setText("Elenco aule");
						jButtonElencoAule.addActionListener(this);
					}
					
					
					try
					{
						Class.forName("com.mysql.jdbc.Driver");
					}
					catch (Exception e1)
					{
						System.err.println("Errore nel caricamento del Driver");
					}
					
					
					try
					{
						Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/schedule_dib","root","");
						conn.setAutoCommit(false);
						Statement stmt=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
						String query;
						
						query="SELECT * FROM dati_aule where Nome='"+n+"' and Npiano='"+p+"'";
						ResultSet rs= stmt.executeQuery(query);
						
						while(rs.next())
						{
							jTextFieldNomeAula.setText(rs.getString("Nome"));
							jTextFieldNpiano.setText(rs.getString("Npiano"));
							jTextFieldNposti.setText(rs.getString("Nposti"));
							
							
							int index=0;
							if(rs.getString("Ubicazione").equalsIgnoreCase(" "))
								index=0;
							else
								 if(rs.getString("Ubicazione").equalsIgnoreCase("Dipartimento Informatica"))
								index=1;
								 else 
									 if(rs.getString("Ubicazione").equalsIgnoreCase("Palazzo delle aule"))
									 index=2;
									 else index=0;
							jComboBoxUbicazioneaula.setSelectedIndex(index);
							if(rs.getString("Tipologia").equalsIgnoreCase(" "))
								index=0;
							else 
								if(rs.getString("Tipologia").equalsIgnoreCase("Aula"))
								index=1;
								else if(rs.getString("Tipologia").equalsIgnoreCase("Laboratorio"))
									index=2;
								else index=0;
							jComboBoxTipologia.setSelectedIndex(index);
							
							
							
							
							
							
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
		
		if(e.getActionCommand().equalsIgnoreCase("Elenco aule"))
		{
			dispose();
		}
		
		
		
		if(e.getActionCommand().equalsIgnoreCase("Salva"))
		{
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
			}
			catch(Exception e1)
			{
			    System.err.println("Errore nel caricamento dei driver");	
			}
			
			
			try
			{
				Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/schedule_dib","root","");
				conn.setAutoCommit(false);
				Statement stmt=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
				String query;
				
				query="Update `dati_aule` set `Nome`='"+jTextFieldNomeAula.getText()+"', `Npiano`='"+jTextFieldNpiano.getText()+"', `Nposti`='"+jTextFieldNposti.getText()+"', `Ubicazione`='"+l1[jComboBoxUbicazioneaula.getSelectedIndex()]+"', `Tipologia`='"+l2[jComboBoxTipologia.getSelectedIndex()]+"' where Nome='"+n+"' and Npiano='"+p+"'";
				
				
				
				int righe=stmt.executeUpdate(query);
				
				if(righe != 1)
				{
					JOptionPane.showMessageDialog(null, "Errore aggiornamneto database...");
				}
				
				
				conn.commit();
				stmt.close();
				conn.close();
				JOptionPane.showMessageDialog(null, "Operazione avvenuta con successo");
				dispose();
				
			}
			
			catch(Exception exc)
			{
				JOptionPane.showMessageDialog(null, "Errore aggiornamento database..."+exc.getMessage());
			}
		}
		
	}

}
