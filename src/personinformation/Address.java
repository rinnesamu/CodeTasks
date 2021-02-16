package personinformation;

public class Address {

  private String country;
  private String region;
  private String city;
  private int postalCode;
  private Building building;
  private int apartmentNumber;

  public Address(){}

  /*
  Basic getters and setters, nothing "important" really
   */
  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public String getRegion() {
    return region;
  }

  public void setRegion(String region) {
    this.region = region;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public int getPostalCode() {
    return postalCode;
  }

  public void setPostalCode(int postalCode) {
    this.postalCode = postalCode;
  }

  public Building getBuilding() {
    return building;
  }

  public void setBuilding(Building building) {
    this.building = building;
  }

  public int getApartmentNumber() {
    return apartmentNumber;
  }

  public void setApartmentNumber(int apartmentNumber) {
    this.apartmentNumber = apartmentNumber;
  }
}
