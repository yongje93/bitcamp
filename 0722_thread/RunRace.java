import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

//Frame�� BorderLayout(��������)
class RunRace extends Frame implements ActionListener {
	private int count; // ���� ����
	private Button btn;
	private Racer[] ra;

	public RunRace(String[] args) {
		count = Integer.parseInt(args[0]);

		btn = new Button("���");
		ra = new Racer[count];
		Panel p1 = new Panel(new GridLayout(count, 1));
		for (int i = 0; i < count; i++) {
			ra[i] = new Racer(args[i + 1]); // Canvas ������.
			p1.add(ra[i]);
		}

		Panel p2 = new Panel(new FlowLayout(FlowLayout.RIGHT)); // Panel�� FlowLayout(������ġ-�߾�) //new
																// FlowLayout(FlowLayout.RIGHT);�� ���ؼ� ���������� ���
		p2.add(btn);

		add("Center", p1);
		add("South", p2);

		setBounds(100, 200, 600, 500);
		setVisible(true);
		setResizable(false);

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		btn.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) { // ��ư ������ �����̴ϱ�.
		btn.setEnabled(false); // ��ư �ѹ� ���� �ڿ� ��Ȱ��ȭ.
		Thread[] t = new Thread[count]; // ������ �迭 ����
		for (int i = 0; i < t.length; i++) {
			t[i] = new Thread(ra[i]); // ������ ����
			t[i].setPriority((int) (Math.random() * 10) + 1);
			t[i].start(); // ������ ���� - ������ ���� (run() ����)
		}
	}

	public static void main(String[] args) {
		if (args.length < 2) {
			System.out.println("Usage : java RunRace count name1, ...");
			System.exit(0);
		}

		if (Integer.parseInt(args[0]) != args.length - 1) {
			System.out.println("�� �������� �̸��� ������ ���� �ʽ��ϴ�.");
			System.exit(0);
		}

		RunRace rr = new RunRace(args);
	}
}
