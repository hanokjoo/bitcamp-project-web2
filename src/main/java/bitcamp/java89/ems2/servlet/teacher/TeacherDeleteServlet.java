package bitcamp.java89.ems2.servlet.teacher;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.java89.ems2.dao.ManagerDao;
import bitcamp.java89.ems2.dao.MemberDao;
import bitcamp.java89.ems2.dao.StudentDao;
import bitcamp.java89.ems2.dao.TeacherDao;
import bitcamp.java89.ems2.listener.ContextLoaderListener;

@WebServlet("/teacher/delete")
public class TeacherDeleteServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    try {
      int memberNo = Integer.parseInt(request.getParameter("memberNo"));
      
      TeacherDao teacherDao = (TeacherDao)ContextLoaderListener.applicationContext.getBean("teacherDao");
      
      if (!teacherDao.exist(memberNo)) {
        throw new Exception("사용자를 찾지 못했습니다.");
      }
      
      teacherDao.delete(memberNo);

      MemberDao memberDao = (MemberDao)ContextLoaderListener.applicationContext.getBean("memberDao");
      ManagerDao managerDao = (ManagerDao)ContextLoaderListener.applicationContext.getBean("managerDao");
      StudentDao studentDao = (StudentDao)ContextLoaderListener.applicationContext.getBean("studentDao");
      
      if (!managerDao.exist(memberNo) && !studentDao.exist(memberNo)) {
        memberDao.delete(memberNo);
      }

      response.sendRedirect("list");
      
    } catch (Exception e) {
      request.setAttribute("error", e);
      RequestDispatcher rd = request.getRequestDispatcher("/error.jsp");
      rd.forward(request, response);
      return;
    }
  }
}
