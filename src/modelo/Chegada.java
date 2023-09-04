package modelo;

public class Chegada {
	private int prova;
	private int colocacao;
	private Piloto piloto;
	
	public Chegada (int prova, int colocacao, Piloto piloto) {
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

	public Piloto getPiloto() {
		return piloto;
	}

	public void setPiloto(Piloto piloto) {
		this.piloto = piloto;
	}

	@Override
	public String toString() {
		return "Chegada [prova=" + prova + ", colocacao=" + colocacao + ", piloto=" + piloto + "]";
	}
	
}
