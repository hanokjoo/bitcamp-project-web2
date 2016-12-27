package bitcamp.java89.ems2.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.java89.ems2.domain.Manager;
import bitcamp.java89.ems2.domain.Member;
import bitcamp.java89.ems2.domain.Photo;
import bitcamp.java89.ems2.domain.Student;
import bitcamp.java89.ems2.domain.Teacher;

@WebServlet("/header")
public class HeaderServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  
  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {
  
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    out.println("<div id='header' style='background-color: gray; height: 60px;"
        + " position:relative;'>");
    out.println("<div style='width:300px; height:58px; "
        + " position:absolute; left:0px; top:0px;'>");
    out.println("<img src='../image/go.jpg' "
        + "height='50' style='float: left; margin-top: 5px; margin-left: 5px;'>");
    out.println("<div style='color: white; font-weight: bold; "
        + "margin-left: 80px; padding-top: 15px; font-family: D2Coding, sans-serif; "
        + "font-size: x-large;'>교육센터관리시스템</div>");
    out.println("</div>");

    // 로그인 사용자 정보를 가져온다.
    out.println("<div style='height:50px; margin-top: 5px; float:right;'>");
    Member member = (Member)request.getSession().getAttribute("member");
    
    if (member == null) {
      out.println("<a href='../auth/login' style='position:absolute; right:0px; top:15px;'>로그인</a>");
    } else {
      out.printf("<img src='../upload/%s' height='50' style='vertical-align:middle;'>\n", this.getPhotoPath(member));
      out.printf("<span>%s</span>\n", member.getName());
      out.println("<a href='../auth/logout'>로그아웃</a>");
    }
    out.println("</div>");
    out.println("</div>");
  }
  
  private String getPhotoPath(Member member) {
    if (member instanceof Student) {
      System.out.println("[student]");
      return ((Student)member).getPhotoPath();
    
    } else if (member instanceof Manager) {
      System.out.println("[manager]");
      return ((Manager)member).getPhotoPath();
    
    } else /*if (member instanceof Teacher) */ {
      System.out.println("[teacher]");
      List<Photo> photoList = ((Teacher)member).getPhotoList();
      if (photoList.size() > 0) {
        return photoList.get(0).getFilePath();
      } else {
        return null;
      }
    }
  }
}
