package br.ufrn.imd.controle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import br.ufrn.imd.modelo.Tratamento;
import br.ufrn.imd.modelo.Tupla;

/**
 * Classe alternativa para ordenacao das distancias usando tuplas
 * @author Anderson e Gabriel Rocha
 *
 */
public class Knn implements KnnInterface {
//List<Tupla<Integer, Double, Character>> tuples = new ArrayList<Tupla<Integer, Double, Character>>();
	@Override
	public String KnnFuncao(Tratamento tratamento, int k) {
		List<Tupla<Integer, Double, Character>> tuplas = new ArrayList<Tupla<Integer, Double, Character>>();
		//ArrayList<ObjetoDataSet> a = new ArrayList<ObjetoDataSet>();
		for(int i = 0; i<100; i++ ) {
			tuplas.add(new Tupla<Integer, Double, Character>(i, tratamento.getDataset().get(i).getDistancia(),tratamento.getDataset().get(i).getRotulo()));
		}
		comparar(tuplas);
		int np = 0;
		int p = 0;
		
		for (int j =0; j<k;j++) {
			if( tuplas.get(j).getZ().equals('n')) {
				np ++;				
			}else {
				p ++;
			}
		}
		
		if(np>p) {
			return "Não tem pessoa!";
		}else {
			return "Tem pessoa!";
		}
		
		
	}
	
	public void comparar(List<Tupla<Integer, Double, Character>> tupla) {
		Comparator<Tupla<Integer, Double, Character>> comparator = new Comparator<Tupla<Integer, Double, Character>>() {
			@Override
			public int compare(Tupla<Integer, Double, Character> cmp1, Tupla<Integer, Double, Character> cmp2) {
				// TODO Auto-generated method stub
				return cmp1.getY().compareTo(cmp2.getY());
			}

	    };

	    Collections.sort(tupla, comparator);
	}

}
