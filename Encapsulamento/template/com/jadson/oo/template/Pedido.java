/**
 * 
 */
package com.jadson.oo.template;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Formattable;
import java.util.Formatter;
import java.util.List;
import java.util.Locale;

/**
 * Entidade Pedido
 * 
 * @author jadson
 *
 * <p><i>This program is distributed without any warranty and it
 * can be freely redistributed for research, classes or private studies, 
 * since the copyright notices are not removed.</i></p>
 *
 */
public class Pedido implements Serializable, Formattable{

	private Long id = 0l;
	
	/** Pedido é composto por vários itens. Você não deve deixar a abstração vazar */
	private List<ItemPedido> itens = new ArrayList<ItemPedido>();

	public List<ItemPedido> getItens() {
		return Collections.unmodifiableList(itens);
	}
	
	/**
	 * Adiciona na lista validando as consistência dos elementos
	 * 
	 * @param item
	 */
	public void add(ItemPedido item){
		if(item == null) throw new IllegalArgumentException();
		if(! itens.contains(item)){
			itens.add(item);
		}
	}
	
	/**
	 * Aplica dentro nos intens do pedido
	 * @param porcento
	 */
	public void aplicarDesconto(Integer porcento){
		if(porcento < 0 || porcento > 100) throw new IllegalArgumentException();
		
		List<ItemPedido> itensTemp = new ArrayList<ItemPedido>();
		
		for (ItemPedido itemPedido : itens) {
			itensTemp.add( ItemPedido.getInstance(itemPedido.getCodigo(), itemPedido.getQuantidade(), 
					(itemPedido.getValor().subtract( itemPedido.getValor().divide( new BigDecimal(porcento)  ) )) ) );
		}
		itens = itensTemp;
	}
	

	/**
	 * Ajuda na debug da aplicacao (para Desenvolvedor)
	 */
	@Override
	public String toString() {
		return "Pedido [id=" + id + ", itens=" + itens + "]";
	}

	/** 
	 * Forma para o usuário (para Negocio)
	 * @see java.util.Formattable#formatTo(java.util.Formatter, int, int, int)
	 */
	@Override
	public void formatTo(Formatter formatter, int flags, int width, int precision) {
		
		if (formatter.locale().equals( new Locale("pt", "BR"))) {
			formatter.format("Pedido ..");
        }else{
        	if (formatter.locale().equals( new Locale("en", "US"))) {
    			formatter.format("Order ..");
            }
        }
		
	}
	
}
