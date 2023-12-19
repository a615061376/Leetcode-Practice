package Demo01;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DishApp {

    // 提前準備一些菜品，展示給用戶，同時用戶可以點菜
    // 定義集合(表示飯店有的菜品)
    static List<Dish> dishList = new ArrayList<>();

    // 用戶已點的菜品集合
    static List<Dish> personDish = new ArrayList<>();

    public static void main(String[] args) {

        // 初始化菜品方法
        initDish();

        // 創建掃描器對象，獲取到控制台輸入的內容
        Scanner sc = new Scanner(System.in);

        // 寫死循環 (為了持續執行)
        while (true) {
            // 展示主菜單方法
            showMenu();
            // 獲取內容
            int num = sc.nextInt();
            // 判斷用戶輸入的數字
            switch (num) {
                case 1:
                    // 為了不跳回大的while循環
                    while (true) {
                        // 飯店菜單顯示方法
                        showDishMenu();
                        // 獲取內容
                        int id = sc.nextInt();
                        // 判斷
                        if (id ==0) {
                            break;
                        }
                        //從集合中取得菜品對象
                        Dish dish = dishList.get(id - 1);
                        System.out.println("您點了" + dish.name);
                        personDish.add(dish);
                    }
                case 2:
                    // 展示已點菜品方法
                    showPersonDish();
                    break;
                case 3:
                    // 買單方法
                    buy();
                    break;
            }
        }
    }

    // 初始化菜品
    public static void initDish() {
        Dish dish = new Dish(1,"魚香肉絲",29.0);
        dishList.add(dish);
        Dish dish2 = new Dish(2,"番茄炒蛋",20.0);
        dishList.add(dish2);
        Dish dish3 = new Dish(3,"燉五花肉",45.0);
        dishList.add(dish3);
        dishList.add(new Dish(4,"佛跳牆",89.0));
        dishList.add(new Dish(5,"椒鹽蝦",50.0));
    }

    // 展示主菜單
    public static void showMenu() {
        System.out.println("----主菜單----");
        System.out.println("菜單\t\t\t 1");
        System.out.println("已點菜品\t\t 2");
        System.out.println("買單\t\t\t 3");
        System.out.println("----根據編號請選擇服務----");
    }

    // 飯店菜單顯示
    public static void showDishMenu() {
        System.out.println("----請您點菜----");
        // 遍歷集合
        for (Dish dish : dishList) {
            System.out.println(dish.id + "\t" + dish.name + "\t" + dish.price);
        }
        System.out.println("----輸入序號點菜，按0返回上一級----");
    }

    // 展示已點菜品
    public static void showPersonDish() {
        System.out.println("----您已點的菜品----");
        for (Dish dish : personDish) {
            System.out.println(dish.id + "\t" + dish.name + "\t" + dish.price);
        }
    }

    // 買單
    public static void buy() {
        System.out.println("----請稍等，正在結算----");
        double total = 0f;
        for (Dish dish : personDish) {
            total += dish.price;
        }
        System.out.println("您本次消費了" + total + "元");
    }
}
