package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoMySql {
  private static final String URL = "jdbc:mysql://localhost:3306/locadora";
  private static final String USUARIO = "root";
  private static final String SENHA = "92537602Lin@";

  public static Connection conectar() {
    Connection conexao = null;
    try {
      conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
    } catch (SQLException e) {
      System.out.println("Erro ao conectar: " + e.getMessage());
    }
    return conexao;
  }

}
