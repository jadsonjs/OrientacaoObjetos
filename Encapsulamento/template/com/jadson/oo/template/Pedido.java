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
 * Entidades s�o objetos que possuem um identificador.
 * Esse identificador deve ser �nico para todo o modelo. Sua principal fun��o � distingu
 * ir um objeto de todos os outros do modelo que possuem identidade. 
 * Entidades  s�o  objetos  importantes  no 
 * Domain  Model e  eles  devem  ser  considerados 
 * desde  o  come�o  da  modelagem  do  sistema.  Tamb�m  �  importante  determinar  se  um  objeto 
 * precisar ser uma entidade ou n�o, pois isso implica
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
	
	/** Pedido composto por varios itens. Voce nao deve deixar a abstracao vazar */
	private List<ItemPedido> itens = new ArrayList<ItemPedido>();

	public List<ItemPedido> getItens() {
		return Collections.unmodifiableList(itens);
	}
	
	/**
	 * Adiciona na lista validando as consist�ncia dos elementos
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
	 * Forma para o usuario (para Negocio)
	 * @see java.util.Formattable#formatTo(java.util.Formatter, int, int, int)
	 */
	@Override
	public void formatTo(Formatter formatter, int flags, int width, int precision) {
		StringBuilder sb = new StringBuilder();
		
		if (formatter.locale().equals( new Locale("pt", "BR"))) {
			sb.append("Pedido "+id);
        }else{
        	if (formatter.locale().equals( new Locale("en", "US"))) {
        		sb.append("Order "+id);
            }
        }
	 
        sb.append(" flags: "+flags+" width: "+width+" precision: "+precision);
        
		
		formatter.format(sb.toString());
	}
	
}
