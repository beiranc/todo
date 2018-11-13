package Controller;

import java.util.Date;
import java.util.UUID;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import Model.Tasks;
import Model.TasksService;

public class AddTasksAction extends Action {
	TasksService tasksService = new TasksService();
	
	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession httpSession = request.getSession();
		String todolistId = new String(request.getParameter("todolistId").trim().getBytes("iso-8859-1"), "UTF-8");
		String title = new String(request.getParameter("title").trim().getBytes("iso-8859-1"), "UTF-8");
		String contents = new String(request.getParameter("contents").trim().getBytes("iso-8859-1"), "UTF-8");
		int priority = Integer.parseInt(request.getParameter("priority"));
		//deadline值为一个字符串(2018-11-12)
		String deadline = new String(request.getParameter("deadline").trim().getBytes("iso-8859-1"), "UTF-8");
		//格式化创建日期
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String createTime = dateFormat.format(new Date());
		//生成tasksId
		String tasksId = UUID.randomUUID().toString().replace("-", "").toLowerCase();
		
		Tasks tasks = new Tasks();
		tasks.setIs_del(0);
		tasks.setFinished(false);
		tasks.setCreateTime(createTime);
		tasks.setContents(contents);
		tasks.setDeadline(deadline);
		tasks.setPriority(priority);
		tasks.setTasksId(tasksId);
		tasks.setTodolistId(todolistId);
		if(!(title.equals(null)) && !(title.equals(""))) {
			tasks.setTitle(title);
		}
		
		boolean result = false;
		result = tasksService.addTasks(tasks);
		if(result) {
			httpSession.setAttribute("todolistId", todolistId);
			System.out.println("Add Tasks Success. ");
			return actionMapping.findForward("success");
		}else {
			return actionMapping.findForward("error");
		}
		
	}
}
