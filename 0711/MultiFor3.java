class MultiFor3 {
	public static void main(String[] args) {
		int dan, i;
		 for(i = 1; i <=9; i++) {
			 for(dan = 2; dan <=9; dan++){
				System.out.print(dan +" * " + i + " = " + (dan*i) +"\t");
			}
			System.out.println();
		}
	}
}