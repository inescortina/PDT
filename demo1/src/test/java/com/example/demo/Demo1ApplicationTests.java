package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Demo1ApplicationTests {

  @Test
  public void test_totals() {
    assertEquals(0, PriceCalculator.getTotalPrice(""));
    assertEquals(50, PriceCalculator.getTotalPrice("A"));
    assertEquals(80, PriceCalculator.getTotalPrice("AB"));
    assertEquals(115, PriceCalculator.getTotalPrice("CDBA"));

    assertEquals(100, PriceCalculator.getTotalPrice("AA"));
    assertEquals(130, PriceCalculator.getTotalPrice("AAA"));
    assertEquals(180, PriceCalculator.getTotalPrice("AAAA"));
    assertEquals(230, PriceCalculator.getTotalPrice("AAAAA"));
    assertEquals(260, PriceCalculator.getTotalPrice("AAAAAA"));

    assertEquals(160, PriceCalculator.getTotalPrice("AAAB"));
    assertEquals(175, PriceCalculator.getTotalPrice("AAABB"));
    assertEquals(190, PriceCalculator.getTotalPrice("AAABBD"));
    assertEquals(190, PriceCalculator.getTotalPrice("DABABA"));
  }

}
