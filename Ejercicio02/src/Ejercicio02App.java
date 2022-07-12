
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Ejercicio02App {

	/* Crea una aplicación que gestione el flujo de ventas
	 * de una caja de supermercado. El programa guarda las
	 * cantidades del carrito de compra dentro de una lista.
	 * Mostrará por pantalla la siguiente información: 
	 * - IVA aplicado (21% o 4%)
	 * - Precio total bruto y precio más IVA.
	 * - Número de artículos comprados.
	 * - Cantidad pagada.
	 * - Cambio a devolver al cliente. 
	 */
	
	static ArrayList<Double[]> ventas = new ArrayList<>(); 
	
	public static void main(String[] args) {
		
		InputOutputDialog();
		
	}
	
	public static void InputOutputDialog() {
		
		boolean salirPrograma = true;
		while (salirPrograma) {
			String accionUsuario = JOptionPane.showInputDialog("Registrar una nueva venta\n=> Venta\nVer una venta\n=> Ver\nSalir del programa\n=> Salir");
			
			switch (accionUsuario.toUpperCase()) {
				// Registrar una nueva venta
				case "VENTA":
					creadorDeVentas();
					break;
				// Ver una venta en específico
				case "VER":
					verVenta(Integer.parseInt(JOptionPane.showInputDialog("Introduce la venta que quieres visualizar.")));
					break;
				// Salir del programa
				case "SALIR":
					salirPrograma = false;
					break;
				default:
					JOptionPane.showMessageDialog(null, "Has introducido una acción invalida.");
			}
			
		}
		
	}
	
	public static void verVenta(int ventaEspecifica) {
		
		// Obtenemos la venta especificada
		Double[] venta = ventas.get(ventaEspecifica-1);
		
		// Mostramos la venta
		JOptionPane.showMessageDialog(null, "La compra " + ventaEspecifica + " tiene " + venta[0] + " articulos en el carrito de compra,\nsu precio bruto es: " + venta[1] + "€, el IVA elegido es: " + venta[2] + "%,\nel precio neto es: " + venta[3] + "€, la cantidad pagada ha sido: " + venta[4] + "€,\nla cantidad a devolver es: " + venta[5] + "€");
		
	}
	
	public static ArrayList<Double[]> creadorDeVentas() {
		
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
			// Valor del producto en €
			venta[1] = 0.00;
			Double precioProducto = Double.parseDouble(JOptionPane.showInputDialog("Introduce el precio del producto " + (i+1) + "/" + cantidadProductos));
			venta[1] += precioProducto; 
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
		
		// Devolvemos ventas
		return ventas;

	}
	
}
