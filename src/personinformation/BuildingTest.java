package personinformation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.xml.bind.ValidationException;

import static org.junit.jupiter.api.Assertions.*;

class BuildingTest {

  private final String YEAR = "2020";
  private final double AREA = 120;


  Building building;
  @BeforeEach
  void init(){
    building = new Building();
  }

  @Test
  @DisplayName("Test change address")
  void testChangeAddress() {
    try {
      Address a = new Address();
      building.changeAddress(a);
      assertEquals(a, building.getAddress(), "couldnn't change address");
    } catch (ValidationException e) {
      e.printStackTrace();
    }
  }

  @Test
  @DisplayName("Test test build year")
  void testChangeBuildYear(){
    try{
      building.changeBuildYear(YEAR);
      assertEquals(YEAR, building.getBuildYear(),
        "Couldn't change build year");
    } catch (ValidationException e) {
      e.printStackTrace();
    }
  }

  @Test
  @DisplayName("Test change area")
  void testChangeArea(){
    try{
      building.changeArea(AREA);
      assertEquals(AREA, building.getArea(), "Couldn't change area");
    } catch (ValidationException e) {
      e.printStackTrace();
    }
  }

  @Test
  @DisplayName("Test change owenr")
  void testChangeOwner(){
    try {
      Person firstOwner = new Person();
      Person secondOwner = new Person();
      building.changeOwner(firstOwner);
      assertEquals(firstOwner, building.getOwner(),
        "Couldn't change owner");
      assertThrows(ValidationException.class, () -> {
        building.changeOwner(null);
      });
      assertEquals(firstOwner, building.getOwner(),
        "Changing owner to null messed up something");
      building.changeOwner(firstOwner);
      assertEquals(firstOwner, building.getOwner(),
        "giving owner as new buyer messed up something");
      building.changeOwner(secondOwner);
      assertEquals(secondOwner, building.getOwner(),
        "Changing owner did not work");
    } catch (ValidationException e) {
      e.printStackTrace();
    }
  }
}