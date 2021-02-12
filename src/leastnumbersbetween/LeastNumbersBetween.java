package leastnumbersbetween;

import java.util.List;

public class LeastNumbersBetween {

  private final int ERROR_CODE = -1;

  public int getLeastNumbersBetween(List<Integer> list){
    int returnInt = 1111111;
    if (list == null || list.size() == 0){
      return -1;
    }

    if (list.size() == 1){
      return 0;
    }

    for (int i = 0; i < list.size()-1; i++){
      for (int j = i+1; j < list.size(); j++){
        if (list.get(i) == list.get(j)){
          return 0;
        }
        int numbersBetween = Math.abs(list.get(i) - list.get(j)) - 1;
        if (numbersBetween < returnInt){
          returnInt = numbersBetween;
        }

      }

    }
    return returnInt;
  }
}
