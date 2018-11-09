package Controller;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import Model.Todolist;
import Model.TodolistService;

public class AddTodolistAction extends Action {
	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response) throws Exception {
		TodolistService todolistService = new TodolistService();
		Todolist todolist = new Todolist();
		HttpSession httpSession = request.getSession();
		
		String userId = (String) httpSession.getAttribute("userId");
		String title = new String(request.getParameter("title").trim().getBytes("iso-8859-1"), "UTF-8");
		String comments = new String(request.getParameter("comments").trim().getBytes("iso-8859-1"), "UTF-8");
		String todolistId = UUID.randomUUID().toString().replace("-", "").toLowerCase();
		
		todolist.setIs_del(0);
		todolist.setTodolistId(todolistId);
		todolist.setUserId(userId);
		
		if( (!title.equals(null)) && (!comments.equals(null))) {
			todolist.setTitle(title);
			todolist.setComments(comments);
		} else {
			return actionMapping.findForward("error");
		}
		
		boolean result = false;
		result = todolistService.addTodolist(todolist);
		if(result) {
			httpSession.setAttribute("todolist", todolist);
			System.out.println("Add Todolist Success ! ");
			return actionMapping.findForward("success");
		} else {
			return actionMapping.findForward("error");
		}
	}
}
