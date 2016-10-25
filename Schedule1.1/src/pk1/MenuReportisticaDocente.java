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
* All'interno della seguente classe è riportato l'elenco di tutte le funzioni legate alla 
* reportistica docente. La reportistica consente al docente la stampa su file (.pdf e .html)
* dei propri dati personali, dei propri programmi didattici, dei propri corsi d'insegnamento
* degli orari di riceviemnto per ogni corso d'insegnamento e la stampa della situazione
* occupazionale delle aule e dei laboratori.
*/
public class MenuReportisticaDocente extends javax.swing.JFrame implements ActionListener {
	private JPanel jPanel1;
	private JLabel jLabelTitolo;
	private JButton jButtonTornaMenu;
	private JButton jButtonPrenotazione;
	private JButton jButtonProgrammiDidattici;
	private JButton jButtonOrarioRicevimento;
	private JButton jButtonInsegnamenti;
	private JButton jButtonDatiPersonali;
	private JLabel jLabelSottotitolo;
	private JPanel jPanel3;
	private JPanel jPanel2;
	public MenuDocente j2;
	public String pLogin, pPassword, pNome, pCognome;

	
	
	public MenuReportisticaDocente(MenuDocente j) {
		super();
		j2=j;
		initGUI();
	}
	
	private void initGUI() {
		pLogin=j2.pLogin;
		pPassword=j2.pPassword;
		pNome=j2.pNome;
		pCognome=j2.pCognome;

		
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("REPORTISTICA DOCENTE");
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
						jLabelTitolo.setText("REPORTISTICA DOCENTE");
						jLabelTitolo.setFont(new java.awt.Font("Arial",0,18));
					}
					{
						jLabelSottotitolo = new JLabel();
						jPanel2.add(jLabelSottotitolo, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						jLabelSottotitolo.setText("Stampa dei dati, in .html e .pdf, inerenti al docente");
						jLabelSottotitolo.setFont(new java.awt.Font("Tahoma",0,16));
					}
				}
				{
					jPanel3 = new JPanel();
					GridBagLayout jPanel3Layout = new GridBagLayout();
					jPanel1.add(jPanel3, BorderLayout.CENTER);
					jPanel3Layout.rowWeights = new double[] {0.0, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1};
					jPanel3Layout.rowHeights = new int[] {25, 7, 7, 7, 7, 20, 20, 20};
					jPanel3Layout.columnWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.1};
					jPanel3Layout.columnWidths = new int[] {142, 120, 168, 131, 7};
					jPanel3.setLayout(jPanel3Layout);
					{
						jButtonDatiPersonali = new JButton();
						jPanel3.add(jButtonDatiPersonali, new GridBagConstraints(2, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
						jButtonDatiPersonali.setText("Dati personali");
						jButtonDatiPersonali.addActionListener(this);
					}
					{
						jButtonInsegnamenti = new JButton();
						jPanel3.add(jButtonInsegnamenti, new GridBagConstraints(2, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
						jButtonInsegnamenti.setText("Insegnamenti");
						jButtonInsegnamenti.addActionListener(this);
					}
					{
						jButtonOrarioRicevimento = new JButton();
						jPanel3.add(jButtonOrarioRicevimento, new GridBagConstraints(2, 3, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
						jButtonOrarioRicevimento.setText("Orario di ricevimento");
						jButtonOrarioRicevimento.addActionListener(this);
					}
					{
						jButtonProgrammiDidattici = new JButton();
						jPanel3.add(jButtonProgrammiDidattici, new GridBagConstraints(2, 4, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
						jButtonProgrammiDidattici.setText("Programmi didattici");
						jButtonProgrammiDidattici.addActionListener(this);
					}
					{
						jButtonPrenotazione = new JButton();
						jPanel3.add(jButtonPrenotazione, new GridBagConstraints(2, 5, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
						jButtonPrenotazione.setText("Prenotazione aule");
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
			j2.setVisible(true);
		}
		
		if(e.getActionCommand().equalsIgnoreCase("Dati personali"))
		{
			D_ReportisticaDatiPersonali dati = new D_ReportisticaDatiPersonali(this, pPassword);
			dati.setVisible(true);
			
		}
		
		if(e.getActionCommand().equalsIgnoreCase("Insegnamenti"))
		{
			D_ReportisticaInsegnamenti insegnamenti = new D_ReportisticaInsegnamenti(this);
			insegnamenti.setVisible(true);
		}
		
		if(e.getActionCommand().equalsIgnoreCase("Orario di ricevimento"))
		{
			D_ReportisticaOrario orario = new D_ReportisticaOrario(this);
			orario.setVisible(true);
		}
		
		if(e.getActionCommand().equalsIgnoreCase("Programmi didattici"))
		{
			D_ReportisticaProgrammi programma = new D_ReportisticaProgrammi(this);
			programma.setVisible(true);
		}
		
	}

}
