package control;

import entity.Carro;

public class FotosControll {	
	public String[] get_urls_fotos() {
		Carro carro = new Carro();
		String fotos_carro[] = carro.getFotos_carro();
		return fotos_carro;
	}
}
