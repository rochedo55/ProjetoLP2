package br.ufrn.imd.controle;

import java.util.ArrayList;

import br.ufrn.imd.modelo.ObjetoDataSet;
import br.ufrn.imd.modelo.ObjetoEuclidiano;
import br.ufrn.imd.modelo.Tratamento;

/**
 * Classe alternativa que ordena as distancias a partir do k fornecido
 * @author Anderson Gabriel Rocha
 *
 */
public class KnnTeste {
	/**
	 * funcao que ordena para as k distancias mais proximas
	 * @param tratamento
	 * @param k
	 * @return
	 */
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
	/**
	 * funcao que verifica o ArrayList das distancias ordenadas
	 * @param listObj lista ordenada das distancias
	 * @param k knn da interface
	 * @return retorna o rotulo mais frequente e o resultado sai no label da interface
	 */
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
