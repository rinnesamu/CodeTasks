package personinformation;

import javax.xml.bind.ValidationException;

public class Building {
  private Address address;
  private String buildYear;
  private String intendedUse;
  private double area;
  private Person owner;

  public Building(){}

  public void changeAddress(Address address) throws ValidationException {
    if (address == null){
      throw new ValidationException("No address object");
    }
    this.address = address;
  }

  public void changeOwner(Person newOwner) throws ValidationException {
    if (newOwner == null){
      throw new ValidationException("No person object");
    }
    if (owner != null){
      owner.removeProperty(this);
    }
    newOwner.giveNewProperty(this);
    this.owner = newOwner;

  }

  public void changeBuildYear(String year) throws ValidationException {
    if (!Validator.validateStringWithOnlyNumbers(year)){
      throw new ValidationException(year);
    }
    this.buildYear = year;
  }

  public void changeIntendedUse(String use) throws ValidationException {
    if(Validator.validateStringWithoutNumbers(use)){
      throw new ValidationException(use);
    }
    this.intendedUse = use;
  }

  public void changeArea(double area) throws ValidationException {
    if (area <= 0){
      throw new ValidationException(Double.toString(area));
    }
    this.area = area;

  }

  /*
  Basic getters, nothing "important" really
   */
  public Address getAddress() {
    return address;
  }

  public String getBuildYear() {
    return buildYear;
  }

  public String getIntendedUse() {
    return intendedUse;
  }

  public double getArea() {
    return area;
  }

  public Person getOwner(){
    return this.owner;
  }

}
