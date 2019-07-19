import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class PersonSort {
	public static void main(String[] args) {
		String[] ar = {"orange","apple","banana","pear","peach","applemango"};		
		Arrays.sort(ar);
		for(String data : ar) {
			System.out.print(data + "	");
		}
		System.out.println();

		PersonDTO aa = new PersonDTO("�ڳ�", 13);
		PersonDTO bb = new PersonDTO("��ġ", 30);
		PersonDTO cc = new PersonDTO("�浿", 25);

		ArrayList<PersonDTO> list = new ArrayList<PersonDTO>();
		list.add(aa);
		list.add(bb);
		list.add(cc);
		
		Collections.sort(list);
		System.out.println("\n ���̷� ���� = " + list);	//toString �����Ǿ�����.
		
		System.out.print ("\n �̸����� ���� = ");	
		Comparator<PersonDTO> com = new Comparator<PersonDTO>() { //���ο� �������� ����
			@Override
			public int compare(PersonDTO p1, PersonDTO p2) {
				//��������
				//return p1.getName().compareTo(p2.getName()); //compareTo�� ���� ���ϰ� -1, 0, 1 �������.
				//��������
				//return p2.getName().compareTo(p1.getName());
				return p1.getName().compareTo(p2.getName())*-1;
			}
		};		
		
		Collections.sort(list, com);//�׳� list�� PersonDTO�� compareTo�ϱ� �ڿ� com�� �־��༭ Comparator�� �̿��ϰ� ����
		System.out.println(list);
	}
}
