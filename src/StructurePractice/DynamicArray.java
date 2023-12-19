package StructurePractice;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

public class DynamicArray implements Iterable<Integer>{

    private int size = 0;
    private int capacity = 8;
    private int[] array = {};

    public void addLast(int element) {
        array[size] = element;
        size++;
    }

    public void add(int index, int element) {

        checkAndGrow();

        if (index >= 0 && index < size) {
            System.arraycopy(array, index, array, index + 1, size - index);
        }
        array[index] = element;
        size++;
    }

    private void checkAndGrow() {
        if (size == 0) {
            array = new int[capacity];
        }
        if (size == capacity) {
            // upscale x1.5 x1.618 x2
            capacity += capacity >> 1;
            int[] newArrays = new int[capacity];
            System.arraycopy(array, 0, newArrays,0, size);
            array = newArrays;
        }
    }

    public int get(int index) { // [0...size)
        return array[index];
    }

    // 使用函數式接口 FunctionalInterface
    public void foreach(Consumer<Integer> consumer) {
        for (int i = 0; i < size; i++) {
            consumer.accept(array[i]);
        }
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            int i = 0;

            @Override
            public boolean hasNext() {
                return i < size;
            }

            @Override
            public Integer next() {
                return array[i++];
            }
        };
    }

    public IntStream stream() {
        return IntStream.of(Arrays.copyOfRange(array, 0, size));
    }

    public int remove(int index) {
        int removed = array[index];

        if (index < size - 1) {
            System.arraycopy(array, index + 1, array, index, size - index - 1);
        }
        size--;
        return removed;
    }




    @Test
    @DisplayName("test add and for loop")
    public void test01() {
        DynamicArray dynamicArray = new DynamicArray();
        dynamicArray.addLast(1);
        dynamicArray.addLast(2);
        dynamicArray.addLast(3);
        dynamicArray.addLast(4);
        //dynamicArray.addLast(5);

        dynamicArray.add(2,5);

        for (int i = 0; i < 5; i++) {
            System.out.println(dynamicArray.get(i));
        }

    }

    @Test
    @DisplayName("test foreach loop")
    public void test02() {
        DynamicArray dynamicArray = new DynamicArray();
        dynamicArray.addLast(1);
        dynamicArray.addLast(2);
        dynamicArray.addLast(3);
        dynamicArray.addLast(4);

        //dynamicArray.foreach((element) -> {
        //    System.out.println(element);
        //});

        dynamicArray.foreach(System.out::println);
    }

    @Test
    @DisplayName("test iterator loop")
    public void test03() {
        DynamicArray dynamicArray = new DynamicArray();
        dynamicArray.addLast(1);
        dynamicArray.addLast(2);
        dynamicArray.addLast(3);
        dynamicArray.addLast(4);

        for (Integer element : dynamicArray) {
            System.out.println(element);
        }
    }

    @Test
    @DisplayName("test stream loop")
    public void test04() {
        DynamicArray dynamicArray = new DynamicArray();
        dynamicArray.addLast(1);
        dynamicArray.addLast(2);
        dynamicArray.addLast(3);
        dynamicArray.addLast(4);

//        dynamicArray.stream().forEach(element -> {
//            System.out.println(element);
//        });

        dynamicArray.stream().forEach(System.out::println);
    }

    @Test
    @DisplayName("test remove")
    public void test05() {
        DynamicArray dynamicArray = new DynamicArray();
        dynamicArray.addLast(1);
        dynamicArray.addLast(2);
        dynamicArray.addLast(3);
        dynamicArray.addLast(4);
        dynamicArray.addLast(5);

        int removed = dynamicArray.remove(2);
        System.out.println(removed);
        System.out.println("----");
        dynamicArray.stream().forEach(System.out::println);
    }

//    @Test
//    @DisplayName("test upscale array")
//    public void test06() {
//        DynamicArray dynamicArray = new DynamicArray();
//        for (int i = 0; i < 9; i++) {
//            dynamicArray.addLast(i + 1);
//        }
//        assertIterableEquals(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9), dynamicArray);
//
//    }

}
