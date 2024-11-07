package com.db;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class Task2Test {

  @Test
  public void testGetHexNumbersPositive() {
    int min = 0, max = 10, step = 1;
    List<String> expectedHexNumbers = List.of("0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A");
    List<Integer> expectedNumbers = List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    List<Task2.HexDecimalContainer> expectedContainers = new ArrayList<>();

    for (int i = 0; i < expectedNumbers.size(); i++) {
      expectedContainers.add(new Task2.HexDecimalContainer(expectedNumbers.get(i), expectedHexNumbers.get(i)));
    }

    Assertions.assertEquals(expectedContainers, Task2.getHexNumbers(min, max, step));
  }

  @Test
  void testGetHexNumbersBigNumbersPositive() {
    int min = 0, max = 5321, step = 137;
    List<String> expectedHexNumbers = List.of(
        "0", "89", "112", "19B", "224", "2AD", "336", "3BF", "448", "4D1",
        "55A", "5E3", "66C", "6F5", "77E", "807", "890", "919", "9A2", "A2B",
        "AB4", "B3D", "BC6", "C4F", "CD8", "D61", "DEA", "E73", "EFC", "F85",
        "100E", "1097", "1120", "11A9", "1232", "12BB", "1344", "13CD", "1456"
    );
    List<Integer> expectedNumbers = List.of(
        0, 137, 274, 411, 548, 685, 822, 959, 1096, 1233,
        1370, 1507, 1644, 1781, 1918, 2055, 2192, 2329, 2466, 2603,
        2740, 2877, 3014, 3151, 3288, 3425, 3562, 3699, 3836, 3973,
        4110, 4247, 4384, 4521, 4658, 4795, 4932, 5069, 5206
    );
    List<Task2.HexDecimalContainer> expectedContainers = new ArrayList<>();
    for (int i = 0; i < expectedNumbers.size(); i++) {
      expectedContainers.add(new Task2.HexDecimalContainer(expectedNumbers.get(i), expectedHexNumbers.get(i)));
    }

    Assertions.assertEquals(expectedContainers, Task2.getHexNumbers(min, max, step));
  }

  @Test
  void testGetHexNumbersWrongStep() {
    int min = 0, max = 5321, step = -1;

    Assertions.assertThrows(RuntimeException.class, () -> Task2.getHexNumbers(min, max, step));
  }


}
