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
         if (fromArray[fromIndex].compareTo(aValue) == 0) { 
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

      if (fromIndex < fromArray.length && aValue.compareTo(fromArray[fromIndex]) == 0) {
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
            quickSort(array, fromIndex, toIndex - 1, comparator);
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

   public static <E> void quickSort(E[] array, int fromIndex, int toIndex, Comparator<E> comparator) {
      if (fromIndex < toIndex) {
         int pIndex = hoarePartition(array, fromIndex, toIndex, comparator);
         quickSort(array, fromIndex, pIndex, comparator);
         quickSort(array, pIndex + 1, toIndex, comparator);
      }
   }
   

   public static <E> void mergeSort(E[] array, int fromIndex, int toIndex, Comparator comparator){
      if (toIndex - fromIndex < 1) {
         return;
      }
      int middle = fromIndex + (toIndex - fromIndex) / 2;

      mergeSort(array, fromIndex, middle, comparator);
      mergeSort(array, middle + 1, toIndex, comparator);

      merge(array, fromIndex, middle, toIndex, comparator);
   }
   

   private static <E> void merge(E[] array, int fromIndex, int middle, int toIndex, Comparator comparator) {
      int lCapacity = middle - fromIndex + 1;
      int rCapacity = toIndex - middle + 1;

      Object[] leftArray = new Object[lCapacity];
      Object[] rightArray = new Object[rCapacity];

      for (int i = 0; i < lCapacity; i++) {
         leftArray[i] = array[fromIndex + i];
      }

      for (int j = 0; j < rCapacity; j++) {
         rightArray[j] = array[middle + 1 + j];
      }

      //TODO yhistä ja kopioi
   }
   /*
   private static <E> int partition(E[] array, int low, int high, Comparator<E> comparator) {
      E pivot = array[high];
      int i = low - 1;

      for (int j = low; j < high; j++){
         if (comparator.compare(array[j], pivot) < 0) {
            i++;
            MyClass.swap(array, i, j);
         }
      }

      MyClass.swap(array, i + 1, high);
      return i + 1;
   }*/

   private static <E> int hoarePartition(E[] array, int low, int high, Comparator<E> comparator) {
      

      E pivot = medianOfThree(array, low, high, comparator);
      int i = low - 1;
      int j = high + 1;
      while (true) {
         do {
            i++;
        } while (comparator.compare(array[i], pivot) < 0);
        
         do {
            j--;
        } while (comparator.compare(array[j], pivot) > 0);

         if (i >= j) {
            return j;
         }

         MyClass.swap(array, i, j);
      }
   }

   private static <E> E medianOfThree(E[] array, int low, int high, Comparator<E> comparator) {
      int middle = low + (high - low) / 2;
   
      if (comparator.compare(array[low], array[middle]) > 0) {
         MyClass.swap(array, low, middle);
      }
      if (comparator.compare(array[low], array[high]) > 0) {
         MyClass.swap(array, low, high);
      }
      if (comparator.compare(array[middle], array[high]) > 0) {
         MyClass.swap(array, middle, high);
      }
      
      return array[middle];
   }

} 
// End of class Algorithms
