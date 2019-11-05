package application;
	
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

import br.ufrn.imd.modelo.ObjetoEuclidiano;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.OutputStream;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		HOGDescriptor hog = new HOGDescriptor();
		Mat img = new Mat();
		MatOfFloat features = new MatOfFloat();
		img = Imgcodecs.imread("C:\\Users\\ander\\Downloads\\peixe.jpg", Imgcodecs.IMREAD_GRAYSCALE);
		Imgproc.resize(img, img, new Size(64,128), 0.5, 0.5, Imgproc.INTER_LINEAR);
		hog.compute(img,features);
		List<Float> arrayOfFeatures = features.toList();

		//System.out.print(features.toList()); // mostra a img em float
		
		File dataset = new File("dataset_2019_1.csv");
		List<ObjetoEuclidiano> ListaDeObjetos = new ArrayList<ObjetoEuclidiano>();
		List<Float> listaDeAtributos = new ArrayList<Float>();
		char rotulo = 0;
		String linha = new String(); 
		
		try {
			Scanner leitor = new Scanner(dataset);
			
			int n = 0;
			while(leitor.hasNext()) {
				
				linha = leitor.nextLine();
				String listaDaLinha[] = linha.split(Pattern.quote(","));
				if(n != 0) {
					for(int i = 0; i <= 1000; i ++) {
						if(i == 1000) {
							String r = listaDaLinha[999];
							rotulo = r.charAt(0);
						}else {
							float valor = (float)Float.parseFloat(listaDaLinha[i]);
							System.out.print(valor+"\n"+i+"\n");
							listaDeAtributos.add(valor);
						}
						ObjetoEuclidiano obj = new ObjetoEuclidiano();
						obj.setRotulo(rotulo);
						obj.setAtributos(listaDeAtributos);
						ListaDeObjetos.add(obj);

					}
				}
				n = n + 1;
			}
			leitor.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		launch(args);
	}
}
