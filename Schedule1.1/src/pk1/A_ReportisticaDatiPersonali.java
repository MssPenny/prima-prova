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
* La seguente classe contiene l'elenco di tutte le interrogazioni che l'amministartore
* può effettuare in modo da poter ottenere su file(.pdf e .html) la stampa di tutte le
* informazioni inerenti ai dati personali dei docenti del Dipartimento di Informatica. 
*/
public class A_ReportisticaDatiPersonali extends javax.swing.JFrame implements ActionListener {
	private JPanel jPanel1;
	private JLabel jLabelTitolo;
	private JButton jButtonSingoloDocente;
	private JButton jButtonTornaMenu;
	private JButton jButtonTuttiDocenti;
	private JPanel jPanel4;
	private JPanel jPanel3;
	private JLabel jLabelSottotitolo;
	private JPanel jPanel2;
	public MenuReportisticaAmministratore s2;

	
	
	public A_ReportisticaDatiPersonali(MenuReportisticaAmministratore s) {
		super();
		s2=s;
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("REPORTISTICA DATI PERSONALI");
			{
				jPanel1 = new JPanel();
				BorderLayout jPanel1Layout = new BorderLayout();
				jPanel1.setLayout(jPanel1Layout);
				getContentPane().add(jPanel1, BorderLayout.CENTER);
				{
					jPanel2 = new JPanel();
					GridBagLayout jPanel2Layout = new GridBagLayout();
					jPanel1.add(jPanel2, BorderLayout.NORTH);
					jPanel2.setPreferredSize(new java.awt.Dimension(692, 84));
					jPanel2Layout.rowWeights = new double[] {0.1, 0.1};
					jPanel2Layout.rowHeights = new int[] {7, 7};
					jPanel2Layout.columnWeights = new double[] {0.1};
					jPanel2Layout.columnWidths = new int[] {7};
					jPanel2.setLayout(jPanel2Layout);
					{
						jLabelTitolo = new JLabel();
						jPanel2.add(jLabelTitolo, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						jLabelTitolo.setText("Reportistica Dati Personali");
						jLabelTitolo.setFont(new java.awt.Font("Arial",0,18));
					}
					{
						jLabelSottotitolo = new JLabel();
						jPanel2.add(jLabelSottotitolo, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						jLabelSottotitolo.setText("Stampa dei dati personali dei docenti in formato .html e .pdf");
						jLabelSottotitolo.setFont(new java.awt.Font("Tahoma",0,16));
					}
				}
				{
					jPanel3 = new JPanel();
					jPanel1.add(jPanel3, BorderLayout.WEST);
					jPanel3.setPreferredSize(new java.awt.Dimension(337, 482));
				}
				{
					jPanel4 = new JPanel();
					GridBagLayout jPanel4Layout = new GridBagLayout();
					jPanel1.add(jPanel4, BorderLayout.CENTER);
					jPanel4Layout.rowWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 0.1};
					jPanel4Layout.rowHeights = new int[] {50, 50, 50, 50, 50, 7};
					jPanel4Layout.columnWeights = new double[] {0.0, 0.0, 0.1};
					jPanel4Layout.columnWidths = new int[] {120, 120, 7};
					jPanel4.setLayout(jPanel4Layout);
					{
						jButtonTuttiDocenti = new JButton();
						jPanel4.add(jButtonTuttiDocenti, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
						jButtonTuttiDocenti.setText("Tutti i docenti");
						jButtonTuttiDocenti.addActionListener(this);
					}
					{
						jButtonSingoloDocente = new JButton();
						jPanel4.add(jButtonSingoloDocente, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
						jButtonSingoloDocente.setText("Singolo docente");
						jButtonSingoloDocente.addActionListener(this);
					}
					{
						jButtonTornaMenu = new JButton();
						jPanel4.add(jButtonTornaMenu, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
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
			s2.setVisible(true);
			
		}
		
		if(e.getActionCommand().equalsIgnoreCase("Tutti i docenti"))
		{
			A_ReportisticaDatiPersonali1 tutti_docenti = new A_ReportisticaDatiPersonali1(this);
			tutti_docenti.setVisible(true);
		}
		
		if(e.getActionCommand().equalsIgnoreCase("Singolo docente"))
		{
			A_ReportisticaDatiPersonali2 singolo_docente = new A_ReportisticaDatiPersonali2(this);
			singolo_docente.setVisible(true);
		}
		
	}

}
