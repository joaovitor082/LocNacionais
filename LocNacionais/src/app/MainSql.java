package app;

import java.sql.Connection;

import util.ConexaoMySql;

public class MainSql {
   public static void main(String[] args) {
      Connection conexao = ConexaoMySql.conectar();
      if (conexao != null) {
         System.out.println("Conectado com sucesso!");
      } else {
         System.out.println("Erro ao conectar!");
      }
    }  
}
