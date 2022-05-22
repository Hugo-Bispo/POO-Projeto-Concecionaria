package control;

import entity.Carro;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class FotosControll {
	private int indice = 0;
	StringProperty url_foto[] = new SimpleVec();
	
	public StringProperty url_foto() {
		return url_foto;
	}
	
	public Carro boundaryToEntity() {
		Carro carro = new Carro();
		carro.setUrlcaro(get_urlcarro());
		return carro;
	}
	
	public void entityToBoundary(Carro carro) {
		if (carro != null) {
			url_foto.set(get_urlcarro());
		}
	}
	
	private String get_urlcarro() {
		Carro carro = new Carro();
		if (indice == carro.getFotos_carro().length) {
			indice = 0;
		}
		String fotos_carro[] = carro.getFotos_carro();
		String url_foto_carro = fotos_carro[indice];
		indice++;
		System.out.println(url_foto_carro);
		return url_foto_carro;
	}
	
	public void proxima_foto() {
		Carro carro = new Carro();
		entityToBoundary(carro);
	}
}
