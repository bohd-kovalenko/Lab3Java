package com.db;

import org.junit.jupiter.api.Test;

import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertTrue;

class Task28Test {
  @Test
  void testSingleArgumentWithUniqueCharacters() {
    String[] args = {"hello"};
    assertTrue(charsEqualIgnoreOrder("helo", Task28.getUniqueChars(args)));
  }

  @Test
  void testMultipleArgumentsWithSomeUniqueCharacters() {
    String[] args = {"apple", "banana", "grape"};
    assertTrue(charsEqualIgnoreOrder("lbnrg", Task28.getUniqueChars(args)));
  }

  @Test
  void testMultipleArgumentsWithNoUniqueCharacters() {
    String[] args = {"hello", "hlo", "hole"};

    assertTrue(charsEqualIgnoreOrder("", Task28.getUniqueChars(args)));
  }

  @Test
  void testArgumentsWithAllUniqueCharacters() {
    String[] args = {"abc", "def", "ghi"};
    assertTrue(charsEqualIgnoreOrder("abcdefghi", Task28.getUniqueChars(args)));
  }

  @Test
  void testEmptyArgument() {
    String[] args = {""};
    assertTrue(charsEqualIgnoreOrder("", Task28.getUniqueChars(args)));
  }

  private boolean charsEqualIgnoreOrder(String str1, String str2) {
    Set<Character> set1 = str1.chars().mapToObj(c -> (char) c).collect(Collectors.toSet());
    Set<Character> set2 = str2.chars().mapToObj(c -> (char) c).collect(Collectors.toSet());
    return set1.equals(set2);
  }
}
