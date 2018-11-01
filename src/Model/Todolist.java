package Model;

public class Todolist {
	private String todolistId;
	private String title;
	private String comments;
	private String userId;
	private int is_del;
	
	public Todolist() {
		//测试用  用完记得删除
	}
	
	public Todolist(String todolistId, String title, String comments, String userId, int is_del) {
		this.todolistId = todolistId;
		this.title = title;
		this.comments = comments;
		this.userId = userId;
		this.is_del = is_del;
	}

	public String getTodolistId() {
		return todolistId;
	}

	public void setTodolistId(String todolistId) {
		this.todolistId = todolistId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getIs_del() {
		return is_del;
	}

	public void setIs_del(int is_del) {
		this.is_del = is_del;
	}
}
