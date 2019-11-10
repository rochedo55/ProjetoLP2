package br.ufrn.imd.modelo;

import br.ufrn.imd.modelo.Tratamento;

/**
 * Classe Objeto euclidiano, classe filha de ObjetoDataSet, onde é implementado o cálculo da distancian euclidiana
 * 
 */
public class ObjetoEuclidiano extends ObjetoDataSet{

	public  ObjetoEuclidiano(){
		super();
	};
	
	/**
	 * Funcao CalcularDistancia
	 * @param objeto do tipo tratamento com o atributo distancia vazio
	 * @return tratamento com a distancia calculada
	 */
	public Tratamento CalcularDistancia(Tratamento tratamento) {
		double distancia = 0;
		double calculo = 0;
		for(int j = 0; j < 100; j ++) {
			for(int i = 0; i < 1000; i ++) {
				calculo = ((tratamento.imagem.get(i) - tratamento.dataset.get(j).getAtributo(i)) * (tratamento.imagem.get(i) - tratamento.dataset.get(j).getAtributo(i)));
				distancia = (double)(distancia + calculo);
			}
			distancia = Math.sqrt(distancia);
			tratamento.dataset.get(j).setDistancia(distancia);
			distancia = 0;
		}
		return tratamento;
	}
}
