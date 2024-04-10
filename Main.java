package GiuaKi2Java;

import GK2.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        java.lang.Thread t = new java.lang.Thread(new Thread(students));
        java.lang.Thread t1 = new java.lang.Thread(new Thread1(students));
        java.lang.Thread t2 = new java.lang.Thread(new Thread2(students));
        java.lang.Thread t3 = new java.lang.Thread(new Thread3(students));


        t1.start();
        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        t2.start();
        try {
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        t3.start();
        try {
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        t.start();
    }
}
