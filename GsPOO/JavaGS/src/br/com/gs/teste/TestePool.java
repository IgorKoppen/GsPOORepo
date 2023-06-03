package br.com.gs.teste;

import br.com.gs.connection.ConnectionFactory;

import java.sql.Connection;
import java.sql.SQLException;

public class TestePool {
    public static void main(String[] args) throws SQLException {
        for(int i = 1; i < 15; i++){
            Connection conexao = ConnectionFactory.conectar();
            System.out.println("Conexao: " + i);
        }
    }
}
