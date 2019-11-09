package br.ufrn.imd.controle;

import java.util.ArrayList;

import br.ufrn.imd.modelo.ObjetoDataSet;
import br.ufrn.imd.modelo.ObjetoEuclidiano;
import br.ufrn.imd.modelo.Tratamento;

public class KnnTeste {
	public String Ordenar (Tratamento tratamento, int k) {
		double menor = 100.0;
		int id = 0;
		ArrayList<ObjetoDataSet> listObj = new ArrayList<ObjetoDataSet>();

		for(int i = 0; i < k; i ++) {
			
			for(int j = 0; j < 100; j ++) {
				if(tratamento.getDataset().get(j).getDistancia() < menor ) {
					menor = tratamento.getDataset().get(j).getDistancia();
					id = j;
					//System.out.print(j+" "+tratamento.getDataset().get(j).getRotulo()+"   "+tratamento.getDataset().get(j).getDistancia()+"\n");
				}
				//System.out.print( j+" " +tratamento.getDataset().get(j).getRotulo()+"   "+tratamento.getDataset().get(j).getDistancia()+"\n");
			}
			ObjetoEuclidiano teste = new ObjetoEuclidiano();
			teste.setDistancia(tratamento.getDataset().get(id).getDistancia()); 
			teste.setRotulo(tratamento.getDataset().get(id).getRotulo()); 
			listObj.add(teste);
			tratamento.getDataset().get(id).setDistancia(1000.0);
			id = 0;
			menor = 100.0;
		}
//		for(int j = 0; j < k; j ++) {
//			System.out.print(listObj.get(j).getRotulo()+"   "+listObj.get(j).getDistancia()+"\n");
//		}
		return knn(listObj, k);
	}
	
	public String knn(ArrayList<ObjetoDataSet> listObj, int k) {
		int pessoa = 0;
		for (int i =0; i < k; i++) {
			Character r =  listObj.get(i).getRotulo();
			if(r.equals('p')) {
				pessoa = pessoa + 1;	
			}
		}
		int naoPessoa = k - pessoa;
		if(naoPessoa == pessoa) {
			return "Tem pessoa! \n";
		}else {
			if(naoPessoa < pessoa) {
				return "Tem pessoa! \n";
			}else {
				return "Não tem pessoa! \n";
			}
		}
	}
}
