package com.xuefei.concurrent.king.bronze;

/**
 * @version 1.0
 * @author: xuefei
 * @date: 2022/7/18 6:38 下午
 */
public class Bronze_1 {

    public static void main(String[] args) {
        Thread neZhaPlayer = new Thread() {
            @Override
            public void run() {
                System.out.println("我是哪吒，我去上路");
            }
        };
        Thread anQiLaPlayer = new Thread() {
            @Override
            public void run() {
                System.out.println("我是安其拉，我去中路");
            }
        };
        Thread suLiePlayer = new Thread() {
            @Override
            public void run() {
                System.out.println("我是苏烈，我去下路");
            }
        };
        neZhaPlayer.start();
        anQiLaPlayer.start();
        suLiePlayer.start();
    }


}
