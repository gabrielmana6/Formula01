package aplicacao;

import java.util.List;

import com.db4o.ObjectContainer;
import com.db4o.query.Query;

import modelo.Chegada;
import modelo.Piloto;
import modelo.Prova;

public class Deletar {
	
	protected static ObjectContainer manager;

	public Deletar() {
		try {
			manager = Util.conectarBanco();
			
			System.out.println("Deletar...");
			
			//deletar piloto
			Query q = manager.query();
			q.constrain(Piloto.class);
			q.descend("nome").constrain("Sergio Perez");
			List<Piloto> resultados = q.execute(); 

			if (resultados.size() > 0) {
			
				Piloto p = resultados.get(0);
				manager.delete(p);
				manager.commit();
				System.out.println("apagou piloto");
			} else
				System.out.println("piloto inexistente");
			
			//deletar prova
			Query q2 = manager.query();
			q2.constrain(Prova.class);
			q2.descend("id").constrain(2);
			List<Prova> resultados2 = q2.execute(); 

			if (resultados2.size() > 0) {
			
				Prova p2 = resultados2.get(0);
				manager.delete(p2);
				manager.commit();
				System.out.println("apagou prova");
			} else
				System.out.println("prova inexistente");
			
			
			//deletar chegadas
			Query q3 = manager.query();
			q3.constrain(Chegada.class);
			List<Chegada> resultados3 = q3.execute(); 

			if (!resultados3.isEmpty()) {
			
				for (Chegada chegada : resultados3) {
			        manager.delete(chegada);
			    }
				
				manager.commit();
				System.out.println("Todos os objetos Chegada foram excluídos.");
			} else
				System.out.println("Nenhum objeto Chegada encontrado para exclusão.");
		
			
						
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		Util.desconectar();
	}
	
	
//MÉTODOS PERSONALIZADOS DE REMOÇÃO ÚNICA DE OBJETOS OU GENERALIZADA
	
	public static String deletarPilotoPorNome(ObjectContainer manager, String nomePiloto ) {
		System.out.println("Deletar piloto por nome...");
		
		String resposta = "";
		
		//deletar piloto
		Query q = manager.query();
		q.constrain(Piloto.class);
		q.descend("nome").constrain(nomePiloto);
		List<Piloto> resultados = q.execute(); 
		
		if (resultados.size() > 0) {
			Piloto p = resultados.get(0);
			manager.delete(p);
			manager.commit();
			
			Util.desconectar();
			
			resposta = "Apagou piloto";	
			
		} else {	
			
			resposta = "Piloto não encontrado"; 
		}
		
		
		Util.desconectar();
		
		return resposta;
		
	}
	
	public static String deletarTodosOsPilotos(ObjectContainer manager) {
		System.out.println("Deletar todos os pilotos...");
		
		String resposta = "";
		
		Query q = manager.query();
		q.constrain(Piloto.class);
		List<Piloto> resultados = q.execute(); 

		if (!resultados.isEmpty()) {
		
			for (Piloto chegada : resultados) {
		        manager.delete(chegada);
		    }
			
			manager.commit();
			
			resposta = "Apagou todos os pilotos";	
			
		} else {	
			
			resposta = "Nenhum piloto encontrado"; 
		}
		
		Util.desconectar();
		
		return resposta;	
		
	}
	
	public static String deletarProvaPorId(ObjectContainer manager, int provaId ) {
		System.out.println("Deletar prova por id...");
		
		String resposta = "";
		
		//deletar piloto
		Query q = manager.query();
		q.constrain(Prova.class);
		q.descend("id").constrain(provaId);
		List<Prova> resultados = q.execute(); 
		
		if (resultados.size() > 0) {
			Prova p = resultados.get(0);
			manager.delete(p);
			manager.commit();
			
			Util.desconectar();
			
			resposta = "Apagou prova";	
			
		} else {	
			
			resposta = "Prova não encontrada"; 
		}
		
		
		Util.desconectar();
		
		return resposta;
		
	}
	
	public static String deletarTodasAsProvas(ObjectContainer manager) {
		System.out.println("Deletando todas as provas...");
		
		String resposta = "";
		
		Query q = manager.query();
		q.constrain(Prova.class);
		List<Prova> resultados = q.execute(); 

		if (!resultados.isEmpty()) {
		
			for (Prova chegada : resultados) {
		        manager.delete(chegada);
		    }
			
			manager.commit();
			
			resposta = "Apagou todas objetos de 'provas'";	
			
		} else {	
			
			resposta = "Nenhum objeto de 'prova' encontrado no sistema"; 
		}
		
		Util.desconectar();
		
		return resposta;	
		
	}
	
	
	public static String deletarChegadas(ObjectContainer manager) {
		System.out.println("Deletando todas as chegadas...");
		
		String resposta = "";
		
		Query q = manager.query();
		q.constrain(Chegada.class);
		List<Chegada> resultados = q.execute(); 

		if (!resultados.isEmpty()) {
		
			for (Chegada chegada : resultados) {
		        manager.delete(chegada);
		    }
			
			manager.commit();
			
			resposta = "Apagou todas os objetos de 'chegada' ";	
			
		} else {	
			
			resposta = "Nenhum objeto de 'chegada' encontrada no sistema"; 
		}
		
		Util.desconectar();
		
		return resposta;	
		
	}
	
	public static String deletarReferenciaAoPiloto(ObjectContainer manager, String nomePiloto) {
	    //System.out.println("Removendo referências de Piloto em todas as Chegadas...");

	    String resposta = "";
	    

	    Query q = manager.query();
	    q.constrain(Chegada.class);
	    List<Chegada> resultados = q.execute();

	    if (!resultados.isEmpty()) {
	        for (Chegada chegada : resultados) {
	            Piloto piloto = chegada.getPiloto(); //recebe a referencia ao piloto
	            
	            if (piloto != null && piloto.getNome().equals(nomePiloto)) { // compara o nome do piloto ao parametro
	            	chegada.setPiloto(null); 
	            	
	            	manager.ext().store(chegada);
	            }
	        }

	        manager.commit();

	        resposta = "Removido as referências do Piloto em todas as Chegadas.";
	    } else {
	        //resposta = "Nenhuma Chegada encontrada no sistema.";
	    }

	    Util.desconectar();

	    return resposta;
	}
	

	public static void main(String[] args) {
		new Deletar();
		
		
//trecho de operações individuais---------------------
		
		//para cada chamada de método precisa é necessário 
		//sempre inicializar o manager
		
		try {
			//manager = Util.conectarBanco();
			//String resultado = deletarPilotoPorNome(manager, "Lewis Hamilton");
		    //System.out.println(resultado);
		    
		    //manager = Util.conectarBanco();
		    //String resultado2 = deletarTodosOsPilotos(manager);
		    //System.out.println(resultado2);
		    
		    //manager = Util.conectarBanco();
		    //String resultado3 = deletarProvaPorId(manager, 1);
		    //System.out.println(resultado3);
		    
		    //manager = Util.conectarBanco();
		    //String resultado4 = deletarTodasAsProvas(manager);
		    //System.out.println(resultado4);
		    
		    //manager = Util.conectarBanco();
		    //String resultado5 = deletarChegadas(manager);
		    //System.out.println(resultado5);
		    
		    //manager = Util.conectarBanco();
		    //String resultado6 = deletarReferenciaAoPiloto(manager, "Valtteri Bottas");
		    //System.out.println(resultado6);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
			
	}

}
