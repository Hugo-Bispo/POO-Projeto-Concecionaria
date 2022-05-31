package entity;

import java.time.LocalDate;

public class Venda{
	private int funcional;
	private String placa;
	private LocalDate data_venda;
	public int getFuncional() {
		return funcional;
	}
	public void setFuncional(int funcional) {
		this.funcional = funcional;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public LocalDate getData_venda() {
		return data_venda;
	}
	public void setData_venda(LocalDate data_venda) {
		this.data_venda = data_venda;
	}	
}
