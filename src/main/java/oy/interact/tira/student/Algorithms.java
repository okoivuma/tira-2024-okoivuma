package oy.interact.tira.student;

import java.util.Comparator;

public class Algorithms {

   private Algorithms() {
      // nada
   }

   ///////////////////////////////////////////
   // Insertion Sort for the whole array
   ///////////////////////////////////////////

   public static <T extends Comparable<T>> void insertionSort(T[] array) {

      insertionSort(array, 0, array.length);
      
   }

   ///////////////////////////////////////////
   // Insertion Sort for a slice of the array
   ///////////////////////////////////////////

   public static <T extends Comparable<T>> void insertionSort(T[] array, int fromIndex, int toIndex) {
      
      // fromindex + 1 because no need to compare first value with itself
      for (int i = fromIndex + 1; i < toIndex; i++) {
         int index = i;
         while (index > fromIndex && array[index-1].compareTo(array[index]) > 0) {
            MyClass.swap(array, index, index - 1);
            index--;
         }
      }
   }

   //////////////////////////////////////////////////////////
   // Insertion Sort for the whole array using a Comparator
   //////////////////////////////////////////////////////////

   public static <T> void insertionSort(T[] array, Comparator<T> comparator) {      
      insertionSort(array, 0, array.length, comparator);
   }

   ////////////////////////////////////////////////////////////
   // Insertion Sort for slice of the array using a Comparator
   ////////////////////////////////////////////////////////////

   public static <T> void insertionSort(T[] array, int fromIndex, int toIndex, Comparator<T> comparator) {
      for (int i = fromIndex + 1; i < toIndex; i++) {
         int index = i;
         while (index > fromIndex && comparator.compare(array[index - 1], array[index]) > 0) {
            MyClass.swap(array, index, index - 1);
            index--;
         }
      }
   }

   ///////////////////////////////////////////
   // Reversing an array
   ///////////////////////////////////////////

   public static <T> void reverse(T[] array) {
      reverse(array, 0, array.length);
   }

   ///////////////////////////////////////////
   // Reversing a slice of an array
   ///////////////////////////////////////////

   public static <T> void reverse(T[] array, int fromIndex, int toIndex) {
     
      int leftIndex = fromIndex;
      int rightIndex = toIndex - 1;

      while (leftIndex < rightIndex) {
         MyClass.swap(array, leftIndex, rightIndex);
         rightIndex--;
         leftIndex++;
      }
   }


   ///////////////////////////////////////////
   // Recursive binary search bw indices
   ///////////////////////////////////////////

   public enum BSearchImplementation {
      RECURSIVE,
      ITERATIVE
   }

   public static <T extends Comparable<T>> int binarySearch(T aValue, T[] fromArray, int fromIndex, int toIndex) {
      return binarySearchRecursive(aValue, fromArray, fromIndex, toIndex - 1);
   }

   public static <T extends Comparable<T>> int binarySearch(T aValue, T[] fromArray, int fromIndex, int toIndex, BSearchImplementation impl) {
      if (impl == BSearchImplementation.RECURSIVE) {
         return binarySearchRecursive(aValue, fromArray, fromIndex, toIndex - 1);
      }
      if (impl == BSearchImplementation.ITERATIVE) {
         return binarySearchIterative(aValue, fromArray, fromIndex, toIndex);
      }
      return -1;
   }


   // Lähde: luentomateriaalin pseudokoodi
   public static <T extends Comparable<T>> int binarySearchRecursive(T aValue, T[] fromArray, int fromIndex, int toIndex) {
     if (fromIndex == toIndex) {
         if (fromArray[fromIndex].equals(aValue)) {
            return fromIndex;
         } else {
            return -1;
         }
     }
      int middle = fromIndex + (toIndex - fromIndex) / 2;

      if (aValue.compareTo(fromArray[middle]) <= 0 ) {
         return binarySearchRecursive(aValue, fromArray, fromIndex, middle);
      } else {
         return binarySearchRecursive(aValue, fromArray, middle + 1, toIndex);
      }
   }

   // iteratiivinen toteutus Combarablea käyttäen

   public static <T extends Comparable<T>> int binarySearchIterative(T aValue, T[] fromArray, int fromIndex, int toIndex) {
      int middle = 0;

      while (fromIndex != toIndex) {

         middle = fromIndex + (toIndex - fromIndex) / 2;

         if (aValue.compareTo(fromArray[middle]) < 0) {
            toIndex = middle - 1;
         } else if (aValue.compareTo(fromArray[middle]) > 0){
            fromIndex = middle + 1;
         } else {
            return middle;
         }
      }

      if (fromIndex < fromArray.length && aValue.equals(fromArray[fromIndex])) {
         return fromIndex;
      }
      return -1;
   }

   ///////////////////////////////////////////
   // Binary search using a Comparator
   ///////////////////////////////////////////

   public static <T> int binarySearch(T aValue, T[] fromArray, int fromIndex, int toIndex, Comparator<T> comparator) {
      return binarySearchRecursive(aValue, fromArray, fromIndex, toIndex, comparator);
   }

   public static <T> int binarySearch(T aValue, T[] fromArray, int fromIndex, int toIndex, Comparator<T> comparator, BSearchImplementation impl) {
      if (impl == BSearchImplementation.RECURSIVE) {
         return binarySearchRecursive(aValue, fromArray, fromIndex, toIndex - 1, comparator);
      }
      if (impl == BSearchImplementation.ITERATIVE) {
         return binarySearchIterative(aValue, fromArray, fromIndex, toIndex, comparator);
      }
      return -1;
   }

   public static <T> int binarySearchRecursive(T aValue, T[] fromArray, int fromIndex,
         int toIndex, Comparator<T> comparator) {
      
      if (fromIndex == toIndex) {
         if (comparator.compare(aValue, fromArray[fromIndex]) == 0) {
            return fromIndex;
         } else {
            return -1;
         }
      }     
      
      int middle = fromIndex + (toIndex - fromIndex) / 2;

      if (comparator.compare(aValue, fromArray[middle]) <= 0) {
         return binarySearchRecursive(aValue, fromArray, fromIndex, middle, comparator);
      } else {
         return binarySearchRecursive(aValue, fromArray, middle + 1, toIndex, comparator);
      }
   }

   public static <T> int binarySearchIterative(T aValue, T[] fromArray, int fromIndex, int toIndex, Comparator<T> comparator) {
      int middle = 0;

      while (fromIndex != toIndex) {

         middle = fromIndex + (toIndex - fromIndex) / 2;

         if (comparator.compare(aValue, fromArray[middle]) < 0) {
            toIndex = middle - 1;
         } else if (comparator.compare(aValue, fromArray[middle]) > 0){
            fromIndex = middle +1;
         } else {
            return middle;
         }
      }
      if (comparator.compare(aValue, fromArray[fromIndex]) == 0) {
         return fromIndex;
      }
      return -1;
   }

   public enum FastSortAlgorithm {
      QUICKSORT,
      HEAPSORT,
      MERGESORT
   }

   public static <E> void fastSort(E[] array, Comparator<E> comparator) {
      fastSort(array, 0, array.length, comparator, FastSortAlgorithm.QUICKSORT);
   }

   public static <E extends Comparable<E>> void fastSort(E[] array) {
      fastSort(array, 0, array.length, Comparator.naturalOrder(), FastSortAlgorithm.QUICKSORT);
   }

   public static <E> void fastSort(E[] array, int fromIndex, int toIndex, Comparator<E> comparator) {
      fastSort(array, fromIndex, toIndex, comparator, FastSortAlgorithm.QUICKSORT);
   }

   public static <E> void fastSort(E[] array, int fromIndex, int toIndex, Comparator<E> comparator, FastSortAlgorithm algorithm) {
      switch (algorithm) {
         case QUICKSORT:
            // TODO: Call your quicksort algorithm here.
            break;
         case HEAPSORT:
            // TODO: IF implementing heapsort, call your algorithm here.
            break;
         case MERGESORT:
            // TODO: IF implementing mergesort, call your algorithm here.
            break;
         default:
            break;
      }
   }

} // End of class Algorithms
