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
* La seguente classe contiene l'elenco di tutte le funzioni legate alla reportistica
* amministratore. La reportistica consente all'amministratore di 
* effettuare la stampa su file (.pdf e .html) di tutte le informazioni relative ai 
* docenti come ad esempio: i propri dati personali, i programmi didattici, gli orari di 
* ricevimento, gli insegnameti assegnati o presenti all'interno del dipartiemnto e 
* la stampa della situazione occupazionale delle aule oppure dei laboratori del 
* Diaprtiemnto di Informatica oppure del Palazzo delle Aule.    
*/
public class MenuReportisticaAmministratore extends javax.swing.JFrame implements ActionListener {
	private JPanel jPanel1;
	private JLabel jLabelTitolo;
	private JButton jButtonDatiDocenti;
	private JButton jButtonInsegnamenti;
	private JButton jButtonOrariRicevimento;
	private JButton jButtonProgrammi;
	private JButton jButtonPrenotazione;
	private JPanel jPanel3;
	private JPanel jPanel2;
	public MenuAmministratore d2;
	private JButton jButtonTornaMenu;

	public MenuReportisticaAmministratore(MenuAmministratore d) {
		super();
		d2=d;
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("REPORTISTICA AMMINISTRATORE");
			{
				jPanel1 = new JPanel();
				BorderLayout jPanel1Layout = new BorderLayout();
				jPanel1.setLayout(jPanel1Layout);
				getContentPane().add(jPanel1, BorderLayout.CENTER);
				{
					jPanel2 = new JPanel();
					GridBagLayout jPanel2Layout = new GridBagLayout();
					jPanel1.add(jPanel2, BorderLayout.NORTH);
					jPanel2.setPreferredSize(new java.awt.Dimension(692, 77));
					jPanel2Layout.rowWeights = new double[] {0.1, 0.1};
					jPanel2Layout.rowHeights = new int[] {7, 7};
					jPanel2Layout.columnWeights = new double[] {0.1};
					jPanel2Layout.columnWidths = new int[] {7};
					jPanel2.setLayout(jPanel2Layout);
					{
						jLabelTitolo = new JLabel();
						jPanel2.add(jLabelTitolo, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						jLabelTitolo.setText("Reportistica Amministratore");
						jLabelTitolo.setFont(new java.awt.Font("Arial",0,18));
					}
				}
				{
					jPanel3 = new JPanel();
					GridBagLayout jPanel3Layout = new GridBagLayout();
					jPanel1.add(jPanel3, BorderLayout.CENTER);
					jPanel3Layout.rowWeights = new double[] {0.0, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1};
					jPanel3Layout.rowHeights = new int[] {25, 7, 7, 7, 7, 20, 20, 20};
					jPanel3Layout.columnWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.1};
					jPanel3Layout.columnWidths = new int[] {145, 120, 168, 131, 7};
					jPanel3.setLayout(jPanel3Layout);
					{
						jButtonPrenotazione = new JButton();
						jPanel3.add(jButtonPrenotazione, new GridBagConstraints(2, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
						jButtonPrenotazione.setText("Prenotazione aule");
						jButtonPrenotazione.addActionListener(this);
					}
					{
						jButtonProgrammi = new JButton();
						jPanel3.add(jButtonProgrammi, new GridBagConstraints(2, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
						jButtonProgrammi.setText("Programmi didattici");
						jButtonProgrammi.addActionListener(this);
					}
					{
						jButtonOrariRicevimento = new JButton();
						jPanel3.add(jButtonOrariRicevimento, new GridBagConstraints(2, 3, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
						jButtonOrariRicevimento.setText("Orari ricevimento");
						jButtonOrariRicevimento.addActionListener(this);
					}
					{
						jButtonInsegnamenti = new JButton();
						jPanel3.add(jButtonInsegnamenti, new GridBagConstraints(2, 4, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
						jButtonInsegnamenti.setText("Insegnamenti");
						jButtonInsegnamenti.addActionListener(this);
					}
					{
						jButtonDatiDocenti = new JButton();
						jPanel3.add(jButtonDatiDocenti, new GridBagConstraints(2, 5, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
						jButtonDatiDocenti.setText("Dati docenti");
						jButtonDatiDocenti.addActionListener(this);
					}
					{
						jButtonTornaMenu = new JButton();
						jPanel3.add(jButtonTornaMenu, new GridBagConstraints(2, 6, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
						jButtonTornaMenu.setText("Torna al Menu");
						jButtonTornaMenu.addActionListener(this);
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
		
		if(e.getActionCommand().equalsIgnoreCase("Torna al Menu"))
		{
			setVisible(false);
			d2.setVisible(true);
		}
		
		if(e.getActionCommand().equalsIgnoreCase("Programmi didattici"))
		{
			A_ReportisticaProgrammi programmi = new A_ReportisticaProgrammi(this);
			programmi.setVisible(true);
		}
		
		if(e.getActionCommand().equalsIgnoreCase("Orari ricevimento"))
		{
			A_ReportisticaOrario orario = new A_ReportisticaOrario(this);
			orario.setVisible(true);
		}
		
		if(e.getActionCommand().equalsIgnoreCase("Insegnamenti"))
		{
			A_ReportisticaInsegnamenti insegnamenti = new A_ReportisticaInsegnamenti(this);
			insegnamenti.setVisible(true);
		}
		
		if(e.getActionCommand().equalsIgnoreCase("Dati docenti"))
		{
			A_ReportisticaDatiPersonali docenti = new A_ReportisticaDatiPersonali(this);
			docenti.setVisible(true);
		}
		
		
		
		
	}

}
