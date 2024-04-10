package GiuaKi2Java;

import java.util.List;

public class Thread3 implements Runnable {
    List<Student> students;

    public Thread3(List<Student> students) {
        this.students = students;
    }

    public void run() {
        for (Student student : students) {
            boolean isPrime = true;
            for (int i = 2; i <= Math.sqrt(student.sum); i++) {
                if (student.sum % i == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                System.out.println("ID: " + student.id + ", Ten: " + student.name + ", Dia chi: " + student.address + ", Tuoi: " + student.age + ", Tong ngay thang nam " + student.sum + " la so nguyen to");
            } else {
                System.out.println("ID: " + student.id + ", Ten: " + student.name + ", Dia chi: " + student.address + ", Tuoi: " + student.age + ", Tong ngay thang nam " + student.sum + " khong la so nguyen to");
            }
        }
    }
}

