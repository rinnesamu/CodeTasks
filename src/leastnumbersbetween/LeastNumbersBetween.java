package leastnumbersbetween;

import java.util.ArrayList;
import java.util.List;

public class LeastNumbersBetween {

  /*
  What is returned, if list is null, empty or too small
   */
  private final int CANT_COMPARE = 0;

  private final int INIT = -1;

  public int getLeastNumbersBetween(List<Integer> originalList){
    if (originalList == null){
      return CANT_COMPARE;
    }
    List<Integer> list = removeDuplicatesAndSort(originalList);
    int answer = INIT;
    /*
    Init ans to negative, because there cannot be negative
    amount of numbers between
     */
    if (list.size() < 2){
      return CANT_COMPARE;
    }

    for (int i = 0; i < list.size()-1; i++){
      int numbersBetween = Math.abs(list.get(i) - list.get(i+1)) -1;
      if (answer == INIT || numbersBetween < answer){
        answer = numbersBetween;
      }
    }
    return answer;
  }


  private List<Integer> removeDuplicatesAndSort(List<Integer> list){
    List<Integer> sortedList = new ArrayList<>();
    for (int element : list) {
      if (element >= 0) {
        if (sortedList.size() == 0) {
          sortedList.add(element);
        } else {
          int index = findPlace(sortedList, element, 0, sortedList.size() - 1);
          if (index >= 0) {
            sortedList.add(index, element);
          }
        }
      }
    }
    return sortedList;
  }


  private int findPlace(List<Integer> list, int element, int min, int max ){
    final int REPEATED_VALUE = -1;
    if (min == max){
      if (element < list.get(min)){
        return min;
      }else if (element > list.get(min)){
        return min+1;
      }else {
        return REPEATED_VALUE;
      }
    }
    int index = min+max/2;
    if (element == list.get(index)){
      return REPEATED_VALUE;
    }else if(element > list.get(index)){
      return findPlace(list, element, index+1, max);
    }else{
      return findPlace(list, element, min, index);
    }
   }

}
