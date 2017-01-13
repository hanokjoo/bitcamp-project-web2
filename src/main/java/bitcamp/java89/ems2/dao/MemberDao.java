package bitcamp.java89.ems2.dao;

import java.util.Map;

import bitcamp.java89.ems2.domain.Member;

public interface MemberDao {
  void insert(Member member) throws Exception;
  public void update(Member member) throws Exception;
  public void delete(int memberNo) throws Exception;
  int count(String email) throws Exception;
  Member getOneByEmailPassword(Map<String,String> paramMap) throws Exception;
  public Member getOne(String email) throws Exception;
}
