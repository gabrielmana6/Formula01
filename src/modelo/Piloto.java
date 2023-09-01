package modelo;

public class Piloto {
	private String nome;
	private String escuderia;
	
	public Piloto (String nome, String escuderia) {
		this.nome = nome;
		this.escuderia = escuderia;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEscuderia() {
		return escuderia;
	}

	public void setEscuderia(String escuderia) {
		this.escuderia = escuderia;
	}

	@Override
	public String toString() {
		return "Piloto [nome=" + nome + ", escuderia=" + escuderia + "]";
	}
	
}
