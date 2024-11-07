package com.db;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Task14Test {

  @Test
  public void testEncryptDecryptBasic() {
    String text = "HELLO";
    String key = "XMCKL";
    String encryptedText = Task14.encrypt(text, key);
    String decryptedText = Task14.decrypt(encryptedText, key);


    Assertions.assertNotEquals(text, encryptedText);
    Assertions.assertEquals(text, decryptedText);
  }

  @Test
  public void testEncryptDecryptWithSpecialChars() {
    String text = "HELLO123!";
    String key = "XMCKL123@";
    String encryptedText = Task14.encrypt(text, key);
    String decryptedText = Task14.decrypt(encryptedText, key);

    Assertions.assertNotEquals(text, encryptedText);
    Assertions.assertEquals(text, decryptedText);
  }

  @Test
  public void testEncryptEmptyText() {
    String text = "";
    String key = "";
    String encryptedText = Task14.encrypt(text, key);
    String decryptedText = Task14.decrypt(encryptedText, key);

    Assertions.assertEquals("", encryptedText);
    Assertions.assertEquals("", decryptedText);
  }

  @Test
  public void testKeyLengthMismatchInEncrypt() {
    String text = "HELLO";
    String key = "DIFFERENT";
    IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> Task14.encrypt(text, key));

    Assertions.assertEquals("Key length must match text length.", thrown.getMessage());
  }

}
