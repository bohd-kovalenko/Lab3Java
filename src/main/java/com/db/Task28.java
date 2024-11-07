package com.db;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Task28 {
  public static void main(String[] args) {
    if (args.length == 0) {
      throw new IllegalArgumentException("No arguments present");
    }
    System.out.println("Arguments count: " + args.length);
    System.out.println("Arguments:");
    for (String arg : args) {
      System.out.println(arg);
    }
    String uniqueChars = getUniqueChars(args);
    if (!uniqueChars.isEmpty()) {
      System.out.println("Symbols, that are met only in a single argument: " + uniqueChars);
    } else {
      System.out.println("There are no symbols, that are met only in a single argument");
    }
  }

  public static String getUniqueChars(String[] args) {
    Map<Character, Integer> charCount = new HashMap<>();
    for (String arg : args) {
      Set<Character> uniqueCharsInArg = new HashSet<>();
      for (char c : arg.toCharArray()) {
        uniqueCharsInArg.add(c);
      }
      for (char c : uniqueCharsInArg) {
        charCount.put(c, charCount.getOrDefault(c, 0) + 1);
      }
    }
    StringBuilder uniqueChars = new StringBuilder();
    for (Map.Entry<Character, Integer> entry : charCount.entrySet()) {
      if (entry.getValue() == 1) {
        uniqueChars.append(entry.getKey());
      }
    }
    return uniqueChars.toString();
  }
}
