package bitcamp.java89.ems2.control;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import bitcamp.java89.ems2.dao.ManagerDao;
import bitcamp.java89.ems2.dao.MemberDao;
import bitcamp.java89.ems2.dao.StudentDao;
import bitcamp.java89.ems2.dao.TeacherDao;
import bitcamp.java89.ems2.domain.Member;
import bitcamp.java89.ems2.domain.Photo;
import bitcamp.java89.ems2.domain.Teacher;
import bitcamp.java89.ems2.util.MultipartUtil;

@Controller
public class TeacherController {
  @Autowired ServletContext sc;
  @Autowired TeacherDao teacherDao;
  @Autowired MemberDao memberDao;
  @Autowired ManagerDao managerDao;
  @Autowired StudentDao studentDao;
  

  @RequestMapping("/teacher/list")
  public String list(Model model) throws Exception {
    ArrayList<Teacher> list = teacherDao.getList(); 
    model.addAttribute("teachers", list);
    model.addAttribute("title", "강사 관리-목록");
    model.addAttribute("contentPage", "/teacher/list.jsp");

    return "main";
  }
  
  @RequestMapping("/teacher/detail")
  public String detail(int memberNo, Model model) throws Exception {
    Teacher teacher = teacherDao.getOne(memberNo);
    if (teacher == null) {
      throw new Exception("사용자가 없습니다.");
    }
    List<Photo> photoList = teacher.getPhotoList();
    
    model.addAttribute("teacher", teacher);
    model.addAttribute("photoList", photoList);
    
    model.addAttribute("title", "강사 관리-상세정보");
    model.addAttribute("contentPage", "/teacher/detail.jsp");
    
    return "main";
  }
  
  @RequestMapping("/teacher/add")
  public String add(Teacher teacher, MultipartFile photo1, MultipartFile photo2, MultipartFile photo3) throws Exception {
    ArrayList<MultipartFile> multi = new ArrayList<>();
    multi.add(photo1);
    multi.add(photo2);
    multi.add(photo3);
    
    if (teacherDao.exist(teacher.getEmail())) {
      throw new Exception("같은 이메일이 존재합니다. 등록을 취소합니다.");
    }
    
    if (!memberDao.exist(teacher.getEmail())) { // 학생이나 매니저로 등록되지 않았다면,
      memberDao.insert(teacher);
    } else { // 학생이나 매니저로 이미 등록된 사용자라면 기존의 회원 번호를 사용한다.
      Member member = memberDao.getOne(teacher.getEmail());
      teacher.setMemberNo(member.getMemberNo());
    }
    
    ArrayList<Photo> photoList = new ArrayList<>();
    for (MultipartFile mf : multi) {
      if (mf.getSize() > 0) { // 파일이 업로드 되었다면
        String newFilename = MultipartUtil.generateFilename();
        mf.transferTo(new File(sc.getRealPath("/upload/" + newFilename)));
        photoList.add(new Photo(newFilename));
      }
    }
    teacher.setPhotoList(photoList);
    
    teacherDao.insert(teacher);

    return "redirect:list.do";
  }
  
  @RequestMapping("/teacher/delete")
  public String delete(int memberNo, HttpServletRequest request) throws Exception {
    if (!teacherDao.exist(memberNo)) {
      throw new Exception("사용자를 찾지 못했습니다.");
    }
    
    teacherDao.delete(memberNo);
    
    if (!managerDao.exist(memberNo) && !studentDao.exist(memberNo)) {
      memberDao.delete(memberNo);
    }

    return "redirect:list.do";
  }
  
  @RequestMapping("/teacher/update")
  public String update(Teacher teacher, MultipartFile photo1, MultipartFile photo2, MultipartFile photo3) throws Exception {
    ArrayList<MultipartFile> multi = new ArrayList<>();
    multi.add(photo1);
    multi.add(photo2);
    multi.add(photo3);
    
    if (!teacherDao.exist(teacher.getMemberNo())) {
      throw new Exception("사용자를 찾지 못했습니다.");
    }
    memberDao.update(teacher);
    
    ArrayList<Photo> photoList = new ArrayList<>();
    for (MultipartFile mf : multi) {
      if (mf.getSize() > 0) { // 파일이 업로드 되었다면
        String newFilename = MultipartUtil.generateFilename();
        mf.transferTo(new File(sc.getRealPath("/upload/" + newFilename)));
        photoList.add(new Photo(newFilename));
      }
    }
    teacher.setPhotoList(photoList);
    teacherDao.update(teacher);

    return "redirect:list.do";
  }
}
