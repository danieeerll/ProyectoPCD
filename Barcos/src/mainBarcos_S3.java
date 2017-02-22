public class mainBarcos_S3 {
	
	public static void main(String[] args) {
		Puerta p = new Puerta();
		Control c = new Control();
		Barco[] b = new Barco[20];
		
		for (int i = 0;i<10;i++) {
			b[i] = new Barco(i, 0, p, c);
		}
		
		for (int i = 10;i<20;i++) {
			b[i] = new Barco(i, 1, p, c);
		}		
		
		for (int i = 0;i<20;i++) {
			Thread t = new Thread(b[i]);
			t.start();
		}
		
		System.out.println("END of main thread");
	}

		
}
