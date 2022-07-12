
import java.util.Hashtable;
import java.util.Enumeration;
import javax.swing.JOptionPane;

public class Ejercicio01App {

	/* 
	 * Crea una aplicación que calcule la nota media de los alumnos
	 * pertenecientes al curso de programación. Una vez calculada
	 * la nota media se guarda esta información en un diccionario de
	 * datos que almacene la nota media de cada alumno. Todos estos
	 * datos se han de proporcionar por pantalla.
	 */

	public static void main(String[] args) {
		
		InputOutputDialog();
		
	}
	
	public static void InputOutputDialog() {
		
		// Preguntando al usuario el numero de alumnos
		int numeroDeAlumnos = Integer.parseInt(JOptionPane.showInputDialog("Introduce la cantidad de alumnos"));
		
		// Preguntando al usuario el cantidad de asignaturas
		int numeroDeAsignaturas = Integer.parseInt(JOptionPane.showInputDialog("Introduce la cantidad de asignaturas"));
		
		Hashtable<String, Integer> notas = notaMediaConstructor(numeroDeAlumnos, numeroDeAsignaturas);
		
		String buscarAlumno = JOptionPane.showInputDialog("Introduce un alumno o \"TOTAL\" para ver la nota media de un alumno o la total de todos.");
		
		switch (buscarAlumno.toUpperCase()) {
			// Ver la nota media de toda la clase
			case "TOTAL":
				JOptionPane.showMessageDialog(null, "La nota media total de todos los alumnos es: " + notaMediaTotal(numeroDeAsignaturas, notas));
				break;
			// Ver la nota media de un alumno
			default:
				JOptionPane.showMessageDialog(null, "La nota media del usuario " + buscarAlumno + " es: " + notaMediaAlumno(buscarAlumno, notas));
				break;
		}
		
	}
	
	public static int notaMediaAlumno(String alumno, Hashtable<String, Integer> notas) {
		
		int nota = notas.get(alumno);
		
		return nota;
		
	}
	
	public static int notaMediaTotal(int numeroDeAsignaturas, Hashtable<String, Integer> notas) {
		
		int notaMediaTotal = 0;
		
		Enumeration<String> notasKey = notas.keys();
		while(notasKey.hasMoreElements()) {
			// notasMediaTotal = notasMediaTotal + nota
			notaMediaTotal += notas.get(notasKey.nextElement());
		}
		
		// Devolvemos la notaMediaTotal
		return notaMediaTotal /= numeroDeAsignaturas;
	}
	
	public static Hashtable<String, Integer> notaMediaConstructor(int numeroDeAlumnos, int numeroDeAsignaturas) {
		
		
		Hashtable<String, Integer> notas = new Hashtable<>();
		
		for (int i = 0; i <= numeroDeAlumnos - 1; i++) {
			
			// Preguntamos al usuario el nombre del alumno
			String nombreAlumno = JOptionPane.showInputDialog("Introduce el nombre del alumno " + (i+1) + "/" + numeroDeAlumnos);
			int nota = 0;
			int mediaNotas = 0;
			
			for (int x = 0; x <= numeroDeAsignaturas - 1; x++) {
				// Preguntamos al usuario la nota de una asignatura
				nota = Integer.parseInt(JOptionPane.showInputDialog("Introduce nota de la asignatura " + (x+1) + "/" + numeroDeAsignaturas));
				mediaNotas += nota; 	
			}
			
			// Añadimos la nota media del alumno a notas
			notas.put(nombreAlumno, (mediaNotas/numeroDeAsignaturas));
			
		}
		
		// Devolvemos notas
		return notas;
		
	}
	
}
