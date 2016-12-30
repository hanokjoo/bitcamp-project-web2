package bitcamp.java89.ems2.servlet.manager;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.java89.ems2.dao.ManagerDao;
import bitcamp.java89.ems2.domain.Manager;
import bitcamp.java89.ems2.listener.ContextLoaderListener;

@WebServlet("/manager/detail")
public class ManagerDetailServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    try {
      int memberNo = Integer.parseInt(request.getParameter("memberNo"));
      
      response.setContentType("text/html;charset=UTF-8");
      PrintWriter out = response.getWriter();
      
      out.println("<!DOCTYPE html>");
      out.println("<html>");
      out.println("<head>");
      out.println("<meta charset='UTF-8'>");
      out.println("<title>매니저 관리-상세정보</title>");
      out.println("</head>");
      out.println("<body>");
      
   // HeaderServlet에게 머리말 HTML 생성을 요청한다.
      RequestDispatcher rd = request.getRequestDispatcher("/header");
      rd.include(request, response);
      
      out.println("<h1>매니저 정보</h1>");
      out.println("<form action='update' method='POST' enctype='multipart/form-data'>");
      
      ManagerDao managerDao = (ManagerDao)ContextLoaderListener.applicationContext.getBean("managerDao");
      
      Manager manager = managerDao.getOne(memberNo);
      if (manager == null) {
        throw new Exception("사용자가 없습니다.");
      }
      
      out.println("<table border='1'>");
      out.printf("<tr><th>이메일</th><td><input name='email' type='text' value='%s'></td></tr>\n", manager.getEmail());
      out.printf("<tr><th>암호</th><td><input name='password' type='password'></td></tr>\n");
      out.printf("<tr><th>이름</th><td><input name='name' type='text' value='%s'></td></tr>\n", manager.getName());
      out.printf("<tr><th>전화</th><td><input name='tel' type='text' value='%s'></td></tr>\n", manager.getTel());
      out.println("<tr><th>직급</th><td>");
      out.println("<select name='position'>");
      out.printf("  <option value='사원' %s>사원</option>\n", "사원".equals(manager.getPosition())? "selected": "");
      out.printf("  <option value='주임' %s>주임</option>\n", "주임".equals(manager.getPosition())? "selected": "");
      out.printf("  <option value='대리' %s>대리</option>\n", "대리".equals(manager.getPosition())? "selected": "");
      out.printf("  <option value='과장' %s>과장</option>\n", "과장".equals(manager.getPosition())? "selected": "");
      out.printf("  <option value='차장' %s>차장</option>\n", "차장".equals(manager.getPosition())? "selected": "");
      out.printf("  <option value='부장' %s>부장</option>\n", "부장".equals(manager.getPosition())? "selected": "");
      out.println("</select>");
      out.println("</td></tr>");
      out.printf("<tr><th>팩스</th><td><input name='faxNum' type='text' value='%s'></td></tr>\n", manager.getFaxNum());
      out.printf("<tr><th>사진</th><td>"
          + "<img src='../upload/%s' height='80'>"
          + "<input name='photoPath' type='file'></td></tr>\n",
          manager.getPhotoPath());
      out.println("</table>");
      
      out.println("<button type='submit'>변경</button>");
      out.printf("<a href='delete?memberNo=%d'>삭제</a>\n", memberNo);
    
      out.printf("<input type='hidden' name='memberNo' value='%d'>\n", manager.getMemberNo());
      
      out.println("<a href='list'>목록</a>");
      out.println("</form>");
      
   // FooterServlet에게 꼬리말 HTML 생성을 요청한다.
      rd = request.getRequestDispatcher("/footer");
      rd.include(request, response);
      
      out.println("</body>");
      out.println("</html>");

    } catch (Exception e) {
      request.setAttribute("error", e);
      RequestDispatcher rd = request.getRequestDispatcher("/error");
      rd.forward(request, response);
      return;
    }
  }
}
