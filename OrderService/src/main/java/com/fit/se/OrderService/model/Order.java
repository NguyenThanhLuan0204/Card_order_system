package com.fit.se.OrderService.model;



import java.io.Serializable;

import javax.persistence.*;


@Entity
@Table(name = "Orders")
public class Order implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name="id_Card", columnDefinition = "Long", nullable = false)
	private Long idCard;

	@Column(name="quanlity", columnDefinition = "integer")
	private Integer quanlity;

	public String getId() {
		return id.toString();
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdCard() {
		return idCard;
	}

	public void setIdCard(Long idCard) {
		this.idCard = idCard;
	}


	public Integer getQuanlity() {
		return quanlity;
	}

	public void setQuanlity(Integer quanlity) {
		this.quanlity = quanlity;
	}
}