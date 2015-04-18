package logica;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class segundoEjercicio {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			int n = Integer.parseInt((new BufferedReader(new InputStreamReader(System.in))).readLine());
			int m = Integer.parseInt((new BufferedReader(new InputStreamReader(System.in))).readLine());
			int acumulador = 1;
			for (int i = 0; i <m; i++) {
				acumulador*=n;
			}
			System.out.println(acumulador);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
