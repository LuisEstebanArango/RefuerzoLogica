package logica;

import java.util.ArrayList;
import java.util.List;

public class Ejercicio {

	public static void main(String[] args) {
		int[] h = {-1,-34,-15,-2-20,-45,-10};
//		int[] h = {1,34,15,2,20,45,10};
		h = radixsort(h);
		for (int i : h) {
			System.out.println(i);
		}
		
		int m = 159, n = 300;
		System.out.println("\nMultiplicación divide y venceras: "+m+" x "+n+" = "+mult(159, 300));
	}
	
	public static int[] radixsort(int[] input) {
		  final int RADIX = 10;
		  // declare and initialize bucket[]
		  List<Integer>[] bucket = new ArrayList[RADIX];
		  for (int i = 0; i < bucket.length; i++) {
		    bucket[i] = new ArrayList<Integer>();
		  }
		 
		  // sort
		  boolean maxLength = false;
		  int tmp = -1, placement = 1;
		  while (!maxLength) {
		    maxLength = true;
		    // split input between lists
		    for (Integer i : input) {
		      tmp = i / placement;
		      tmp = (tmp<0?tmp*(-1):tmp);
		      bucket[tmp % RADIX].add(i);
		      if (maxLength && tmp > 0) {
		        maxLength = false;
		      }
		    }
		    
		    //El siguiente codigo comentado sirve solo para arreglos con números positivos
//		    int a = 0;
//		    for (int b = 0; b < RADIX; b++) {
//		      for (Integer i : bucket[b]) {
//		        input[a++] = i;
//		      }
//		      bucket[b].clear();
//		    }
		    
		    //Este codigo sirve solo para arreglos con números negativos
		    // empty lists into input array
		    int a = input.length-1;
		    for (int b = RADIX-1; b >= 0; b--) {
		      for (Integer i : bucket[b]) {
		        input[a--] = i;
		      }
		      bucket[b].clear();
		    }
		    
		    
		    // move to next digit
		    placement *= RADIX;
		  }
		  return input;
	}
	
	
	public static int mult(int m, int n){
		if(n==0)
			return 0;
		else
			if(n==1)
				return m;
			else
				if(n%2==0)
					return mult(m+m, n/2);
				else
					return mult(m+m, n/2)+m;
	}
}
