package taskdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import task.Task;
import util.Conn;

public class TaskDAO {
	public void save(Task task) throws Exception {
		String sql = "INSERT INTO task_table(title, description) VALUES (?, ?)";
		
		Connection conn = null;
		
		PreparedStatement prepare = null;
		
		try {
			conn = Conn.getConn();
			
			prepare = conn.prepareStatement(sql);
			
			prepare.setString(1, task.getTitle());
			prepare.setString(2, task.getDescription());
			
			prepare.execute();
			
		} catch(SQLException error) {
			System.out.println("Have a beetle: " + error);
		}finally {
			try {
				if(prepare!=null) {
					prepare.close();
				}
				if(conn!=null) {
					conn.close();
				}
			}catch (Exception error) {
				System.out.println("Have a beetle: " + error);
			}
		}
		
	}
}
