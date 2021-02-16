package personinformation;

public class Validator {

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
