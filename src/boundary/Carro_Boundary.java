package boundary;

import control.CarroController;
import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.converter.NumberStringConverter;

public class Carro_Boundary extends Application {
	control.CarroController control_carro = new CarroController();

	private Button btnPesquisar = new Button("Pesquisar");
	private Button btnCriar = new Button("Criar");
	
	private TextField txtPlaca = new TextField();
	private TextField txtModelo = new TextField();
	private TextField txtVersao = new TextField();
	private TextField txtMarca = new TextField();
	private TextField txtAno = new TextField();
	private TextField txtQuilometragem = new TextField();
//	private String Tipo_Combusivel[] = { "Gasolina", "Etanol", "Flex", "GNV" };
	private ComboBox<String> boxCombustivel = new ComboBox<String>(FXCollections.observableArrayList("Gasolina", "Etanol", "Flex", "GNV"));
	private TextField txtCilindrada = new TextField();
	private ComboBox<String> boxCambio = new ComboBox<String>(FXCollections.observableArrayList("Manual", "Automatico", "Automatizado"));
	private TextField txtCor = new TextField();

	public void start(Stage stage) throws Exception {

		BackgroundImage background = new BackgroundImage(new Image(getClass().getResourceAsStream("backgound.jpg")),
				BackgroundRepeat.NO_REPEAT, 
				BackgroundRepeat.NO_REPEAT, 
				BackgroundPosition.CENTER,
				BackgroundSize.DEFAULT);

		BorderPane border_pane = new BorderPane();
		BorderPane border_pane_indice = new BorderPane();

		GridPane pane_pesquisar = new GridPane();
		GridPane pane_info_carro = new GridPane();

		Text Text_Placa = new Text("Placa do Carro:");

		pane_pesquisar.add(Text_Placa, 0, 0);
		pane_pesquisar.add(txtPlaca, 2, 0);
		pane_pesquisar.add(btnPesquisar, 3, 0);
		pane_pesquisar.add(btnCriar, 4, 0);
		pane_pesquisar.setHgap(5);
		pane_pesquisar.setMinSize(200, 200);
		pane_pesquisar.setAlignment(Pos.CENTER);

		border_pane_indice.setCenter(pane_pesquisar);
		border_pane_indice.setStyle("-fx-font: 20 arial;-fx-font-weight: bold");
		
		pane_info_carro.add(new Label("Modelo: "), 0, 0);
		pane_info_carro.add(txtModelo, 1, 0);
		pane_info_carro.add(new Label("Versão: "), 2, 0);
		pane_info_carro.add(txtVersao, 3, 0);
		pane_info_carro.add(new Label("Marca: "), 4, 0);
		pane_info_carro.add(txtMarca, 5, 0);
		pane_info_carro.add(new Label("Ano: "), 0, 1);
		pane_info_carro.add(txtAno, 1, 1);
		pane_info_carro.add(new Label("Quilometragem: "), 2, 1);
		pane_info_carro.add(txtQuilometragem, 3, 1);
		pane_info_carro.add(new Label("Cilindrada:"), 4, 1);
		pane_info_carro.add(txtCilindrada, 5, 1);
		pane_info_carro.add(new Label("Combustivel: "), 0, 2);
		pane_info_carro.add(boxCombustivel, 1, 2);
		pane_info_carro.add(new Label("Câmbio: "), 2, 2);
		pane_info_carro.add(boxCambio, 3, 2);
		pane_info_carro.add(new Label("Cor: "), 4, 2);
		pane_info_carro.add(txtCor, 5, 2);
		pane_info_carro.setStyle("-fx-font: 18 arial;-fx-font-weight: bold");
		pane_info_carro.setHgap(5);
		pane_info_carro.setVgap(20);
		pane_info_carro.setAlignment(Pos.CENTER);
		
		Bindings.bindBidirectional(txtPlaca.textProperty(), control_carro.placaProperty());
		Bindings.bindBidirectional(txtModelo.textProperty(), control_carro.modeloProperty());
		Bindings.bindBidirectional(txtVersao.textProperty(), control_carro.versaoProperty());
		Bindings.bindBidirectional(txtMarca.textProperty(), control_carro.marcaProperty());
		Bindings.bindBidirectional(txtAno.textProperty(), control_carro.anoProperty());
		Bindings.bindBidirectional(txtQuilometragem.textProperty(), control_carro.quilometragemProperty());
		Bindings.bindBidirectional(txtCilindrada.textProperty(), control_carro.cilindraProperty());
		Bindings.bindBidirectional(boxCombustivel.valueProperty(), control_carro.combustivelProperty());
		Bindings.bindBidirectional(boxCambio.valueProperty(), control_carro.cambioProperty());
		Bindings.bindBidirectional(txtCor.textProperty(), control_carro.corProperty());
		
		btnCriar.setOnAction( e -> control_carro.adicionar());
		
		btnPesquisar.setOnAction( e -> control_carro.pesquisar());

//		border_pane_indice.setAlignment(pane_pesquisar, Pos.CENTER);
		border_pane.setTop(border_pane_indice);
		border_pane.setCenter(pane_info_carro);
//		border_pane.setCenter(pane_func);
		border_pane.setStyle("-fx-text-fill: white");
//		border_pane.setBackground(new Background(background));
		Scene snc = new Scene(border_pane, 1280, 720);
		
		stage.setResizable(false);
		stage.setScene(snc);
		stage.show();
	}

	public static void main(String[] args) {
		Application.launch(Carro_Boundary.class, args);
	}

}
