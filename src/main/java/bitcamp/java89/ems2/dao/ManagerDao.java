package bitcamp.java89.ems2.dao;

import java.util.ArrayList;

import bitcamp.java89.ems2.domain.Manager;

public interface ManagerDao {
  public ArrayList<Manager> getList() throws Exception;
  public Manager getOne(int memberNo) throws Exception;
  public void insert(Manager manager) throws Exception;
  public void update(Manager manager) throws Exception;
  public void delete(int memberNo) throws Exception;
  int countByNo(int memberNo) throws Exception;
  int count(String email) throws Exception;
}
