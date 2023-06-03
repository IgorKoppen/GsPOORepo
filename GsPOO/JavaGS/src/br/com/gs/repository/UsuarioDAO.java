package br.com.gs.repository;

import br.com.gs.connection.ConnectionFactory;
import br.com.gs.interfaces.UsuariosDAOinterface;
import br.com.gs.model.Usuario;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UsuarioDAO implements UsuariosDAOinterface{
        private Connection conexao;

        public UsuarioDAO() throws SQLException {
            this.conexao = ConnectionFactory.conectar();
        }

    @Override
    public void insert(Usuario usuario) {
        try {
            String sql = "insert into usuarios(nome,senha,email,data)values(?,?,?,?)";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getSenha());
            stmt.setString(3, usuario.getEmail());
            stmt.setDate(4, usuario.getData());
            stmt.execute();
            stmt.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public boolean findUser(String user, String senha)  {

        String sql = "select * from usuarios";

        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {

               if(user.equals(rs.getString("nome")) && senha.equals(rs.getString("senha"))){
                   rs.close();
                   stmt.close();
                   return true;
               }
            }
            rs.close();
            stmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}

