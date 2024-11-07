package com.db;

public class Task38 {
  public static void main(String[] args) {
    if (args.length == 0) {
      System.out.println("No arguments provided.");
      return;
    }
    System.out.println("Number of arguments provided: " + args.length);
    System.out.println("Arguments:");
    for (String arg : args) {
      System.out.println(arg);
    }
    int binaryCount = 0;
    System.out.println("Converted arguments:");
    for (String arg : args) {
      if (isBinary(arg)) {
        binaryCount++;
        String paddedBinary = padBinary(arg);
        String hexValue = binaryToHex(paddedBinary);
        System.out.printf("Binary: %s -> Hexadecimal: %s%n", arg, hexValue);
      } else {
        System.out.printf("String: %s%n", arg);
      }
    }
    System.out.println("Number of numeric arguments (binary): " + binaryCount);
  }

  public static boolean isBinary(String arg) {
    return arg.matches("[01]+");
  }

  public static String padBinary(String binary) {
    int length = binary.length();
    int paddingLength = 4 - (length % 4);
    if (paddingLength != 4) {
      binary = "0".repeat(paddingLength) + binary;
    }
    return binary;
  }

  public static String binaryToHex(String binary) {
    StringBuilder hex = new StringBuilder();
    for (int i = 0; i < binary.length(); i += 4) {
      String fourBits = binary.substring(i, i + 4);
      int decimal = Integer.parseInt(fourBits, 2);
      hex.append(Integer.toHexString(decimal).toUpperCase());
    }
    return hex.toString();
  }
}
