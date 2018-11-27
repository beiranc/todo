package Controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import Model.Tasks;
import Model.TasksService;

public class SearchTasksAction extends Action {
	TasksService tasksService = new TasksService();
	
	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response) throws Exception {
		String keyWord = new String(request.getParameter("keyWord").trim().getBytes("iso-8859-1"), "UTF-8");
		
		List<Tasks> list = new ArrayList();
		
		list = tasksService.searchTasksByKey(keyWord);
		if(!list.isEmpty()) {
			request.setAttribute("keyWord", keyWord);
			request.setAttribute("list", list);
			return actionMapping.findForward("success");
		} else {
			System.out.println("该查询无结果！");
			return actionMapping.findForward("error");
		}
	}
}
