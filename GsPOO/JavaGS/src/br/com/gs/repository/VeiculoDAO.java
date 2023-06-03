package br.com.gs.repository;

import br.com.gs.connection.ConnectionFactory;

import br.com.gs.interfaces.VeiculosDAOinterface;
import br.com.gs.model.Veiculo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public  class VeiculoDAO implements VeiculosDAOinterface {
    private Connection conexao;
    public VeiculoDAO() throws SQLException{
        this.conexao = ConnectionFactory.conectar();
    }

    @Override
    public void insert(Veiculo veiculo) {
        try {
            String sql = "insert into veiculos(tipoveiculo,refrigerado,proprietario,marca,modelo,placa,data_entrada,tipo_combustivel,carga_max,tanque_max)values(?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, veiculo.getTipoVeiculo());
            stmt.setString(2, veiculo.getRefrigerado());
            stmt.setString(3, veiculo.getProprietario());
            stmt.setString(4, veiculo.getMarca());
            stmt.setString(5, veiculo.getModelo());
            stmt.setString(6,veiculo.getPlaca());
            stmt.setDate(7, veiculo.getDateEntrada());
            stmt.setString(8, veiculo.getTipoCombustivel());
            stmt.setFloat(9, veiculo.getCargaMax());
            stmt.setFloat(10, veiculo.getTanqueMax());

            stmt.execute();
            stmt.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void update(Veiculo veiculo) {
        try {
            String sql = "update veiculos set tipoveiculo=?,refrigerado=?, proprietario=?,marca=?,modelo=?,placa=?,data_entrada=?,tipo_combustivel=?,carga_max=?,tanque_max=? where codveiculo=? ";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, veiculo.getTipoVeiculo());
            stmt.setString(2, veiculo.getRefrigerado());
            stmt.setString(3, veiculo.getProprietario());
            stmt.setString(4, veiculo.getMarca());
            stmt.setString(5, veiculo.getModelo());
            stmt.setDate(6, veiculo.getDateEntrada());
            stmt.setString(7, veiculo.getPlaca());
            stmt.setString(8, veiculo.getTipoCombustivel());
            stmt.setFloat(9, veiculo.getCargaMax());
            stmt.setFloat(10, veiculo.getTanqueMax());
            stmt.setInt(11, veiculo.getCodVeiculo());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try {
            String sql = "delete from veiculos where codveiculo=?";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Veiculo> selectAll() {
        List<Veiculo> veiculos = new ArrayList<Veiculo>();
        String sql = "select * from veiculos order by codveiculo";
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Veiculo veiculo = new Veiculo();
                veiculo.setCodVeiculo(rs.getInt("codveiculo"));
                veiculo.setTipoVeiculo(rs.getString("tipoveiculo"));
                veiculo.setRefrigerado(rs.getString("refrigerado"));
                veiculo.setProprietario(rs.getString("proprietario"));
                veiculo.setMarca(rs.getString("marca"));
                veiculo.setModelo(rs.getString("modelo"));
                veiculo.setPlaca(rs.getString("placa"));
                veiculo.setDataEntrada(rs.getDate("data_entrada"));
                veiculo.setTipoCombustivel(rs.getString("tipo_combustivel"));
                veiculo.setCargaMax(rs.getFloat("carga_max"));
                veiculo.setTanqueMax(rs.getFloat("tanque_max"));
                veiculos.add(veiculo);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return veiculos;
    }

    @Override
    public Veiculo selectById(int id) {
        Veiculo veiculo = null;
        String sql = "select * from veiculos where codveiculo=?";
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                veiculo = new Veiculo();
                veiculo.setCodVeiculo(rs.getInt("codveiculo"));
                veiculo.setTipoVeiculo(rs.getString("tipoveiculo"));
                veiculo.setRefrigerado(rs.getString("refrigerado"));
                veiculo.setProprietario(rs.getString("proprietario"));
                veiculo.setMarca(rs.getString("marca"));
                veiculo.setModelo(rs.getString("modelo"));
                veiculo.setPlaca(rs.getString("placa"));
                veiculo.setDataEntrada(rs.getDate("data_entrada"));
                veiculo.setTipoCombustivel(rs.getString("tipo_combustivel"));
                veiculo.setCargaMax(rs.getFloat("carga_max"));
                veiculo.setTanqueMax(rs.getFloat("tanque_max"));
                rs.close();
                stmt.close();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return veiculo;
    }
}
