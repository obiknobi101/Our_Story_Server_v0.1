package Server;

import java.net.*;
import java.io.*;

public class Server_Thread extends Thread {
	private Socket socket = null;

	public Server_Thread(Socket socket) {
		super("Server_Thread");
		this.socket = socket;
	}

	public void run() {
		System.out.println("Thread started");
		try (BufferedReader in = new BufferedReader(new InputStreamReader(
				socket.getInputStream()));) {
			System.out.println("input stream opened");
			String inputLine = in.readLine();
			System.out.println("Client: " + inputLine);
			if (inputLine.equals("Bye")) {
				Server_Starter.listening = false;
			}
			in.close();
			socket.close();
			this.interrupt();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}