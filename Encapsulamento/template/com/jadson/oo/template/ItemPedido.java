/**
 * 
 */
package com.jadson.oo.template;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author jadson
 *
 * <p><i>This program is distributed without any warranty and it
 * can be freely redistributed for research, classes or private studies, 
 * since the copyright notices are not removed.</i></p>
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
