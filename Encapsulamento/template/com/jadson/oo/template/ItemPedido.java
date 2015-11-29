/**
 * 
 */
package com.jadson.oo.template;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Item de Pedidos. Esse objeto é um VO.
 * 
 * Existem  implicações  no  desempenho  do  sistema  fazer todos  os  objetos  do  domínio entidades.  
 * O  processo  para  se  criar  um  identificador  em  um  objeto  não  é  tão  simples.  
 * Em muitos   casos   estamos   interessados   apenas   nos   valores   dos   atributos   de   um   objeto, independentemente de qual objeto seja. 
 * Um objeto que é usado para descrever certos aspectos do domínio, mas que não possui um identificador é chamado de  Value Object.
 * 
 * É  recomendável que Values  Objects sejam  imutáveis,  ou  seja,  que  eles  sejam  criados 
 * com os valores passados no construtor e esses valores nunca mais sejam modificados durante sua  existência.  
 * Quando  se  precisar  de  um  valor  diferente  para  os  atributos,  simplesmente  se cria outro Value Object.
 * Isso simplifica bastante o design da aplicação. Como Values  Objects são  objetos  imutáveis  e  não  possuem  identificador 
 * eles  podem ser compartilhados entre objetos, até mesmos objetos de outras camadas, pois não se corre o risco que outros objetos 
 * alterem o seu valor e gerem uma inconsistência. Values  Objects podem  conter  outros Values  Objects,  bem  como  referência  para Entidades. 
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

	/** Crie somente os gets necessários
	 * 
	 *  Se você precisar chamar mais de 2 gets seu encapsulamento está quebrado, você está fazendo algo 
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
