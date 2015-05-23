package logica;

import java.util.ArrayList;

public class Backtracking {

	static int[][] lab = { 
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 1 }, 
			{ 1, 0, 1, 0, 1, 0, 1, 0, 0, 1 },
			{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 1 }, 
			{ 1, 1, 0, 1, 0, 1, 0, 1, 0, 1 },
			{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 1 }, 
			{ 1, 0, 1, 1, 1, 1, 1, 1, 0, 1 },
			{ 1, 0, 1, 1, 1, 1, 1, 1, 0, 1 }, 
			{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, };

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> mejorCamino =  backtracking(1, 1, 4, 4);
		for (String i:mejorCamino) {
			System.out.println(i);
		}
		System.out.println(mejorCamino.size());
	}

	public static ArrayList<String> backtracking(int x, int y, int xDestion,
			int yDestino) {

		// Condicion base
		if (x == xDestion && y == yDestino) {
			ArrayList<String> temp = new ArrayList<String>();
			temp.add(x + " " + y);
			return temp;
		}
		if (lab[x][y] == -1 || lab[x][y] == 1) {
			return null;
		}

		// Combinaciones

		lab[x][y] = -1;// marco con -1 para saber que ya pase por ahi
		ArrayList<String> arriba = backtracking(x - 1, y, xDestion, yDestino);
		ArrayList<String> derecha = backtracking(x, y + 1, xDestion, yDestino);
		ArrayList<String> abajo = backtracking(x + 1, y, xDestion, yDestino);
		ArrayList<String> izquierda = backtracking(x, y - 1, xDestion, yDestino);
		lab[x][y] = 0;// marco con 0 para seguir caminando en el lab

		// Seleccion del mejor camino
		ArrayList<String> aux = null;
		int tam = 10000000;
		if (arriba != null) {
			if(arriba.size()<tam){
				tam = arriba.size();
				aux = arriba;
			}
		}
		if (derecha != null) {
			if(derecha.size()<tam){
				tam = derecha.size();
				aux = derecha;
			}
		}
		if (abajo != null) {
			if(abajo.size()<tam){
				tam = abajo.size();
				aux = abajo;
			}
		}
		if (izquierda != null) {
			if(izquierda.size()<tam){
				tam = izquierda.size();
				aux = izquierda;
			}
		}
		if(aux!=null)
			aux.add(x+" "+y);
		return aux;
	}

}
