package bitcamp.java89.ems2.control.teacher;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bitcamp.java89.ems2.control.PageController;
import bitcamp.java89.ems2.dao.TeacherDao;
import bitcamp.java89.ems2.domain.Photo;
import bitcamp.java89.ems2.domain.Teacher;

@Component("/teacher/detail.do")
public class TeacherDetailControl implements PageController {
  @Autowired TeacherDao teacherDao;
  
  @Override
  public String service(HttpServletRequest request, HttpServletResponse response) throws Exception {
    int memberNo = Integer.parseInt(request.getParameter("memberNo"));
    
    Teacher teacher = teacherDao.getOne(memberNo);
    if (teacher == null) {
      throw new Exception("사용자가 없습니다.");
    }
    List<Photo> photoList = teacher.getPhotoList();
    
    request.setAttribute("teacher", teacher);
    request.setAttribute("photoList", photoList);
    
    request.setAttribute("title", "강사 관리-상세정보");
    request.setAttribute("contentPage", "/teacher/detail.jsp");
    
    return "/main.jsp";
  }
}
