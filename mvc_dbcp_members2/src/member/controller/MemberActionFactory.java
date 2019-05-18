package member.controller;

import member.action.Action;
import member.action.MemberCheckIdAction;
import member.action.MemberJoinAction;
import member.action.MemberLeaveAction;
import member.action.MemberLoginAction;
import member.action.MemberModifyAction;

public class MemberActionFactory {
  private MemberActionFactory() {}
  
  private static MemberActionFactory maf;
  
  public static MemberActionFactory getInstance() {
	  if(maf==null)
		  maf = new MemberActionFactory();
	  return maf;
  }
  
  Action action = null;
  public Action action(String cmd) {
	  if("/login.do".equals(cmd)) {
		  action = new MemberLoginAction("view/loginForm.jsp");
	  }else if("/join.do".equals(cmd)) {
		  action = new MemberJoinAction("view/loginForm.jsp");
	  }else if("/leave.do".equals(cmd)) {
		  action = new MemberLeaveAction("view/joinForm.jsp");
	  }else if("/modify.do".equals(cmd)) {
		  action = new MemberModifyAction("view/loginForm.jsp");
	  }else if("/checkId.do".equals(cmd)) {
		  action = new MemberCheckIdAction("view/checkId.jsp");
	  }
	  return action;
  }
}
