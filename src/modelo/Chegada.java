package modelo;

public class Chegada {
	private int colocacao;
	
	private Prova prova;
	private Piloto piloto;
	
	public Chegada (Prova prova, int colocacao, Piloto piloto) {
		this.prova = prova;
		this.colocacao = colocacao;
		this.piloto = piloto;
	}

	public Prova getProva() {
		return prova;
	}

	public void setProva(Prova prova) {
		this.prova = prova;
		prova.addListaDeChegada(this);
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
		return "Chegada [prova=" + prova.getId() + ", colocacao=" + colocacao + ", piloto=" + piloto + "]";
	}
	
}
