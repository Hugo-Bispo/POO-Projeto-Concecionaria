package boundary;

import control.VendasCotroller;
import control.VendedorController;
import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

public class Vendas_Boundary extends Application {
	VendedorController controlVendedor = new VendedorController();
	VendasCotroller controlVenda = new VendasCotroller();

	private Button btnNovoFuncionario = new Button("Criar Funcionario");
	private Button btnVender = new Button("Vender");

	private TextField txtFuncionalVendas = new TextField();
	private TextField txtPlaca = new TextField();
	private TextField txtValuePesquisa = new TextField();

	private DatePicker calendarDataVenda = new DatePicker();

	private ComboBox<String> boxTypePesquisa = new ComboBox<String>(
			FXCollections.observableArrayList("Cod� Vendedor", "Modelo", "Placa", "Data"));

	private Button btnPesquisar = new Button("Pesquisar");

	public void start(Stage stage) throws Exception {
		BorderPane border_pane = new BorderPane();
		
//		TilePane Titulo e Button Cadastrar Cliente
		TilePane index_pane = new TilePane();
		index_pane.getChildren().addAll(new Label("Cadastro de Vendas"), btnNovoFuncionario);
		index_pane.setHgap(100);
		index_pane.setAlignment(Pos.CENTER);
		index_pane.setStyle("-fx-font: 24 arial;-fx-font-weight: bold");
		
		btnNovoFuncionario.setOnAction(e -> cadastrar_vendedor());

//		Gridpane para Cadastrar Venda de carro
		GridPane vendas_pane = new GridPane();
		vendas_pane.add(new Label("Cod� Funcionario:"), 0, 0);
		vendas_pane.add(txtFuncionalVendas, 1, 0);
		vendas_pane.add(new Label("Placa Carro:"), 0, 1);
		vendas_pane.add(txtPlaca, 1, 1);
		vendas_pane.add(new Label("Data venda:"), 0, 2);
		vendas_pane.add(calendarDataVenda, 1, 2);
		vendas_pane.add(btnVender, 1, 3);
		vendas_pane.setHgap(5);
		vendas_pane.setVgap(10);
		vendas_pane.setStyle("-fx-font: 18 arial;-fx-font-weight: bold");

		Bindings.bindBidirectional(txtFuncionalVendas.textProperty(), controlVenda.funcionalProperty());
		Bindings.bindBidirectional(txtPlaca.textProperty(), controlVenda.placaProperty());
		Bindings.bindBidirectional(calendarDataVenda.valueProperty(), controlVenda.data_vendaObjectProperty());

		btnVender.setOnAction(e -> controlVenda.adicionar());

		border_pane.setTop(vendas_pane);

//		GridPane Bot�es Pesquisa
		GridPane consulta_pane = new GridPane();
		consulta_pane.add(new Label("Pesquisar Vendas por: "), 0, 0);
		consulta_pane.add(boxTypePesquisa, 1, 0);
		consulta_pane.add(new Label("Valor de Pesquisa: "), 0, 1);
		consulta_pane.add(txtValuePesquisa, 1, 1);
		consulta_pane.add(btnPesquisar, 3, 1);
		consulta_pane.setHgap(5);
		consulta_pane.setVgap(10);
		consulta_pane.setStyle("-fx-font: 18 arial;-fx-font-weight: bold");
		
//		Uni�o GridPane Pesquisa e Cadastrar Venda
		GridPane PesquisaCadastra_pane = new GridPane();
		PesquisaCadastra_pane.add(vendas_pane, 0, 0);
		PesquisaCadastra_pane.add(consulta_pane, 1, 0);
		PesquisaCadastra_pane.setAlignment(Pos.CENTER);
		PesquisaCadastra_pane.setHgap(50);
		
		
		
//		BorderPane Definindo Posi�oes
		border_pane.setTop(index_pane);
		border_pane.setCenter(PesquisaCadastra_pane);

		Scene snc = new Scene(border_pane, 1280, 720);

		stage.setResizable(false);
		stage.setScene(snc);
		stage.show();

	}

	public void cadastrar_vendedor() {
		Vendedor_Boundary vendedor = new Vendedor_Boundary();
		try {
			vendedor.start(new Stage());
		} catch (Exception e1) {
			e1.printStackTrace();
		}

	}

	public static void main(String[] args) {
		Application.launch(Vendas_Boundary.class, args);
	}

}
