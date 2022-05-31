package control;

import java.time.LocalDate;

import dao.DAO_Venda;
import entity.Venda;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class VendasCotroller implements Controller_Interfaces<Venda>{
	DAO_Venda dao = new DAO_Venda();
	
	private StringProperty funcional = new SimpleStringProperty("");
	private StringProperty placa = new SimpleStringProperty("");
	private ObjectProperty<LocalDate> data_venda = new SimpleObjectProperty<LocalDate>();
	private String placaEntity;
	
	public StringProperty funcionalProperty() {
		return funcional;
	}
	
	public StringProperty placaProperty() {
		return placa;
	}
	
	public ObjectProperty<LocalDate> data_vendaObjectProperty(){
		return data_venda;
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
	}

	@Override
	public void pesquisar() {
//		Venda v = dao.consultar(funcional.get());
//		entityToBoundary(v);
		
	}
	
	
}
