package bitcamp.java89.ems2.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/header")
public class HeaderServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  
  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {
  
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    out.println("<div id='header' style='background-color: gray; height: 60px;'>");
    out.println("<img src='../image/go.jpg' "
        + "height='50' style='float: left; margin-top: 5px; margin-left: 5px;'>");
    out.println("<div style='color: white; font-weight: bold; "
        + "margin-left: 80px; padding-top: 15px; font-family: D2Coding, sans-serif; "
        + "font-size: x-large;'>교육센터관리시스템</div>");
    out.println("</div>");
  }
}
