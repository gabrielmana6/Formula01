package modelo;

import java.util.ArrayList;

public class Prova {
	private int id;
	private ArrayList<String> listaDeChegada;
	
	public Prova(int id) {
		this.id = id;
		this.listaDeChegada = new ArrayList<String>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ArrayList<String> getListaDeChegada() {
		return listaDeChegada;
	}

	public void setListaDeChegada(ArrayList<String> listaDeChegada) {
		this.listaDeChegada = listaDeChegada;
	}

	@Override
	public String toString() {
		return "Prova [id=" + id + ", listaDeChegada=" + listaDeChegada + "]";
	}
	
}
