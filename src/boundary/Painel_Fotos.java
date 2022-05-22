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
	control.FotosControll controle_fotos = new FotosControll();
	private ImageView iv;
    private Image[] images;
	
	@Override
	public void start(Stage stage) throws Exception {

		BorderPane pane = new BorderPane();
		Button buttom_proximo = new Button(">");
		Button buttom_anterior = new Button("<");
		buttom_proximo.setPrefSize(100,100);
		buttom_anterior.setPrefSize(100,100);
		
		
		
		Image img = new Image(getClass().getResourceAsStream("teste.jpg"));
 		String caminho_image = "";
		
//		images = new Image[5];
//		
		
        ImageView iv2 = new ImageView();
        iv2.setImage(img);
        iv2.setFitWidth(500);
        iv2.setPreserveRatio(true);
        iv2.setSmooth(true);
        iv2.setCache(true);
        
		pane.setCenter(iv2);
		pane.setRight(buttom_proximo);
		pane.setLeft(buttom_anterior);
		
		buttom_proximo.setOnAction((e) -> {
			controle_fotos.proxima_foto();
		});
		
		Scene snc = new Scene(pane, 1280, 720 );
		
		stage.setScene(snc);
		stage.show();
	}

	public static void main(String[] args) {
		Application.launch(Painel_Fotos.class, args);
	}

}
