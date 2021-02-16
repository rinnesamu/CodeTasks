package personinformation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.xml.bind.ValidationException;

import static org.junit.jupiter.api.Assertions.*;

class AddressTest {

  private final String COUNTRY = "Finland";
  private final String REGION = "Uusimaa";
  private final String CITY = "Espoo";
  private final String POSTAL_CODE = "02000";
  private final String ADDRESS = "Test address 2a";

  Address address;

  @BeforeEach
  void init(){
    address = new Address();
  }

  @Test
  @DisplayName("Test changing country")
  void testChangeCountry(){
    try {
      address.changeCountry(COUNTRY);
      assertEquals(COUNTRY, address.getCountry(),
        "Couldn't change country name");
    } catch (ValidationException e) {
      e.printStackTrace();
    }
  }

  @Test
  @DisplayName("Test change region")
  void testChangeRegion(){
    try{
      address.changeRegion(REGION);
      assertEquals(REGION, address.getRegion(),
        "Couldn't change region");
    } catch (ValidationException e) {
      e.printStackTrace();
    }
  }

  @Test
  @DisplayName("Test change city")
  void testChangeCity(){
    try{
      address.changeCity(CITY);
      assertEquals(CITY, address.getCity(),
        "Couldn't change city");
    } catch (ValidationException e) {
      e.printStackTrace();
    }
  }

  @Test
  @DisplayName("Tess changing postal code")
  void testChangePostalCode(){
    try{
      address.changePostalCode(POSTAL_CODE);
      assertEquals(POSTAL_CODE, address.getPostalCode(),
        "couldn't change postal code");
    } catch (ValidationException e) {
      e.printStackTrace();
    }
  }

  @Test
  @DisplayName("Test change address")
  void testChangeAddress(){
    try{
      address.changeStreetAddress(ADDRESS);
      assertEquals(ADDRESS, address.getStreetAddress(),
        "Couldn't change address");
    } catch (ValidationException e) {
      e.printStackTrace();
    }
  }

  @Test
  @DisplayName("Test address as string")
  void testAddressAsString(){
    try{
      address.changeCountry(COUNTRY);
      address.changeRegion(REGION);
      address.changeCity(CITY);
      address.changePostalCode(POSTAL_CODE);
      address.changeStreetAddress(ADDRESS);
      assertEquals("Test address 2a, 02000 Espoo, Uusimaa, Finland",
        address.addressAsString(),
        "addressAsString returned incorrect value");
    } catch (ValidationException e) {
      e.printStackTrace();
    }
  }


}