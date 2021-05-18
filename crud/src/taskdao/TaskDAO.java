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

	public void save(int id, String title, String description) throws Exception {
		String sql = "INSERT INTO task_table(title, description) VALUES (?, ?)";

		Task task = new Task(id, title, description);

		Connection conn = null;

		PreparedStatement prepare = null;

		try {
			conn = Conn.getConn();

			prepare = conn.prepareStatement(sql);

			prepare.setString(1, task.getTitle());
			prepare.setString(2, task.getDescription());

			prepare.execute();

		} catch (SQLException error) {
			System.out.println("Have a beetle: " + error);
		} finally {
			try {
				if (prepare != null) {
					prepare.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception error) {
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
				int id = result.getInt("id");
				String title = result.getString("title");
				String description = result.getString("description");

				Task task = new Task(id, title, description);

				list.add(task);
			}

		} catch (Exception error) {
			System.out.println("Have a beetle: " + error);
		} finally {
			try {
				if (prepare != null) {
					prepare.close();
				}
				if (result != null) {
					result.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception error) {
				System.out.println("Have a beetle: " + error);
			}

		}
		for (Task task : list) {
			System.out.println(task + ",");
		}
		return list;
	}

	public void update(Task task) throws Exception {
		String sql = "UPDATE task_table SET title = ?, description = ? WHERE (id = ?);";

		Connection conn = null;

		PreparedStatement prepare = null;

		try {
			conn = Conn.getConn();

			prepare = conn.prepareStatement(sql);
			
			prepare.setString(1, task.getTitle());
			prepare.setString(2, task.getDescription());
			prepare.setInt(3, task.getId());
			
			prepare.execute();
			
		} catch (SQLException error) {
			System.out.println("Have a beetle: " + error);
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
				if (prepare != null) {
					prepare.close();
				}
			} catch (SQLException error) {
				System.out.println("Have a beetle: " + error);
			}
		}

	}
}
