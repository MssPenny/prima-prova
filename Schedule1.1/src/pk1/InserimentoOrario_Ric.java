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

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;


/**
* Nella seguente classe, dopo aver selezionato il corso d'insegnamento a cui si desidera
* associare un orario di riceviemnto, il docente inserisce i dati relativi all'orario di 
* ricevimento. I dati relativi agli orari di riceviemnto, inseriti dal docente,  sono i giorni
* e l'intervallo di tempo messo a disposizione degli alunni per ciascun giorno di ricevimento.
* I dati relativi agli orari di riceviemnto, per ciascun corso d'insegnamento assegnato
* dall'amministratore al docente, vengono salvati all'interno del database del sistema. 
*/
public class InserimentoOrario_Ric extends javax.swing.JFrame implements ActionListener {
	private JPanel jPanel1;
	private JLabel jLabelGiorno1;
	private JLabel jLabelSeparatoreIntervallo3;
	private JComboBox jComboBoxOraInizio3;
	private JLabel jLabelOrarioRicevimento3;
	private JComboBox jComboBoxGiorno3;
	private JLabel jLabelGiorno3;
	private JComboBox jComboBoxOraFine2;
	private JLabel jLabelSeparatoreIntervallo2;
	private JComboBox jComboBoxOraInizio2;
	private JLabel jLabelOrarioRicevimento2;
	private JComboBox jComboBoxGiorno2;
	private JLabel jLabelGiorno2;
	private JComboBox jComboBoxOraFine1;
	private JLabel jLabelSeparatoreIntervallo1;
	private JComboBox jComboBoxOraInizio1;
	private JLabel jLabelOrarioRicevimento1;
	private JComboBox jComboBoxGiorno1;
	private JLabel jLabelInsegnamento;
	private JLabel jLabelCorsoLaurea;
	private JLabel jLabelSottotitolo;
	private JButton jButtonIndietro;
	private JButton jButtonSalva;
	private JComboBox jComboBoxOraFine3;
	private JLabel jLabeltTitolo;
	private JPanel jPanel4;
	private JPanel jPanel3;
	private JPanel jPanel2;
	public String pLogin, pPassword;
	public String[] a1,a2,a3,a4,a5,a6,a7,a8,a9;
	public String p,h;

	
	
	public InserimentoOrario_Ric(String p1, String h1) {
		super();
		p=p1;
		h=h1;
		
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("INSERIMENTO ORARIO RICEVIMENTO");
			{
				jPanel1 = new JPanel();
				BorderLayout jPanel1Layout = new BorderLayout();
				jPanel1.setLayout(jPanel1Layout);
				getContentPane().add(jPanel1, BorderLayout.CENTER);
				{
					jPanel2 = new JPanel();
					GridBagLayout jPanel2Layout = new GridBagLayout();
					jPanel1.add(jPanel2, BorderLayout.NORTH);
					jPanel2.setPreferredSize(new java.awt.Dimension(692, 87));
					jPanel2Layout.rowWeights = new double[] {0.1, 0.1};
					jPanel2Layout.rowHeights = new int[] {7, 7};
					jPanel2Layout.columnWeights = new double[] {0.1};
					jPanel2Layout.columnWidths = new int[] {7};
					jPanel2.setLayout(jPanel2Layout);
					{
						jLabeltTitolo = new JLabel();
						jPanel2.add(jLabeltTitolo, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						jLabeltTitolo.setText("Inserisci l'orario di ricevimento");
						jLabeltTitolo.setFont(new java.awt.Font("Arial",0,18));
					}
					{
						jLabelSottotitolo = new JLabel();
						jPanel2.add(jLabelSottotitolo, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						jLabelSottotitolo.setText("Inserisci l'orario di ricevimento relativo al corso d'insegnamento");
						jLabelSottotitolo.setFont(new java.awt.Font("Tahoma",0,16));
					}
				}
				{
					jPanel3 = new JPanel();
					GridBagLayout jPanel3Layout = new GridBagLayout();
					jPanel1.add(jPanel3, BorderLayout.WEST);
					jPanel3.setPreferredSize(new java.awt.Dimension(267, 482));
					jPanel3Layout.rowWeights = new double[] {0.1, 0.1, 0.0, 0.1, 0.0, 0.1, 0.0, 0.1, 0.0, 0.1, 0.0, 0.1, 0.1, 0.0, 0.1, 0.0, 0.1, 0.0, 0.1, 0.0, 0.1, 0.1, 0.0, 0.1, 0.0, 0.1, 0.0, 0.1, 0.0, 0.1};
					jPanel3Layout.rowHeights = new int[] {7, 7, 7, 7, 7, 7, 7, 20, 7, 20, 7, 20, 20, 7, 20, 7, 20, 7, 20, 7, 20, 20, 7, 20, 7, 20, 7, 20, 7, 20};
					jPanel3Layout.columnWeights = new double[] {0.0, 0.1};
					jPanel3Layout.columnWidths = new int[] {7, 7};
					jPanel3.setLayout(jPanel3Layout);
					{
						jLabelCorsoLaurea = new JLabel();
						jPanel3.add(jLabelCorsoLaurea, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						jLabelCorsoLaurea.setText("Corso di laurea: "+h);
					}
					{
						jLabelInsegnamento = new JLabel();
						jPanel3.add(jLabelInsegnamento, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						jLabelInsegnamento.setText("Corso d'insegnamento: "+p);
					}
					{
						jLabelGiorno1 = new JLabel();
						jPanel3.add(jLabelGiorno1, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						jLabelGiorno1.setText("Giorno ricevimento");
					}
					{
						a1=new String[]{ " ", "Lunedì", "Martedì", "Mercoledì", "Giovedì", "Venerdì" };
						ComboBoxModel jComboBoxGiorno1Model = 
							new DefaultComboBoxModel(a1);
						jComboBoxGiorno1 = new JComboBox();
						jPanel3.add(jComboBoxGiorno1, new GridBagConstraints(1, 5, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
						jComboBoxGiorno1.setModel(jComboBoxGiorno1Model);
					}
					{
						jLabelOrarioRicevimento1 = new JLabel();
						jPanel3.add(jLabelOrarioRicevimento1, new GridBagConstraints(1, 7, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						jLabelOrarioRicevimento1.setText("Orario ricevimento");
					}
					{
						a2=new String[]{" ", "09:00", "09:30", "10:00", "10:30", "11:00", "11:30", "12:00", "12:30", "13:00", "13:00", "14:00", "14:30", "15:00", "15:30", "16:00", "16:30", "17:00", "17:30", "18:00", "18:30"};
						ComboBoxModel jComboBoxOraInizio1Model = 
							new DefaultComboBoxModel(a2);
						jComboBoxOraInizio1 = new JComboBox();
						jPanel3.add(jComboBoxOraInizio1, new GridBagConstraints(1, 9, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 150), 0, 0));
						jComboBoxOraInizio1.setModel(jComboBoxOraInizio1Model);
					}
					{
						jLabelSeparatoreIntervallo1 = new JLabel();
						jPanel3.add(jLabelSeparatoreIntervallo1, new GridBagConstraints(1, 9, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						jLabelSeparatoreIntervallo1.setText("-");
					}
					{
						a3=new String[]{" ", "09:00", "09:30", "10:00", "10:30", "11:00", "11:30", "12:00", "12:30", "13:00", "13:30", "14:00", "14:30", "15:00", "15:30", "16:00", "16:30", "17:00", "17:30", "18:00", "18:30"};
						ComboBoxModel jComboBoxOraFine1Model = 
							new DefaultComboBoxModel(a3);
						jComboBoxOraFine1 = new JComboBox();
						jPanel3.add(jComboBoxOraFine1, new GridBagConstraints(1, 9, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 150, 0, 0), 0, 0));
						jComboBoxOraFine1.setModel(jComboBoxOraFine1Model);
					}
					{
						jLabelGiorno2 = new JLabel();
						jPanel3.add(jLabelGiorno2, new GridBagConstraints(1, 12, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						jLabelGiorno2.setText("Giorno ricevimento");
					}
					{
						a4=new String[]{" ", "Lunedì", "Martedì", "Mercoledì", "Giovedì", "Venerdì" };
						ComboBoxModel jComboBoxGiorno2Model = 
							new DefaultComboBoxModel(a4);
						jComboBoxGiorno2 = new JComboBox();
						jPanel3.add(jComboBoxGiorno2, new GridBagConstraints(1, 14, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
						jComboBoxGiorno2.setModel(jComboBoxGiorno2Model);
					}
					{
						jLabelOrarioRicevimento2 = new JLabel();
						jPanel3.add(jLabelOrarioRicevimento2, new GridBagConstraints(1, 16, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						jLabelOrarioRicevimento2.setText("Orario ricevimento");
					}
					{
						a5=new String[]{" ", "09:00", "09:30", "10:00", "10:30", "11:00", "11:30", "12:00", "12:30", "13:00", "13:30", "14:00", "14:30", "15:00", "15:30", "16:00", "16:30", "17:00", "17:30", "18:00", "18:30" };
						ComboBoxModel jComboBoxOraInizio2Model = 
							new DefaultComboBoxModel(a5);
						jComboBoxOraInizio2 = new JComboBox();
						jPanel3.add(jComboBoxOraInizio2, new GridBagConstraints(1, 18, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 150), 0, 0));
						jComboBoxOraInizio2.setModel(jComboBoxOraInizio2Model);
					}
					{
						jLabelSeparatoreIntervallo2 = new JLabel();
						jPanel3.add(jLabelSeparatoreIntervallo2, new GridBagConstraints(1, 18, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						jLabelSeparatoreIntervallo2.setText("-");
					}
					{
						a6=new String[]{" ", "09:00", "09:30", "10:00", "10:30", "11:00", "11:30", "12:00", "12:30", "13:00", "13:30", "14:00", "14:30", "15:00", "15:30", "16:00", "16:30", "17:00", "17:30", "18:00", "18:30" };
						ComboBoxModel jComboBoxOraFine2Model = 
							new DefaultComboBoxModel(a6);
						jComboBoxOraFine2 = new JComboBox();
						jPanel3.add(jComboBoxOraFine2, new GridBagConstraints(1, 18, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 150, 0, 0), 0, 0));
						jComboBoxOraFine2.setModel(jComboBoxOraFine2Model);
					}
					{
						jLabelGiorno3 = new JLabel();
						jPanel3.add(jLabelGiorno3, new GridBagConstraints(1, 21, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						jLabelGiorno3.setText("Giorno ricevimento");
					}
					{
						a7=new String[]{" ", "Lunedì", "Martedì", "Mercoledì", "Giovedì", "Venerdì" };
						ComboBoxModel jComboBoxGiorno3Model = 
							new DefaultComboBoxModel(a7);
						jComboBoxGiorno3 = new JComboBox();
						jPanel3.add(jComboBoxGiorno3, new GridBagConstraints(1, 23, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
						jComboBoxGiorno3.setModel(jComboBoxGiorno3Model);
					}
					{
						jLabelOrarioRicevimento3 = new JLabel();
						jPanel3.add(jLabelOrarioRicevimento3, new GridBagConstraints(1, 25, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						jLabelOrarioRicevimento3.setText("Orario ricevimento");
					}
					{
						a8=new String[]{" ", "09:00", "09:30", "10:00", "10:30", "11:00", "11:30", "12:00", "12:30", "13:00", "13:00", "14:00", "14:30", "15:00", "15:30", "16:00", "16:30", "17:00", "17:30", "18:00", "18:30" };
						ComboBoxModel jComboBoxOraInizio3Model = 
							new DefaultComboBoxModel(a8);
						jComboBoxOraInizio3 = new JComboBox();
						jPanel3.add(jComboBoxOraInizio3, new GridBagConstraints(1, 27, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 150), 0, 0));
						jComboBoxOraInizio3.setModel(jComboBoxOraInizio3Model);
					}
					{
						jLabelSeparatoreIntervallo3 = new JLabel();
						jPanel3.add(jLabelSeparatoreIntervallo3, new GridBagConstraints(1, 27, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						jLabelSeparatoreIntervallo3.setText("-");
					}
					{
						a9=new String[]{" ", "09:00", "09:30", "10:00", "10:30", "11:00", "11:30", "12:00", "12:30", "13:00", "13:30", "14:00", "14:30", "15:00", "15:30", "16:00", "16:30", "17:00", "17:30", "18:00", "18:30" };
						ComboBoxModel jComboBoxOraFine3Model = 
							new DefaultComboBoxModel(a9);
						jComboBoxOraFine3 = new JComboBox();
						jPanel3.add(jComboBoxOraFine3, new GridBagConstraints(1, 27, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 150, 0, 0), 0, 0));
						jComboBoxOraFine3.setModel(jComboBoxOraFine3Model);
					}
				}
				{
					jPanel4 = new JPanel();
					GridBagLayout jPanel4Layout = new GridBagLayout();
					jPanel1.add(jPanel4, BorderLayout.CENTER);
					jPanel4Layout.rowWeights = new double[] {0.0, 0.0, 0.0, 0.1};
					jPanel4Layout.rowHeights = new int[] {50, 50, 50, 7};
					jPanel4Layout.columnWeights = new double[] {0.0, 0.0, 0.1};
					jPanel4Layout.columnWidths = new int[] {163, 120, 7};
					jPanel4.setLayout(jPanel4Layout);
					{
						jButtonSalva = new JButton();
						jPanel4.add(jButtonSalva, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
						jButtonSalva.setText("Salva");
						jButtonSalva.addActionListener(this);
					}
					{
						jButtonIndietro = new JButton();
						jPanel4.add(jButtonIndietro, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
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
				System.err.println("Errore nel caricamento del driver");
			}
			
			try
			{
				Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/schedule_dib","root","");
				conn.setAutoCommit(false);
				Statement stmt=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
				String query;
				
				query="Insert into `orario`(`Giorno1`,`Ora_inizio1`,`Ora_fine1`,`Giorno2`,`Ora_inizio2`,`Ora_fine2`,`Giorno3`,`Ora_inizio3`,`Ora_fine3`,`Nome_insegn`,`Corso_laurea`)values('"+a1[jComboBoxGiorno1.getSelectedIndex()]+"','"+a2[jComboBoxOraInizio1.getSelectedIndex()]+"','"+a3[jComboBoxOraFine1.getSelectedIndex()]+"','"+a4[jComboBoxGiorno2.getSelectedIndex()]+"','"+a5[jComboBoxOraInizio2.getSelectedIndex()]+"','"+a6[jComboBoxOraFine2.getSelectedIndex()]+"','"+a7[jComboBoxGiorno3.getSelectedIndex()]+"','"+a8[jComboBoxOraInizio3.getSelectedIndex()]+"','"+a9[jComboBoxOraFine3.getSelectedIndex()]+"','"+p+"','"+h+"')";
				
				int righe=stmt.executeUpdate(query);
				
				if(righe != 1)
				{
					JOptionPane.showMessageDialog(null, "Errore aggiornamento database...");
				}
				else
				{
					conn.commit();
					stmt.close();
					conn.close();
					JOptionPane.showMessageDialog(null, "Inserimento effettuato con successo...");
				}
				
			}
			catch(Exception exc)
			{
				JOptionPane.showMessageDialog(null, "L'orario di ricevimento per il seguente corso è stato già inserito precedentemente..."+exc.getMessage());
			}
			
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
		
	}

}
