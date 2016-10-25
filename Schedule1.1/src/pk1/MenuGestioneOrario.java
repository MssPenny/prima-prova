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
* All'interno della seguente classe è rappresentato l'elenco di tutte le funzioni 
* che consentono la gestione degli orari di ricevimento degli insegamanti assegnati, 
* da parte dell'amministratore del sistema, al docente preso in considerazione. 
* Per gestione s'intende tutte le operazioni come l'inserimento, la visualizzazione e 
* la modifica. Ogni funzione contenuta all'interno della seguente schermata porta
* a successive schermate in cui è possibile sviluppare nel dettaglio lo scopo 
* della funzione di gestione desiderata.
*/
public class MenuGestioneOrario extends javax.swing.JFrame implements ActionListener {
	private JPanel jPanel1;
	private JLabel jLabelTitolo;
	private JButton jButtonVisualizzaOrario;
	private JButton jButtonTornaMenu;
	private JButton jButtonInserimentoOrario;
	private JPanel jPanel4;
	private JPanel jPanel3;
	private JLabel jLabelSottotitolo;
	private JPanel jPanel2;
	public MenuDocente gestione_or;
	public String pLogin, pPassword;

	public MenuGestioneOrario(MenuDocente m) {
		super();
		gestione_or = m;
		initGUI();
	}
	
	private void initGUI() {
         pLogin=gestione_or.pLogin;
         pPassword=gestione_or.pPassword;
		
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("GESTIONE ORARIO DI RICEVIMENTO");
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
						jLabelTitolo.setText("GESTIONE ORARIO DI RICEVIMENTO");
						jLabelTitolo.setFont(new java.awt.Font("Arial",0,18));
					}
					{
						jLabelSottotitolo = new JLabel();
						jPanel2.add(jLabelSottotitolo, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						jLabelSottotitolo.setText("Menu per la gestione degli orari di ricevimento degli insegnamenti");
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
					jPanel4Layout.rowWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.1};
					jPanel4Layout.rowHeights = new int[] {50, 50, 50, 50, 7};
					jPanel4Layout.columnWeights = new double[] {0.0, 0.0, 0.1};
					jPanel4Layout.columnWidths = new int[] {120, 120, 7};
					jPanel4.setLayout(jPanel4Layout);
					{
						jButtonInserimentoOrario = new JButton();
						jPanel4.add(jButtonInserimentoOrario, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
						jButtonInserimentoOrario.setText("Inserimento orario");
						jButtonInserimentoOrario.addActionListener(this);
					}
					{
						jButtonVisualizzaOrario = new JButton();
						jPanel4.add(jButtonVisualizzaOrario, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
						jButtonVisualizzaOrario.setText("Visualizza orario");
						jButtonVisualizzaOrario.addActionListener(this);
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
		
		if(e.getActionCommand().equalsIgnoreCase("Inserimento orario"))
		{
			InserimentoOrario modifica=new InserimentoOrario(this);
			modifica.setVisible(true);
			setVisible(false);
		}
		
		if(e.getActionCommand().equalsIgnoreCase("Visualizza orario"))
		{
			VisualizzaOrario visualizza=new VisualizzaOrario(this);
			visualizza.setVisible(true);
			setVisible(false);
		}
		
		if(e.getActionCommand().equalsIgnoreCase("Torna al Menu"))
		{
			setVisible(false);
			gestione_or.setVisible(true);
		}
		
	}

}
