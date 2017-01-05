package bitcamp.java89.ems2.control.student;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bitcamp.java89.ems2.control.PageController;
import bitcamp.java89.ems2.dao.StudentDao;
import bitcamp.java89.ems2.domain.Student;

@Component("/student/detail.do")
public class StrudentDetailControl implements PageController {
  @Autowired StudentDao studentDao;
  
  @Override
  public String service(HttpServletRequest request, HttpServletResponse response) throws Exception {
    int memberNo = Integer.parseInt(request.getParameter("memberNo"));

    Student student = studentDao.getOne(memberNo);
    if (student == null) {
      throw new Exception("해당 일련번호의 학생이 없습니다.");
    }
    request.setAttribute("student", student);
    request.setAttribute("title", "학생 관리-상세정보");
    request.setAttribute("contentPage", "/student/detail.jsp");

    return "/main.jsp";
  }
}
