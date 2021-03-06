package Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import Model.TodolistService;

public class ListAllTodoAction extends Action {
	TodolistService todolistService = new TodolistService();
	
	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response) throws Exception {
		String todolistId = new String(request.getParameter("todolistId").trim().getBytes("iso-8859-1"), "UTF-8");
		
		boolean result = todolistService.deleteTodolistById(todolistId);
		if(result) {
			return actionMapping.findForward("success");
		} else {
			return actionMapping.findForward("error");
		}
	}
}
