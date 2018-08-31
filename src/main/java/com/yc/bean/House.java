package com.yc.bean;

import java.io.Serializable;
import java.util.Date;

public class House implements Serializable {
	private Integer id;
	private User user;
	private HouseType type;
	private Street street;
	private String title;
	private String description;
	private Double price;
	private String pubDate;
	private Integer floorage;
	private String contact;
	private String houseimg;
	
	public String getHouseimg() {
		return houseimg;
	}
	public void setHouseimg(String houseimg) {
		this.houseimg = houseimg;
	}
	public House() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public HouseType getType() {
		return type;
	}
	public void setType(HouseType type) {
		this.type = type;
	}
	public Street getStreet() {
		return street;
	}
	public void setStreet(Street street) {
		this.street = street;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getPubDate() {
		return pubDate;
	}
	public void setPubDate(String pubDate) {
		this.pubDate = pubDate;
	}
	public Integer getFloorage() {
		return floorage;
	}
	public void setFloorage(Integer floorage) {
		this.floorage = floorage;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	@Override
	public String toString() {
		return "House [id=" + id + ", user=" + user + ", type=" + type
				+ ", street=" + street + ", title=" + title + ", description="
				+ description + ", price=" + price + ", pubDate=" + pubDate
				+ ", floorage=" + floorage + ", contact=" + contact
				+ ", houseimg=" + houseimg + "]";
	}
	
}
