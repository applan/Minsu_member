package member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.domain.MemberVO;
import member.service.MemberLoginService;

public class MemberLoginAction implements Action {
 private String path;
 
 public MemberLoginAction(String path) {
	 super();
	 this.path = path;
 }
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String userid = req.getParameter("userid");
		String current_password = req.getParameter("current_password");
		
		MemberLoginService service = new MemberLoginService();
		MemberVO vo =service.isLogin(userid,current_password);
		HttpSession session = req.getSession();
		if(vo != null) {
			session.setAttribute("login", vo);	
		}
		return new ActionForward(path, true);
	}

}
