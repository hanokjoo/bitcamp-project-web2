package bitcamp.java89.ems2.domain;

public class Manager extends Member {
  private static final long serialVersionUID = 1L;
  
  protected int managerNo;
  protected String position;
  protected String faxNum;
  protected String photoPath;
  
  public int getManagerNo() {
    return managerNo;
  }
  public void setManagerNo(int managerNo) {
    this.managerNo = managerNo;
  }
  public String getPosition() {
    return position;
  }
  public void setPosition(String position) {
    this.position = position;
  }
  public String getFaxNum() {
    return faxNum;
  }
  public void setFaxNum(String faxNum) {
    this.faxNum = faxNum;
  }
  public String getPhotoPath() {
    return photoPath;
  }
  public void setPhotoPath(String photoPath) {
    this.photoPath = photoPath;
  }
}
