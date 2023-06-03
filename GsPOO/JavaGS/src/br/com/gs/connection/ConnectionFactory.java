package br.com.gs.connection;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionFactory{
	private static String ORACLE = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";
	private static DataSource conexao = null;
	private ConnectionFactory(){

	}
	public static Connection conectar() throws  SQLException{
		if(conexao == null){
			final ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
			comboPooledDataSource.setJdbcUrl(ORACLE);
			comboPooledDataSource.setUser("rm93507");
			comboPooledDataSource.setPassword("081002");
			comboPooledDataSource.setMaxPoolSize(10);
			conexao = comboPooledDataSource;
		}
		return  conexao.getConnection();
	};
}

