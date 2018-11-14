package Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import Model.Todolist;
import Model.TodolistService;

public class UpdateTodolistAction extends Action {
	TodolistService todolistService = new TodolistService();
	
	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response) throws Exception {
		String title = new String(request.getParameter("title").trim().getBytes("iso-8859-1"), "UTF-8");
		String comments = new String(request.getParameter("comments").trim().getBytes("iso-8859-1"), "UTF-8");
		String todolistId = new String(request.getParameter("todolistId").trim().getBytes("iso-8859-1"), "UTF-8");
		
		Todolist todolist = new Todolist();
		todolist.setTitle(title);
		todolist.setComments(comments);
		todolist.setTodolistId(todolistId);
		
		boolean result = todolistService.updateTodolist(todolist);
		
		if(result) {
			return actionMapping.findForward("success");
		} else {
			System.out.println("Update Error ! ");
			return actionMapping.findForward("error");
		}
	}
}
