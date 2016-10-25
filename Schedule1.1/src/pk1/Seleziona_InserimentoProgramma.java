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

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;


/**
* All'interno della seguente classe è possibile selezionare il corso di laurea ed il 
* relativo corso di insegnamento a cui il docente desidera inserire il corrispondente 
* programma didattico.
*/
public class Seleziona_InserimentoProgramma extends javax.swing.JFrame implements ActionListener {
	private JPanel jPanel1;
	private JLabel jLabelTitolo;
	private JComboBox jComboBoxCorsoLaurea;
	private JButton jButtonIndice;
	private JButton jButtonInserimento;
	private JComboBox jComboBoxInsegnamento;
	private JLabel jLabelInsegnamento;
	private JButton jButtonVediInsegnamento;
	private JLabel jLabelCorsiLaurea;
	private JLabel jLabelSottotitolo;
	private JPanel jPanel4;
	private JPanel jPanel3;
	private JPanel jPanel2;
	public Vector<String> vettore, vins;
	public String pLogin, pPassword;
	public MenuGestioneProgrammiDidattici f2;

	
	
	public Seleziona_InserimentoProgramma(MenuGestioneProgrammiDidattici f) {
		super();
		f2=f;
		initGUI();
	}
	
	private void initGUI() {
		pLogin=f2.pLogin;
		pPassword=f2.pPassword;
		
		
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("INSERIMENTO PROGRAMMA");
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
						jLabelTitolo.setText("Inserimento programma");
						jLabelTitolo.setFont(new java.awt.Font("Arial",0,18));
					}
					{
						jLabelSottotitolo = new JLabel();
						jPanel2.add(jLabelSottotitolo, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						jLabelSottotitolo.setText("Seleziona il corso d'insegnamento a cui dovrai inserire il programma didattico");
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
						jLabelCorsiLaurea = new JLabel();
						jPanel3.add(jLabelCorsiLaurea, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.SOUTHWEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						jLabelCorsiLaurea.setText("Seleziona il corso di laurea:");
					}
					
					{
						jButtonVediInsegnamento = new JButton();
						jPanel3.add(jButtonVediInsegnamento, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						jButtonVediInsegnamento.setText("Vedi insegnamento");
						jButtonVediInsegnamento.addActionListener(this);
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
					jPanel1.add(jPanel4, BorderLayout.CENTER);
					jPanel4Layout.rowWeights = new double[] {0.0, 0.0, 0.0, 0.1};
					jPanel4Layout.rowHeights = new int[] {50, 50, 50, 7};
					jPanel4Layout.columnWeights = new double[] {0.0, 0.0, 0.1};
					jPanel4Layout.columnWidths = new int[] {120, 120, 7};
					jPanel4.setLayout(jPanel4Layout);
					{
						jButtonInserimento = new JButton();
						jPanel4.add(jButtonInserimento, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
						jButtonInserimento.setText("Inserimento");
						jButtonInserimento.setVisible(false);
						jButtonInserimento.addActionListener(this);
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
							JOptionPane.showMessageDialog(null, "Errore aggiornamento database..."+exc.getMessage());
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
			f2.setVisible(true);
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
				InserimentoProgramma inserimento_programma = new InserimentoProgramma(this, pIns, pCorso, pLogin, pPassword);
				inserimento_programma.setVisible(true);
			}
			
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
				JOptionPane.showMessageDialog(null, "Errore aggiornamento del database"+exc.getMessage());
			}
			
	    }

}
}

