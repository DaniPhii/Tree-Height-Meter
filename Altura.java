/*


	Tree Height Meter. Copyright © 2014 Dani Poveda.


*/
import java.util.Scanner;
class Arbol { // Objeto Árbol.
	// Atributos:
	private String Tipo_Arbol;
	private float Sombra_Arbol;
	// Métodos:
	public Arbol() { // Método constructor.
	}
	public void setTipo(String dato) {
		Tipo_Arbol=dato;
	}
	public void setSombra(float dato) {
		Sombra_Arbol=dato;
	}
	public String getTipo() {
		return Tipo_Arbol;
	}
	public float getSombra() {
		return Sombra_Arbol;
	}
}
class Palo { // Objeto Palo.
	// Atributos:
	private float Altura_Palo;
	private float Sombra_Palo;
	// Métodos:
	public Palo() { // Método constructor.
	}
	public void setAltura(float dato) {
		Altura_Palo=dato;
	}
	public void setSombra(float dato) {
		Sombra_Palo=dato;
	}
	public float getAltura() {
		return Altura_Palo;
	}
	public float getSombra() {
		return Sombra_Palo;
	}
}
class Altura {
	static Scanner leer=new Scanner(System.in);
	public static void main (String[] args) {
		Palo Vara = new Palo();
		int n;
			System.out.print("\nTree Height Meter. Copyright © 2014 Dani Poveda.\nGNU General Public License, Version 3.\n\nEste programa calcula la altura de un número determinado de árboles a partir de:\n\t1.- La longitud de la sombra que proyecta cada árbol en el suelo.\n\t2.- La longitud de un palo clavado en el suelo.\n\t3.- La longitud de la sombra que proyecta el palo.\nTodos los datos hay que recopilarlos en un mismo momento determinado del día, ya que estos varían a lo largo del mismo.\nTambién has de saber que el cálculo no será exacto si el árbol no ha crecido verticalmente, y tampoco si el terreno es muy irregular.\n\nPara empezar, introduzca el número de árboles que quiere medir: ");
		n=leer.nextInt();
		while(n<=0){
			System.out.print("No se puede operar si no introduce un número mayor que cero.\nIntroduzca un número correcto: ");
			n=leer.nextInt();
		}
		Arbol[] MatrizArboles = new Arbol[n];
		do {
			System.out.print("\nIntroduzca los datos necesarios.\n\nPrimero, introduzca la longitud del palo \n(en centímetros y con decimales si procede): ");
			Vara.setAltura(leer.nextFloat());
			while (Vara.getAltura()<=0) {
				System.out.print("\nNo se puede operar si introduce una medida nula, o si esta es negativa (absurdo). \nIntroduzca una medida correcta: ");
				Vara.setAltura(leer.nextFloat());
			}
			System.out.print("\nAhora, introduzca la longitud de la sombra que proyecta\n el palo (en centímetros y con decimales si quiere): ");
			Vara.setSombra(leer.nextFloat());
			while (Vara.getSombra()<=0) {
				System.out.print("\nNo se puede operar si introduce una medida nula, o si esta es negativa (absurdo).\nIntroduzca una medida correcta: ");
				Vara.setSombra(leer.nextFloat());
			}
			System.out.println("\nPor último, introduzca los datos referentes a cada árbol.\n");
			for (int i=0; i<n; i++) {
				int k=1+i;
				System.out.println("Datos del árbol nº "+k+":");
				System.out.print("Introduzca la longitud de la sombra del árbol (en metros y con decimales si procede): ");
				MatrizArboles[i] = new Arbol();
				MatrizArboles[i].setSombra(leer.nextFloat());
				while(MatrizArboles[i].getSombra()<=0) {
					System.out.print("\nNo se puede operar si introduce una medida nula, o si esta es negativa (absurdo). \nIntroduzca una medida correcta: ");
					MatrizArboles[i].setSombra(leer.nextFloat());
				}
				System.out.print("¿Qué tipo de árbol es? ");
				MatrizArboles[i].setTipo(leer.nextLine()); // Error a revisar (no debería repetir la instrucción)
				MatrizArboles[i].setTipo(leer.nextLine());
			}
			System.out.println("\n\n\tTabla de datos\n");
			for (int j=0; j<n; j++) {
				System.out.printf("%2d. %12s: %6.2f m de altura.\n", j+1, MatrizArboles[j].getTipo(), Altura_Arbol(MatrizArboles[j].getSombra(), Vara.getAltura(), Vara.getSombra()));
			}
			System.out.print("\n\n¡Cálculo completado!\n\nIntroduzca:\n\t1 si quiere elaborar otra lista.\n\t0 para salir. ");
		} while (Continuar());
		System.out.println("\nGracias por utilizar este programa.\n");
	}
	public static float Altura_Arbol(float a, float b, float c) { // Método que calcula el dato deseado.
		return (float) ((a*0.01*b)/(0.01*c));
	}
	public static boolean Continuar() {
	int Opcion=leer.nextInt();
	boolean Seguir=(Opcion==1) ? true : false;
	return Seguir;
	}
}