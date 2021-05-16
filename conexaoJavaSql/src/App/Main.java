package App;

import task.Task;
import taskdao.TaskDAO;

public class Main {

	public static void main(String[] args) throws Exception {
		Task task = new Task();
		task.setTitle("Estudar bibliotecas de som");
		task.setDescription("faça projeto para fixar melhor");
		
		TaskDAO taskDao = new TaskDAO();
		
		taskDao.save(task);
		

	}

}
