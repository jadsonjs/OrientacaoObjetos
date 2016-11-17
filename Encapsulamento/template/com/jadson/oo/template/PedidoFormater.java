/**
 * 
 */
package com.jadson.oo.template;

import java.util.Formatter;
import java.util.Locale;

/**
 * Formatador para Pedido
 * @author jadson
 *
 */
public class PedidoFormater {

	public static void main(String[] args) {
		
		 Pedido p = new Pedido();
		 System.out.println(new Formatter().format("%s", p)); // Pedido 0 flags: 0 width: -1 precision: -1
		 System.out.println(new Formatter().format(Locale.US, "%s", p)); // Order 0 flags: 0 width: -1 precision: -1
		 System.out.println(new Formatter().format("%#s", p)); // Pedido 0 flags: 4 width: -1 precision: -1
		 System.out.println(new Formatter().format("%25s", p)); // Pedido 0 flags: 0 width: 25 precision: -1
		 System.out.println(new Formatter().format("%.12s", p)); // Pedido 0 flags: 0 width: -1 precision: 12
		
	}
	
}
