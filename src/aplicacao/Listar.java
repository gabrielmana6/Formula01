package aplicacao;

import java.util.List;

import com.db4o.ObjectContainer;
import com.db4o.query.Query;

import modelo.Piloto;
import modelo.Prova;

public class Listar {
	protected ObjectContainer manager;
	
	
	public Listar() {
		try {			
			manager = Util.conectarBanco();
			
			//Lista pilotos
			System.out.println("\n---Pilotos: ");
			Query q = manager.query();
			q.constrain(Piloto.class);
			List<Piloto> pilotos = q.execute();
			for(Piloto piloto: pilotos)
				System.out.println(piloto);
			
			//Lista provas
			System.out.println("\n---Provas: ");
			q = manager.query();
			q.constrain(Prova.class);
			List<Prova> provas = q.execute();
			for(Prova prova: provas)
				System.out.println(prova);
			
			//Lista chegadas
			System.out.println("\n---Chegadas: ");
			
			
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		Util.desconectar();
	}
	
	
	public static void main(String[] args) {
		new Listar();
	}
}
