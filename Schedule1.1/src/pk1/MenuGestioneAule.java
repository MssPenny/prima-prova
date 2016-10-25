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
* La seguente classe contiene l'elenco delle funzioni relative alla gestione delle aule
* e dei laboratori del Dipartimento di Informatica oppure del Palazzo delle Aule.
* Per gestione s'intende le operazioni di inserimento, visulizzazione e modifica dei 
* dati inerenti alle aule oppure ai laboratori.
*/
public class MenuGestioneAule extends javax.swing.JFrame implements ActionListener {
	private JPanel jPanel1;
	private JLabel jLabelTitolo;
	private JButton jButtonTornaMenu;
	private JButton jButtonVisualizzaAule;
	private JButton jButtonInserimentoAule;
	private JPanel jPanel4;
	private JPanel jPanel3;
	private JLabel jLabelSottotitolo;
	private JPanel jPanel2;
	public MenuAmministratore m1;
	

	
	
	public MenuGestioneAule(MenuAmministratore m) {
		super();
		m1=m;
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("GESTIONE AULE");
			{
				jPanel1 = new JPanel();
				BorderLayout jPanel1Layout = new BorderLayout();
				jPanel1.setLayout(jPanel1Layout);
				getContentPane().add(jPanel1, BorderLayout.CENTER);
				{
					jPanel2 = new JPanel();
					GridBagLayout jPanel2Layout = new GridBagLayout();
					jPanel1.add(jPanel2, BorderLayout.NORTH);
					jPanel2.setPreferredSize(new java.awt.Dimension(692, 71));
					jPanel2Layout.rowWeights = new double[] {0.1, 0.1};
					jPanel2Layout.rowHeights = new int[] {7, 7};
					jPanel2Layout.columnWeights = new double[] {0.1};
					jPanel2Layout.columnWidths = new int[] {7};
					jPanel2.setLayout(jPanel2Layout);
					{
						jLabelTitolo = new JLabel();
						jPanel2.add(jLabelTitolo, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						jLabelTitolo.setText("GESTIONE AULE/LABORATORI");
						jLabelTitolo.setFont(new java.awt.Font("Arial",0,18));
					}
					{
						jLabelSottotitolo = new JLabel();
						jPanel2.add(jLabelSottotitolo, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						jLabelSottotitolo.setText("Menu per la gestione delle aule e dei laboratori");
						jLabelSottotitolo.setFont(new java.awt.Font("Tahoma",0,16));
					}
				}
				{
					jPanel3 = new JPanel();
					jPanel1.add(jPanel3, BorderLayout.WEST);
					jPanel3.setPreferredSize(new java.awt.Dimension(351, 495));
				}
				{
					jPanel4 = new JPanel();
					GridBagLayout jPanel4Layout = new GridBagLayout();
					jPanel1.add(jPanel4, BorderLayout.CENTER);
					jPanel4Layout.rowWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.1};
					jPanel4Layout.rowHeights = new int[] {79, 52, 52, 52, 20};
					jPanel4Layout.columnWeights = new double[] {0.0, 0.0, 0.1};
					jPanel4Layout.columnWidths = new int[] {101, 162, 7};
					jPanel4.setLayout(jPanel4Layout);
					{
						jButtonInserimentoAule = new JButton();
						jPanel4.add(jButtonInserimentoAule, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
						jButtonInserimentoAule.setText("Inserimento aule/laboratori");
						jButtonInserimentoAule.addActionListener(this);
					}
					{
						jButtonVisualizzaAule = new JButton();
						jPanel4.add(jButtonVisualizzaAule, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						jButtonVisualizzaAule.setText("Visualizza elenco aule/laboratori");
						jButtonVisualizzaAule.addActionListener(this);
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
		
		if(e.getActionCommand().equalsIgnoreCase("Inserimento aule/laboratori"))
		{
			InserimentoAule modifica =new InserimentoAule(this);
			modifica.setVisible(true);
			setVisible(false);
		}
		
		if(e.getActionCommand().equalsIgnoreCase("Visualizza elenco aule/laboratori"))
		{
			VisualizzaElencoAule elenco =new VisualizzaElencoAule();
			elenco.setVisible(true);
			
		}
		
		if(e.getActionCommand().equalsIgnoreCase("Torna al Menu"))
		{
			setVisible(false);
			m1.setVisible(true);
		}
		
		
	}

}
