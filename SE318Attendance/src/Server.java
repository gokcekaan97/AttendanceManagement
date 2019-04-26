import java.io.*;
import java.util.*;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {
	private HashMap<HashMap<String,String>,String> session;
	private HashMap<String,String> students;
	public static void Main(String[] args) {
		while (true) {
			try (ServerSocket listener = new ServerSocket(6717)) {
				System.out.println("tcp client listening");
				try (Socket socket = listener.accept()) {
					// connecting teacher screen
					//connecting student screen
					//session to be created.
					//student map to be embedded to session.
					//taking attendance
					//ending session
					// keeping datas to database that comes from created session
					socket.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
