package org.first.onetooneassociation;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

@NamedQuery(name = "findByName", query = "SELECT p FROM PersonUni p WHERE p.name = ?1")
@NamedQuery(name = "findByPhone", query = "SELECT p FROM PersonUni p WHERE p.phone = ?1")

@Entity
public class PersonUni {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private long phone;
	@OneToOne(cascade = CascadeType.ALL)
	private PanCardUni card;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
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
	public PanCardUni getCard() {
		return card;
	}
	public void setCard(PanCardUni card) {
		this.card = card;
	}
	@Override
	public String toString() {
		return "PersonUni [id=" + id + ", name=" + name + ", phone=" + phone + "]";
	}
}
