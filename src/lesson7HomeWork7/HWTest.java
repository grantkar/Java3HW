package lesson7HomeWork7;

public class HWTest {



    @BeforeSuit (priority = 1)
    public static void testBeforeSuit(){
        System.out.println("test BeforeSuit");
    }

    @AfterSuit(priority = 2)
    public static void testAfterSuit(){
        System.out.println("test AfterSuit");
    }
   // @AfterSuit(priority = 9)                        // проверка на одну аннотацию
   // public static void testAfterSuit2(){
   //     System.out.println("test AfterSuit");
   // }

    @Test(priority = 3)
    public static void test1(){
        System.out.println("test1");
    }

    @Test(priority = 7)
    public static void test2(){
        System.out.println("test7");
    }

    @Test(priority = 8)
    public static void test3(){
        System.out.println("test8");
    }

    @Test(priority = 4)
    public static void test4(){
        System.out.println("test4");
    }

    @Test(priority = 5)
    public static void test5(){
        System.out.println("test5");
    }

    @Test(priority = 6)
    public static void test6(){
        System.out.println("test6");
    }
}
