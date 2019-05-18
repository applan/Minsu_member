package member.action;

import java.util.Scanner;

import member.domain.MemberVO;
import member.service.MemberModifyService;
import member.ui.MemberConsoleUtil;

public class MemberModifyAction implements Action {

	@Override
	public void execute(Scanner sc) throws Exception {
		MemberConsoleUtil util = new MemberConsoleUtil();
		MemberVO vo = util.printModifyMessage(sc);
		boolean modifyFlag = false;
		
		if (vo != null) {
			MemberModifyService service = new MemberModifyService();
			modifyFlag = service.modifyFlag(vo);
			if (modifyFlag) {
				util.printModifySuccessMessage(vo.getName());
			} else {
				util.printModifyFailMessage(vo.getName());
			}
		}
	}
}
