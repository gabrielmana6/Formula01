package aplicacao;

import com.db4o.ObjectContainer;

public class Alterar {
	protected ObjectContainer manager;
	
	public Alterar() {
		try {
			manager = Util.conectarBanco();
			System.out.println("Alterar...");
		} catch(Exception e) {
			
		}
		Util.desconectar();
	}
	
	
	public static void main(String[] args) {
		new Alterar();
	}
}
