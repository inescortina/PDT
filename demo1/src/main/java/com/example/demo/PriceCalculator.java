package com.example.demo;

import java.util.HashMap;
import java.util.Map;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PriceCalculator {

  public static void main(String[] args) {
//    String input = "AABCBADD";
    String input = null;
getTotalPrice(input);

  }

  public static Integer getTotalPrice(String input) {
    Map<Character, Integer> productCountMap = countProducts(input);
    Map<String, Integer> pricingMap = getPricing();
    Map<String, Integer> offerNumOfProductsMap = getOfferNumOfProducts();
    Map<String, Integer> offerPriceMap = getOfferPrice();
    Map<String, Integer> modifiedMap = modifyMapValues(productCountMap, pricingMap,
        offerNumOfProductsMap, offerPriceMap);
    Integer totalPrice = sumPrice(modifiedMap);

//    System.out.println("Product count: " + productCountMap);
//    System.out.println("Price: " + modifiedMap);
//    System.out.println("Total price: " + totalPrice);
    return totalPrice;
  }

  public static Map<Character, Integer> countProducts(String input) {
    Map<Character, Integer> productCountMap = new HashMap<>();

    for (char c : input.toCharArray()) {
      if (Character.isLetter(c)) {
        c = Character.toLowerCase(c);
        productCountMap.put(c, productCountMap.getOrDefault(c, 0) + 1);
      }
    }

    return productCountMap;
  }

  public static Map<String, Integer> getPricing() {
    Map<String, Integer> pricingMap = new HashMap<>();
    pricingMap.put("a", 50);
    pricingMap.put("b", 30);
    pricingMap.put("c", 20);
    pricingMap.put("d", 15);
    return pricingMap;
  }

  public static Map<String, Integer> getOfferNumOfProducts() {
    Map<String, Integer> offerNumOfProductsMap = new HashMap<>();
    offerNumOfProductsMap.put("a", 3);
    offerNumOfProductsMap.put("b", 2);
    return offerNumOfProductsMap;
  }

  public static Map<String, Integer> getOfferPrice() {
    Map<String, Integer> offerPriceMap = new HashMap<>();
    offerPriceMap.put("a", 130);
    offerPriceMap.put("b", 45);
    return offerPriceMap;
  }

  public static Boolean hasOffer(String product) {
   if (product.equals("a")) {
     return true;
    }
     else if (product.equals("b")) {
      return true;
    }
   else if (product.equals("d")) {
      return false;
    }
    else if (product.equals("c")) {
      return false;
    }
    else {
      return false;
   }
  }

  public static Map<String, Integer> modifyMapValues(Map<Character, Integer> map,
                                                     Map <String, Integer> pricingMap,
                                                     Map <String, Integer> offerNumOfProductsMap,
                                                     Map <String, Integer> offerPriceMap
                                                     ) {
    Map<String, Integer> modifiedMap = new HashMap<>();

    for (Map.Entry<Character, Integer> entry : map.entrySet()) {
      String key = entry.getKey().toString();
      Integer value = entry.getValue();
      modifiedMap.put(key, value);
    }

    for (String key : modifiedMap.keySet()) {
      int value = modifiedMap.get(key);

      if (hasOffer(key) && key.equals(key) && value >= offerNumOfProductsMap.get(key) ) {
        modifiedMap.put(key, (value/offerNumOfProductsMap.get(key)*offerPriceMap.get(key) +
            ((value - ((offerNumOfProductsMap.get(key) * (value / offerNumOfProductsMap.get(key) )))) * pricingMap.get(key))));
      } else if (hasOffer(key) && key.equals(key) && value < offerNumOfProductsMap.get(key)) {
        modifiedMap.put(key, pricingMap.get(key) * value);
      }

      if (!hasOffer(key) && key.equals(key)) {
        modifiedMap.put(key, pricingMap.get(key) * value);
      }
    }
    return modifiedMap;
  }

  public static Integer sumPrice(final Map<String, Integer> modifiedMap) {
    int totalSum = 0;
    for (String key : modifiedMap.keySet()) {
      int value = modifiedMap.get(key);
      totalSum += value;
    }
    return totalSum;
  }

}
