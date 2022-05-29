package dao;

import entity.Carro;

public interface InterfaceCarroDAO {
    void inserir(Carro c);
    public Carro consultar_total(String placa);
}
