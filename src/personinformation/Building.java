package personinformation;

public class Building {
  private String streetAddress;
  private int buildYear;
  private String intendedUse;
  private double area;

  public Building(){}


  /*
  Basic getters and setters, nothing "important" really
   */
  public String getStreetAddress() {
    return streetAddress;
  }

  public void setStreetAddress(String streetAddress) {
    this.streetAddress = streetAddress;
  }

  public int getBuildYear() {
    return buildYear;
  }

  public void setBuildYear(int buildYear) {
    this.buildYear = buildYear;
  }

  public String getIntendedUse() {
    return intendedUse;
  }

  public void setIntendedUse(String intendedUse) {
    this.intendedUse = intendedUse;
  }

  public double getArea() {
    return area;
  }

  public void setArea(double area) {
    this.area = area;
  }
}
