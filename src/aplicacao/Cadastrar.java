package aplicacao;

import com.db4o.ObjectContainer;

import modelo.Chegada;
import modelo.Piloto;
import modelo.Prova;

public class Cadastrar {
	protected ObjectContainer manager;
	
	public Cadastrar() {
		try {
			manager = Util.conectarBanco();
			
			System.out.println("Cadastrar...");
			
			//Cadastra pilotos
			Piloto piloto1 = new Piloto("Lewis Hamilton", "Mercedes-AMG Petronas Formula One Team");
			manager.store(piloto1);
			manager.commit();
			
			Piloto piloto2 = new Piloto("Max Verstappen", "Red Bull Racing Honda");
			manager.store(piloto2);
			manager.commit();
			
			Piloto piloto3 = new Piloto("Valtteri Bottas", "Mercedes-AMG Petronas Formula One Team");
			manager.store(piloto3);
			manager.commit();
			
			Piloto piloto4 = new Piloto("Charles Leclerc", "Scuderia Ferrari");
			manager.store(piloto4);
			manager.commit();
			
			Piloto piloto5 = new Piloto("Sergio Perez", "Red Bull Racing Honda");
			manager.store(piloto5);
			manager.commit();
			
			
			//Cadastra provas
			int id;
			id = Util.gerarIdProva();
			Prova prova1 = new Prova(id);
			manager.store(prova1);
			manager.commit();
			
			id = Util.gerarIdProva();
			Prova prova2 = new Prova(id);
			manager.store(prova2);
			manager.commit();
			
			
			//Cadastra chegada prova1
			Chegada chegada1 = new Chegada(prova1, 1, piloto2);
			manager.store(chegada1);
			manager.commit();
			
			Chegada chegada2 = new Chegada(prova1, 2, piloto3);
			manager.store(chegada2);
			manager.commit();
			
			Chegada chegada3 = new Chegada(prova1, 3, piloto1);
			manager.store(chegada3);
			manager.commit();

			//Cadastra chegada prova2
			chegada1 = new Chegada(prova2, 1, piloto4);
			manager.store(chegada1);
			manager.commit();
			
			chegada2 = new Chegada(prova2, 2, piloto5);
			manager.store(chegada2);
			manager.commit();
			
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		Util.desconectar();
	}

	
	public static void main(String[] args) {
		new Cadastrar();
	}
	
}