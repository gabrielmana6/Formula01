/**********************************
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * POB - Persistencia de Objetos
 * Prof. Fausto Ayres
 *
 */

package aplicacao;

import java.util.List;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.config.EmbeddedConfiguration;
import com.db4o.query.Query;

import modelo.Chegada;
import modelo.Piloto;
import modelo.Prova;

public class Util {
	private static ObjectContainer manager;

	public static ObjectContainer conectarBanco(){
		if (manager != null)
			return manager;		//ja tem uma conexao

		//---------------------------------------------------------------
		//configurar, criar e abrir banco local (pasta do projeto)
		//---------------------------------------------------------------
		EmbeddedConfiguration config =  Db4oEmbedded.newConfiguration(); 
		config.common().messageLevel(0);  // mensagens na tela 0(desliga),1,2,3...
		
		// habilitar cascata na alteracao, remocao e leitura
		config.common().objectClass(Piloto.class).cascadeOnDelete(false);
		config.common().objectClass(Piloto.class).cascadeOnUpdate(true);
		config.common().objectClass(Piloto.class).cascadeOnActivate(true);
		config.common().objectClass(Prova.class).cascadeOnDelete(false);
		config.common().objectClass(Prova.class).cascadeOnUpdate(true);
		config.common().objectClass(Prova.class).cascadeOnActivate(true);
		config.common().objectClass(Chegada.class).cascadeOnDelete(false);
		config.common().objectClass(Chegada.class).cascadeOnUpdate(true);
		config.common().objectClass(Chegada.class).cascadeOnActivate(true);
	
		//conexao local
		manager = Db4oEmbedded.openFile(config, "banco.db4o");
		return manager;
	}

	public static void desconectar() {
		if(manager!=null) {
			manager.close();
			manager=null;
		}
	}
	
	public static int gerarIdProva() {
		if(manager.query(Prova.class).size()==0) return 1;
		
		Query q = manager.query();
		q.constrain(Prova.class);
		q.descend("id").orderDescending();
		List<Prova> provas = q.execute();
		
		if(provas.size() > 0 ) {
			Prova prova = provas.get(0);
			return prova.getId() + 1;
		} else {
			return 1;		
		}
	}
	
}
