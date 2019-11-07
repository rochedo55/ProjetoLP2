package br.ufrn.imd.controle;

import java.util.ArrayList;
import java.util.List;

import br.ufrn.imd.modelo.ObjetoDataSet;

public interface Knn {
	public String Knn(int knn,ArrayList<ObjetoDataSet> dados,List<Float> att);

}
