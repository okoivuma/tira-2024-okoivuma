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
      // TODO: Implement this.
   }

   ////////////////////////////////////////////////////////////
   // Insertion Sort for slice of the array using a Comparator
   ////////////////////////////////////////////////////////////

   public static <T> void insertionSort(T[] array, int fromIndex, int toIndex, Comparator<T> comparator) {
      // TODO: Implement this.
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
      // TODO: IF implementing iterative binary search, call that here.
      return -1;
   }

   public static <T extends Comparable<T>> int binarySearchRecursive(T aValue, T[] fromArray, int fromIndex, int toIndex) {
      return -1;
   }

   ///////////////////////////////////////////
   // Binary search using a Comparator
   ///////////////////////////////////////////

   public static <T> int binarySearch(T aValue, T[] fromArray, int fromIndex, int toIndex, Comparator<T> comparator) {
      return -1;
   }

   public static <T> int binarySearch(T aValue, T[] fromArray, int fromIndex, int toIndex, Comparator<T> comparator, BSearchImplementation impl) {
      if (impl == BSearchImplementation.RECURSIVE) {
         return binarySearchRecursive(aValue, fromArray, fromIndex, toIndex - 1, comparator);
      }
      // TODO: IF implementing iterative binary search, call that here.
      return -1;
   }

   public static <T> int binarySearchRecursive(T aValue, T[] fromArray, int fromIndex,
         int toIndex, Comparator<T> comparator) {
      // TODO: Recursive implementation
      return -1;
   }

   public static <T> int binarySearchIterative(T aValue, T[] fromArray, int fromIndex, int toIndex, Comparator<T> comparator) {
      // TODO: Iterative implementation if grade interests you:
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
