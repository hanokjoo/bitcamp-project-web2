package bitcamp.java89.ems2.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bitcamp.java89.ems2.dao.ManagerDao;
import bitcamp.java89.ems2.dao.MemberDao;
import bitcamp.java89.ems2.dao.StudentDao;
import bitcamp.java89.ems2.dao.TeacherDao;
import bitcamp.java89.ems2.domain.Member;
import bitcamp.java89.ems2.domain.Student;
import bitcamp.java89.ems2.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
  @Autowired StudentDao studentDao;
  @Autowired MemberDao memberDao;
  @Autowired ManagerDao managerDao;
  @Autowired TeacherDao teacherDao;
  
  public List<Student> getList() throws Exception {
    return studentDao.getList();
  }
  
  public Student getDetail(int no) throws Exception {
    return studentDao.getOne(no);
  }
  
  public int add(Student student) throws Exception {
    
    if (memberDao.count(student.getEmail()) == 0) { // 강사나 매니저로 등록되지 않았다면,
      memberDao.insert(student);
    } else { // 강사나 매니저로 이미 등록된 사용자라면 기존의 회원 번호를 사용한다.
      Member member = memberDao.getOne(student.getEmail());
      student.setMemberNo(member.getMemberNo());
    }
    
    return studentDao.insert(student);
  }
  
  public int delete(int no) throws Exception {
    if (studentDao.countByNo(no) == 0) {
      throw new Exception("사용자를 찾지 못했습니다.");
    }
    
    int count = studentDao.delete(no);

    if (managerDao.countByNo(no) == 0 && teacherDao.countByNo(no) == 0) {
      memberDao.delete(no);
    }
    return count;
  }
  
  public int update(Student student) throws Exception {
    if (studentDao.countByNo(student.getMemberNo()) == 0) {
      throw new Exception("사용자를 찾지 못했습니다.");
    }
    memberDao.update(student);
    return studentDao.update(student);
  }
}
