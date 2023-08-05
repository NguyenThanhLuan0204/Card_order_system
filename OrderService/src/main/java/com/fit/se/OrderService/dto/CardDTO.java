package com.fit.se.OrderService.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class CardDTO {
	@JsonProperty("id")
	private Long id;
	@JsonProperty("nameCard")
	private String nameCard;
	@JsonProperty("type")
	private Integer type;
	@JsonProperty("decription")
	private String decription;
	@JsonProperty("status")
	private Integer status;
	@JsonProperty("img")
	private String img;
	@JsonProperty("price")
	private Long price;
	@JsonProperty("quantityStorage")
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
