package org.first.onetooneassociation;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class AadharBi {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private long number;
	private String address;
	@OneToOne(mappedBy = "card")
	private UserBi userbi;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public long getNumber() {
		return number;
	}
	public void setNumber(long number) {
		this.number = number;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public UserBi getUserbi() {
		return userbi;
	}
	public void setUserbi(UserBi userbi) {
		this.userbi = userbi;
	}
	
	@Override
	public String toString() {
		return "AadharBi [id=" + id + ", number=" + number + ", address=" + address + "]";
	}
}
