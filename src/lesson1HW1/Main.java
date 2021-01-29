package lesson1HW1;

import com.sun.org.apache.xpath.internal.operations.Or;

import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        ArrayList <Object> arrayList = new ArrayList<>();


           //  Первая задача

        String [] arr = {"asd","123","asfg","dfg","lskjlk","234"};
        Integer [] arr1 = {1,2,3,4,5,6};

        swapArrElem(arr,0,4);
        swapArrElem(arr1,1,4);

          // Вторая задача

        arrayToArrayList(arr, arrayList);
        // Можно конечно использовать просто метод asList ну раз в задании написанно что сделать метод сделали метод))

        //  Третья задача

        Box <Orange> box1 = new Box();
        Box <Apple> box2 = new Box();

        for (int i = 0; i < 10; i++) {
            box1.addToBox(new Orange()); // добавляем 10 апельсинов в коробку
            box2.addToBox(new Apple());  // добавляем 10 яблок в коробку
        }

        System.out.println(box1.getWeightBox()); // Вес коробки с апельсинами
        System.out.println(box2.getWeightBox()); // Вес коробки с яблоками

        System.out.println(box1.compareBox(box2)); // Сравниваем вес первой коробки со второй

           Box <Apple> box3 = new Box(); // Создаем новую пустую коробку для хранения яблок
           box2.pouringFromBox(box3); // Пересыпаем содержимое с box2 в box3
        System.out.println(box2.getWeightBox());
        System.out.println(box3.getWeightBox());

        //  box1.addToBox(new Apple()); (нельзя добавить апельсины в коробку с яблоками )
        //  box1.pouringFromBox(box3); (Нельзя пересыпать содержимое коробки с апельсинами в коробку с яблоками )


    }


    public static void swapArrElem(Object [] arr, int i, int j){  //метод перемены местами двух элементов в массиве объектов
        Object o = arr[i];
        arr[i]=arr[j];
        arr[j]=o;
        System.out.println(Arrays.toString(arr));
    }

    public static void arrayToArrayList(Object [] arr, ArrayList <Object> arrayList){

        Collections.addAll(arrayList,arr);  // Метод преобразования (в нашем случае добавления) массива объектов в Arraylist
        System.out.println(arrayList);
    }

}
