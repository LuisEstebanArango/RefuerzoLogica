package logica;

public class EjercicioDoce {
	static Persona[] lista = new Persona[8];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		lista[0]=new Persona("Luis", 22, 'M');
		lista[1]=new Persona("Martha", 28, 'F');
		lista[2]=new Persona("Ramon", 34, 'M');
		lista[3]=new Persona("Carolina", 19, 'F');
		lista[4]=new Persona("Sandra", 24, 'F');
		lista[5]=new Persona("Carlos", 38, 'M');
		lista[6]=new Persona("Yenny", 36, 'F');
		lista[7]=new Persona("Lorena", 18, 'F');
		System.out.println("a)\nLa cantidad de hombres es: "+getNumeroHombres()+"\nLa cantidad de mujeres es: "+
				getNumeroMujeres()+"\n");
		System.out.println("b)\nEl promedio de las edades de los hombres es: "+getPromedioEdadHombres()+"\n"+
				"El promedio de las edades de las mujeres es: "+getPromedioEdadMujeres()+"\n");
		System.out.println("c)\nEl nombre de la persona más joven es: "+getNombrePersonaMasJoven()+"\n");
		System.out.println("d)\nEl nombre de las personas que sobrepasan la edad promedio: "+getNombrePersonasMayorPromedio()+"\n");
		System.out.println("e)\nLista de personas en orden alfabetico: "+imprimirNombresAlfabeticamente());
	}

	private static String imprimirNombresAlfabeticamente() {
		Persona[] listaOrdenada = lista.clone();
		
		for (int i = 0; i < listaOrdenada.length; i++) {
			Persona temp = listaOrdenada[i];
			int indice = i;
			for (int j = i+1; j < listaOrdenada.length; j++) {
				if(temp.getNombre().compareTo(listaOrdenada[j].getNombre())>0){
					temp=listaOrdenada[j];
					indice = j;
				}
			}
			if(indice!=i){
				listaOrdenada[indice] = listaOrdenada[i];
				listaOrdenada[i] = temp;
			}
		}
		String retorno = "";
		for (Persona persona : listaOrdenada) {
			retorno += persona.getNombre()+" ";
		}
		return retorno;
	}

	private static String getNombrePersonasMayorPromedio() {
		String temp = "";
		int promedio = getEdadPromedio();
		for (Persona persona : lista) {
			if(persona.getEdad()>promedio)
				temp += persona.getNombre()+ " ";
		}
		return temp.substring(0, temp.length()-1);
	}

	private static int getEdadPromedio() {
		int temp = 0;
		for (Persona persona : lista) {
			temp += persona.getEdad();
		}
		return temp/lista.length;
	}

	private static String getNombrePersonaMasJoven() {
		Persona temp = lista[0];
		for (Persona persona : lista) {
			if(persona.getEdad()<temp.getEdad()){
				temp = persona;
			}
		}
		return temp.getNombre();
	}

	private static int getPromedioEdadMujeres() {
		int temp = 0;
		for (Persona persona : lista) {
			if (persona.getSexo()=='F') {
				temp += persona.getEdad();
			}
		}
		temp/=getNumeroMujeres();
		return temp;
	}

	private static int getPromedioEdadHombres() {
		int temp = 0;
		for (Persona persona : lista) {
			if (persona.getSexo()=='M') {
				temp += persona.getEdad();
			}
		}
		temp/=getNumeroHombres();
		return temp;
	}

	private static int getNumeroMujeres() {
		int cont = 0;
		for (Persona persona : lista) {
			if (persona.getSexo()=='F'){
				cont++;
			}
		}
		return cont;
	}

	private static int getNumeroHombres() {
		int cont = 0;
		for (Persona persona : lista) {
			if (persona.getSexo()=='M')
				cont++;
		}
		return cont;
	}

}
