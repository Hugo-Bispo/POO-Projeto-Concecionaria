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
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

public class Cadastrar_Carro_Boundary extends Application {
	control.CarroController control_carro = new CarroController();

	private Button btnCriar = new Button("Cadastrar");
	
	private TextField txtPlaca = new TextField();
	private TextField txtValor = new TextField();
	private TextField txtAgencia = new TextField();
	private TextField txtModelo = new TextField();
	private TextField txtVersao = new TextField();
	private TextField txtMarca = new TextField();
	private TextField txtAno = new TextField();
	private TextField txtQuilometragem = new TextField();
	private ComboBox<String> boxCombustivel = new ComboBox<String>(FXCollections.observableArrayList("Gasolina", "Etanol", "Flex", "GNV"));
	private TextField txtCilindrada = new TextField();
	private ComboBox<String> boxCambio = new ComboBox<String>(FXCollections.observableArrayList("Manual", "Automatico", "Automatizado"));
	private TextField txtCor = new TextField();

	public void start(Stage stage) throws Exception {

		BorderPane border_pane = new BorderPane();

//		TilePane Titulo e Button Cadastrar Carro
		TilePane index_pane = new TilePane();
		index_pane.getChildren().addAll(new Label("Cadastro de Veiculo"), btnCriar);
		index_pane.setHgap(100);
		index_pane.setAlignment(Pos.CENTER);
		index_pane.setStyle("-fx-font: 24 arial;-fx-font-weight: bold");
	

//		GridPane Informacao do Carro
		GridPane pane_info_carro = new GridPane();
		
		pane_info_carro.add(new Label("Placa: "), 0, 0);
		pane_info_carro.add(txtPlaca, 1, 0);
		pane_info_carro.add(new Label("Valor: "), 2, 0);
		pane_info_carro.add(txtValor, 3, 0);
		pane_info_carro.add(new Label("Agência: "), 4, 0);
		pane_info_carro.add(txtAgencia, 5, 0);
		pane_info_carro.add(new Label("Modelo: "), 0, 1);
		pane_info_carro.add(txtModelo, 1, 1);
		pane_info_carro.add(new Label("Versão: "), 2, 1);
		pane_info_carro.add(txtVersao, 3, 1);
		pane_info_carro.add(new Label("Marca: "), 4, 1);
		pane_info_carro.add(txtMarca, 5, 1);
		pane_info_carro.add(new Label("Ano: "), 0, 2);
		pane_info_carro.add(txtAno, 1, 2);
		pane_info_carro.add(new Label("Quilometragem: "), 2, 2);
		pane_info_carro.add(txtQuilometragem, 3, 2);
		pane_info_carro.add(new Label("Cilindrada:"), 4, 2);
		pane_info_carro.add(txtCilindrada, 5, 2);
		pane_info_carro.add(new Label("Combustivel: "), 0, 3);
		pane_info_carro.add(boxCombustivel, 1, 3);
		pane_info_carro.add(new Label("Câmbio: "), 2, 3);
		pane_info_carro.add(boxCambio, 3, 3);
		pane_info_carro.add(new Label("Cor: "), 4, 3);
		pane_info_carro.add(txtCor, 5, 3);
		pane_info_carro.setStyle("-fx-font: 18 arial");
		pane_info_carro.setHgap(5);
		pane_info_carro.setVgap(20);
		pane_info_carro.setAlignment(Pos.CENTER);
		
		Bindings.bindBidirectional(txtPlaca.textProperty(), control_carro.placaProperty());
		Bindings.bindBidirectional(txtValor.textProperty(), control_carro.valorProperty());
		Bindings.bindBidirectional(txtAgencia.textProperty(), control_carro.agenciaProperty());
		Bindings.bindBidirectional(txtModelo.textProperty(), control_carro.modeloProperty());
		Bindings.bindBidirectional(txtVersao.textProperty(), control_carro.versaoProperty());
		Bindings.bindBidirectional(txtMarca.textProperty(), control_carro.marcaProperty());
		Bindings.bindBidirectional(txtAno.textProperty(), control_carro.anoProperty());
		Bindings.bindBidirectional(txtQuilometragem.textProperty(), control_carro.quilometragemProperty());
		Bindings.bindBidirectional(txtCilindrada.textProperty(), control_carro.cilindraProperty());
		Bindings.bindBidirectional(boxCombustivel.valueProperty(), control_carro.combustivelProperty());
		Bindings.bindBidirectional(boxCambio.valueProperty(), control_carro.cambioProperty());
		Bindings.bindBidirectional(txtCor.textProperty(), control_carro.corProperty());
		
//		Button Criar Carro
		btnCriar.setOnAction( e -> control_carro.adicionar());
		btnCriar.setStyle("-fx-font: 24 arial;-fx-font-weight: bold");
		btnCriar.setAlignment(Pos.BOTTOM_RIGHT);
		
		
		border_pane.setTop(index_pane);
		border_pane.setCenter(pane_info_carro);
		
		Scene snc = new Scene(border_pane, 1280, 400);
		
		stage.setResizable(false);
		stage.setScene(snc);
		stage.show();
	}
}
