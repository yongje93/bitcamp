package kr.co.bit.obj2;

public class Array_Test4 {
	
	public static void main(String[] args) {
		String cities[] = {"����", "�뱸", "��õ", "���", "����" };
		String nations[] = new String[] {"���ѹα�", "�̱�", "����", "�Ϻ�", "������" };
		
		for(int i = 0; i<cities.length; i++) {
			System.out.println("cities [" + i + "] =" +cities[i]);
		}
		for(int i = 0; i<nations.length; i++) {
			System.out.println("nations [" + i + "] =" +nations[i]);
		}
	}
	
}
