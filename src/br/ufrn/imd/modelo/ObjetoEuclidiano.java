package br.ufrn.imd.modelo;

import br.ufrn.imd.modelo.Tratamento;

public class ObjetoEuclidiano extends ObjetoDataSet{

	public  ObjetoEuclidiano(){
		super();
	};
	
	@Override
	public Tratamento CalcularDistancia(Tratamento tratamento) {
		float distancia = 0;
		double calculo = 0;
		for(int j = 0; j < 100; j ++) {
			for(int i = 0; i < 1000; i ++) {
				calculo = ((tratamento.imagem.get(i) - tratamento.dataset.get(j).getAtributo(i)) * (tratamento.imagem.get(i) - tratamento.dataset.get(j).getAtributo(i)));
				distancia = (float)(distancia + calculo);
			}
			tratamento.dataset.get(j).setDistancia(distancia);
		}
		return tratamento;
	}
}
