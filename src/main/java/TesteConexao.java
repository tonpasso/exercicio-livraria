import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TesteConexao {

	public static void main(String[] args) {
		
		Connection conexao = null;
		PreparedStatement ps = null;

        try {

                 Class.forName("oracle.jdbc.OracleDriver");

                 conexao = DriverManager.getConnection(

                		 "jdbc:oracle:thin:@localhost:1521:XE", "sefaz", "sefaz");
                 
                 
                 
                String sql = "INSERT INTO LIVRO (CODIGO, TITULO, AUTOR, CATEGORIA) VALUES ('00123', 'HARRY POTTER', 'J.K.HOWLING', 'FICÇÃO')";
    			ps = conexao.prepareStatement(sql);
    			ps.execute();

                 System.out.println("Conexao: " + conexao.toString());
                 
                 
                 
        } catch (ClassNotFoundException e) {

                 e.printStackTrace();

        } catch (SQLException e) {

                 e.printStackTrace();

        }


	}

}
