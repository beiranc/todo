package Model;

public class Tasks {
	private String tasksId;
	private String title;
	private String contents;
	private boolean isFinished;
	private int priority;
	private String createTime;
	private String deadline;
	private int is_del;
	private String todolistId;
	
	public Tasks() {
		
	}
	
	public Tasks(String tasksId, String title, String contents, int priority, String createTime, String deadline, int is_del, String todolistId) {
		this.tasksId = tasksId;
		this.title = title;
		this.contents = contents;
		this.isFinished = false; //默认为未完成
		this.priority = priority;
		this.createTime = createTime;
		this.deadline = deadline;
		this.is_del = is_del;
		this.todolistId = todolistId;
	}

	public String getTasksId() {
		return tasksId;
	}

	public void setTasksId(String tasksId) {
		this.tasksId = tasksId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getDeadline() {
		return deadline;
	}

	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}

	public int getIs_del() {
		return is_del;
	}

	public void setIs_del(int is_del) {
		this.is_del = is_del;
	}

	public String getTodolistId() {
		return todolistId;
	}

	public void setTodolistId(String todolistId) {
		this.todolistId = todolistId;
	}

	public boolean isFinished() {
		return isFinished;
	}

	public void setFinished(boolean isFinished) {
		this.isFinished = isFinished;
	}
}
