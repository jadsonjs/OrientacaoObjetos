/**
 * 
 */
package com.jadson.oo.template;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author jadson
 *
 * <p><i>This program is distributed without any warranty and it
 * can be freely redistributed for research, classes or private studies, 
 * since the copyright notices are not removed.</i></p>
 *
 */
public class PedidoTest {

	/**
	 * Test method for {@link com.jadson.oo.template.Pedido#aplicarDesconto(java.lang.Integer)}.
	 */
	@Test
	public void testAplicarDesconto() {
		Pedido p = new Pedido();
		p.add(ItemPedido.getInstance(1234, 1, new BigDecimal("10.00")) );
		p.add(ItemPedido.getInstance(4323, 3, new BigDecimal("20.00")) );
		p.add(ItemPedido.getInstance(2343, 3, new BigDecimal("30.00")) );
		
		p.aplicarDesconto(10);
		
		Assert.assertEquals(new BigDecimal("9.00"), p.getItens().get(0).getValor());
		Assert.assertEquals(new BigDecimal("18.00"), p.getItens().get(1).getValor());
		Assert.assertEquals(new BigDecimal("27.00"), p.getItens().get(2).getValor());
	}

}
