package member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import member.domain.MemberVO;
import member.service.MemberModifyService;

public class MemberModifyAction implements Action{
   private String path;
   
   
	public MemberModifyAction(String path) {
	super();
	this.path = path;
}

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		HttpSession session = req.getSession();
		
		String current_password = req.getParameter("current_password");
		String new_password = req.getParameter("new_password");
		MemberVO vo = (MemberVO)session.getAttribute("login");
		String userid = vo.getUserid();
		String result = "0";
		MemberModifyService service = new MemberModifyService();
		boolean tf =service.searchOverlap(userid, current_password);
		if(tf) { // 해당 유저의 아이디와 패스워드를 가진 애가 있는지 확인
			vo.setUserid(userid);
			vo.setPassword(new_password);
			boolean inTf = service.ModifyMember(vo);
			 if(!inTf) { 
				 result = "2";
				 session.setAttribute("result", result);
				 path="view/modifyForm.jsp";
			 }else {
				 result = "3";
				 session.removeAttribute("login");
				 session.setAttribute("result", result);
				 
			 }
		}else { // // 해당 유저의 아이디와 패스워드를 가진 애가 있는지 확인 후 없는 경우
			result = "1";
			session.setAttribute("result", result);
			path="view/modifyForm.jsp";
		}
		return new ActionForward(path, true);
	}

}
