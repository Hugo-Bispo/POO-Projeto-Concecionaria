package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.Carro;

public class DAO_Carro extends Connector_DB implements DAO_Interface<Carro> {

    public void inserir(Carro c) {
        String sql = "INSERT INTO carro (placa, modelo, versao, marca, ano, quilometragem, cilindrada, combustivel, cambio, cor) ";
        sql += " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement stmt = getCon().prepareStatement(sql);
            stmt.setString(1, c.getPlaca());
            stmt.setString(2, c.getModelo());
            stmt.setString(3, c.getVersao());
            stmt.setString(4, c.getMarca());
            stmt.setInt(5, c.getAno());
            stmt.setDouble(6, c.getQuilometragem());
            stmt.setDouble(7, c.getCilindrada());
            stmt.setString(8, c.getCombustivel());
            stmt.setString(9, c.getCambio());
            stmt.setString(10, c.getCor());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public Carro consultar(String placa) {
    	Carro c = new Carro();
        String sql = "SELECT * FROM carro WHERE placa ='" + placa +"'";
        try {
            PreparedStatement stmt = getCon().prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            rs.first();
                c.setPlaca(rs.getString("placa"));
                c.setModelo(rs.getString("modelo"));
                c.setVersao(rs.getString("versao"));
                c.setMarca(rs.getString("marca"));
                c.setAno(rs.getInt("ano"));
                c.setQuilometragem(rs.getDouble("quilometragem"));
                c.setCilindrada(rs.getDouble("cilindrada"));
                c.setCombustivel(rs.getString("combustivel"));
                c.setCambio(rs.getString("cambio"));
                c.setCor(rs.getString("cor"));
        } catch (SQLException e) {
            e.printStackTrace();
            c = null;
        }
        return c;
    }
}
