package aplicacao;

import com.db4o.ObjectContainer;

import modelo.Piloto;
import modelo.Prova;

public class Cadastrar {
	protected ObjectContainer manager;
	
	public Cadastrar() {
		try {
			manager = Util.conectarBanco();
			
			System.out.println("Cadastrando...");
			
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
			
			Piloto piloto5 = new Piloto("Sergio Perez ", "Red Bull Racing Honda");
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
			
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		Util.desconectar();
	}

	
	public static void main(String[] args) {
		new Cadastrar();
	}
	
}