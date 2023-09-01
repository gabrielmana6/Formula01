package modelo;

public class Chegada {
	private int prova;
	private int colocacao;
	private String piloto;
	
	public Chegada (int prova, int colocacao, String piloto) {
		this.prova = prova;
		this.colocacao = colocacao;
		this.piloto = piloto;
	}

	public int getProva() {
		return prova;
	}

	public void setProva(int prova) {
		this.prova = prova;
	}

	public int getColocacao() {
		return colocacao;
	}

	public void setColocacao(int colocacao) {
		this.colocacao = colocacao;
	}

	public String getPiloto() {
		return piloto;
	}

	public void setPiloto(String piloto) {
		this.piloto = piloto;
	}
	
}
