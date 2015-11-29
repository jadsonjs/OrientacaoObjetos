/**
 * 
 */
package com.jadson.oo.template;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Item de Pedidos. Esse objeto � um VO.
 * 
 * Existem  implica��es  no  desempenho  do  sistema  fazer todos  os  objetos  do  dom�nio entidades.  
 * O  processo  para  se  criar  um  identificador  em  um  objeto  n�o  �  t�o  simples.  
 * Em muitos   casos   estamos   interessados   apenas   nos   valores   dos   atributos   de   um   objeto, independentemente de qual objeto seja. 
 * Um objeto que � usado para descrever certos aspectos do dom�nio, mas que n�o possui um identificador � chamado de  Value Object.
 * 
 * �  recomend�vel que Values  Objects sejam  imut�veis,  ou  seja,  que  eles  sejam  criados 
 * com os valores passados no construtor e esses valores nunca mais sejam modificados durante sua  exist�ncia.  
 * Quando  se  precisar  de  um  valor  diferente  para  os  atributos,  simplesmente  se cria outro Value Object.
 * Isso simplifica bastante o design da aplica��o. Como Values  Objects s�o  objetos  imut�veis  e  n�o  possuem  identificador 
 * eles  podem ser compartilhados entre objetos, at� mesmos objetos de outras camadas, pois n�o se corre o risco que outros objetos 
 * alterem o seu valor e gerem uma inconsist�ncia. Values  Objects podem  conter  outros Values  Objects,  bem  como  refer�ncia  para Entidades. 
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
public class ItemPedido implements Serializable{

	public Integer codigo = 0;
	
	public Integer quantidade = 0;
	
	public BigDecimal valor = BigDecimal.ZERO;

	/**
	 * @param codigo
	 * @param quantidade
	 * @param valor
	 */
	private ItemPedido(Integer codigo, Integer quantidade, BigDecimal valor) {
		super();
		this.codigo = codigo;
		this.quantidade = quantidade;
		this.valor = valor;
	}
	
	/**
	 * Factory Method
	 * 
	 * @param codigo
	 * @param quantidade
	 * @param valor
	 * @return
	 */
	public static ItemPedido getInstance(Integer codigo, Integer quantidade, BigDecimal valor) {
		if (codigo == null) throw new IllegalArgumentException();
		if (quantidade == null) throw new IllegalArgumentException();
		if (valor == null) throw new IllegalArgumentException();
		return new ItemPedido(codigo, quantidade, valor);
	}

	/** Crie somente os gets necess�rios
	 * 
	 *  Se voc� precisar chamar mais de 2 gets seu encapsulamento est� quebrado, voc� est� fazendo algo 
	 *  fora do objeto que deveria estar dentro  
	 */
	
	public Integer getCodigo() {
		return codigo;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public BigDecimal getValor() {
		return valor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((quantidade == null) ? 0 : quantidade.hashCode());
		result = prime * result + ((valor == null) ? 0 : valor.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemPedido other = (ItemPedido) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (quantidade == null) {
			if (other.quantidade != null)
				return false;
		} else if (!quantidade.equals(other.quantidade))
			return false;
		if (valor == null) {
			if (other.valor != null)
				return false;
		} else if (!valor.equals(other.valor))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ItemPedido [codigo=" + codigo + ", quantidade=" + quantidade + ", valor=" + valor + "]";
	}
	
	
}
