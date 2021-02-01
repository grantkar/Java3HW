package lesson1HW1;

import java.util.*;

public class Box <T extends Fruit> {

    private ArrayList<T> box = new ArrayList<>(); // Создаем ArrayList для хранения данных коробки

    public Box() {

    }

    public ArrayList<T> getBox() {
        return box;
    }

    public float getWeightBox(){   //  Высчитываем вес коробки
        float weight = 0.0f;
        for (T fruit : box) {
            weight += fruit.getWeight();
        }
        return weight;
    }

    public boolean compareBox(Box <?> another){  //  Сравнивание месов коробок между собой

     return Math.abs(getWeightBox()-another.getWeightBox()) < 0.0001;  // Высчитываем модуль разности и сравниваем
                                                                      //   с незначительно маленьким числом
    }

    public void pouringFromBox(Box <T> anotherBox){ // пересыпание из одной коробки в другую (если типы коробок одинаковые)
        anotherBox.box.addAll(box);
        box.clear();
    }

    public void addToBox(T fruit){  // Добавление одного фрукта в нашу коробку

            box.add(fruit);
    }

}
