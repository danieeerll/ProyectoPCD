public class mainBarcos_A {
	
	public static void main(String[] args) {
		Control c = new Control();
		Puerta p = new Puerta(c);
		Barco[] b = new Barco[20];
		
		for (int i = 0;i<10;i++) {
			b[i] = new Barco(i, 0, p);
		}
		
		for (int i = 10;i<20;i++) {
			b[i] = new Barco(i, 1, p);
		}		
		
		for (int i = 0;i<20;i++) {
			Thread t = new Thread(b[i]);
			t.start();
		}
		
		System.out.println("END of main thread");
	}
}
