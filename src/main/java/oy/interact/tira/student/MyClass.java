package oy.interact.tira.student;

public class MyClass {
    
    private MyClass() {

    }

    public static <T> void swap (T[] array, int first, int second) {

        T temp = array[first];

        array[first] = array[second];
        array[second] = temp;
    } 
}
