package personinformation;


import javax.xml.bind.ValidationException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Person {

  private String firstName;
  private String lastName;
  private String socialSecurityNumber;
  private Address address;
  private int apartmentNumber;
  private List<Person> parents = new ArrayList<>();
  private List<Person> children = new ArrayList<>();
  private Date birthDay;
  private Date dateOfDeath;
  private List<Building> properties = new ArrayList<>();

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
    setSSN(socialSecurityNumber);

  }
  public boolean markAsChild(Person child){
    if (child == null || children.contains(child)){
      return false;
    }
    if (!child.markAsParent(this)){
      /*
      If this person cannot be marked as parent of the child, neither
      connections should be added.
       */
      return false;
    }
    children.add(child);
    return true;
  }

  private boolean markAsParent(Person parent){
    if (parents.size() >= 2 || parents.contains(parent)){
      return false;
    }
    parents.add(parent);
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
    setSSN(ssn);
  }

  public void changeAddress(Address address) throws ValidationException {
    if (address == null){
      throw new ValidationException("Address is null");
    }
    this.address = address;
  }

  public boolean markDateOfDeath(Date date){
    if (this.birthDay == null || date == null || date.before(this.birthDay)){
      return false;
    }
    this.dateOfDeath = date;
    return true;
  }

  public String checkBirthdayAsString(){
    return parseDateToPrint(this.birthDay);
  }

  public String checkDateOfDeathAsString(){
    return parseDateToPrint(this.dateOfDeath);
  }

  public boolean giveNewProperty(Building building){
    if (building == null || properties.contains(building)){
      return false;
    }
    properties.add(building);
    return true;
  }

  public boolean removeProperty(Building building){
    if (building == null || !properties.contains(building)){
      return false;
    }
    properties.remove(building);
    return true;
  }

  /*
   Validates name. At this point only checks that given string is not null
   and it must not contain any numbers. Could be extended to every special
   character that are not allowed in .
   */
  private boolean validateName(String firstName, String lastName){
    boolean correctFirst = Validator.validateStringWithoutNumbers(firstName);
    boolean correctLast = Validator.validateStringWithoutNumbers(lastName);
    return correctLast && correctFirst;
  }

  /*
  Check that entered social security number is valid. Was going to add checks
  for first 4 digits, but would wee too time consuming for this project.
  Works only with Finnish ssn, additional clauses should be added to check
  others too. Also missing some checks like last digit should be reminder of
  first 9 / 31.
   */
  private boolean validateSocialSecurityNumber(String socialSecurityNumber){
    if(socialSecurityNumber == null){
      return false;
    }
    return Validator.validateSSN(socialSecurityNumber);
  }

  private void parseBirthday(String socialSecurityNumber) {
    int day = Integer.parseInt(socialSecurityNumber.substring(0,2));
    int month = Integer.parseInt(socialSecurityNumber.substring(2,4));
    int year = Integer.parseInt(socialSecurityNumber.substring(4,6));
    String test = socialSecurityNumber.substring(6,7);
    switch (test) {
      case "+":
        year += 1800;
        break;
      case "-":
        year += 1900;
        break;
      case "A":
        year += 2000;
        break;
    }
    this.birthDay = new Date(year - 1900, month-1, day);
  }

  private void setSSN(String ssn){
    this.socialSecurityNumber = ssn;
    parseBirthday(ssn);
  }

  private String parseDateToPrint(Date date){
    if (date == null){
      return "Date not added";
    }
    String DateAsString =
      date.getDate() + "." + (+date.getMonth()+1) + "." + (+date.getYear()+1900);
    return DateAsString;
  }


  /*
  Basic getters, nothing "important" really.
   */
  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getSocialSecurityNumber() {
    return socialSecurityNumber;
  }

  public Address getAddress() {
    return address;
  }

  public List<Person> getParents() {
    return parents;
  }

  public List<Person> getChildren() {
    return children;
  }

  public Date getBirthDay() {
    return birthDay;
  }


  public Date getDateOfDeath() {
    return dateOfDeath;
  }

}
