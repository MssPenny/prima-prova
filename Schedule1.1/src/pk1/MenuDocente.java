package pk1;
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

/**
* La seguente classe definisce il menu docente, cioè le funzioni che il docente può
* svolgere all'interno del proprio profilo; ad esempio: gestione dei dati personali, 
* gestione degli orari di riceviemnto, gestione dei programmi didattici, gestione delle
* prenotazioni delle aule e dei laboratori del Dipartiemnto di Informtica e del Palazzo
* delle Aule.
*/
public class MenuDocente extends javax.swing.JFrame implements ActionListener {
	private JPanel jPanel1;
	private JLabel jLabelTitolo;
	private JButton jButtonReport;
	private JButton jButtonGestioneOrario;
	JLabel jLabelRiconoscimento;
	private JButton jButtonPrenotazioniAule;
	private JButton jButtonProgrammiDidattici;
	private JButton jButtonGestioneDati;
	private JPanel jPanel4;
	private JPanel jPanel3;
	private JPanel jPanel2;
	public RegistrazioneDoc RegDoc;
	public Login ll;
	public boolean fromLogin=false;
	public String pNome, pCognome, pPassword, pLogin;

	

	public MenuDocente(RegistrazioneDoc rg) {
		super();
		RegDoc=rg;
		initGUI();
	}
	
	public MenuDocente (Login login, String pNome, String pCognome, String pPassword, String pLogin)
	{
		super();
		ll=login;
		fromLogin=true;
		this.pNome=pNome;
		this.pCognome=pCognome;
		this.pPassword=pPassword;
		this.pLogin=pLogin;
		initGUI();
	}
	
	
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("MENU DOCENTE");
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
						jLabelTitolo.setText("MENU DOCENTE");
						jLabelTitolo.setFont(new java.awt.Font("Arial",0,18));
					}
					{
						jLabelRiconoscimento = new JLabel();
						jPanel2.add(jLabelRiconoscimento, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						jLabelRiconoscimento.setText("Ha effettuato l'accesso al sistema il prof./ssa: regGUI.pCognome");
						jLabelRiconoscimento.setFont(new java.awt.Font("Tahoma",0,16));
						if(fromLogin==false)
							jLabelRiconoscimento.setText("Ha effettuato l'accesso al sistema il prof./ssa: "+RegDoc.pNome+" "+RegDoc.pCognome);
					    else jLabelRiconoscimento.setText("Ha effettuato l'accesso al sistema il prof./ssa: "+pNome+" "+pCognome);
					}
				}
				{
					jPanel3 = new JPanel();
					jPanel1.add(jPanel3, BorderLayout.WEST);
					jPanel3.setPreferredSize(new java.awt.Dimension(351, 490));
				}
				{
					jPanel4 = new JPanel();
					GridBagLayout jPanel4Layout = new GridBagLayout();
					jPanel1.add(jPanel4, BorderLayout.CENTER);
					jPanel4Layout.rowWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.1};
					jPanel4Layout.rowHeights = new int[] {50, 50, 50, 50, 50, 50, 20};
					jPanel4Layout.columnWeights = new double[] {0.0, 0.0, 0.1};
					jPanel4Layout.columnWidths = new int[] {120, 120, 7};
					jPanel4.setLayout(jPanel4Layout);
					{
						jButtonGestioneDati = new JButton();
						jPanel4.add(jButtonGestioneDati, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
						jButtonGestioneDati.setText("Gestione Dati");
						jButtonGestioneDati.addActionListener(this);
					}
					{
						jButtonGestioneOrario = new JButton();
						jPanel4.add(jButtonGestioneOrario, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
						jButtonGestioneOrario.setText("Gestione Orario");
						jButtonGestioneOrario.addActionListener(this);
					}
					{
						jButtonProgrammiDidattici = new JButton();
						jPanel4.add(jButtonProgrammiDidattici, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
						jButtonProgrammiDidattici.setText("Programmi Didattici");
						jButtonProgrammiDidattici.addActionListener(this);
					}
					{
						jButtonPrenotazioniAule = new JButton();
						jPanel4.add(jButtonPrenotazioniAule, new GridBagConstraints(1, 4, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
						jButtonPrenotazioniAule.setText("Gestione Prenotazioni");
						jButtonPrenotazioniAule.addActionListener(this);
					}
					{
						jButtonReport = new JButton();
						jPanel4.add(jButtonReport, new GridBagConstraints(1, 5, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
						jButtonReport.setText("Reportistica");
						jButtonReport.addActionListener(this);
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
	
	/**
	 * Cliccando su ciascuna delle seguenti funzioni è possibile accedere ad ulteriori
	 * schermate che consentono la gestione dei propri dati. 
	 */
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if (e.getActionCommand().equalsIgnoreCase("Gestione Dati"))
		{
		GestioneDati modifica = new GestioneDati(this);
		modifica.setVisible(true);
		}
		
		if(e.getActionCommand().equalsIgnoreCase("Gestione Orario"))
		{
			MenuGestioneOrario orario = new MenuGestioneOrario(this);
			orario.setVisible(true);
		}
		
		if(e.getActionCommand().equalsIgnoreCase("Programmi Didattici"))
		{
			MenuGestioneProgrammiDidattici programmi = new MenuGestioneProgrammiDidattici(this);
			programmi.setVisible(true);
		}
		
		if(e.getActionCommand().equalsIgnoreCase("Gestione Prenotazioni"))
		{
			MenuGestionePrenotazione prenota = new MenuGestionePrenotazione(this);
			prenota.setVisible(true);
		}
		
		if(e.getActionCommand().equalsIgnoreCase("Reportistica"))
		{
			MenuReportisticaDocente stampa = new MenuReportisticaDocente(this);
			stampa.setVisible(true);
		}
		
		
	}

}
