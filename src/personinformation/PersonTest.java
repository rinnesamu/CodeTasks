package personinformation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.xml.bind.ValidationException;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

  private final String VALID_FIRST_NAME = "Test";
  private final String VALID_LAST_NAME = "Person";
  private final String VALID_SOCIAL_NUMBER = "123456-123K";

  /*
  Constructor tests
   */

  @Test
  @DisplayName("Test Person constructor. All ok")
  void testConstructorOK() {
    try {
      Person person = new Person(VALID_FIRST_NAME, VALID_LAST_NAME,
        VALID_SOCIAL_NUMBER);
      assertEquals(VALID_FIRST_NAME, person.getFirstName(),
        "Error with the first name");
      assertEquals(VALID_LAST_NAME, person.getLastName(),
        "Error with the last name");
      assertEquals(VALID_SOCIAL_NUMBER, person.getSocialSecurityNumber(),
        "Error with the social security number");
    } catch (ValidationException e){
      System.out.println("Failed to create person with constructor");
    }
  }

  @Test
  @DisplayName("Test illegal first name in constructor")
  void testConstructorIllegalFirstName(){
    assertThrows(ValidationException.class, () -> {
      new Person(null, VALID_LAST_NAME, VALID_SOCIAL_NUMBER);
    });
    assertThrows(ValidationException.class, () -> {
      new Person("", VALID_LAST_NAME, VALID_SOCIAL_NUMBER);
    });
    assertThrows(ValidationException.class, () -> {
      new Person("Test1", VALID_LAST_NAME, VALID_SOCIAL_NUMBER);
    });
  }

  @Test
  @DisplayName("Test illegal last name in constructor")
  void testConstructorIllegalLastName(){
    assertThrows(ValidationException.class, () -> {
      new Person(VALID_FIRST_NAME, null, VALID_SOCIAL_NUMBER);
    });
    assertThrows(ValidationException.class, () -> {
      new Person(VALID_FIRST_NAME, "", VALID_SOCIAL_NUMBER);
    });
    assertThrows(ValidationException.class, () -> {
      new Person(VALID_FIRST_NAME, "Person2", VALID_SOCIAL_NUMBER);
    });
  }

  @Test
  @DisplayName("Test illegal social security number")
  void testConstructorIllegalSocialSecurityNumber(){
    assertThrows(ValidationException.class, () -> {
      new Person(VALID_FIRST_NAME, VALID_LAST_NAME, "12345a-123K");
    });
    assertThrows(ValidationException.class, () -> {
      new Person(VALID_FIRST_NAME, VALID_LAST_NAME, "1234562123K");
    });
    assertThrows(ValidationException.class, () -> {
      new Person(VALID_FIRST_NAME, VALID_LAST_NAME, "123456-12AK");
    });
    assertThrows(ValidationException.class, () -> {
      new Person(VALID_FIRST_NAME, VALID_LAST_NAME, "123456-123Z");
    });
    assertThrows(ValidationException.class, () -> {
      new Person(VALID_FIRST_NAME, VALID_LAST_NAME, "123456-123");
    });
  }

  /*
  Test change name
   */

  @Test
  @DisplayName("Test changeName with correct names")
  void testChangeName(){
    try {
      Person person = new Person();
      person.changeName(VALID_FIRST_NAME, VALID_LAST_NAME);
      assertEquals(VALID_FIRST_NAME, person.getFirstName(),
        "Error with the first name");
      assertEquals(VALID_LAST_NAME, person.getLastName(),
        "Error with the last name");
    } catch (ValidationException e){
      System.out.println("Failed to change name");
    }
  }

  @Test
  @DisplayName("Text changeName with incorrect first name")
  void testChangeNameIncorrectFirstName(){
    Person person = new Person();
    assertThrows(ValidationException.class, () -> {
      person.changeName(null, VALID_LAST_NAME);
    });
    assertThrows(ValidationException.class, () -> {
      person.changeName("", VALID_LAST_NAME);
    });
    assertThrows(ValidationException.class, () -> {
      person.changeName("Test2", VALID_LAST_NAME);
    });
  }

  @Test
  @DisplayName("Test changeName with incorrect last name")
  void testChangeNameIncorrectLastName(){
    Person person = new Person();
    assertThrows(ValidationException.class, () -> {
      person.changeName(VALID_FIRST_NAME, null);
    });
    assertThrows(ValidationException.class, () -> {
      person.changeName(VALID_FIRST_NAME, "");
    });
    assertThrows(ValidationException.class, () -> {
      person.changeName(VALID_FIRST_NAME, "2Person");
    });
  }

  /*
  Change social security number tests
   */

  @Test
  @DisplayName("Test changeSSN with correct ssn")
  void testChangeSSN(){
    try {
      Person person = new Person();
      person.changeSocialSecurityNumber(VALID_SOCIAL_NUMBER);
      assertEquals(VALID_SOCIAL_NUMBER, person.getSocialSecurityNumber(),
        "Failed to change SSN");
    } catch (ValidationException e){
      System.out.println("Failed to change SSN");
    }
  }

  @Test
  @DisplayName("Test changeSSn with incorrect ssn")
  void testChaneSSNIncorrecValue(){
    Person person = new Person();
    assertThrows(ValidationException.class, () -> {
      person.changeSocialSecurityNumber("12312A-123K");
    });
    assertThrows(ValidationException.class, () -> {
      person.changeSocialSecurityNumber("123126S123K");
    });
    assertThrows(ValidationException.class, () -> {
      person.changeSocialSecurityNumber("123126-1A3K");
    });
    assertThrows(ValidationException.class, () -> {
      person.changeSocialSecurityNumber("123126-123Z");
    });
  }

}