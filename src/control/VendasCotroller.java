package control;

import java.time.LocalDate;
import java.util.List;

import dao.DAO_Vendas;
import entity.CarroVenda;
import entity.Venda;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class VendasCotroller implements Controller_Interfaces<Venda>{
	DAO_Vendas dao = new DAO_Vendas();
	
	private ObservableList<CarroVenda> funcionalvenda = FXCollections.observableArrayList();
	
	private StringProperty funcional = new SimpleStringProperty("");
	private StringProperty placa = new SimpleStringProperty("");
	private ObjectProperty<LocalDate> data_venda = new SimpleObjectProperty<LocalDate>();
	private StringProperty boxPesquisa = new SimpleStringProperty("");
	private StringProperty txtValuePesquisa = new SimpleStringProperty("");
	
	private String placaEntity;
	
	private TableView<CarroVenda> table = new TableView<>();
	
	public StringProperty funcionalProperty() {
		return funcional;
	}
	
	public StringProperty placaProperty() {
		return placa;
	}
	
	public ObjectProperty<LocalDate> data_vendaObjectProperty(){
		return data_venda;
	}
	
	public StringProperty boxPesquisaProperty() {
		return boxPesquisa;
	}
	
	public StringProperty txtValuePesquisaProperty() {
		return txtValuePesquisa;
	}

    @SuppressWarnings("unchecked")
	public VendasCotroller() {
        TableColumn<CarroVenda, String> col1 = new TableColumn<>("Codº Vendedor");
        col1.setCellValueFactory(new PropertyValueFactory<>("funcional"));
        
        TableColumn<CarroVenda, String> col2 = new TableColumn<>("Placa Carro");
        col2.setCellValueFactory(new PropertyValueFactory<>("placa"));
        
        TableColumn<CarroVenda, String> col3 = new TableColumn<>("Modelo");
        col3.setCellValueFactory(new PropertyValueFactory<>("modelo"));
        
        TableColumn<CarroVenda, String> col4 = new TableColumn<>("Versão");
        col4.setCellValueFactory(new PropertyValueFactory<>("versao"));
        
        TableColumn<CarroVenda, String> col5 = new TableColumn<>("Marca");
        col5.setCellValueFactory(new PropertyValueFactory<>("marca"));
        
        TableColumn<CarroVenda, String> col6 = new TableColumn<>("Câmbio");
        col6.setCellValueFactory(new PropertyValueFactory<>("cambio"));
        
        TableColumn<CarroVenda, String> col7 = new TableColumn<>("Cor");
        col7.setCellValueFactory(new PropertyValueFactory<>("cor"));
        
        TableColumn<CarroVenda, String> col8 = new TableColumn<>("Data");
//        col8.setCellValueFactory((itemData)-> {
//            LocalDate dt = itemData.getValue().getData();
//            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//            return new ReadOnlyStringWrapper(dt.format(formatter));
       
        TableColumn<CarroVenda, Double> col9 = new TableColumn<>("Valor");
        col9.setCellValueFactory(new PropertyValueFactory<>("valor"));

        table.getColumns().addAll(col1, col2, col3, col4, col5, col6, col7, col8, col9);
        table.setItems(funcionalvenda);
        table.scrollToColumnIndex(0);
        table.setMinSize(1000, 300);
        table.setMaxSize(1000, 300);
    }
	
	@Override
	public Venda boundaryToEntity() {
		Venda v = new Venda();
		placaEntity = placa.get();
		placaEntity = placaEntity.replace("-", "");
		
		try {
			v.setFuncional(Integer.parseInt(funcional.get()));
		} catch (NumberFormatException e) {
			return null;
		}
		
		if (placaEntity.length() == 7) {
			v.setPlaca(placaEntity);
		} else {
			//Adicionar erro placa
		}
		
		v.setData_venda(data_venda.get());
		return v;
	}

	@Override
	public void entityToBoundary(Venda v) {
		if (v != null) {
			funcional.set(v.getPlaca());
			placa.set(v.getPlaca());
			data_venda.set(v.getData_venda());
		}
		
	}

	@Override
	public void adicionar() {
		Venda v = new Venda();
		v = boundaryToEntity();
		dao.inserir(v);
		dao.alterarCondicao(v);
	}

	@Override
	public void pesquisar() {
		System.out.println("Teste");
		List<CarroVenda> lista = dao.consultarVendaFuncional(txtValuePesquisa.get());
		lista.toString();
		funcionalvenda.clear();
		funcionalvenda.addAll(lista);
		funcionalvenda.toString();
		
	}
	
    public TableView<CarroVenda> getTable() {
        return table;
    }
	
	
}
