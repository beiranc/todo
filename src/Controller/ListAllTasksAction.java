package Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import Model.TasksService;

public class ListAllTasksAction extends Action {
	TasksService tasksService = new TasksService();
	
	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response) throws Exception {
		String tasksId = new String(request.getParameter("tasksId").trim().getBytes("iso-8859-1"), "UTF-8");
		String todolistId = new String(request.getParameter("todolistId").trim().getBytes("iso-8859-1"), "UTF-8");
		String completed = new String(request.getParameter("complete").trim().getBytes("iso-8859-1"), "UTF-8");
		
		//complete为1 则当前状态为未完成 ，需要修改成完成
		//complete为0 则当前状态为已完成 ，需要修改成未完成
		System.out.println("tasksId：" + tasksId + "\t" + "todolistId：" + todolistId + "\t" + "complete: " + completed);
		
		if(completed.equals("1")) {
			boolean result = tasksService.completeTasks(tasksId);
			if(result) {
				response.sendRedirect(request.getContextPath() + "/pages/ListTasksPage.jsp?todolistId=" + todolistId);
				return null;
				//return actionMapping.findForward("success");
			} else {
				return actionMapping.findForward("error");
			}
		} else {
			boolean result = tasksService.resetTasks(tasksId);
			if(result) {
				response.sendRedirect(request.getContextPath() + "/pages/ListTasksPage.jsp?todolistId=" + todolistId);
				return null;
				//return actionMapping.findForward("success");
			} else {
				return actionMapping.findForward("error");
			}
		}
	}
}
