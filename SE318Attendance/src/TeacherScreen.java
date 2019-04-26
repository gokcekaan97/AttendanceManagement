import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class TeacherScreen {

	private static JFrame frmTeacherLoginScreen;
	private JTextField txtUsername;
	private JPasswordField pwdPassword;
	private Connection conn;
	private PreparedStatement prepstatement;
	private ResultSet rs;
	private ControlScreen ctrls;
	private boolean match;
	

	/**
	 * Launch the application.
	 */
	public void TeacherScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TeacherScreen window = new TeacherScreen();
					window.frmTeacherLoginScreen.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TeacherScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		frmTeacherLoginScreen = new JFrame();
		frmTeacherLoginScreen.setTitle("Teacher Login Screen");
		frmTeacherLoginScreen.setBounds(100, 100, 290, 140);
		frmTeacherLoginScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTeacherLoginScreen.getContentPane().setLayout(null);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(135, 6, 130, 26);
		frmTeacherLoginScreen.getContentPane().add(txtUsername);
		txtUsername.setColumns(10);
		
		pwdPassword = new JPasswordField();
		pwdPassword.setBounds(135, 44, 130, 26);
		frmTeacherLoginScreen.getContentPane().add(pwdPassword);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//logging action.
				TeacherLoggingIn(txtUsername.getText(), pwdPassword.getText());
			}
		});
		btnLogin.setBounds(135, 83, 130, 29);
		frmTeacherLoginScreen.getContentPane().add(btnLogin);
		
		JTextPane txtpnTeachersUsername = new JTextPane();
		txtpnTeachersUsername.setEditable(false);
		txtpnTeachersUsername.setText("Teacher's username");
		txtpnTeachersUsername.setBounds(6, 11, 124, 16);
		frmTeacherLoginScreen.getContentPane().add(txtpnTeachersUsername);
		
		JTextPane txtpnPassword = new JTextPane();
		txtpnPassword.setText("Password");
		txtpnPassword.setBounds(30, 50, 59, 16);
		frmTeacherLoginScreen.getContentPane().add(txtpnPassword);
		
		JButton btnReturnBack = new JButton("Return back");
		btnReturnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//here it could return back to main menu.
				gui.main(null);
				frmTeacherLoginScreen.setVisible(false);
				}
		});
		btnReturnBack.setBounds(6, 83, 117, 29);
		frmTeacherLoginScreen.getContentPane().add(btnReturnBack);
	}
	//we reach teachers database ands let them log in to control gui.
	public boolean TeacherLoggingIn(String txtUsername,String pwdPassword){
		try {
			match=false;
			conn=DriverManager.getConnection("jdbc:sqlite:Attendance.db");
			prepstatement= conn.prepareStatement("SELECT * FROM Teacher WHERE TeacherNumber= ? AND Password=?");
			prepstatement.setString(1,txtUsername);
			prepstatement.setString(2,pwdPassword);
			rs=prepstatement.executeQuery();
			if(rs.next()){
				match=true;
				ctrls = new ControlScreen();
				ctrls.ControlScreen();
				frmTeacherLoginScreen.setVisible(false);
			}else{
				JOptionPane.showMessageDialog(null, "Username and Password does not match");
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return match;
	}
}