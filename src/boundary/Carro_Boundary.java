package boundary;

import control.CarroController;
import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
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
import javafx.scene.layout.TilePane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.converter.NumberStringConverter;

public class Carro_Boundary extends Application {
	control.CarroController control_carro = new CarroController();

	private TextField txtPlaca = new TextField();
	private Button btnPesquisar = new Button("Pesquisar");
	private Button btnCriar = new Button("Criar");

	private TextField txtValor = new TextField();
	private TextField txtEstado = new TextField();

	private Text textValor = new Text();
	private Text textDisponibilidade = new Text();
	private Text textAgencia = new Text();
	private Text textModelo = new Text();
	private Text textVersao = new Text();
	private Text textMarca = new Text();
	private Text textAno = new Text();
	private Text textQuilometragem = new Text();
	private Text textCombustivel = new Text();
	private Text textCilindrada = new Text();
	private Text textCambio = new Text();
	private Text textCor = new Text();

	public void start(Stage stage) throws Exception {

		BackgroundImage background = new BackgroundImage(new Image(getClass().getResourceAsStream("backgound.jpg")),
				BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
				BackgroundSize.DEFAULT);

		BorderPane border_pane = new BorderPane();
//		BorderPane border_pane_indice = new BorderPane();

//		GridPane Pesquisar-Criar Carro
		GridPane pane_pesquisar = new GridPane();
		Text Text_Placa = new Text("Placa do Carro:");

		pane_pesquisar.add(Text_Placa, 0, 0);
		pane_pesquisar.add(txtPlaca, 2, 0);
		pane_pesquisar.add(btnPesquisar, 3, 0);
		pane_pesquisar.add(btnCriar, 4, 0);
		pane_pesquisar.setHgap(5);
		pane_pesquisar.setMinSize(200, 200);
		pane_pesquisar.setAlignment(Pos.CENTER);
//		border_pane_indice.setCenter(pane_pesquisar);
		pane_pesquisar.setStyle("-fx-font: 20 arial;-fx-font-weight: bold");

		Bindings.bindBidirectional(txtPlaca.textProperty(), control_carro.placaProperty());

		btnCriar.setOnAction(e -> cadastrar_carro());
		btnPesquisar.setOnAction(e -> control_carro.pesquisar());

//		GridPane Situacao do Carro
		GridPane situacao_pane = new GridPane();
		situacao_pane.add(new Label("Valor: "), 0, 0);
		situacao_pane.add(txtValor, 1, 0);
		situacao_pane.add(new Label("Estado: "), 0, 1);
		situacao_pane.add(txtEstado, 1, 1);
		situacao_pane.setAlignment(Pos.CENTER);
		situacao_pane.setStyle("-fx-font: 20 arial;-fx-font-weight: bold");

		GridPane paneModelo = new GridPane();
		paneModelo = TextStyle("Modelo:", textModelo);

		GridPane paneVersao = new GridPane();
		paneVersao.add(new Label("Versão:"), 0, 0);
		paneVersao.add(textVersao, 1, 0);

		GridPane paneMarca = new GridPane();
		paneMarca.add(new Label("Marca:"), 0, 0);
		paneMarca.add(textMarca, 1, 0);

		GridPane paneValor = new GridPane();
		paneValor.add(new Label("Valor:"), 0, 0);
		paneValor.add(textValor, 1, 0);

		GridPane paneDisponibilidade = new GridPane();
		paneDisponibilidade.add(new Label("Disponiblidade:"), 0, 0);
		paneDisponibilidade.add(textDisponibilidade, 1, 0);

		GridPane paneAgencia = new GridPane();
		paneAgencia.add(new Label("Agência:"), 0, 0);
		paneAgencia.add(textAgencia, 1, 0);

		GridPane paneAno = new GridPane();
		paneAno.add(new Label("Ano:"), 0, 0);
		paneAno.add(textAno, 1, 0);

		GridPane paneQuilometragem = new GridPane();
		paneQuilometragem.add(new Label("Quilometragem:"), 0, 0);
		paneQuilometragem.add(textQuilometragem, 1, 0);

		GridPane paneCilindrada = new GridPane();
		paneCilindrada.add(new Label("Cilindrada:"), 0, 0);
		paneCilindrada.add(textCilindrada, 1, 0);

		GridPane paneCombustivel = new GridPane();
		paneCombustivel.add(new Label("Combustivel:"), 0, 0);
		paneCombustivel.add(textCombustivel, 1, 0);

		GridPane paneCambio = new GridPane();
		paneCambio.add(new Label("Câmbio:"), 0, 0);
		paneCambio.add(textCambio, 1, 0);

		GridPane paneCor = new GridPane();
		paneCor.add(new Label("Cor:"), 0, 0);
		paneCor.add(textCor, 1, 0);

//		GridPane Informacao do Carro
		GridPane pane_info_carro = new GridPane();

//		pane_info_carro.add(new Label("Modelo: "), 0, 0);
//		pane_info_carro.add(textModelo, 1, 0);
		pane_info_carro.add(paneModelo, 0, 0);
		pane_info_carro.add(paneVersao, 1, 0);
		pane_info_carro.add(paneMarca, 2, 0);
		pane_info_carro.add(paneValor, 0, 1);
		pane_info_carro.add(paneDisponibilidade, 1, 1);
		pane_info_carro.add(paneAgencia, 2, 1);
		pane_info_carro.add(paneAno, 0, 2);
		pane_info_carro.add(paneQuilometragem, 1, 2);
		pane_info_carro.add(paneCilindrada, 2, 2);
		pane_info_carro.add(paneCombustivel, 0, 3);
		pane_info_carro.add(paneCambio, 1, 3);
		pane_info_carro.add(paneCor, 2, 3);
		pane_info_carro.setStyle("-fx-font: 20 arial;-fx-font-weight: bold");
		pane_info_carro.setHgap(200);
		pane_info_carro.setVgap(20);

		pane_info_carro.setMinSize(1100, 500);
		pane_info_carro.setMaxSize(1100, 500);
		pane_info_carro.setAlignment(Pos.CENTER);

		Bindings.bindBidirectional(textModelo.textProperty(), control_carro.modeloProperty());
		Bindings.bindBidirectional(textVersao.textProperty(), control_carro.versaoProperty());
		Bindings.bindBidirectional(textMarca.textProperty(), control_carro.marcaProperty());

		Bindings.bindBidirectional(textValor.textProperty(), control_carro.valorProperty());
		Bindings.bindBidirectional(textDisponibilidade.textProperty(), control_carro.situacaoProperty());
		Bindings.bindBidirectional(textAgencia.textProperty(), control_carro.agenciaProperty());

		Bindings.bindBidirectional(textAno.textProperty(), control_carro.anoProperty());
		Bindings.bindBidirectional(textQuilometragem.textProperty(), control_carro.quilometragemProperty());
		Bindings.bindBidirectional(textCilindrada.textProperty(), control_carro.cilindraProperty());

		Bindings.bindBidirectional(textCombustivel.textProperty(), control_carro.combustivelProperty());
		Bindings.bindBidirectional(textCambio.textProperty(), control_carro.cambioProperty());
		Bindings.bindBidirectional(textCor.textProperty(), control_carro.corProperty());

		border_pane.setTop(pane_pesquisar);
//		border_pane.setCenter(situacao_pane);
		border_pane.setCenter(pane_info_carro);
//		border_pane.setBottom(pane_info_carro);
//		border_pane.setBackground(new Background(background));
		Scene snc = new Scene(border_pane, 1280, 720);

		stage.setResizable(false);
		stage.setScene(snc);
		stage.show();
	}

	public GridPane TextStyle(String textIndice, Text textButton) {
		GridPane paneStyle = new GridPane();
		paneStyle.add(new Label(textIndice), 0, 0);
		paneStyle.add(textButton, 1, 0);
		paneStyle.setMinSize(300, 50);
		paneStyle.setMaxSize(300, 50);
		paneStyle.setAlignment(Pos.CENTER_LEFT);
		paneStyle.setStyle("-fx-background-radius: 300px;"
					+ 	"-fx-border-radius: 300px;\r\n" + "    -fx-border-width: 5px;\r\n"
				+ "    -fx-border-color: black;");

		return paneStyle;
	}

	public void cadastrar_carro() {
		Cadastrar_Carro_Boundary carro = new Cadastrar_Carro_Boundary();
		try {
			carro.start(new Stage());
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Application.launch(Carro_Boundary.class, args);
	}

}
