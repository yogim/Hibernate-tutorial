package com.ymhase.firsthibernate.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ymhase.firsthibernate.model.address.AddressModel;

@Entity
@Table(name = "USER_SIX")
public class UserSix {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "user_name")
	private String name;

	@ElementCollection
	private Set<AddressModel> addressSet = new HashSet<AddressModel>();

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

	public Set<AddressModel> getAddressSet() {
		return addressSet;
	}

	public void setAddressSet(Set<AddressModel> addressSet) {
		this.addressSet = addressSet;
	}

}
