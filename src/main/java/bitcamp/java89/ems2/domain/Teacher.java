package bitcamp.java89.ems2.domain;

import java.util.List;

public class Teacher extends Member {
  private static final long serialVersionUID = 1L;
  
  protected String homePage;
  protected String faceBook;
  protected String twitter;
  protected List<Photo> photoList;
  
  public String getHomePage() {
    return homePage;
  }
  public void setHomePage(String homePage) {
    this.homePage = homePage;
  }
  public String getFaceBook() {
    return faceBook;
  }
  public void setFaceBook(String faceBook) {
    this.faceBook = faceBook;
  }
  public String getTwitter() {
    return twitter;
  }
  public void setTwitter(String twitter) {
    this.twitter = twitter;
  }
  public List<Photo> getPhotoList() {
    return photoList;
  }
  public void setPhotoList(List<Photo> photoList) {
    this.photoList = photoList;
  }
  
}
