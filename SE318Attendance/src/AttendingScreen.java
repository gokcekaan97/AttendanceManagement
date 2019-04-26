import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AttendingScreen {

	private JFrame frame;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public void AttendingScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	//this string number here carries the student number from student login screen.
	public AttendingScreen(String number) {
		initialize(number);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String StudentNumber) {
		frame = new JFrame();
		frame.setBounds(100, 100, 131, 180);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		lblNewLabel = new JLabel("Status");
		lblNewLabel.setBounds(29, 23, 61, 16);
		frame.getContentPane().add(lblNewLabel);
		JButton btnAttend = new JButton("Attend");
		btnAttend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// to be attended
			}
		});

		btnAttend.setBounds(6, 44, 117, 29);
		frame.getContentPane().add(btnAttend);
		
		JLabel lblSession = new JLabel("Session");
		lblSession.setBounds(29, 6, 61, 16);
		frame.getContentPane().add(lblSession);
		
		JButton btnMakeExcue = new JButton("Make Excuse");
		btnMakeExcue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//to be permitted with some info.
			}
		});
		btnMakeExcue.setBounds(6, 85, 117, 29);
		frame.getContentPane().add(btnMakeExcue);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			//Returns back to main menu
			public void actionPerformed(ActionEvent e) {
				gui.main(null);
				frame.setVisible(false);
			}
		});
		btnBack.setBounds(6, 123, 117, 29);
		frame.getContentPane().add(btnBack);
		
	}


}
