import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;


class CollectionTest {
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Collection coll = new ArrayList();
		//ArrayList list = new ArrayList();
		coll.add("ȣ����");
		coll.add("����");
		coll.add("ȣ����");//�ߺ����, ����
		coll.add(25);
		coll.add(43.8);
		coll.add("�⸰");
		coll.add("�ڳ���");

		Iterator it = coll.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}

		
	}
}
