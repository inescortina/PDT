package com.example.katasearch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KataSearchApplication {

  public static void main(String[] args) {
    SpringApplication.run(KataSearchApplication.class, args);

    int[] array = {1, 3, 5, 7, 9};
    int target = 5;

    int index = binarySearchIterative(target, array);

    if (index != -1) {
      System.out.println("The target is found at index: " + index);
    } else {
      System.out.println("The target is not found in the array.");
    }

    int index2 = binarySearchRecursive(target, array);

    if (index2 != -1) {
      System.out.println("The target is found at index: " + index);
    } else {
      System.out.println("The target is not found in the array.");
    }

    int index3 = linearSearch(target, array);

    if (index3 != -1) {
      System.out.println("The target is found at index: " + index);
    } else {
      System.out.println("The target is not found in the array.");
    }

    int index4 = jumpSearch(target, array);

    if (index4 != -1) {
      System.out.println("The target is found at index: " + index);
    } else {
      System.out.println("The target is not found in the array.");
    }

    int index5 = interpolationSearch(target, array);

    if (index5 != -1) {
      System.out.println("The target is found at index: " + index);
    } else {
      System.out.println("The target is not found in the array.");
    }

  }

  public static int binarySearchIterative(int target, int[] array) {
    int left = 0;
    int right = array.length - 1;

    while (left <= right) {
      int mid = left + (right - left) / 2;

      if (array[mid] == target) {
        return mid;
      } else if (array[mid] < target) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }

    return -1;
  }

  public static int binarySearchRecursive(int target, int[] array) {
    return binarySearchRecursiveHelper(target, array, 0, array.length - 1);
  }

  private static int binarySearchRecursiveHelper(int target, int[] array, int left, int right) {
    if (left <= right) {
      int mid = left + (right - left) / 2;

      if (array[mid] == target) {
        return mid;
      } else if (array[mid] < target) {
        return binarySearchRecursiveHelper(target, array, mid + 1, right);
      } else {
        return binarySearchRecursiveHelper(target, array, left, mid - 1);
      }
    }

    return -1;
  }

  public static int linearSearch(int target, int[] array) {
    for (int i = 0; i < array.length; i++) {
      if (array[i] == target) {
        return i;
      }
    }
    return -1;
  }

  public static int jumpSearch(int target, int[] array) {
    int n = array.length;
    int step = (int) Math.floor(Math.sqrt(n));
    int prev = 0;

    while (array[Math.min(step, n) - 1] < target) {
      prev = step;
      step += (int) Math.floor(Math.sqrt(n));
      if (prev >= n) {
        return -1;
      }
    }

    while (array[prev] < target) {
      prev++;
      if (prev == Math.min(step, n)) {
        return -1;
      }
    }

    if (array[prev] == target) {
      return prev;
    }

    return -1;
  }

  public static int interpolationSearch(int target, int[] array) {
    int left = 0;
    int right = array.length - 1;

    while (left <= right && target >= array[left] && target <= array[right]) {
      if (left == right) {
        if (array[left] == target) {
          return left;
        }
        return -1;
      }

      int pos = left + (((right - left) / (array[right] - array[left])) * (target - array[left]));

      if (array[pos] == target) {
        return pos;
      }

      if (array[pos] < target) {
        left = pos + 1;
      } else {
        right = pos - 1;
      }
    }

    return -1;
  }


}
