import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

class DataStream {
	public static void main(String[] args) throws IOException {
		//DataOutputStream dos = new DataOutputStream(new FileOutputStream("result.txt"));
		FileOutputStream fos = new FileOutputStream("result.txt");
		DataOutputStream dos = new DataOutputStream(fos);
		dos.writeUTF("ȫ�浿");
		dos.writeInt(25);
		dos.writeDouble(185.3);
		dos.close();

	}
}















