package Controller;

import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import Model.User;
import Model.UserService;

public class LoginAction extends Action {
	UserService userService = new UserService();
	
	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response) throws Exception {
		String userName = new String(request.getParameter("userName").trim().getBytes("iso-8859-1"), "UTF-8");
		String password = new String(request.getParameter("password").trim().getBytes("iso-8859-1"), "UTF-8");	
		
		//获取数据库中当前User数据
		User user = userService.getUserByName(userName);
		
		HttpSession httpSession = request.getSession();
		httpSession.setAttribute("userId",user.getUserId());
		
		if(user.getUserName().equals(userName) && user.getPassword().equals(password)) {
			System.out.println("Login Success !! ");
			return actionMapping.findForward("success");
		} else {
			System.out.println("Login Error !! ");
			return actionMapping.findForward("error");
		}
	}
}
