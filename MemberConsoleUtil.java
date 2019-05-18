package member.ui;

import java.util.ArrayList;
import java.util.Scanner;

import member.domain.MemberVO;

public class MemberConsoleUtil {
	// 사용자에게 Member 입력받기 위한 화면 구성
	public MemberVO addMember(Scanner sc) {
		System.out.println("새로운 멤버의 정보를 입력해주세요");
		System.out.print("이 름 > ");
		String name = sc.next();
		System.out.print("주 소 > ");
		String addr = sc.next();
//		sc.nextLine();
		System.out.print("이메일 > ");
		String email = sc.next();
		System.out.print("국 적 > ");
		String nation = sc.next();
		System.out.print("나 이 > ");
		int age = sc.nextInt();
		
//		MemberVO vo = new MemberVO();
//		vo.setName(name);
//		vo.setAddr(addr);
//		vo.setEmail(email);
//		vo.setNation(nation);
//		vo.setAge(age);
		
		return new MemberVO(name, addr, nation, email, age);
	}
	
	// insert 성공 메세지
	public void printAddSuccessMessage(MemberVO vo) {
		System.out.println(vo.getName() + "님 추가 성공");
	}
	
	// insert 실패 메세지
	public void printAddFailMessage() {
		System.out.println("실패");
	}
	
	// list출력 메세지
	public void printMemberList(ArrayList<MemberVO> list) {
		System.out.println("id \t name \t addr \t nation \t email \t age");
		System.out.println("==========================================================");
		for (MemberVO memberVO : list) {
			System.out.println(memberVO.toString());
		}
	}
	
	// list 없음 메세지
	public void printListFail() {
		System.out.println("사용자가 없습니다");
	}
	
	// 수정관련 메소드
	public MemberVO printModifyMessage(Scanner sc) {
		System.out.println("수정할 사용자의 정보를 입력해주세요");
		System.out.print("이 름 > ");
		String name = sc.next();
		System.out.print("변경할 주 소 > ");
		String addr = sc.next();
		
		MemberVO vo = new MemberVO();
		vo.setName(name);
		vo.setAddr(addr);
		
		return vo;
	}
	
	public void printModifySuccessMessage(String name) {
		System.out.println(name + " 님의 정보를 수정하였습니다");
	}
	
	public void printModifyFailMessage(String name) {
		System.out.println(name + " 님의 정보를 찾을 수 없습니다");
	}
	
}












