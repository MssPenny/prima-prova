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
* All'interno della seguente classe è visualizzato l'elenco delle modalità occupazionali
* relative ai laboratori del Dipartiemnto di Informatica oppure del Palazzo delle Aule.
* Le modalità occupazionali presenti, che il docente può scegliere per poter visualizzare
* le prenotazioni sono: giorno, settimana oppure mese.
* Selezionando una delle seguenti modalità è possibile accedere alla visualizzazione
* della situazione occupazionale scelta. 
*/
public class Modalita_visualizzazione_prenotazioniLab extends javax.swing.JFrame implements ActionListener {
	private JPanel jPanel1;
	private JLabel jLabelTitolo;
	private JButton jButtonIndietro;
	private JButton jButtonMese;
	private JButton jButtonSettimana;
	private JButton jButtonGiorno;
	private JPanel jPanel3;
	private JLabel jLabelSottotitolo;
	private JPanel jPanel2;
	public VisualizzaPrenotazione b2;

	
	
	public Modalita_visualizzazione_prenotazioniLab(VisualizzaPrenotazione b) {
		super();
		b2=b;
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("MODALITA' DI VISUALIZZAZIONE DELLE PRENOTAZIONI AULE");
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
						jLabelTitolo.setText("Modalità di visualizzazione delle prenotazioni");
						jLabelTitolo.setFont(new java.awt.Font("Arial",0,18));
					}
					{
						jLabelSottotitolo = new JLabel();
						jPanel2.add(jLabelSottotitolo, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						jLabelSottotitolo.setText("Scegli la modalità di visulaizzazione delle prenotazioni dei laboratori più opportuna ");
						jLabelSottotitolo.setFont(new java.awt.Font("Tahoma",0,16));
					}
				}
				{
					jPanel3 = new JPanel();
					GridBagLayout jPanel3Layout = new GridBagLayout();
					jPanel1.add(jPanel3, BorderLayout.CENTER);
					jPanel3Layout.rowWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 0.1};
					jPanel3Layout.rowHeights = new int[] {50, 50, 50, 50, 50, 7};
					jPanel3Layout.columnWeights = new double[] {0.0, 0.0, 0.1};
					jPanel3Layout.columnWidths = new int[] {290, 120, 7};
					jPanel3.setLayout(jPanel3Layout);
					{
						jButtonGiorno = new JButton();
						jPanel3.add(jButtonGiorno, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
						jButtonGiorno.setText("Giorno");
					}
					{
						jButtonSettimana = new JButton();
						jPanel3.add(jButtonSettimana, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
						jButtonSettimana.setText("Settimana");
						jButtonSettimana.addActionListener(this);
					}
					{
						jButtonMese = new JButton();
						jPanel3.add(jButtonMese, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
						jButtonMese.setText("Mese");
					}
					{
						jButtonIndietro = new JButton();
						jPanel3.add(jButtonIndietro, new GridBagConstraints(1, 4, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
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
			setVisible(false);
			b2.setVisible(true);
		}
		
		if(e.getActionCommand().equalsIgnoreCase("Settimana"))
		{
			VisualizzaElencoLaboratori_Prenotazione settimana = new VisualizzaElencoLaboratori_Prenotazione(this);
			settimana.setVisible(true);
			setVisible(false);
		}
		
	}

}
