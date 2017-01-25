package bitcamp.java89.ems2.control.json;

import java.io.File;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import bitcamp.java89.ems2.domain.Student;
import bitcamp.java89.ems2.service.StudentService;
import bitcamp.java89.ems2.util.MultipartUtil;

@Controller
public class StrudentJsonControl {
  @Autowired ServletContext sc;
  
  @Autowired StudentService studentService;
  
  @RequestMapping("/student/form")
  public String form(Model model) {
    model.addAttribute("title", "학생 입력폼");
    model.addAttribute("contentPage", "student/form.jsp");
    return "main";
  }
  
  @RequestMapping("/student/list")
  public AjaxResult list() throws Exception {
    List<Student> list = studentService.getList();
    return new AjaxResult(AjaxResult.SUCCESS, list);
  }
  
  @RequestMapping("/student/detail")
  public AjaxResult detail(int memberNo) throws Exception {
    Student student = studentService.getDetail(memberNo);
    if (student == null) {
      return new AjaxResult(AjaxResult.FAIL, "해당 일련번호의 학생이 없습니다.");
    }
    return new AjaxResult(AjaxResult.SUCCESS, student);
  }
  
  @RequestMapping("/student/add")
  public String add(Student student, MultipartFile photo) throws Exception {
    // 페이지 컨트롤러는 입력 파라미터 값을 가공하여 모델 객체에게 전달하는 일을 한다.
    if (photo.getSize() > 0) { // 파일이 업로드 되었다면
      String newFilename = MultipartUtil.generateFilename();
      photo.transferTo(new File(sc.getRealPath("/upload/" + newFilename)));
      student.setPhotoPath(newFilename);
    }
    studentService.add(student);
    
    return "redirect:list.do";
  }
  
  @RequestMapping("/student/delete")
  public String delete(int memberNo, HttpServletRequest request) throws Exception {
    studentService.delete(memberNo);
    return "redirect:list.do";
  }
  
  @RequestMapping("/student/update")
  public String update(Student student, MultipartFile photo) throws Exception {
    if (photo.getSize() > 0) { // 파일이 업로드 되었다면0
      String newFilename = MultipartUtil.generateFilename();
      photo.transferTo(new File(sc.getRealPath("/upload/" + newFilename)));
      student.setPhotoPath(newFilename);
    }
    
    studentService.update(student);
    
    return "redirect:list.do";
  }
}
