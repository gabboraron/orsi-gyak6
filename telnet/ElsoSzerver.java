
import java.io.*;
import java.util.*;
import java.net.*;

public class ElsoSzerver {
	public static void main(String[] args) throws Exception {
		// protokoll
			// interfesz
		// 0-65535 (1024-65535)
		int PORT = 12345;
		// try-with-resources (AutoCloseable)
		try (
			ServerSocket ss = new ServerSocket(PORT);
			Socket s = ss.accept();
			Scanner sc = new Scanner(s.getInputStream());
			PrintWriter pw = new PrintWriter(s.getOutputStream());
		) {
			
			while(true){
			String name = sc.nextLine();

			System.out.println("Hello, " + name);
			
			for (int idx = 0; idx < 1000 ;++idx ) {
				pw.println("nr: " + idx);
				pw.flush();
			}
			}
		}
	}
}
