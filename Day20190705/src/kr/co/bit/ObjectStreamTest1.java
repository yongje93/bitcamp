package kr.co.bit;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectStreamTest1 {

	public static void main(String[] args) {
		User1 beforeUser1 = new User1("aaa", "aaa", "µ¿", 27, "È«±æµ¿");
		User1 afterUser1 = null;
		FileOutputStream fileos = null;
		ObjectOutputStream objectos = null;
		FileInputStream fileis = null;
		ObjectInputStream objectis = null;
		try {
			fileos = new FileOutputStream("C:\\eclipse\\workspace\\Day20190705\\src\\kr\\co\\bit\\userInfo.ser");
			objectos = new ObjectOutputStream(fileos);
			objectos.writeObject(beforeUser1);

			fileis = new FileInputStream("C:\\eclipse\\workspace\\Day20190705\\src\\kr\\co\\bit\\userInfo.ser");
			objectis = new ObjectInputStream(fileis);
			afterUser1 = (User1) objectis.readObject();
			System.out.println(afterUser1);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try { 
				fileos.close();
				objectos.close();
				fileis.close();
				objectis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
