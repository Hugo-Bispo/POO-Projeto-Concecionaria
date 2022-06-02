package boundary;

import control.VendasCotroller;
import control.VendedorController;
import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class SubBoundary_Vendedor extends Application {
	VendedorController controlVendedor = new VendedorController();
	VendasCotroller controlVenda = new VendasCotroller();

	private Button btnCriar = new Button("Criar");
	private TextField txtFuncionalVendedor = new TextField();
	private TextField txtNome = new TextField();
	private TextField txtTelefone = new TextField();
	private Button btnPesquisar = new Button("Pesquisar");
	
	public void start(Stage stage) throws Exception {		
		BorderPane tela_pane = new BorderPane();

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
		vendedor_pane.setStyle("-fx-font: 20 arial;-fx-font-weight: bold");
		vendedor_pane.setAlignment(Pos.CENTER);
		
		tela_pane.setCenter(vendedor_pane);
		
		Bindings.bindBidirectional(txtFuncionalVendedor.textProperty(), controlVendedor.funcionalProperty());
		Bindings.bindBidirectional(txtNome.textProperty(), controlVendedor.nomeProperty());
		Bindings.bindBidirectional(txtTelefone.textProperty(), controlVendedor.telefoneProperty());
		
		btnCriar.setOnAction( e -> controlVendedor.adicionar());
		btnPesquisar.setOnAction( e -> controlVendedor.pesquisar());
		
		Scene snc = new Scene(tela_pane,500,300);
		
		stage.setTitle("Cadastro de Vendedor");
		stage.setResizable(false);
		stage.setScene(snc);
		stage.show();

	}
}
