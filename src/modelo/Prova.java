package modelo;

import java.util.ArrayList;

public class Prova {
	private int id;
	private ArrayList<Chegada> listaDeChegada;
	
	public Prova(int id) {
		this.id = id;
		this.listaDeChegada = new ArrayList<Chegada>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public void addListaDeChegada(Chegada chegada) {
		this.listaDeChegada.add(chegada);
	}
	
	public void rmvListaDeChegada(Chegada chegada) {
		this.listaDeChegada.remove(chegada);
	}

	public ArrayList<Chegada> getListaDeChegada() {
		return listaDeChegada;
	}

	public void setListaDeChegada(ArrayList<Chegada> listaDeChegada) {
		this.listaDeChegada = listaDeChegada;
	}

	@Override
	public String toString() {
		return "Prova [id=" + id + ", listaDeChegada=" + listaDeChegada + "]";
	}
	
}
