package Server;

import java.net.*;
import java.io.*;

public class Server_Starter {
	public static boolean listening = true;

	public static void main(String[] args) throws IOException {

		if (args.length != 1) {
			System.err.println("Usage: java KKMultiServer <port number>");
			System.exit(1);
		}

		int portNumber = Integer.parseInt(args[0]);

		try (ServerSocket serverSocket = new ServerSocket(44441)) {
			System.out.println("Socket created: ");
			while (listening) {
				new Server_Thread(serverSocket.accept()).start();
				
			}
		} catch (IOException e) {
			System.err.println("Could not listen on port " + portNumber);
			System.exit(-1);
		}
	}
}