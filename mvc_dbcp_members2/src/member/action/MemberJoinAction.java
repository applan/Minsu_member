package member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.service.MemberJoinService;

public class MemberJoinAction implements Action {
	private String path;

	
	public MemberJoinAction(String path) {
		super();
		this.path = path;
	}


	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {		
		req.setCharacterEncoding("utf-8");
		String userid = req.getParameter("userid");
		String password = req.getParameter("password");
		String name = req.getParameter("name");
		String gender = req.getParameter("gender");
		String email = req.getParameter("email");
		MemberJoinService service = new MemberJoinService();
		boolean tf = service.JoinService(userid, password, name, gender, email);
		if(!tf) {
			path="view/joinForm.jsp";
		}
		return new ActionForward(path, true);
	}

}
