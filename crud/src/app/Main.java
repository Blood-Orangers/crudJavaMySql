package app;

import task.Task;
import taskdao.TaskDAO;

public class Main {

	public static void main(String[] args) throws Exception {
		TaskDAO taskDao = new TaskDAO();
		
		taskDao.update(new Task(3,"testando", "updated"));
		
		taskDao.read();
	}

}
