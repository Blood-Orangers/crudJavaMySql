package app;

import taskdao.TaskDAO;

public class Main {

	public static void main(String[] args) throws Exception {
		TaskDAO taskDao = new TaskDAO();
		taskDao.read();
	}

}
