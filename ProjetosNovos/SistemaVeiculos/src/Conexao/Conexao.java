

package Conexao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;



public class Conexao {
    //TODO Teste
    //atributo con da classe Connection: para estabelcer a conexao com o SGBD
    private static Connection con;
    //atributo stm da classe Statement: para elaborar as expressoes SQL
    private static Statement stm;
    
    /** Creates a new instance of Conexao */
    public Conexao() {
    }
    
    public static void conectar() {
        //TODO tentar fazer conexao com banco MySQL
        String driver = "jdbc:postgresql:";
        String bancoDados = "//localhost:5432/db_veiculos";
        String user = "postgres";
        String pass = "alisson";
        
        try {
            //Acessar a classe Driver mysql
            Class.forName("org.postgresql.Driver");
            //estabelecimento da conexao atraves da invocacao do metodo getConnection
            con = DriverManager.getConnection(driver + bancoDados, user, pass);
            //habilitando stm para execucao de expressoes SQL
            stm = con.createStatement();            
        }
        catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Não foi possível conectar com o Banco de Dados!");
        }
        catch (SQLException e) {
//            JOptionPane.showMessageDialog(null, "Excecao SQL ! Conexao nao pode ser realizada");
            e.printStackTrace();
        }
    }
    
    public static void encerrar() {
        try {
            con.close();    
        }
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Excecao SQL !");
        }
        
    }
    
    public static Statement getStm() {
        return stm;
    }
    
    public static Connection getCon() {
        if (con == null) {
            conectar();
        } 
        return con;
    }
    
    public static void setStm(Statement s) {
        stm = s;
    }
    
    public static void setCon(Connection c) {
        con = c;
    }
}
