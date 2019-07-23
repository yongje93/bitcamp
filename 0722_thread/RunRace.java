import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

//Frame은 BorderLayout(동서남북)
class RunRace extends Frame implements ActionListener {
	private int count; // 말의 개수
	private Button btn;
	private Racer[] ra;

	public RunRace(String[] args) {
		count = Integer.parseInt(args[0]);

		btn = new Button("출발");
		ra = new Racer[count];
		Panel p1 = new Panel(new GridLayout(count, 1));
		for (int i = 0; i < count; i++) {
			ra[i] = new Racer(args[i + 1]); // Canvas 생성됨.
			p1.add(ra[i]);
		}

		Panel p2 = new Panel(new FlowLayout(FlowLayout.RIGHT)); // Panel은 FlowLayout(순서배치-중앙) //new
																// FlowLayout(FlowLayout.RIGHT);를 통해서 오른쪽으로 출력
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

	public void actionPerformed(ActionEvent e) { // 버튼 누르면 시작이니까.
		btn.setEnabled(false); // 버튼 한번 누른 뒤에 비활성화.
		Thread[] t = new Thread[count]; // 스레드 배열 생성
		for (int i = 0; i < t.length; i++) {
			t[i] = new Thread(ra[i]); // 스레드 생성
			t[i].setPriority((int) (Math.random() * 10) + 1);
			t[i].start(); // 스레드 시작 - 스레드 실행 (run() 으로)
		}
	}

	public static void main(String[] args) {
		if (args.length < 2) {
			System.out.println("Usage : java RunRace count name1, ...");
			System.exit(0);
		}

		if (Integer.parseInt(args[0]) != args.length - 1) {
			System.out.println("말 마리수와 이름의 개수가 맞지 않습니다.");
			System.exit(0);
		}

		RunRace rr = new RunRace(args);
	}
}
