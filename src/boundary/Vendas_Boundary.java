package boundary;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Vendas_Boundary extends Application{

	@Override
	public void start(Stage stage) throws Exception {
		BorderPane border_pane = new BorderPane();
		
		GridPane vendas_pane = new GridPane();
		
		Scene snc = new Scene(border_pane, 1280, 720);
		
		stage.setResizable(false);
		stage.setScene(snc);
		stage.show();
		
	}
	
	public static void main (String []args) {
		Application.launch(Vendas_Boundary.class, args);
	}

}
