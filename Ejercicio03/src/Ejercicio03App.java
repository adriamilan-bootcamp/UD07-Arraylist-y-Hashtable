
import java.util.Hashtable;
import java.util.Set;
import javax.swing.JOptionPane;

public class Ejercicio03App {

	/*
	 * Crea una base de datos de 10 artícuos para controlar
	 * el stock de productos de una tienda por medio de un
	 * diccionario de datos (artículos:precio). El usuario
	 * podrá añadir, por medio de interfaz visual artículos
	 * nuevos y cantidades de estos. EL usuario podrá consultar
	 * la información almacenada en el diccionario referente a
	 * un articulo concreto e incluso listar toda la información
	 * en la terminal del programa.
	 */
	
	/* 
	 * Declaramos 2 Hashtables globales 
	 * - Articulos
	 * - ArticulosStock
	 */
	
	static Hashtable<String, Double> articulos = new Hashtable<>();
	
	static Hashtable<String, Integer> articulosStock = new Hashtable<>();
	
	public static void main(String[] args) {
		
		articulosIniciales();
		InputOutputDialog();
		
	}
	
	public static void articulosIniciales() {
	
		// Artículos iniciales
		articulos.put("Arroz", 2.35); articulos.put("Pasta", 3.21); articulos.put("Huevos", 8.32); articulos.put("Guisantes", 2.95); articulos.put("Tomate", 1.25); articulos.put("Heura", 3.95); articulos.put("Tofu", 2.34); articulos.put("Maíz", 1.21); articulos.put("Lentejas", 2.34); articulos.put("Judías", 2.21);
	
		// Stock artículos iniciales
		articulosStock.put("Arroz", 21); articulosStock.put("Pasta", 12); articulosStock.put("Huevos", 18); articulosStock.put("Guisantes", 3); articulosStock.put("Tomate", 43); articulosStock.put("Heura", 12); articulosStock.put("Tofu", 23);  articulosStock.put("Maíz", 52); articulosStock.put("Lentejas", 23); articulosStock.put("Judías", 22);

	}
	
	public static void InputOutputDialog() {
		
		boolean salirPrograma = true;
		while (salirPrograma) {
			
			String accion = JOptionPane.showInputDialog("Introduce la acción que quieres hacer:\n=> Listar información de todos los productos con: PRODUCTOS\n=> Listar información de un producto con: LISTAR\n=> Añadir un producto con: AÑADIR\n=> Salir del programa con: SALIR");
			
			switch (accion.toUpperCase()) {
				// Ver todos los productos disponibles
				case "PRODUCTOS":
					mostrarTodosProducto();
					break;
				// Listar información de un producto en especifico
				case "LISTAR":
					String producto = JOptionPane.showInputDialog("Introduce el producto que quieres ver la información.");
					if (articulos.containsKey(producto)) {
						mostrarProducto(producto);
					} else {
						JOptionPane.showMessageDialog(null, "El producto introducido no existe,\nte recomendamos usar el comando \"PRODUCTOS\" para ver los disponibles.");
					}
					break;
				// Crear un producto
				case "AÑADIR":
					crearArticulo();
					break;
				// Salir del programa
				case "SALIR":
					salirPrograma = false;
					break;
				default:
					JOptionPane.showMessageDialog(null, "La acción introducida es incorrecta.");
			}
			
		}
		
	}
	
	public static void crearArticulo() {
		
		// Nombre del producto
		String nombreProducto = JOptionPane.showInputDialog("Introduce el nombre del producto.");
		
		// Precio del producto
		articulos.put(nombreProducto, Double.parseDouble(JOptionPane.showInputDialog("Introduce el precio del producto " + nombreProducto)));
		
		// Stock del producto
		articulosStock.put(nombreProducto, Integer.parseInt(JOptionPane.showInputDialog("Introduce el stock del producto " + nombreProducto)));
		
	}
	
	public static void mostrarTodosProducto() {
		
		String todosProductos = "";
		
		Set<String> keys = articulos.keySet();
        for(String key: keys){
        	/*
        	 * Key => Nombre del producto
        	 * articulos.get(key) => Valor del producto €€
        	 * articulosStock.get(key) => Stock del producto
        	 */
            todosProductos += key + " vale: " + articulos.get(key) + "€ y tiene un stock de: " + articulosStock.get(key) + "\n\n";
        }
		
        // Mostrar por pantalla todos los productos y su información
		JOptionPane.showMessageDialog(null, todosProductos);
		
	}
	
	public static void mostrarProducto(String producto) {
		
		// Muestra la información del producto
		JOptionPane.showMessageDialog(null, "El producto " + producto + " vale: " + articulos.get(producto) + "€ y en stock hay: " + articulosStock.get(producto));
		
	}
	
}
