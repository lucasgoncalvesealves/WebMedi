package model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;


/**
 * The persistent class for the HIBERNATE database table.
 * 
 */
@Entity
public class Hibernate implements Serializable {
	private static final long serialVersionUID = 1L;

	private String descricao;

	@Id
	private BigDecimal id;

	public Hibernate() {
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getId() {
		return this.id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

}