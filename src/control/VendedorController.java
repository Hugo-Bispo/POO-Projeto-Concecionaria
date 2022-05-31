package control;

import dao.DAO_Vendedor;
import entity.Vendedor;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class VendedorController implements Controller_Interfaces<Vendedor> {
	DAO_Vendedor dao = new DAO_Vendedor();
	
	private StringProperty funcional = new SimpleStringProperty("");
	private StringProperty nome = new SimpleStringProperty("");
	private StringProperty telefone = new SimpleStringProperty("");

	public StringProperty funcionalProperty() {
		return funcional;
	}

	public StringProperty nomeProperty() {
		return nome;
	}

	public StringProperty telefoneProperty() {
		return telefone;
	}

	public Vendedor boundaryToEntity() {
		Vendedor v = new Vendedor();
		try {
			v.setFuncional(Integer.parseInt(funcional.get()));
		} catch (NumberFormatException e) {
			return null;
		}
		v.setNome(nome.get());
		v.setTelefone(telefone.get());
		return v;
	}

	public void entityToBoundary(Vendedor v) {
		if (v != null) {
			funcional.set(String.valueOf(v.getFuncional()));
			nome.set(v.getNome());
			telefone.set(v.getTelefone());
		}
	}
	
	public void adicionar() {
		Vendedor v = new Vendedor();
		v = boundaryToEntity();
		dao.inserir(v);
		
	}

	public void pesquisar() {
		System.out.println(funcional.get());
		Vendedor v = dao.consultar(funcional.get());
		entityToBoundary(v);
	}

}
