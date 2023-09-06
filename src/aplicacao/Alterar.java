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
			
			//Alterar prova de uma chegada. id da prova 2 para 1. 
			Query q2 = manager.query();
			q2.constrain(Chegada.class);
			q2.descend("prova").descend("id").constrain(2);
			q2.descend("piloto").descend("nome").constrain("Sergio Perez");
			List<Chegada> chegadas = q2.execute();
			
			Query q3 = manager.query();
			q3.constrain(Prova.class);
			q3.descend("id");
			List<Prova> provas = q3.execute();
			
			if(chegadas.size() > 0 && provas.size() > 0) {
				Chegada chegada = chegadas.get(0);
				
				for(Prova prova: provas) {
					
					if(prova.getId() == 2) {
						prova.rmvListaDeChegada(chegada);
					}
					if(prova.getId() == 1){
						chegada.setProva(prova);
					}
					
					manager.store(prova);
					manager.store(chegada);
					manager.commit();
				}
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
