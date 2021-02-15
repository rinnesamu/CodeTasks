package leastnumbersbetween;

import java.util.ArrayList;
import java.util.List;

public class LeastNumbersBetween {

  public int getLeastNumbersBetween(List<Integer> originalList){
    if (originalList == null){
      return 0;
    }
    List<Integer> list = removeDuplicatesAndSort(originalList);
    int answer = -1;
    /*
    Init ans to negative, because there cannot be negative
    amount of numbers between
     */
    if (list.size() < 2){
      return 0;
    }

    for (int i = 0; i < list.size()-1; i++){
      int numbersBetween = Math.abs(list.get(i) - list.get(i+1)) -1;
      if (answer < 0 || numbersBetween < answer){
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
    if (min == max){
      if (element < list.get(min)){
        return min;
      }else if (element > list.get(min)){
        return min+1;
      }else {
        return -1;
      }
    }
    int index = min+max/2;
    if (element == list.get(index)){
      return -1;
    }else if(element > list.get(index)){
      return findPlace(list, element, index+1, max);
    }else{
      return findPlace(list, element, min, index);
    }
   }

}
