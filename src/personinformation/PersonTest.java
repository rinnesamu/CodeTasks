package personinformation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.xml.bind.ValidationException;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

  private final String VALID_FIRST_NAME = "Test";
  private final String VALID_LAST_NAME = "Person";
  private final String VALID_SOCIAL_NUMBER = "111292-123F";
  private final Date VALID_DEATH = new Date(2011-1900, 5-1, 5);

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
      new Person(VALID_FIRST_NAME, VALID_LAST_NAME, "11129A-123F");
    });
    assertThrows(ValidationException.class, () -> {
      new Person(VALID_FIRST_NAME, VALID_LAST_NAME, "1112922123F");
    });
    assertThrows(ValidationException.class, () -> {
      new Person(VALID_FIRST_NAME, VALID_LAST_NAME, "111292-12AF");
    });
    assertThrows(ValidationException.class, () -> {
      new Person(VALID_FIRST_NAME, VALID_LAST_NAME, "111292-123Z");
    });
    assertThrows(ValidationException.class, () -> {
      new Person(VALID_FIRST_NAME, VALID_LAST_NAME, "111292-123");
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
  void testChaneSSNIncorrectValue(){
    Person person = new Person();
    assertThrows(ValidationException.class, () -> {
      person.changeSocialSecurityNumber("11A292-123F");
    });
    assertThrows(ValidationException.class, () -> {
      person.changeSocialSecurityNumber("111292S123F");
    });
    assertThrows(ValidationException.class, () -> {
      person.changeSocialSecurityNumber("111292-1Z3F");
    });
    assertThrows(ValidationException.class, () -> {
      person.changeSocialSecurityNumber("111292-123Z");
    });
    assertThrows(ValidationException.class, () -> {
      person.changeSocialSecurityNumber("111292-123");
    });
  }

  /*
  Tests for adding children
   */

  @Test
  @DisplayName("Testing addChildren with correct values")
  void testMarkAsChild(){
    Person parent = new Person();
    Person secondParent = new Person();
    Person child = new Person();

    assertTrue(parent.markAsChild(child),
      "first parent couldn't be added");
    assertTrue(child.getParents().contains(parent),
      "first parent wasn't found from children");
    assertTrue(secondParent.markAsChild(child),
      "second parent couldn't be added");
    assertTrue(child.getParents().contains(secondParent),
      "second parent wasn't found from children");
    assertTrue(parent.getChildren().contains(child),
      "child wasn't found from first parent");
    assertTrue(secondParent.getChildren().contains(child),
      "child wasn't found from second parent");

  }

  /*
  Test for birthday and date of death
   */

  @Test
  @DisplayName("Test adding legal date of death")
  void testLegalDateOfDeath(){
    Person person = new Person();
    try{
      person.changeSocialSecurityNumber(VALID_SOCIAL_NUMBER);
      assertTrue(person.markDateOfDeath(VALID_DEATH),
        "Cannot add valid date of death");
    } catch (ValidationException e) {
      e.printStackTrace();
    }
  }

  @Test
  @DisplayName("Test adding illegal date of death")
  void addIllegalDateOfDeath(){
    try{
      Person person = new Person();
      assertFalse(person.markDateOfDeath(null),
        "null were added as date of death");
      assertEquals("Date not added", person.checkDateOfDeathAsString(),
        "wrong return when date of death not added yet");
      assertFalse(person.markDateOfDeath(VALID_DEATH),
        "date of death was added without birthday");
      assertEquals("Date not added", person.checkDateOfDeathAsString(),
        "wrong return when date of death not added yet");
      person.changeSocialSecurityNumber(VALID_SOCIAL_NUMBER);
      assertFalse(person.markDateOfDeath(new Date(0, 1, 1)),
        "Date of death is earlier than birthday");
      assertEquals("Date not added", person.checkDateOfDeathAsString(),
        "wrong return when date of death not added yet");
    } catch (ValidationException e) {
      e.printStackTrace();
    }
  }

  @Test
  @DisplayName("Test checking dates without adding them first")
  void testNullDates(){
    Person person = new Person();
    assertEquals("Date not added", person.checkDateOfDeathAsString(),
      "wrong return when date of death not added yet");
    assertEquals("Date not added", person.checkBirthdayAsString(),
      "wrong return when birthday not added yet");
  }

  @Test
  @DisplayName("Test checking dates when already added")
  void testCheckingDates(){
    Person person = new Person();
    try{
      person.changeSocialSecurityNumber(VALID_SOCIAL_NUMBER);
      assertEquals("11.12.1992", person.checkBirthdayAsString(),
        "Birthday string didn't match");
      person.markDateOfDeath(VALID_DEATH);
      assertEquals("5.5.2011", person.checkDateOfDeathAsString(),
        "Date of death string didn't match");
    } catch (ValidationException e) {
      e.printStackTrace();
    }

  }
}