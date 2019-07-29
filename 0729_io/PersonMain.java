import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.IOException;

class PersonMain {
	public static void main(String[] args) throws ClassNotFoundException, IOException {
		PersonDTO dto = new PersonDTO("홍길동", 25, 185.3);
		
		//ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("result2.txt"));
		//oos.writeObject(dto);	// 한꺼번에 DTO 넘어감
		//oos.close();
		
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("result2.txt"));
		PersonDTO dto2 = (PersonDTO)ois.readObject();
		System.out.println("이름 = " +dto2.getName());
		System.out.println("나이 = " +dto2.getAge());
		System.out.println("키 = "+ dto2.getHeight());
	}
}
