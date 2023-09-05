package aplicacao;

import java.util.List;

import com.db4o.ObjectContainer;
import com.db4o.query.Query;

import modelo.Chegada;
import modelo.Piloto;
import modelo.Prova;

public class Alterar {
	protected ObjectContainer manager;
	
	public Alterar() {
		try {
			manager = Util.conectarBanco();
			System.out.println("Alterar...");
			
			//Altera escuderia de Lewis Hamilton
			Query q1 = manager.query();
			q1.constrain(Piloto.class);
			q1.descend("nome").constrain("Lewis Hamilton");
			List<Piloto> pilotos = q1.execute();
			
			if(pilotos.size() > 0) {
				Piloto piloto = pilotos.get(0);
				
				piloto.setEscuderia("McLaren F1 Team");
				manager.store(piloto);
				manager.commit();
			}
			
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		Util.desconectar();
	}
	
	public static void main(String[] args) {
		new Alterar();
	}
}
