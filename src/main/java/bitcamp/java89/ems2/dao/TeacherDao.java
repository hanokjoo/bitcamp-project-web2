package bitcamp.java89.ems2.dao;

import java.util.ArrayList;

import bitcamp.java89.ems2.domain.Teacher;

public interface TeacherDao {
  public ArrayList<Teacher> getList() throws Exception;
  public Teacher getOne(int memberNo) throws Exception;
  public void insert(Teacher manager) throws Exception;
  public void update(Teacher manager) throws Exception;
  public void delete(int memberNo) throws Exception;
  public boolean exist(int memberNo) throws Exception;
  boolean exist(String email) throws Exception;
}
