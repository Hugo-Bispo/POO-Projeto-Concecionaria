package boundary;

import control.FotosControll;
import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Painel_Fotos extends Application {
	
	private static int counter = 0;
	control.FotosControll controle_fotos = new FotosControll();
	private ImageView iv;
    private Image[] images;
    String caminho_fotos[];
	
    public void start(Stage stage) throws Exception {

		BorderPane pane = new BorderPane();
		Button buttom_proximo = new Button(">");
		Button buttom_anterior = new Button("<");
		
		buttom_proximo.setPrefSize(100,100);
		buttom_anterior.setPrefSize(100,100);
		
 		caminho_fotos = controle_fotos.get_urls_fotos();
		images = new Image[caminho_fotos.length];
		
		
        for(int i=0; i< caminho_fotos.length; i++) {
        	System.out.println(caminho_fotos[i]);
            images[i] = new Image(getClass().getResourceAsStream(caminho_fotos[i]));
        }	
		
        iv = new ImageView(images[counter++]);
        
		buttom_proximo.setOnAction((e) -> {
			swapImage(true);
		});
		
		buttom_anterior.setOnAction((e) -> {
			swapImage(false);
		});
		
        iv.setFitWidth(500);
        iv.setPreserveRatio(true);
        iv.setSmooth(true);
        iv.setCache(true);
        
		pane.setCenter(iv);
		pane.setRight(buttom_proximo);
		pane.setLeft(buttom_anterior);
		
		Scene snc = new Scene(pane);
		
		stage.setScene(snc);
		stage.sizeToScene();
		
		
		stage.show();
	}
	
    private void swapImage(Boolean b) {
    	if(b == true) {
    		counter++;
    		if(counter >= caminho_fotos.length) {
    			counter = 0;
    		}else {
    			
    		}
    		
    	}else if(b == false) {
    		counter--;
    		if(counter < 0) {
    			counter = caminho_fotos.length - 1;
    		}else {
    			
    		}
    	}
		iv.setImage(images[counter]);
    	System.out.println(counter);
    }

	public static void main(String[] args) {
		
		Application.launch(Painel_Fotos.class, args);
	}

}
