package entity;

import java.time.LocalDate;

public class CarroVenda extends Carro {

	private int funcional;
	private LocalDate data_venda;
	
	public int getFuncional() {
		return funcional;
	}
	public void setFuncional(int funcional) {
		this.funcional = funcional;
	}
	
	public LocalDate getData_venda() {
		return data_venda;
	}
	public void setData_venda(LocalDate data_venda) {
		this.data_venda = data_venda;
	}
	
	public String toString() {
		return "CarroVenda [funcional=" + funcional + ", data_venda=" + data_venda + "]";
	}
	
	
}
