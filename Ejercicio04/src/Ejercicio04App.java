
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Set;
import javax.swing.JOptionPane;

public class Ejercicio04App {

	/*
	 * Combina los métodos generados en las actividades 2 y 3
	 * creando una aplicación que gestione ventas y control de 
	 * stock en una misma interfaz. Utiliza para ello las estructuras
	 * de datos que creas convenientes
	 */
	
	static Hashtable<String, Double> articulos = new Hashtable<>();
	
	static Hashtable<String, Integer> articulosStock = new Hashtable<>();
	
	static ArrayList<Double[]> ventas = new ArrayList<>(); 
	
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
			
			String accion = JOptionPane.showInputDialog("Introduce la acción que quieres hacer:\n=> Hacer una venta con: VENTA\n=> Ver una venta con: VER\n=> Listar información de todos los productos con: PRODUCTOS\n=> Listar información de un producto con: LISTAR\n=> Añadir un producto con: AÑADIR\n=> Salir del programa con: SALIR");
			
			// Switch acciones
			switch (accion.toUpperCase()) {
				// Crear una venta
				case "VENTA":
					crearVenta();
					break;
				// Ver una venta en especifico
				case "VER":
					verVenta(Integer.parseInt(JOptionPane.showInputDialog("Introduce la venta que quieres visualizar. Ej: 1")));
					break;
				// Ver todos los productos disponibles
				case "PRODUCTOS":
					mostrarTodosProducto();
					break;
				// Listar información de un producto en específico
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
				// En caso de que la acción no exista
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
	
	public static void crearVenta() {
		
		Double[] venta = new Double[6]; 
		/*
		 * 1 => Artículos en el carrito de compra
		 * 2 => Precio Bruto total de la compra
		 * 3 => Iva elegida
		 * 4 => Precio neto total de la compra
		 * 5 => Cantidad pagada
		 * 6 => Cantidad a devolver
		 */
		Double cantidadProductos = Double.parseDouble(JOptionPane.showInputDialog("Introduce la cantidad de productos que hay en el carrito de compra."));
		
		// Cantidad de productos en la cesta de la compra
		venta[0] = cantidadProductos;
		for (int i = 0; i <= cantidadProductos - 1; i++) {
			
			boolean onOff = true;
			venta[1] = 0.00;
			while (onOff) {
				String producto = JOptionPane.showInputDialog("Introduce un producto " + (i+1) + "/" + cantidadProductos);
				if (articulos.containsKey(producto)) /* Comprobamos si el producto existe */{
					// Valor del producto en €
					venta[1] += articulos.get(producto); 
					onOff = false;
				} else {
					// Mensaje de eror
					JOptionPane.showMessageDialog(null, "El producto que has introducido es incorrecto\nTe recomendamos que visites el comando \"PRODUCTOS\" para ver todos los productos disponibles.");
				}
				
			}	
			
		}	
		// IVA
		venta[2] = Double.parseDouble(JOptionPane.showInputDialog("Introduce el IVA (21% o 4%)"));
		// Calculando precio neto
		venta[3] = (venta[1] * venta[2] / 100) + venta[1];
		// Cantidad de dinero que el cliente ha dado en caja
		venta[4] = Double.parseDouble(JOptionPane.showInputDialog("Introduce la cantidad de dinero que el cliente ha entregado."));
		// Cantidad de dinero a devolver
		venta[5] = venta[4] - venta[3];
		
		// Añadimos venta a ventas
		ventas.add(venta);
		
	}
	
	public static void verVenta(int ventaEspecifica) {
		
		// Asignamos a venta la venta especificada por el usuario
		Double[] venta = ventas.get(ventaEspecifica-1);
		
		// Mostrando el mensaje
		JOptionPane.showMessageDialog(null, "La compra " + ventaEspecifica + " tiene " + venta[0] + " articulos en el carrito de compra,\nsu precio bruto es: " + venta[1] + "€, el IVA elegido es: " + venta[2] + "%,\nel precio neto es: " + venta[3] + "€, la cantidad pagada ha sido: " + venta[4] + "€,\nla cantidad a devolver es: " + venta[5] + "€");		
				
	}
}
