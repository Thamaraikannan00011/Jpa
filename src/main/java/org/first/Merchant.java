package org.first;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@NamedQueries(value = {
		@NamedQuery(name = "fetchMerchantByEmailAndContact", query = "SELECT m FROM Merchant m WHERE m.email = ?1 AND m.contact = ?2"),
		@NamedQuery(name = "fetchMerchatByGSTId", query = "SELECT m FROM Merchant m WHERE m.gstId = ?1")
})

@Entity
public class Merchant {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "Name", nullable = false)
	private String name;
	@Column(name = "Company", nullable = false)
	private String companyName;
	@Column(name = "GSTId", nullable = false, unique = true)
	private String gstId;
	@Column(name = "Email", nullable = false, unique = true)
	private String email;
	@Column(name = "Password", nullable = false)
	private String password;
	@Column(name = "ContactNo", nullable = false, unique = true)
	private Long contact;
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
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getGstId() {
		return gstId;
	}
	public void setGstId(String gstId) {
		this.gstId = gstId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Long getContact() {
		return contact;
	}
	public void setContact(Long contact) {
		this.contact = contact;
	}
	@Override
	public String toString() {
		return "Merchant \n{\n	id = " + id + ",\n	name = " + name + ",\n	companyName = " + companyName + ",\n	gstId = " + gstId
				+ ",\n	email = " + email + ",\n	password = " + password + ",\n	contact = " + contact + "\n}\n";
	}
}
