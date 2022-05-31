package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.Vendedor;

public class DAO_Vendedor extends Connector_DB implements DAO_Interface<Vendedor> {

	public void inserir(Vendedor v) {
		String sql = "INSERT INTO vendedor (funcional, nome, telefone) ";
		sql += " VALUES (?, ?, ?)";
		try {
			PreparedStatement stmt = getCon().prepareStatement(sql);
			stmt.setInt(1, v.getFuncional());
			stmt.setString(2, v.getNome());
			stmt.setString(3, v.getTelefone());
            stmt.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

	}

	public Vendedor consultar(String funcional) {
		Vendedor v = new Vendedor();
		String sql = "SELECT * FROM vendedor WHERE funcional ='" + funcional + "'";
        try {
            PreparedStatement stmt = getCon().prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            rs.first();
                v.setFuncional(rs.getInt("funcional"));
                v.setNome(rs.getString("nome"));
                v.setTelefone(rs.getString("telefone"));
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
		return v;
	}
}
