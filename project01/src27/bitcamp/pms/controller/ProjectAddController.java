package bitcamp.pms.controller;

import java.sql.Date;
import java.util.Map;
import java.util.Scanner;

import bitcamp.pms.annotation.Controller;
import bitcamp.pms.annotation.RequestMapping;
import bitcamp.pms.dao.ProjectDao;
import bitcamp.pms.domain.Project;
import bitcamp.pms.util.CommandUtil;

@Controller
public class ProjectAddController {
  private ProjectDao projectDao;
  private Scanner keyScan;
  
  public void setProjectDao(ProjectDao projectDao) {
    this.projectDao = projectDao;
  }

  @RequestMapping("project/add.do")
  public void add(Map<String,Object> paramMap) {
    keyScan = (Scanner)paramMap.get("stdin");
    
    try {
      Project project = new Project();

      System.out.print("프로젝트명? ");
      project.setTitle(keyScan.nextLine());
      System.out.print("시작일? ");
      project.setStartDate(Date.valueOf(keyScan.nextLine()));
      System.out.print("종료일? ");
      project.setEndDate(Date.valueOf(keyScan.nextLine()));
      System.out.print("설명? ");
      project.setDescription(keyScan.nextLine());

      if (CommandUtil.confirm(keyScan, "저장하시겠습니까?")) {
        projectDao.insert(project);
        System.out.println("저장하였습니다.");
      } else {
        System.out.println("저장을 취소하였습니다.");
      }
    } catch (Exception e) {
      System.out.println("데이터 로딩에 실패했습니다.");
    }
  }
}
