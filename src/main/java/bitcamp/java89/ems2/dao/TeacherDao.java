package bitcamp.java89.ems2.dao;

import java.util.ArrayList;

import bitcamp.java89.ems2.domain.Teacher;

public interface TeacherDao {
  public ArrayList<Teacher> getList() throws Exception;
  public Teacher getOneWithPhoto(int memberNo) throws Exception;
  public void insert(Teacher teacher) throws Exception;
  public void insertPhotoList(Teacher teacher) throws Exception;
  public void update(Teacher teacher) throws Exception;
  public void delete(int memberNo) throws Exception;
  public void deletePhotoList(int memberNo) throws Exception;
  int countByNo(int memberNo) throws Exception;
  int count(String email) throws Exception;
}
