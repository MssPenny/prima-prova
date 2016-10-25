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

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;


/**
* All'interno della seguente classe sono visualizzate tutte le funzioni utili per quando
* riguarda la gestione dei corsi di insegnamento.
* Per gestione s'intende le operazioni di inserimento, visualizzazione e modifica; inoltre
* l'amministratore assegna uno o più corsi d'insegnamento a ciascun docente del Dipartimento
* di Informatica.
*/
public class MenuGestioneInsegnamenti extends javax.swing.JFrame implements ActionListener  {
	private JPanel jPanel1;
	private JLabel jLabelTitolo;
	private JButton jButtonCorso;
	private JButton jButtonTornaMenu;
	private JButton jButtonAssociaDoc;
	private JButton jButtonElencoInseg;
	private JButton jButtonInserimentoInseg;
	private JPanel jPanel4;
	private JPanel jPanel3;
	private JLabel jLabelSottotitolo;
	private JPanel jPanel2;
	public MenuAmministratore f1;

	
	
	public MenuGestioneInsegnamenti(MenuAmministratore f) {
		super();
		f1=f;
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("GESTIONE INSEGNAMENTI");
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
						jLabelTitolo.setText("GESTIONE INSEGNAMENTI");
						jLabelTitolo.setFont(new java.awt.Font("Arial",0,18));
					}
					{
						jLabelSottotitolo = new JLabel();
						jPanel2.add(jLabelSottotitolo, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						jLabelSottotitolo.setText("Menu per la gestione degli insegnamenti del Dipartimento di Informatica");
						jLabelSottotitolo.setFont(new java.awt.Font("Tahoma",0,16));
					}
				}
				{
					jPanel3 = new JPanel();
					GridBagLayout jPanel3Layout = new GridBagLayout();
					jPanel1.add(jPanel3, BorderLayout.WEST);
					jPanel3.setPreferredSize(new java.awt.Dimension(351, 485));
					jPanel3Layout.rowWeights = new double[] {0.1, 0.1, 0.1, 0.1};
					jPanel3Layout.rowHeights = new int[] {7, 7, 7, 7};
					jPanel3Layout.columnWeights = new double[] {0.1, 0.1};
					jPanel3Layout.columnWidths = new int[] {7, 7};
					jPanel3.setLayout(jPanel3Layout);
				}
				{
					jPanel4 = new JPanel();
					GridBagLayout jPanel4Layout = new GridBagLayout();
					jPanel1.add(jPanel4, BorderLayout.CENTER);
					jPanel4Layout.rowWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.1};
					jPanel4Layout.rowHeights = new int[] {52, 52, 52, 52, 52, 51, 20};
					jPanel4Layout.columnWeights = new double[] {0.0, 0.0, 0.0, 0.1};
					jPanel4Layout.columnWidths = new int[] {-1, 110, 162, 7};
					jPanel4.setLayout(jPanel4Layout);
					{
						jButtonInserimentoInseg = new JButton();
						jPanel4.add(jButtonInserimentoInseg, new GridBagConstraints(2, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
						jButtonInserimentoInseg.setText("Inserimento insegnamento");
						jButtonInserimentoInseg.addActionListener(this);
					}
					{
						jButtonElencoInseg = new JButton();
						jPanel4.add(jButtonElencoInseg, new GridBagConstraints(2, 3, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
						jButtonElencoInseg.setText("Elenco insegnamenti");
						jButtonElencoInseg.addActionListener(this);
					}
					{
						jButtonAssociaDoc = new JButton();
						jPanel4.add(jButtonAssociaDoc, new GridBagConstraints(2, 4, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
						jButtonAssociaDoc.setText("Associa docente");
						jButtonAssociaDoc.addActionListener(this);
					}
					{
						jButtonTornaMenu = new JButton();
						jPanel4.add(jButtonTornaMenu, new GridBagConstraints(2, 5, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
						jButtonTornaMenu.setText("Torna al Menu");
						jButtonTornaMenu.addActionListener(this);
					}
					{
						jButtonCorso = new JButton();
						jPanel4.add(jButtonCorso, new GridBagConstraints(2, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
						jButtonCorso.setText("Inserimento Corso Laurea");
						jButtonCorso.addActionListener(this);
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
		
		if(e.getActionCommand().equalsIgnoreCase("Inserimento insegnamento"))
		{
			InserimentoInsegnamento inserisci =new InserimentoInsegnamento(this);
			inserisci.setVisible(true);
			setVisible(false);
		}
		
		if(e.getActionCommand().equalsIgnoreCase("Elenco insegnamenti"))
		{
			VisualizzaElencoInsegnamenti elenco=new VisualizzaElencoInsegnamenti();
			elenco.setVisible(true);
		}
		
		if(e.getActionCommand().equalsIgnoreCase("Associa docente"))
		{
			AssociaDocente associa = new AssociaDocente();
			associa.setVisible(true);
		}
		
		if(e.getActionCommand().equalsIgnoreCase("Torna al Menu"))
		{
			setVisible(false);
			f1.setVisible(true);
		}
		
		if(e.getActionCommand().equalsIgnoreCase("Inserimento Corso Laurea"))
		{
			
				String selection= JOptionPane.showInputDialog(getParent(),"Inserisci il nome del corso di laurea:","INSERIMENTO CORSO DI LAUREA",JOptionPane.OK_CANCEL_OPTION);
				if(selection != null )
				{
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
						
						query="Insert into `corsi` (`Corso_laurea`)values('"+selection+"')";
						
						int righe=stmt.executeUpdate(query);
						if(righe != 1)
						{
							JOptionPane.showMessageDialog(null, "Errore aggiornamento database");
						}
						else
						{
							
						}
						
						conn.commit();
						stmt.close();
						conn.close();
						JOptionPane.showMessageDialog(null, "Operazione avvenuta con successo");
						
						
						
				}
					
					catch(Exception exc)
					{
						JOptionPane.showMessageDialog(null, "Errore aggiornamento database"+exc.getMessage());
					}
			
		}
				else
				{
					JOptionPane.showMessageDialog(null, "Nessun corso di laurea inserito");
				}
		
		
	}
		
		
	}

}
