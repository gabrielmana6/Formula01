package aplicacao;

import java.util.List;
import java.util.Scanner;

import com.db4o.ObjectContainer;
import com.db4o.query.Query;

import modelo.Chegada;
import modelo.Piloto;

public class Consultar {
	protected ObjectContainer manager;
	
	
	public Consultar() {
		try {
			manager = Util.conectarBanco();
			
			System.out.println("Consultar...");

			//Quais os pilotos da escuderia X
			System.out.println("Quais os pilotos da escuderia X");
			Scanner scanner = new Scanner(System.in);

	        System.out.print("Digite o nome da escuderia: ");
	        String texto = scanner.nextLine();

	        System.out.println("Você digitou: " + texto);
	        
	        Query q1 = manager.query();
	        q1.constrain(Piloto.class);
	        q1.descend("escuderia").constrain(texto);
	        List<Piloto> pilotos = q1.execute();
	        
	        if(pilotos.size() > 0) {
	        	System.out.println("\nPilotos da escuderia: " + texto + "\n");
	        	for(Piloto piloto : pilotos) {
	        		System.out.println(piloto.getNome());
	        	}
	        } else {
	        	System.out.println("Não existem pilotos dessa escuderia.");
	        }

	        
	        //Quais as colocacoes do piloto de nome X
	        System.out.println("----------------------------------------");
			System.out.println("Quais as colocacoes do piloto de nome X");
			scanner = new Scanner(System.in);
			
			
			System.out.println("Digite o nome do piloto: ");
			texto = scanner.nextLine();
			Query q2 = manager.query();
			q2.constrain(Chegada.class);
			q2.descend("piloto").descend("nome").constrain(texto);
			List<Chegada> chegadas = q2.execute();
			if(chegadas.size() > 0) {
				for(Chegada chegada: chegadas) {
					System.out.println(chegada.getColocacao());				
				}
			} else {
				System.out.println("Não existem colocacoes para esse piloto");
			}
			
			
			//Quais as provas com mais de N chegadas
			System.out.println("----------------------------------------");
			System.out.println("Quais as provas com mais de N chegadas");
			
			scanner = new Scanner(System.in);
			
			System.out.println("Digite o numero de chegadas");
			texto = scanner.nextLine();
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		Util.desconectar();
	}
	
	
	public static void main(String[] args) {
		new Consultar();
	}
}
