/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author felixmorenotabares
 */
public class Cliente1 {
    	public static void main(String args[]) throws IOException {
		final String host = "192.168.1.103";
		final int portNumber = 1045;
		System.out.println("Creating socket to '" + host + "' on port " + portNumber);
                Socket socket = new Socket(host, portNumber);
		while (true) {
			
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

			System.out.println("Pregunta del Servidor: " + br.readLine());

			BufferedReader userInputBR = new BufferedReader(new InputStreamReader(System.in));
			String userInput = userInputBR.readLine();

			out.println(userInput);

			System.out.println("Respuesta del Servidor" + br.readLine());

			if ("exit".equalsIgnoreCase(userInput)) {
				socket.close();
				break;
			}
		}
	}
}
