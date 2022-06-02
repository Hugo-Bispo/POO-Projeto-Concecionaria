package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import entity.CarroVenda;
import entity.Venda;

public class DAO_Vendas extends Connector_DB implements DAO_Interface<Venda> {
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

	public List<CarroVenda> consultarVendaFuncional(String funcional) {
		List<CarroVenda> lista = new ArrayList<>();
		String sql = "SELECT v1.funcional, v1.placa, c1.modelo," + "c1.versao, c1. marca, c1.cambio, "
				+ "c1.cor, v1.data_venda, c1.valor, c1.placa as placa_carro from carro_vendedor v1 INNER JOIN "
				+ "carro c1 on v1.funcional= '" + funcional + "' and v1.placa=c1.placa;";
		try {
			PreparedStatement stmt = getCon().prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				CarroVenda carro_venda = new CarroVenda();
				carro_venda.setFuncional(rs.getInt("funcional"));
				carro_venda.setPlaca(rs.getString("placa"));
				carro_venda.setModelo(rs.getString("modelo"));
				carro_venda.setVersao(rs.getString("versao"));
				carro_venda.setMarca(rs.getString("marca"));
				carro_venda.setCambio(rs.getString("cambio"));
				carro_venda.setCor(rs.getString("cor"));
				carro_venda.setData_venda(rs.getDate("data_venda").toLocalDate());
				carro_venda.setValor(rs.getDouble("valor"));
				lista.add(carro_venda);
				lista.toString();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
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
