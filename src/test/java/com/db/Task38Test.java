package com.db;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Task38Test {

  @Test
  void testIsBinaryWithBinaryString() {
    assertTrue(Task38.isBinary("1010"), "Expected binary string to be recognized as binary");
  }

  @Test
  void testIsBinaryWithNonBinaryString() {
    assertFalse(Task38.isBinary("102"), "Expected non-binary string to be recognized as not binary");
    assertFalse(Task38.isBinary("abc"), "Expected non-binary string to be recognized as not binary");
  }

  @Test
  void testIsBinaryWithEmptyString() {
    assertFalse(Task38.isBinary(""), "Expected empty string to be recognized as not binary");
  }

  @Test
  void testPadBinaryWithAlreadyPaddedBinary() {
    assertEquals("1010", Task38.padBinary("1010"), "Expected no padding for already padded binary");
  }

  @Test
  void testPadBinaryWithShortBinary() {
    assertEquals("0001", Task38.padBinary("1"), "Expected binary to be padded to '0001'");
    assertEquals("0010", Task38.padBinary("10"), "Expected binary to be padded to '0010'");
    assertEquals("0110", Task38.padBinary("110"), "Expected binary to be padded to '0110'");
  }

  @Test
  void testBinaryToHexWithValidBinary() {
    assertEquals("A", Task38.binaryToHex("1010"), "Expected binary '1010' to convert to hex 'A'");
    assertEquals("F", Task38.binaryToHex("1111"), "Expected binary '1111' to convert to hex 'F'");
    assertEquals("0", Task38.binaryToHex("0000"), "Expected binary '0000' to convert to hex '0'");
  }

  @Test
  void testBinaryToHexWithLongBinary() {
    assertEquals("2A", Task38.binaryToHex("00101010"), "Expected binary '00101010' to convert to hex '2A'");
    assertEquals("3F4", Task38.binaryToHex("001111110100"), "Expected binary '001111110100' to convert to hex '3F4'");
  }

  @Test
  void testPadBinaryWithBinaryThatNeedsPadding() {
    assertEquals("0001", Task38.padBinary("1"), "Expected padding to make binary '1' into '0001'");
    assertEquals("0011", Task38.padBinary("11"), "Expected padding to make binary '11' into '0011'");
    assertEquals("0111", Task38.padBinary("111"), "Expected padding to make binary '111' into '0111'");
  }

  @Test
  void testBinaryToHexWithComplexBinary() {
    assertEquals("7E", Task38.binaryToHex("01111110"), "Expected binary '01111110' to convert to hex '7E'");
    assertEquals("3E8", Task38.binaryToHex("001111101000"), "Expected binary '001111101000' to convert to hex '3E8'");
  }
}
