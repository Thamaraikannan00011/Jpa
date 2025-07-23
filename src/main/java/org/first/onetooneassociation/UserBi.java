package org.first.onetooneassociation;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class UserBi {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private long phone;
	@JoinColumn
	@OneToOne(cascade = CascadeType.ALL)
	private AadharBi card;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public AadharBi getCard() {
		return card;
	}
	public void setCard(AadharBi card) {
		this.card = card;
	}
	
	@Override
	public String toString() {
		return "UserBi [id=" + id + ", name=" + name + ", phone=" + phone + "]";
	}
}
