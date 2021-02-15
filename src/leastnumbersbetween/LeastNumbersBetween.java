package leastnumbersbetween;

import java.util.ArrayList;
import java.util.List;

public class LeastNumbersBetween {


  public int getLeastNumbersBetween(List<Integer> list){
    int returnInt = -1;
    if (list == null || list.size() < 2){
      return 0;
    }

    for (int i = 0; i < list.size()-1; i++){
      for (int j = i+1; j < list.size(); j++){
        if (!list.get(i).equals(list.get(j))){
          int numbersBetween = Math.abs(list.get(i) - list.get(j)) - 1;
          if (returnInt < 0 || numbersBetween < returnInt){
            returnInt = numbersBetween;
          }
        } else if (returnInt < 0){
          returnInt = 0;
        }
      }
    }
    return returnInt;
  }


}
