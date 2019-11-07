package br.ufrn.imd.modelo;

import java.util.ArrayList;
import java.util.List;

public abstract class ObjetoDataSet {
	
	protected char rotulo;// 'p' = pessoa | 'n' = não pessoa 
	protected List<Float> atributos; // Lista dos 1000 primeiros atributos
	protected float distancia;// Distancia euclidiana da imd a instancia
	
	public ObjetoDataSet(){
		this.atributos = new ArrayList<Float>();
	};

	public abstract void CalcularDistancia();

	public char getRotulo() {
		return rotulo;
	}

	public void setRotulo(char rotulo) {
		this.rotulo = rotulo;
	}

	public List<Float> getAtributos() {
		return atributos;
	}

	public void setAtributos(List<Float> atributos) {
		this.atributos = atributos;
	}
	
	public void setAtributo(float atributo) {
		this.atributos.add(atributo);
	}

	public float getDistancia() {
		return distancia;
	}

	public void setDistancia(float distancia) {
		this.distancia = distancia;
	}
	
	
}
