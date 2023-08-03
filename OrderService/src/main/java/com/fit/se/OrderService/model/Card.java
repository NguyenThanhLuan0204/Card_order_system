package com.fit.se.OrderService.model;


import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "cards")
public class Card implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name="card_name", columnDefinition = "varchar(100)")
	private String nameCard;

	@Column(name="card_type")
	private int type;

	@Column(name="card_decription", columnDefinition = "nvarchar(200)")
	private String decription;

	@Column(name="status")
	private int status;

	@Column(name="card_img")
	private String img;

	@Column(name="price")
	private Long price;
	@Column(name="ValidQuanlity")
	private int ValidQuanlity;

	public String getId() {
		return id.toString();
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNameCard() {
		return nameCard;
	}

	public void setNameCard(String nameCard) {
		this.nameCard = nameCard;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getDecription() {
		return decription;
	}

	public void setDecription(String decription) {
		this.decription = decription;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public int getValidQuanlity() {
		return ValidQuanlity;
	}

	public void setValidQuanlity(int validQuanlity) {
		ValidQuanlity = validQuanlity;
	}
}