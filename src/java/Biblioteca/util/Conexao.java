package Biblioteca.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
    
    private static final String url = "jdbc:mysql://localhost:3306/biblioteca?useUnicode=true&characterEncoding=UTF-8";
    private static final String user = "root";
    private static final String password = "";

    public static Connection conectar() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            return DriverManager.getConnection(url, user, password);

        } catch (Exception ex) {
            System.out.println("Erro: " + ex.getMessage());
            
            return null;
        }
    }
}