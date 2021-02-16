package personinformation;

public class Validator {

  private static final String SSN_REGEX = "^\\d{6}[+A-]\\d{3}[A-Y0-9]";

  public static boolean validateSSN(String s){
    return s.matches(SSN_REGEX);
  }

  public static boolean validateStringWithoutNumbers(String s){
    if (s == null || s.length() == 0){
      return false;
    }
    return !s.matches(".*\\d+.*");
  }

  public static boolean validateStringWithOnlyNumbers(String s, int amount){
    if (s == null || amount <= 0){
      return false;
    }
    return s.matches("^\\d{" + amount + "}");
  }

  public static boolean validateStringWithOnlyNumbers(String s){
    if (s == null){
      return false;
    }
    return s.matches("\\d+");
  }

}
