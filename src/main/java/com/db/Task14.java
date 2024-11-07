package com.db;

import java.util.Scanner;

public class Task14 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter text for encryption: ");
    String text = scanner.nextLine();
    System.out.print("Enter a key (same length as text): ");
    String key = scanner.nextLine();
    if (text.length() != key.length()) {
      System.out.println("Error: Key length must match text length.");
      return;
    }
    String encryptedText = encrypt(text, key);
    System.out.println("Encrypted text: " + encryptedText);
    String decryptedText = decrypt(encryptedText, key);
    System.out.println("Decrypted text: " + decryptedText);
  }

  public static String encrypt(String text, String key) {
    if (text.length() != key.length()) {
      throw new IllegalArgumentException("Key length must match text length.");
    }
    StringBuilder encryptedText = new StringBuilder();
    for (int i = 0; i < text.length(); i++) {
      char encryptedChar = (char) (text.charAt(i) ^ key.charAt(i));
      encryptedText.append(encryptedChar);
    }
    return encryptedText.toString();
  }

  public static String decrypt(String encryptedText, String key) {
    return encrypt(encryptedText, key);
  }
}
