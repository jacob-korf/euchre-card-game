package euchre;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.UnknownHostException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.WindowConstants;

public class Hub extends JFrame{
		private String[] string = {"Hello", "Goodbye"};
		private static Boolean connect = false;
		private JButton connectToGame = new JButton("Connect to this Game");
		private JButton createGame = new JButton("Create New Game");
		private JComboBox<String> gameOptionsBox = new JComboBox<String>(string);

		public static void main(String[] args) {
			try {
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			} catch (Exception ex) {
				ex.printStackTrace();
			}

			SwingUtilities.invokeLater(new Runnable() {
				@Override
				public void run() {
					Hub hub;
						try {
							hub = new Hub();
							hub.setVisible(true);
						} catch (UnknownHostException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				}
			});

		}

		public static void disconnect() {
			Timer timer = new Timer(6000, (ActionListener) new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}

			});
			timer.start();
		}

		public Hub() throws UnknownHostException, IOException {

			super("Help Queue Display");
			//Make all threads end when the red x is clicked including the Display back-end
			this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			// create a new panel with GridBagLayout manager
			JPanel newPanel = new JPanel(new GridBagLayout());

			GridBagConstraints constraints = new GridBagConstraints();
			constraints.anchor = GridBagConstraints.CENTER;
			constraints.insets = new Insets(10, 10, 10, 10);

			// Adding all display components to the gui
			constraints.gridx = 0;
			constraints.gridy = 0;
			constraints.gridwidth = 1;
			constraints.gridheight = 1;
			constraints.anchor = GridBagConstraints.WEST;
			newPanel.add(gameOptionsBox, constraints);
			
			constraints.gridx = 1;
			constraints.gridy = 0;
			constraints.gridwidth = 1;
			constraints.gridheight = 1;
			constraints.anchor = GridBagConstraints.WEST;
			newPanel.add(connectToGame, constraints);
			

			constraints.gridx = 0;
			constraints.gridy = 1;
			constraints.gridwidth = 2;
			constraints.gridheight = 1;
			constraints.anchor = GridBagConstraints.WEST;
			newPanel.add(createGame, constraints);




			// set border for the panel
			newPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Philips 115 Lab:"));

			// add the panel to this frame
			add(newPanel);

			pack();
			setLocationRelativeTo(null);
			/*if (!connect) {
				queue.setText("Unsuccessful Connection to Server");
				disconnect();
			}*/

		}
	}

