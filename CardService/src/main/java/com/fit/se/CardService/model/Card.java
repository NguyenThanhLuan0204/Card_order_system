package com.fit.se.CardService.model;



import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


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
	private Integer type;

	@Column(name="card_decription", columnDefinition = "nvarchar(200)")
	private String decription;

	@Column(name="status")
	private Integer status;

	@Column(name="card_img")
	private String img;

	@Column(name="price")
	private Long price;
	
	@Column(name="quantityStorage")
	private Integer quantityStorage;

	public Long getId() {
		return id;
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

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getDecription() {
		return decription;
	}

	public void setDecription(String decription) {
		this.decription = decription;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
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

	public Integer getQuantityStorage() {
		return quantityStorage;
	}

	public void setQuantityStorage(Integer quantityStorage) {
		this.quantityStorage = quantityStorage;
	}

	
}