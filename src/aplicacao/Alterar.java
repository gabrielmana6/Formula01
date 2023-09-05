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
			
			//Adiciona chegadas na prova de id1
			Query q2 = manager.query();
			q2.constrain(Chegada.class);
			q2.descend("prova").constrain(1);
			List<Chegada> chegadas = q2.execute();
			
			Query q3 = manager.query();
			q3.constrain(Prova.class);
			q3.descend("id").constrain(1);
			List<Prova> provas = q3.execute();
			
			if(chegadas.size()> 0) {
				Prova prova = provas.get(0);
				for(Chegada chegada : chegadas) {	
					prova.addListaDeChegada(chegada);
				}
				manager.store(prova);
				manager.commit();
			}
			
			//Adiciona chegadas na prova de id 2
			Query q4 = manager.query();
			q4.constrain(Chegada.class);
			q4.descend("prova").constrain(2);
			chegadas = q4.execute();
			
			Query q5 = manager.query();
			q5.constrain(Prova.class);
			q5.descend("id").constrain(2);
			provas = q5.execute();
			
			if(chegadas.size() > 0) {
				Prova prova = provas.get(0);
				for(Chegada chegada : chegadas) {	
					prova.addListaDeChegada(chegada);
				}
				manager.store(prova);
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
