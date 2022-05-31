package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import entity.Venda;

public class DAO_Venda extends Connector_DB implements DAO_Interface<Venda>{

	@Override
	public void inserir(Venda v) {
		String sql = "INSERT INTO carro_vendedor (funcional, placa, data_venda) ";
		sql += " VALUES (?, ?, ?)";
		
		try {
			PreparedStatement stmt = getCon().prepareStatement(sql);
			stmt.setInt(1, v.getFuncional());
			stmt.setString(2, v.getPlaca());
			stmt.setString(3, (v.getData_venda().toString()));
            stmt.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	public Venda consultar(String id_venda) {
		Venda v = new Venda();
		String sql = "SELECT * FROM carro_vendedor WHERE funcional ='" + id_venda + "'";
        try {
            PreparedStatement stmt = getCon().prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            rs.first();
                v.setFuncional(rs.getInt("funcional"));
                v.setPlaca(rs.getString("placa"));
                v.setData_venda(LocalDate.parse(rs.getString("data_venda")));
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
		return v;
	}
	
	public void alterarCondicao(Venda venda) {
		String sql = "UPDATE carro set situacao='V' where placa= (?)";
		try {
			PreparedStatement stmt = getCon().prepareStatement(sql);
			stmt.setString(1, venda.getPlaca());
            stmt.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
}
