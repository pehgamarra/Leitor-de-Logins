package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Instant;
import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import entitis.LoginDeEntrada;

public class Programa {
	
	public static void main(String [] args) {
		
		Scanner teclado = new Scanner (System.in);
		
		System.out.print("Digite o caminho do arquivo a ser lido: ");
		String destino = teclado.nextLine();
		
		try (BufferedReader br = new BufferedReader(new FileReader(destino))){
			
			Set<LoginDeEntrada> set = new HashSet<>();
			
			String line = br.readLine();
			while (line != null) {
				
				String [] fields = line.split(" ");
				String nome = fields[0];
				Date momento = Date.from(Instant.parse(fields[1]));
				
				set.add(new LoginDeEntrada(nome, momento));
				
				line = br.readLine();
			}
			System.out.println("Total users: " + set.size());
			
		} catch (IOException e) {
			System.out.println("Erro!" + e.getMessage());
		}
		
		teclado.close();
	}
}
