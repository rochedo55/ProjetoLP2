package br.ufrn.imd.modelo;

import java.util.ArrayList;
import java.util.List;

public abstract class ObjetoDataSet {
	
	protected char rotulo;// 'p' = pessoa | 'n' = não pessoa 
	protected List<Float> atributos; // Lista dos 1000 primeiros atributos
	protected double distancia;// Distancia euclidiana da imd a instancia
	
	public ObjetoDataSet(){
		this.atributos = new ArrayList<Float>();
	};

	public abstract Tratamento CalcularDistancia(Tratamento tratamento);

	public char getRotulo() {
		return rotulo;
	}

	public void setRotulo(char rotulo) {
		this.rotulo = rotulo;
	}

	public List<Float> getAtributos() {
		return atributos;
	}
	
	public Float getAtributo(int i) {
		return this.atributos.get(i);
	}

	public void setAtributos(List<Float> atributos) {
		this.atributos = atributos;
	}
	
	public void setAtributo(float valor) {
		this.atributos.add(valor);
	}

	public double getDistancia() {
		return distancia;
	}

	public void setDistancia(double d) {
		this.distancia = d;
	}
	
	
}
