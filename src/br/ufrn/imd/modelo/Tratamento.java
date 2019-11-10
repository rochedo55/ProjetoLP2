package br.ufrn.imd.modelo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfFloat;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.HOGDescriptor;
/**
 * Classe que armazena tanto os dados do dataset quanto da imagem processada.
 * @author Anderson e Gabriel Rocha
 *
 */
public class Tratamento {
	/**
	 * {@value #imagem} lista dos atributos da imagem processada
	 * {@value #dataset} lista para armazenar as linhas do dataset logo é uma lista de ObjetoDataSet
	 */
	protected List<Float> imagem;
	protected List<ObjetoDataSet> dataset;
	
	public Tratamento() {
		this.dataset = new ArrayList<ObjetoDataSet>();
	}
	
	public List<Float> getImagem() {
		return imagem;
	}

	public void setImagem(List<Float> imagem) {
		this.imagem = imagem;
	}

	public List<ObjetoDataSet> getDataset() {
		return dataset;
	}
	
	public ObjetoDataSet getDatase(int i) {
		return this.dataset.get(i);
	}

	public void setDataset(List<ObjetoDataSet> dataset) {
		this.dataset = dataset;
	}
	/**
	 * Funcao que processa a imagem fornecida redimensionando ela e transfformando ela numa lista
	 * @param caminho caminho da imagem
	 */
	public void imagem(String caminho) {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		HOGDescriptor hog = new HOGDescriptor();
		Mat img = new Mat();
		MatOfFloat features = new MatOfFloat();
		img = Imgcodecs.imread(caminho, Imgcodecs.IMREAD_GRAYSCALE);
		Imgproc.resize(img, img, new Size(64,128), 0.5, 0.5, Imgproc.INTER_LINEAR);
		hog.compute(img,features);
		this.imagem = features.toList();
	}
	
	/**
	 * Funcao que le o dataset e o armazena na lista de dataset
	 */
	public void dataset() {
		File dataset = new File("dataset_2019_1.csv"); 
		String linha = new String();
		
		try {
			Scanner leitor = new Scanner(dataset);
			linha = leitor.nextLine();  
			while(leitor.hasNext()) {
				linha = leitor.nextLine();
				String listaDaLinha[] = linha.split(Pattern.quote(","));
				ObjetoEuclidiano obj = new ObjetoEuclidiano();
				for(int i = 0; i <= 1000; i ++) {
					if(i == 1000) {
						String r = listaDaLinha[1000];
						obj.setRotulo(r.charAt(0));
					}else {
						float valor = (float)Float.parseFloat(listaDaLinha[i]);
						obj.setAtributo(valor);
					}
				}
				this.dataset.add(obj);
			}
			leitor.close();
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
