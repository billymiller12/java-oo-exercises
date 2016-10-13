import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;

public class RobotGUI {

	private JFrame frame;
	private final Action action = new SwingAction();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RobotGUI window = new RobotGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RobotGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnMakeAttackRobot = new JButton("Make attack robot");
		btnMakeAttackRobot.setBounds(6, 6, 146, 29);
		frame.getContentPane().add(btnMakeAttackRobot);
		
		JButton btnMakeJokeRobot = new JButton("Make joke robot");
		btnMakeJokeRobot.setBounds(6, 36, 146, 29);
		frame.getContentPane().add(btnMakeJokeRobot);
		
		JButton btnMakeRobot = new JButton("Make robot");
		btnMakeRobot.setBounds(6, 67, 146, 29);
		frame.getContentPane().add(btnMakeRobot);
		
		JList list = new JList();
		list.setBounds(389, 274, -196, -258);
		frame.getContentPane().add(list);
		
		JButton btnAttack = new JButton("Attack");
		btnAttack.setBounds(19, 195, 117, 29);
		frame.getContentPane().add(btnAttack);
		
		JButton btnJoke = new JButton("Joke");
		btnJoke.setBounds(19, 225, 117, 29);
		frame.getContentPane().add(btnJoke);
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
