package taskdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
	
	public List<Task> read() {
		List<Task> list = new ArrayList<Task>();
		
		String sql = "SELECT * FROM task_table";
		
		Connection conn = null;
		
		PreparedStatement prepare = null;
		
		ResultSet result = null;
		
		try {
				conn = Conn.getConn();
				
				prepare = conn.prepareStatement(sql);
				
				result = prepare.executeQuery();
				
				while (result.next()) {
					Task task = new Task();
					
					task.setTitle(result.getString("title"));
					task.setDescription(result.getString("description"));
					
					list.add(task);
				}
			
			} catch (Exception error) {
			System.out.println("Have a beetle: " + error);
		} finally {
			try {
				if(prepare!=null) {
					prepare.close();
				}
				if (result!=null) {
					result.close();
				}
				if(conn!=null) {
					conn.close();
				}
			}catch (Exception error) {
				System.out.println("Have a beetle: " + error);
			}
			
		}
	for (int index = 0; index < list.size(); index++)	
		System.out.println(index +" | " + list.get(index) + ",");
	return list;
	}
}
