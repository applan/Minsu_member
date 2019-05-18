package member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.service.MemberCheckIdService;

public class MemberCheckIdAction implements Action {
private String path;
	public MemberCheckIdAction(String path) {
	super();
	this.path = path;
}
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String userid = req.getParameter("userid");
		
		MemberCheckIdService service = new MemberCheckIdService();
		boolean dupId = service.checkId(userid);
		 // jquery validator 작동 
		// 서버쪽에서 넘어온 데이터가 "false", undefined, null => invalid
		// "true" => valid
		if(dupId) {
			req.setAttribute("dupId", "false");
		}else {
			req.setAttribute("dupId", "true");
		}
		
		return new ActionForward(path, false);
	}

}
