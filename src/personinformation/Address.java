package personinformation;

import javax.xml.bind.ValidationException;

public class Address {

  private String country;
  private String region;
  private String city;
  private String postalCode;
  private String streetAddress;

  public Address(){}


  public void changeCountry(String country) throws ValidationException {
    if (!Validator.validateStringWithoutNumbers(country)){
      throw new ValidationException(country);
    }
    this.country = country;
  }

  public void changeRegion(String region) throws ValidationException{
    if (!Validator.validateStringWithoutNumbers(region)){
      throw new ValidationException(region);
    }
    this.region = region;
  }

  public void changeCity(String city) throws  ValidationException{
    if (!Validator.validateStringWithoutNumbers(city)){
      throw new ValidationException(city);
    }
    this.city = city;
  }

  public void changePostalCode(String postalCode) throws ValidationException{
    if (!Validator.validateStringWithOnlyNumbers(postalCode, 5)){
      throw new ValidationException(postalCode);
    }
    this.postalCode = postalCode;
  }

  public void changeStreetAddress(String address) throws ValidationException {
    if (address == null || address.length() == 0){
      throw new ValidationException(address);
    }
    this.streetAddress = address;
  }


  public String addressAsString(){
    StringBuilder sb = new StringBuilder();
    if (streetAddress != null){
      sb.append(streetAddress).append(", ");
    }
    if (postalCode != null){
      sb.append(postalCode).append(" ");
    }
    if (city != null){
      sb.append(city).append(", ");
    }
    if (region != null){
      sb.append(region).append(", ");
    }
    if (country != null){
      sb.append(country);
    }
    return sb.toString();
  }

  /*
  Basic getters, nothing "important" really
   */
  public String getCountry() {
    return country;
  }

  public String getRegion() {
    return region;
  }

  public String getCity() {
    return city;
  }

  public String getPostalCode() {
    return postalCode;
  }


  public String getStreetAddress(){
    return this.streetAddress;
  }
}
