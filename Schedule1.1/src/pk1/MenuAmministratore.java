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
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;


/**
* La seguente classe definisce il menu amministratore, cioè contiene tutte la funzioni 
* che l'amministratore può svolgere all'interno del sistema. Le funzioni che l'amministratore
* svolge sono: gestione delle aule, gestione degli insegnamenti e la reportistica amministratore.
* La seguente schermata viene visualizzata solo dopo che l'amminitratore ha effettuato
* l'autenticazione al sistema.
*/
public class MenuAmministratore extends javax.swing.JFrame implements ActionListener {
	private JPanel jPanel1;
	private JLabel jLabelTitolo;
	private JDialog jDialogCorsiLaurea;
	private JButton jButtonReportistica;
	private JButton jButtonGestioneInsegnamenti;
	private JButton jButtonGestioneAule;
	private JPanel jPanel4;
	private JPanel jPanel3;
	private JLabel jLabelSottotitolo;
	private JPanel jPanel2;
	public Login admin;
	

	
	
	public MenuAmministratore(Login l) {
		super();
		admin=l;
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("MENU AMMINISTRATORE");
			{
				jPanel1 = new JPanel();
				BorderLayout jPanel1Layout = new BorderLayout();
				jPanel1.setLayout(jPanel1Layout);
				getContentPane().add(jPanel1, BorderLayout.CENTER);
				{
					jPanel2 = new JPanel();
					GridBagLayout jPanel2Layout = new GridBagLayout();
					jPanel1.add(jPanel2, BorderLayout.NORTH);
					jPanel2.setPreferredSize(new java.awt.Dimension(692, 74));
					jPanel2Layout.rowWeights = new double[] {0.1, 0.1};
					jPanel2Layout.rowHeights = new int[] {7, 7};
					jPanel2Layout.columnWeights = new double[] {0.1};
					jPanel2Layout.columnWidths = new int[] {7};
					jPanel2.setLayout(jPanel2Layout);
					{
						jLabelTitolo = new JLabel();
						jPanel2.add(jLabelTitolo, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						jLabelTitolo.setText("MENU AMMINISTRATORE");
						jLabelTitolo.setFont(new java.awt.Font("Arial",0,18));
					}
					{
						jLabelSottotitolo = new JLabel();
						jPanel2.add(jLabelSottotitolo, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						jLabelSottotitolo.setText("Area riservata all'amministratore del sistema");
						jLabelSottotitolo.setFont(new java.awt.Font("Tahoma",0,16));
					}
				}
				{
					jPanel3 = new JPanel();
					GridBagLayout jPanel3Layout = new GridBagLayout();
					jPanel1.add(jPanel3, BorderLayout.WEST);
					jPanel3.setPreferredSize(new java.awt.Dimension(351, 492));
					jPanel3Layout.rowWeights = new double[] {0.1, 0.1, 0.1, 0.1};
					jPanel3Layout.rowHeights = new int[] {7, 7, 7, 7};
					jPanel3Layout.columnWeights = new double[] {0.1, 0.1, 0.1};
					jPanel3Layout.columnWidths = new int[] {7, 7, 7};
					jPanel3.setLayout(jPanel3Layout);
					
				}
				{
					jPanel4 = new JPanel();
					GridBagLayout jPanel4Layout = new GridBagLayout();
					jPanel1.add(jPanel4, BorderLayout.CENTER);
					jPanel4Layout.rowWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 0.1, 0.1};
					jPanel4Layout.rowHeights = new int[] {50, 50, 50, 50, 50, 20, 7};
					jPanel4Layout.columnWeights = new double[] {0.0, 0.0, 0.1};
					jPanel4Layout.columnWidths = new int[] {120, 120, 7};
					jPanel4.setLayout(jPanel4Layout);
					{
						jButtonGestioneAule = new JButton();
						jPanel4.add(jButtonGestioneAule, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
						jButtonGestioneAule.setText("Gestione Aule");
						jButtonGestioneAule.addActionListener(this);
					}
					{
						jButtonGestioneInsegnamenti = new JButton();
						jPanel4.add(jButtonGestioneInsegnamenti, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
						jButtonGestioneInsegnamenti.setText("Gestione insegnamenti");
						jButtonGestioneInsegnamenti.addActionListener(this);
					}
					{
						jButtonReportistica = new JButton();
						jPanel4.add(jButtonReportistica, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
						jButtonReportistica.setText("Reportistica");
						jButtonReportistica.addActionListener(this);
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
		
		if(e.getActionCommand().equalsIgnoreCase("Gestione Aule"))
		{
			MenuGestioneAule modifica = new MenuGestioneAule(this);
			modifica.setVisible(true);
			setVisible(false);
		}
		
		if(e.getActionCommand().equalsIgnoreCase("Gestione insegnamenti"))
		{
			MenuGestioneInsegnamenti gestione = new MenuGestioneInsegnamenti(this);
			gestione.setVisible(true);
			setVisible(false);
		}
		
		if(e.getActionCommand().equalsIgnoreCase("Reportistica"))
		{
			MenuReportisticaAmministratore stampa = new MenuReportisticaAmministratore(this);
			stampa.setVisible(true);
			setVisible(false);
		}
		

	}
}
