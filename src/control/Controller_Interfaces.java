package control;

public interface Controller_Interfaces<Classe> {
	public Classe boundaryToEntity();
	public void entityToBoundary(Classe c); 
	public void adicionar();
	public void pesquisar();
}
