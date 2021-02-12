package leastnumbersbetween;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LeastNumbersBetweenTest {

  LeastNumbersBetween least = new LeastNumbersBetween();
  List<Integer> list;
  @BeforeEach
    void initEach(){
      list = new ArrayList<>();
  }


  @Test
  @DisplayName("Testing with paramter null")
  void testNoList(){
    assertEquals(-1, least.getLeastNumbersBetween(null),
      "Error with null parameter");
  }

  @Test
  @DisplayName("Testing with empty list")
  void testEmptyList(){
    assertEquals(-1, least.getLeastNumbersBetween(list),
      "Error with empty list");
  }

  @Test
  @DisplayName("Testing with only one item in list")
  void tesWithOneItem(){
    list.add(2);
    assertEquals(0, least.getLeastNumbersBetween(list),
      "Error with only one item in list");
  }

  @Test
  @DisplayName("Testing with exactly two items in list")
  void tesWithTwoItem(){
    list.add(2);
    list.add(2);
    assertEquals(0, least.getLeastNumbersBetween(list),
      "Error with exactly two items in list");

    list = new ArrayList<>();
    list.add(100);
    list.add(1000);
    assertEquals(899, least.getLeastNumbersBetween(list),
      "Error with exactly two items in list");
  }


  @Test
  @DisplayName("Testing with zero in list")
  void tesWithZero(){
    list.add(0);
    assertEquals(0, least.getLeastNumbersBetween(list),
      "Error with only zero in list");

    list = new ArrayList<>();
    list.add(0);
    list.add(50);
    list.add(100);
    list.add(25);
    assertEquals(24, least.getLeastNumbersBetween(list),
      "Error with zero in list");
  }

  @Test
  @DisplayName("Testing list with multiple same values in it")
  void testWithMultipleSameItems(){
    list.add(2);
    list.add(7);
    list.add(11);
    list.add(2);
    list.add(9);
    assertEquals(0, least.getLeastNumbersBetween(list),
      "Error with multiple same values in list");

    list = new ArrayList<>();
    list.add(2);
    list.add(7);
    list.add(2);
    list.add(7);
    list.add(4);
    list.add(4);
    assertEquals(0, least.getLeastNumbersBetween(list),
      "Error with multiple same values in list");
  }

  @Test
  @DisplayName("Testing list with multiple same intervals in it")
  void testSameIntervals(){
    list.add(2);
    list.add(4);
    list.add(6);
    list.add(9);
    assertEquals(1, least.getLeastNumbersBetween(list),
      "Error with multiple same intervals");

    list = new ArrayList<>();
    list.add(10);
    list.add(20);
    list.add(30);
    list.add(35);
    assertEquals(4, least.getLeastNumbersBetween(list),
      "Error with multiple same intervals");
  }

  @Test
  @DisplayName("Testing list in ascending order")
  void testAscendingOrder(){
    list.add(1);
    list.add(11);
    list.add(19);
    list.add(45);
    assertEquals(7, least.getLeastNumbersBetween(list),
      "Error with ascending order");
  }

  @Test
  @DisplayName("Testing list in descending order")
  void testDescendingOrder(){
    list.add(123);
    list.add(100);
    list.add(88);
    list.add(14);
    assertEquals(11, least.getLeastNumbersBetween(list),
      "Error descending order");
  }

  @Test
  @DisplayName("Testing list in 'random' order")
  void testSmallestBetweenFirstAndLast(){
    list.add(11);
    list.add(275);
    list.add(456);
    list.add(2);
    assertEquals(8, least.getLeastNumbersBetween(list),
      "Error when least numbers bewtween first and last");
  }

  @Test
  @DisplayName("Testing list in 'random' order")
  void testRandomOrder(){
    list.add(26573);
    list.add(11342);
    list.add(333222111);
    list.add(5800000);
    list.add(13275);
    assertEquals(1932, least.getLeastNumbersBetween(list),
      "Error with random big numbers");
  }



}