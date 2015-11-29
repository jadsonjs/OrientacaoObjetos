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
 * Entidades são objetos que possuem um identificador.
 * Esse identificador deve ser único para todo o modelo. Sua principal função é distingu
 * ir um objeto de todos os outros do modelo que possuem identidade. 
 * Entidades  são  objetos  importantes  no 
 * Domain  Model e  eles  devem  ser  considerados 
 * desde  o  começo  da  modelagem  do  sistema.  Também  é  importante  determinar  se  um  objeto 
 * precisar ser uma entidade ou não, pois isso implica
 * em certos custos para o sistema.
 * 
 * @author jadson
 *
 * <p><i>This program is distributed without any warranty and it
 * can be freely redistributed for research, classes or private studies, 
 * since the copyright notices are not removed.</i></p>
 * 
 * <p>Based on Edson Yanaga example: 
 * http://www.infoq.com/br/presentations/encapsulamento-em-java-ee?utm_source=infoq&utm_medium=videos_homepage&utm_campaign=videos_row1</p>
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
