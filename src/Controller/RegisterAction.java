package Controller;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import Dao.UserDao;
import Model.User;
import Model.UserService;

public class RegisterAction extends Action {
	UserService userService = new UserService();
	
	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String userId = UUID.randomUUID().toString().replace("-", "").toLowerCase();
		String userName = new String(request.getParameter("userName").trim().getBytes("iso-8859-1"), "UTF-8");
		String password = new String(request.getParameter("password").trim().getBytes("iso-8859-1"), "UTF-8");	
		User user = new User();
		
		user.setUserId(userId);
		
		if(userName == null || "".equals(userName)) {
			System.out.println("用户名不能为空！！！");
			return actionMapping.findForward("error");
		} else {
			user.setUserName(userName);
		}
		
		if(password == null || "".equals(password)) {
			System.out.println("密码不能为空！！！");
			return actionMapping.findForward("error");
		} else {
			user.setPassword(password);
		}
		
		//一种方法
		//将success跳转设为新增页面，在SuccessRegisterPage.jsp中写一个模态框提示注册成功并跳转至LoginPage.jsp界面
		//Login.jsp同理
		boolean isUserExist = userService.checkUserByName(userName);
		if(isUserExist) {
			System.out.println("用户已存在！");
			return actionMapping.findForward("error");
		} else {
			boolean result = false;
			result = userService.addUser(user);
			if(result) {
				return actionMapping.findForward("success");
			} else {
				return actionMapping.findForward("error");
			}
		}
	}
}
