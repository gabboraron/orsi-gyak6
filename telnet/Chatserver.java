import java.util.*;
import java.io.*;
import java.util.*;
import java.net.*;

public class Chatserver
{
	public static void main(String[] args) throws Exception {		
			
			int PORT = 12345;
			String MACHINE = "157.181.163.21";
			try(
				ServerSocket ss = new ServerSocket(PORT);
				Socket s = ss.accept();
				Scanner sc = new Scanner(s.getInputStream());
				Scanner sc2 = new Scanner(System.in);
				PrintWriter pw = new PrintWriter(s.getOutputStream());

			){
				Thread telnet = new Thread(() -> {
					while(sc.hasNextLine()){
						System.out.println(sc.nextLine());
					}
				});

				Thread stdin = new Thread(() -> {
					while(sc2.hasNextLine()){
						pw.println(sc2.nextLine());
						pw.flush();
					}
				});
				

				telnet.start();
				stdin.start();

				telnet.join(); // ha nincs join akkor hibaüzenet jön a scannerre, mert akkor a try block vége van ott, azaz az erőforrásokat felszabadítjuk és kirúgjuk a scannert
				stdin.join();
			}

	}
}