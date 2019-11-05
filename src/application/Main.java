package application;
	
import java.util.List;
import java.util.Scanner;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfFloat;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.HOGDescriptor;

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
		System.out.print(img+"\n");
		//System.out.print(features.toList()); // mostra a img em float
		
		File dataset = new File("dataset_2019_1.csv");
		
		try {
			String linhas = new String(); 
			Scanner leitor = new Scanner(dataset);
			
			while(leitor.hasNext()) {
				linhas = leitor.nextLine();
				System.out.print(linhas+"\n");
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		launch(args);
	}
}
