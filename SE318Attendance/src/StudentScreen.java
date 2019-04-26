import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class StudentScreen {

	private JFrame frmStudentLoginScreen;
	private JTextField txtUsername;
	private JPasswordField pwdPassword;
	private Connection conn;
	private PreparedStatement prepstatement;
	private ResultSet rs;
	private AttendingScreen ats;
	private boolean match;

	/**
	 * Launch the application.
	 */
	public void StudentScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentScreen window = new StudentScreen();
					window.frmStudentLoginScreen.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public StudentScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmStudentLoginScreen = new JFrame();
		frmStudentLoginScreen.setTitle("Student Login Screen");
		frmStudentLoginScreen.setBounds(100, 100, 290, 140);
		frmStudentLoginScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmStudentLoginScreen.getContentPane().setLayout(null);

		
		txtUsername = new JTextField();
		txtUsername.setBounds(135, 6, 130, 26);
		frmStudentLoginScreen.getContentPane().add(txtUsername);
		txtUsername.setColumns(10);

		pwdPassword = new JPasswordField();
		pwdPassword.setBounds(135, 44, 130, 26);
		frmStudentLoginScreen.getContentPane().add(pwdPassword);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			//studen login action
			public void actionPerformed(ActionEvent e) {
				StudentLoggingIn(txtUsername.getText(), pwdPassword.getText());
			}
		});
		btnLogin.setBounds(135, 83, 130, 29);
		frmStudentLoginScreen.getContentPane().add(btnLogin);
		
		JTextPane txtpnStudentsUsername = new JTextPane();
		txtpnStudentsUsername.setEditable(false);
		txtpnStudentsUsername.setText("Student's username");
		txtpnStudentsUsername.setBounds(6, 11, 124, 16);
		frmStudentLoginScreen.getContentPane().add(txtpnStudentsUsername);
		
		JTextPane txtpnPassword = new JTextPane();
		txtpnPassword.setText("Password");
		txtpnPassword.setBounds(30, 50, 59, 16);
		frmStudentLoginScreen.getContentPane().add(txtpnPassword);
		
		JButton btnReturnBack = new JButton("Return back");
		btnReturnBack.addActionListener(new ActionListener() {
			//returns back to main menu.
			public void actionPerformed(ActionEvent e) {
				gui.main(null);
				frmStudentLoginScreen.setVisible(false);
			}
		});
		btnReturnBack.setBounds(6, 83, 117, 29);
		frmStudentLoginScreen.getContentPane().add(btnReturnBack);
		
	}
	//student login verification.
	public boolean StudentLoggingIn(String txtUsername,String pwdPassword){
		try {
			match=false;
			Class.forName("org.sqlite.JDBC");
			conn=DriverManager.getConnection("jdbc:sqlite:Attendance.db");
			prepstatement= conn.prepareStatement("SELECT * FROM Student WHERE StudentNumber= ? AND Password=?");
			prepstatement.setString(1,txtUsername);
			prepstatement.setString(2,pwdPassword);
			rs=prepstatement.executeQuery();
			if(rs.next()){
				match=true;
				ats=new AttendingScreen(txtUsername);
				ats.AttendingScreen();
				frmStudentLoginScreen.setVisible(false);
			}else{
				JOptionPane.showMessageDialog(null, "Username and Password does not match");
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return match;
	}
	
}