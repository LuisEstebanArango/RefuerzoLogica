package logica;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PrimerEjercico {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String linea = br.readLine();
			int a = 0, e=0, i=0, o=0, u = 0;
			for (int j = 0; j < linea.length(); j++) {
				if(linea.charAt(j)=='a') a++;
				if(linea.charAt(j)=='e') e++;
				if(linea.charAt(j)=='i') i++;
				if(linea.charAt(j)=='o') o++;
				if(linea.charAt(j)=='u') u++;
			}
			System.out.println("a: "+a);
			System.out.println("e: "+e);
			System.out.println("i: "+i);
			System.out.println("o: "+o);
			System.out.println("u: "+u);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
