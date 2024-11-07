package com.db;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Task2 {

  public static void main(String[] args) {
    if (args.length != 3) {
      throw new RuntimeException("Wrong amount of cmd arguments provided");
    }
    List<HexDecimalContainer> hexDecimalNumbers = getHexNumbers(Integer.parseInt(args[0]), Integer.parseInt(args[1]), Integer.parseInt(args[2]));
    hexDecimalNumbers.forEach(System.out::println);
  }

  public static List<HexDecimalContainer> getHexNumbers(int min, int max, int step) {
    if (step <= 0) {
      throw new RuntimeException("Step must be a positive number");
    }
    List<HexDecimalContainer> result = new ArrayList<>();
    for (int i = min; i <= max; i += step) {
      result.add(new HexDecimalContainer(i, Integer.toHexString(i).toUpperCase()));
    }
    return result;
  }

  public record HexDecimalContainer(Integer decimalNumber, String hexNumber) {

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;

      HexDecimalContainer that = (HexDecimalContainer) o;
      return Objects.equals(hexNumber, that.hexNumber) && Objects.equals(decimalNumber, that.decimalNumber);
    }

    @Override
    public int hashCode() {
      int result = Objects.hashCode(decimalNumber);
      result = 31 * result + Objects.hashCode(hexNumber);
      return result;
    }

    @Override
    public String toString() {
      return String.format("Decimal value is: %d , hex values is %s", this.decimalNumber, this.hexNumber);
    }
  }
}
