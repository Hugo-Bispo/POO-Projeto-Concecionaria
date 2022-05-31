package boundary;

import control.VendasCotroller;
import control.VendedorController;
import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Vendas_Boundary extends Application {
	VendedorController controlVendedor = new VendedorController();
	VendasCotroller controlVenda = new VendasCotroller();

	private Button btnCriar = new Button("Criar");
	private Button btnVender = new Button("Vender");
	private TextField txtFuncionalVendas = new TextField();
	private TextField txtFuncionalVendedor = new TextField();
	private TextField txtNome = new TextField();
	private TextField txtTelefone = new TextField();
	private DatePicker calendarDataVenda = new DatePicker();
	private TextField txtPlaca = new TextField();
	
	private TextField txtProcurarCarro = new TextField();
	private TextField txtProcurarFuncional = new TextField();
	
	private Button btnPesquisar = new Button("Pesquisar");
	private Button btnPesquisarFuncional = new Button("Pesquisar");
	private Button btnPesquisarCarro = new Button("Pesquisar");	
	
	public void start(Stage stage) throws Exception {
		BorderPane border_pane = new BorderPane();

//		Gridpane para Cadastrar Vendedor
		GridPane vendedor_pane = new GridPane();
		vendedor_pane.add(new Text("Cadastrar Vendedor"), 0, 0);
		vendedor_pane.add(new Label("Funcional:"), 0, 1);
		vendedor_pane.add(txtFuncionalVendedor, 1, 1);
		vendedor_pane.add(new Label("Nome:"), 0, 2);
		vendedor_pane.add(txtNome, 1, 2);
		vendedor_pane.add(new Label("Telefone:"), 0, 3);
		vendedor_pane.add(txtTelefone, 1, 3);
		vendedor_pane.add(btnCriar, 0, 4);
		vendedor_pane.add(btnPesquisar, 1, 4);
		vendedor_pane.setHgap(5);
		vendedor_pane.setVgap(10);
		
		Bindings.bindBidirectional(txtFuncionalVendedor.textProperty(), controlVendedor.funcionalProperty());
		Bindings.bindBidirectional(txtNome.textProperty(), controlVendedor.nomeProperty());
		Bindings.bindBidirectional(txtTelefone.textProperty(), controlVendedor.telefoneProperty());
		
		btnCriar.setOnAction( e -> controlVendedor.adicionar());
		btnPesquisar.setOnAction( e -> controlVendedor.pesquisar());
		
//		Gridpane para Cadastrar Venda de carro
		GridPane vendas_pane = new GridPane();
		vendas_pane.add(new Text("Cadastrar Venda"), 0, 0);
		vendas_pane.add(new Label("Funcional:"), 0, 1);
		vendas_pane.add(txtFuncionalVendas, 1, 1);
		vendas_pane.add(new Label("Placa Carro:"), 0, 2);
		vendas_pane.add(txtPlaca, 1, 2);
		vendas_pane.add(new Label("Data venda:"), 0, 3);
		vendas_pane.add(calendarDataVenda, 1, 3);
		vendas_pane.add(btnVender, 0, 4);
		vendas_pane.setHgap(5);
		vendas_pane.setVgap(10);
		Bindings.bindBidirectional(txtFuncionalVendas.textProperty(), controlVenda.funcionalProperty());
		Bindings.bindBidirectional(txtPlaca.textProperty(), controlVenda.placaProperty());
		Bindings.bindBidirectional(calendarDataVenda.valueProperty(), controlVenda.data_vendaObjectProperty());
		
		btnVender.setOnAction( e -> controlVenda.adicionar());
		
//		Gridpane Uniao Vendedor e Carros
		GridPane vendas_vendedor_pane = new GridPane();
		vendas_vendedor_pane.add(vendedor_pane, 0, 0);
		vendas_vendedor_pane.add(vendas_pane, 1, 0);
		vendas_vendedor_pane.setAlignment(Pos.TOP_CENTER);
		vendas_vendedor_pane.setHgap(50);
		vendas_vendedor_pane.setStyle("-fx-font: 24 arial;-fx-font-weight: bold");

		border_pane.setTop(vendas_vendedor_pane);
		
//		GridPane Botões Pesquisa
		GridPane consulta_pane = new GridPane();
		consulta_pane.add(new Label("Pesquisar Vendedor"), 0, 0);
		consulta_pane.add(txtProcurarFuncional, 1, 0);
		consulta_pane.add(btnPesquisarFuncional, 2, 0);
		consulta_pane.add(new Label("Pesquisar Carro"), 0, 1);
		consulta_pane.add(txtProcurarCarro, 1, 1);
		consulta_pane.add(btnPesquisarCarro, 2, 1);
		consulta_pane.setAlignment(Pos.CENTER);
		consulta_pane.setHgap(20);
		consulta_pane.setVgap(5);
		consulta_pane.setStyle("-fx-font: 20 arial;-fx-font-weight: bold");
		
		
		border_pane.setCenter(consulta_pane);
		
		Scene snc = new Scene(border_pane, 1280, 720);

		stage.setResizable(false);
		stage.setScene(snc);
		stage.show();

	}

	public static void main(String[] args) {
		Application.launch(Vendas_Boundary.class, args);
	}

}
