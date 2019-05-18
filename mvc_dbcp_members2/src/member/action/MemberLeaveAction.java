package member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.service.MemberLeaveService;

public class MemberLeaveAction implements Action {
   private String path;
   
   
   public MemberLeaveAction(String path) {
	   super();
	   this.path = path;
   };
   
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
        String userid = req.getParameter("userid");
        String current_password = req.getParameter("current_password");
        
        MemberLeaveService service = new MemberLeaveService();
        boolean tf = service.remove(userid, current_password);
        HttpSession session = req.getSession();
		if(tf) {
			session.removeAttribute("login");
		}else {
			path="view/leaveForm.jsp";
		   session.setAttribute("result", true);
		}
		return new ActionForward(path, true);
	}

}
