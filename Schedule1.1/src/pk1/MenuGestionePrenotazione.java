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
* All'interno della seguente classe è contenuto l'elenco di tutte le funzioni utili 
* per quano riguarda la gestione delle prenotazioni delle aule e dei laboratori del 
* Dipartimento di Informatica e del Palazzo delle Aule. Per gestione s'intendono operazioni
* come l'inserimento, la visualizzazione, la modifica e in questo caso è comprese anche
* l'operazione di cancellazione. Per poter effettuare in dattaglio le seguenti funzioni 
* di gestione è necessario accedere a schermate successive e quindi all'utilizzo di apposite
* classi. 
*/
public class MenuGestionePrenotazione extends javax.swing.JFrame implements ActionListener {
	private JPanel jPanel1;
	private JLabel jLabelTitolo;
	private JButton jButtonPrenota;
	private JButton jButtonTornaMenu;
	private JButton jButtonVisualizzaPrenotazione;
	private JLabel jLabelSottotitolo;
	private JPanel jPanel4;
	private JPanel jPanel3;
	private JPanel jPanel2;
	public MenuDocente t1;
	public String pLogin, pPassword;

	
	
	public MenuGestionePrenotazione(MenuDocente t) {
		super();
		t1=t;
		initGUI();
	}
	
	private void initGUI() {
		pLogin=t1.pLogin;
		pPassword=t1.pPassword;
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("GESTIONE PRENOTAZIONI");
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
						jLabelTitolo.setText("GESTIONE PRENOTAZIONI");
						jLabelTitolo.setFont(new java.awt.Font("Arial",0,18));
					}
					{
						jLabelSottotitolo = new JLabel();
						jPanel2.add(jLabelSottotitolo, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						jLabelSottotitolo.setText("Menu utile per la gestione delle prenotazioni delle aule e dei laboratori");
						jLabelSottotitolo.setFont(new java.awt.Font("Tahoma",0,16));
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
						jButtonVisualizzaPrenotazione = new JButton();
						jPanel4.add(jButtonVisualizzaPrenotazione, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
						jButtonVisualizzaPrenotazione.setText("Visualizza Prenotazioni");
						jButtonVisualizzaPrenotazione.addActionListener(this);
					}
					{
						jButtonTornaMenu = new JButton();
						jPanel4.add(jButtonTornaMenu, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
						jButtonTornaMenu.setText("Torna al Menu");
						jButtonTornaMenu.addActionListener(this);
					}
					{
						jButtonPrenota = new JButton();
						jPanel4.add(jButtonPrenota, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
						jButtonPrenota.setText("Prenota");
						jButtonPrenota.addActionListener(this);
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
			t1.setVisible(true);
		}
		
	
		
		if(e.getActionCommand().equalsIgnoreCase("Visualizza Prenotazioni"))
		{
			VisualizzaPrenotazione visualizza_prenotazione = new VisualizzaPrenotazione(this);
			visualizza_prenotazione.setVisible(true);
			setVisible(false);
		}
		
		if(e.getActionCommand().equalsIgnoreCase("Prenota"))
		{
			InserimentoPrenotazioneAulaLab prenotazione = new InserimentoPrenotazioneAulaLab(this);
			prenotazione.setVisible(true);
			setVisible(false);
		}
		
		
		
		
	}

}
