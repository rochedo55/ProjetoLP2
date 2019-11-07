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

public class Tratamento {

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

	public void setDataset(List<ObjetoDataSet> dataset) {
		this.dataset = dataset;
	}
	
	public void imagem(String caminho) {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		HOGDescriptor hog = new HOGDescriptor();
		Mat img = new Mat();
		MatOfFloat features = new MatOfFloat();
		// ------------------------------------------------------------>   Verificar o caminho se não ta vazio e verificar a extenção
		img = Imgcodecs.imread(caminho, Imgcodecs.IMREAD_GRAYSCALE);
		Imgproc.resize(img, img, new Size(64,128), 0.5, 0.5, Imgproc.INTER_LINEAR);
		hog.compute(img,features);
		this.imagem = features.toList();
		//pegar1000atributosimg();
		
		// ------------------------------------------------------------>   Criar uma função pra pegar só os 1000 primeiros atributos
	}
	
	public void dataset() {
		File dataset = new File("dataset_2019_1.csv"); //Pega o data set (caminho) não precisa de verificação pq ta na pasta do projeto
		String linha = new String(); // cria uma string pra ler linha por linha
		
		try {// ---------------------------------------------> OBRIGATÓRIO - ve se da pra ler o arquivo (se ele existe)
			Scanner leitor = new Scanner(dataset);
			linha = leitor.nextLine();  // ---------------------------------> só pra n pegar a primeira linha
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/*public void pegar1000atributosimg() {
		for ()
		for
		0 1000
		this.imagem;
	}*/
}
