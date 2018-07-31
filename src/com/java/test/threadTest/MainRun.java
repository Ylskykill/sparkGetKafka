package com.java.test.threadTest;

import scala.tools.nsc.transform.patmat.Logic;

public class MainRun {

//        public static void main(String[]args){
//            System.out.println(Thread.currentThread().getName()+"主线程运行开始!");
//            ThreadTest1 thread1 = new ThreadTest1("A");
//            ThreadTest1 thread2 = new ThreadTest1("B");
//            thread1.start();
//            thread2.start();
//            try{
//                thread1.join();
//            }catch (InterruptedException e){
//                e.printStackTrace();
//            }
//            try {
//                thread2.join();
//            }catch (InterruptedException e){
//                e.printStackTrace();
//            }
//            System.out.println(Thread.currentThread().getName()+"主线程运行结束!");
//        }

//    public static void main(String[] args) {
//        new Thread(new ThreadTest2("C")).start();
//        new Thread(new ThreadTest2("D")).start();
//    }


    public static void main(String[] args) {
        Object a = new Object();
        Object b = new Object();
        Object c = new Object();

        SynThread pa = new SynThread("A",c,a);
        SynThread pb = new SynThread("B",a,b);
        SynThread pc = new SynThread("C",b,c);

        new Thread(pa).start();
        try{
            Thread.sleep(100);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        new Thread(pb).start();
        try{
            Thread.sleep(100);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        new Thread(pc).start();
        try{
            Thread.sleep(100);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

    }
}
