import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TesteInsercao {
	
public static void main(String[] args) throws DbException {
		
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		
		try {
			conn = DB.getConnection();
			
			st =  conn.createStatement();
			
			// rs = st.executeQuery("select * from TB_PRODUTOS");
			
			String sql = "INSERT INTO JOGO (TITULO, CATEGORIA, PLATAFORMA) VALUES ('FIFA 20', 'ESPORTES', 'PS4')";
			ps = conn.prepareStatement(sql);
			ps.execute();
			

		}
		
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		finally {
			DB.closeResultSet(rs);
			DB.closeStatement(st);
			DB.closeConnection();
		}

	}

}
