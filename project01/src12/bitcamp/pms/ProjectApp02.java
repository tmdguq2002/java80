/* 목표
- 프로젝트 정보를 등록, 목록조회, 변경, 삭제하는 기능을 추가한다.
- 사용 문법:
  => 클래스 정의
  => 여러 클래스의 인스턴스를 다루는 방법

1) 멤버관리와 프로젝트 관리를 선택할 수 있는 메뉴 기능을 추가한다.
- 기존에 동작하던 add, list, update, delete 명령을 막아라!
명령> go member
회원관리>      <--- 프롬프트 아니다. 그냥 출력하라.
명령> go project
프로젝트관리>    <--- 프롬프트 아니다. 그냥 출력하라.
2) go 명령어의 옵션을 처리하는 기능을 추가한다.

*/
package bitcamp.pms;

import java.util.Scanner;
import bitcamp.pms.controller.MemberController;

public class ProjectApp {
  static Scanner keyScan = new Scanner(System.in);

  public static void main(String[] args) {
    // 멤버 관리 객체 생성
    MemberController memberController = new MemberController();
    memberController.setScanner(keyScan); // <-- 의존 객체 주입

    String[] cmds;

    while (true) {
      cmds = prompt().split(" ");

      if (cmds[0].equals("quit")) {
        doQuit();
        break;
      } else if (cmds[0].equals("about")) {
        doAbout();
      } else if (cmds[0].equals("go")) {
        doGo(cmds);
      } else {
        doError();
      }
    }

    keyScan.close(); // 항상 다 쓴 자원은 해제해야 한다.
  }

  static String prompt() {
    System.out.print("명령> ");
    return keyScan.nextLine().toLowerCase();
  }

  static void doQuit() {
    System.out.println("안녕히 가세요!");
  }

  static void doError() {
    System.out.println("올바르지 않은 명령어입니다.");
  }

  static void doAbout() {
    System.out.println("비트캠프 80기 프로젝트 관리 시스템!");
  }

  static void doGo(String[] cmds) {
    if (cmds.length < 2) {
      System.out.println("메뉴 이름을 지정하세요.");
      System.out.println("예) go member");
      return ;
    }

    switch (cmds[1]) {
      case "member":
        System.out.println("회원관리>");
        break;
      case "project":
        System.out.println("프로젝트관리>");
        break;
      default:
        System.out.println("없는 메뉴입니다.");
    }

  }
}
