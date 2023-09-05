package aplicacao;

import java.util.List;

import com.db4o.ObjectContainer;
import com.db4o.query.Query;

import modelo.Chegada;
import modelo.Prova;

public class Alterar {
	protected ObjectContainer manager;
	
	public Alterar() {
		try {
			manager = Util.conectarBanco();
			System.out.println("Alterar...");
			
			//Consultar prova de id = 1
			Query q1 = manager.query();
			q1.constrain(Prova.class);
			q1.descend("id").constrain(1);
			List<Prova> provas = q1.execute();
			
			if(provas.size() > 0 ) {
				Prova prova = provas.get(0);
				
				//Consultar chegada com prova id = 1
				Query q2 = manager.query();
				q2.constrain(Chegada.class);
				q2.descend("colocacao");
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
