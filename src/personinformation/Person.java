package personinformation;


import javax.xml.bind.ValidationException;
import java.util.Date;
import java.util.List;

public class Person {

  private String firstName;
  private String lastName;
  private String socialSecurityNumber;
  private String nationality;
  private Address address;
  private List<Person> parents;
  private List<Person> children;
  private Date birthDay;
  private Date dateOfDeath;
  private List<Building> properties;


  /*
  Probably shouldn't have public default constructor, sine all of the people
  have at least some information like name and some kind of social security
  number. Still leaving it here for testing purposes
   */
  public Person(){ }

  public Person(String firstName, String lastName, String socialSecurityNumber)
    throws ValidationException {
    if (!validateName(firstName, lastName)){
      throw new ValidationException(firstName + " " + lastName);
    }
    if (!validateSocialSecurityNumber(socialSecurityNumber)){
      throw new ValidationException(socialSecurityNumber);
    }
    this.firstName = firstName;
    this.lastName = lastName;
    this.socialSecurityNumber = socialSecurityNumber;

  }

  public boolean markAsParent(Person parent){
    if (parents.size() >= 2 || parents.contains(parent) ||
      parent.getBirthDay().after(this.birthDay)){
      return false;
    }
    parents.add(parent);
    return true;
  }

  public boolean markAsChildren(Person child){
    if (children.contains(child) || this.birthDay.after(child.getBirthDay())){
      return false;
    }
    children.add(child);
    return true;
  }

  public void changeName(String firstName, String lastName)
    throws ValidationException {
    if(!validateName(firstName, lastName)){
      throw new ValidationException(firstName + " " + lastName);
    }
    this.firstName = firstName;
    this.lastName = lastName;
  }

  public void changeSocialSecurityNumber(String ssn) throws ValidationException {
    if(!validateSocialSecurityNumber(ssn)){
      throw new ValidationException(ssn);
    }
    this.socialSecurityNumber = ssn;
  }

  /*
   Validates name. At this point only checks that given string is not null
   and it must not contain any numbers. Could be extended to every special
   character that are not allowed in .
   */
  private boolean validateName(String firstName, String lastName){
    if(firstName == null || firstName.length() == 0 ||
      lastName == null || lastName.length() == 0){
      return false;
    }
    boolean correctFirst = !firstName.matches(".*\\d+.*");
    boolean correctLast = !lastName.matches(".*\\d+.*");
    return correctLast && correctFirst;
  }

  /*
  Check that entered social security number is valid
  Works only with Finnish ssn, additional clauses should be added to check
  others too. Also missing some checks like last digit should be reminder of
  first 9 / 31.
   */
  private boolean validateSocialSecurityNumber(String socialSecurityNumber){
    if(socialSecurityNumber == null){
      return false;
    }
    return socialSecurityNumber.matches("^\\d{6}[+A-]\\d{3}[A-Y0-9]");
  }


  /*
  Basic getters and setters, nothing "important" really
   */
  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getSocialSecurityNumber() {
    return socialSecurityNumber;
  }

  public void setSocialSecurityNumber(String socialSecurityNumber) {
    this.socialSecurityNumber = socialSecurityNumber;
  }

  public String getNationality() {
    return nationality;
  }

  public void setNationality(String nationality) {
    this.nationality = nationality;
  }

  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }

  public List<Person> getParents() {
    return parents;
  }

  public void setParents(List<Person> parents) {
    this.parents = parents;
  }

  public List<Person> getChildren() {
    return children;
  }

  public void setChildren(List<Person> children) {
    this.children = children;
  }

  public Date getBirthDay() {
    return birthDay;
  }

  public void setBirthDay(Date birthDay) {
    this.birthDay = birthDay;
  }

  public Date getDateOfDeath() {
    return dateOfDeath;
  }

  public void setDateOfDeath(Date dateOfDeath) {
    this.dateOfDeath = dateOfDeath;
  }
}
