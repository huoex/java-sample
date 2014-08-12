package hex.com.test12.IO2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectFileTest {
	public static void main(String[] args) {
		Manager boss = new Manager("Carl Cracker", 80000, 1987, 12, 15);
		boss.setBonus(5000);

		Employee[] staff = new Employee[3];
		staff[0] = boss;
		staff[1] = new Employee("Harry Hacker", 50000, 1989, 10, 15);
		staff[2] = new Employee("Tony Tester", 40000, 1990, 1, 15);

		try {
			/**
			 * 使用文件输出流构造一个对象输出流 FileOutputStream文件输出流 ObjectOutputStream对象输出流
			 */
			ObjectOutputStream out = new ObjectOutputStream(
					new FileOutputStream("employee.dat"));
			out.writeObject(staff); // 将对象写入"employee.dat"中
			out.close(); // 关闭流，请牢记

			/**
			 * 使用文件输入流构造一个对象输入流 FileInputStream文件输入流 ObjectInputStream对象输入流
			 */
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(
					"employee.dat"));
			// /readObject()将对象从"employee.dat"中读出，需要类型转换
			Employee[] newStaff = (Employee[]) in.readObject();
			in.close();

			for (int i = 0; i < newStaff.length; i++)
				System.out.println(newStaff[i]);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}