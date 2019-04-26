import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JInternalFrame;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.JTextPane;
import java.awt.Window.Type;

public class gui {

	private JFrame frmLoginScreen;
	protected TeacherScreen ts;
	protected StudentScreen sc;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gui window = new gui();
					window.frmLoginScreen.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public gui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLoginScreen = new JFrame();
		frmLoginScreen.setTitle("Login Screen");
		frmLoginScreen.setBounds(100, 100, 170, 260);
		frmLoginScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLoginScreen.getContentPane().setLayout(null);
		
		JButton btnTeacherLogin = new JButton("Teacher Login");
		btnTeacherLogin.addActionListener(new ActionListener() {
			//Teacher login screen comes up.
			public void actionPerformed(ActionEvent e) {
				ts=new TeacherScreen();
				ts.TeacherScreen();
				frmLoginScreen.setVisible(false);
			}
		});
		btnTeacherLogin.setBounds(6, 26, 162, 67);
		frmLoginScreen.getContentPane().add(btnTeacherLogin);
		
		JButton btnStudentLogin = new JButton("Student Login");
		btnStudentLogin.addActionListener(new ActionListener() {
			//student login screen comes up.
			public void actionPerformed(ActionEvent e) {
				sc=new StudentScreen();
				sc.StudentScreen();
				frmLoginScreen.setVisible(false);
			}
		});
		btnStudentLogin.setBounds(6, 145, 162, 67);
		frmLoginScreen.getContentPane().add(btnStudentLogin);
	}


}
