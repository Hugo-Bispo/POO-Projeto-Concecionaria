package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.Carro;

public class CarroDAOImpl implements InterfaceCarroDAO {
    private final static String JDBC_CLASS = "org.mariadb.jdbc.Driver";
    private static final String JDBC_URL = "jdbc:mariadb://localhost:3306/concessionaria_poo?allowMultiQueries=true";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASS = "";
    private Connection con;

    public CarroDAOImpl() {
        try {
            Class.forName(JDBC_CLASS);
            con = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASS);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void inserir(Carro c) {
        String sql = "INSERT INTO carro (placa, modelo, versao, marca, ano, quilometragem, cilindrada, combustivel, cambio, cor) ";
        sql += " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
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
    
    public Carro consultar_total(String placa) {
    	Carro c = new Carro();
        String sql = "SELECT * FROM carro WHERE placa ='" + placa +"'";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
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
