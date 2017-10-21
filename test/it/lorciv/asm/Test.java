package it.lorciv.asm;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Test {

	public static void main(String[] args) throws IOException {
		
		// Machine code read from file
		
//		BufferedReader reader = new BufferedReader(
//				new FileReader("machine_code.txt"));
		
		// Machine code read from standard input
		
		BufferedReader reader = new BufferedReader(
				new InputStreamReader(System.in));
		
		Scanner scanner = new Scanner();
		PrintWriter console = new PrintWriter(System.err, true);
		
		ArithmeticStackMachine asm = new ArithmeticStackMachine(scanner, console);
		
		String command = reader.readLine();
		
		while (command != null) {
			
			scanner.setString(command);
			asm.executeCommand();
			
			command = reader.readLine();
		}
		
		console.close();
		reader.close();
	}

}
