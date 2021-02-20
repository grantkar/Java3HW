package lesson7HomeWork7;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.TreeMap;

public class MainTest {

    public static void start(Class <?> c ){

        Map <Integer, Method> map = new TreeMap<>();

        for (Method method : c.getDeclaredMethods()) {

            if (method.getAnnotation(BeforeSuit.class) !=null){
                BeforeSuit before = method.getAnnotation(BeforeSuit.class);
                if (before.priority()==1) {
                    map.put(before.priority(), method);
                }
                else {
                    throw new RuntimeException();
                }
            }
            if (method.getAnnotation(AfterSuit.class) != null){
                AfterSuit after = method.getAnnotation(AfterSuit.class);
                if (after.priority()==2) {
                    map.put(after.priority(), method);
                }
                else {
                    throw new RuntimeException();
                }
            }
            if (method.getAnnotation(Test.class) != null){
                Test test = method.getAnnotation(Test.class);
                map.put(test.priority(),method);    // автоматическая сортировка по ключу priority
            }
        }

        HWTest hwTest = new HWTest();
        for (Integer i : map.keySet()) {
            try {
                map.get(i).invoke(hwTest);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
        start(HWTest.class);
    }
}
