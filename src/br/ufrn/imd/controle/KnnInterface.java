package br.ufrn.imd.controle;

import br.ufrn.imd.modelo.Tratamento;
/**
 * Interface em que a classe que calcula o knn deve implementar
 * @author Anderson e Gabriel Rocha
 *
 */
public interface KnnInterface {
	public String KnnFuncao(Tratamento tratamento, int k);
	
}
