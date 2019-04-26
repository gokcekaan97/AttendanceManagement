import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Array;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.awt.event.ActionEvent;

public class ControlScreen {

	private JFrame frame;
	private Connection conn;
	private Statement stmnt;
	private String sql;
	private ResultSet rs;
	private int sessionCounter=0;
	private ArrayList<AttendingScreen> atslist;
	private int atsN=0;
	private PreparedStatement pstmt;

	/**
	 * Launch the application.
	 */
	public static void ControlScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ControlScreen window = new ControlScreen();
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
	public ControlScreen() {
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
		
		JButton btnCreateSession = new JButton("Create Session");
		btnCreateSession.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				//this will create session.
			}
		});
		btnCreateSession.setBounds(46, 133, 117, 29);
		frame.getContentPane().add(btnCreateSession);
		
		JButton btnEndSession = new JButton("End Session");
		btnEndSession.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//this will end the session
			}
		});
		btnEndSession.setBounds(187, 133, 117, 29);
		frame.getContentPane().add(btnEndSession);
	}
	//this is create session method (we are working on it).
	public void CreateSession(){
		try {
			Class.forName("org.sqlite.JDBC");
			conn=DriverManager.getConnection("jdbc:sqlite:Attendance.db");
			stmnt=conn.createStatement();
			atslist=new ArrayList<AttendingScreen>();
			pstmt = conn.prepareStatement("INSERT INTO Sessions (SessionNumber,Students,AttendedStudentsNumber) VALUES (?,?,?)");
			pstmt.setInt(1, sessionCounter);
			pstmt.setBlob(2, (Blob)atslist);
            pstmt.setInt(3,atsN);
            pstmt.executeUpdate();
			sessionCounter++;
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}
