package kr.co.bit.obj;

public class ListCommand implements Command {

	@Override
	public void execute() {
		System.out.println("전체목록을 보여준다.");
	}

}
