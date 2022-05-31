package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.Carro;

public class DAO_Carro extends Connector_DB implements DAO_Interface<Carro> {

	public void inserir(Carro c) {
		String sql = "INSERT INTO carro (placa, modelo, versao, marca, valor, ano, agencia, quilometragem, cilindrada, combustivel, cambio, cor) ";
		sql += " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement stmt = getCon().prepareStatement(sql);
			stmt.setString(1, c.getPlaca());
			stmt.setString(2, c.getModelo());
			stmt.setString(3, c.getVersao());
			stmt.setString(4, c.getMarca());
			stmt.setDouble(5, c.getValor());
			stmt.setInt(6, c.getAno());
			stmt.setString(7, c.getAgencia());
			stmt.setDouble(8, c.getQuilometragem());
			stmt.setDouble(9, c.getCilindrada());
			stmt.setString(10, c.getCombustivel());
			stmt.setString(11, c.getCambio());
			stmt.setString(12, c.getCor());
			stmt.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	public Carro consultar(String placa) {
		Carro c = new Carro();
		String sql = "SELECT * FROM carro WHERE placa ='" + placa + "'";
		try {
			PreparedStatement stmt = getCon().prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			rs.first();
			c.setPlaca(rs.getString("placa"));
			c.setModelo(rs.getString("modelo"));
			c.setVersao(rs.getString("versao"));
			c.setMarca(rs.getString("marca"));
			c.setValor(rs.getDouble("valor"));
			c.setSituacao(rs.getString("situacao"));
			c.setAno(rs.getInt("ano"));
			c.setAgencia(rs.getString("agencia"));
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
