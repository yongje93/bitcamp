import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.IOException;

class PersonMain {
	public static void main(String[] args) throws ClassNotFoundException, IOException {
		PersonDTO dto = new PersonDTO("ȫ�浿", 25, 185.3);
		
		//ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("result2.txt"));
		//oos.writeObject(dto);	// �Ѳ����� DTO �Ѿ
		//oos.close();
		
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("result2.txt"));
		PersonDTO dto2 = (PersonDTO)ois.readObject();
		System.out.println("�̸� = " +dto2.getName());
		System.out.println("���� = " +dto2.getAge());
		System.out.println("Ű = "+ dto2.getHeight());
	}
}
