package com.ymhase.firsthibernate.model;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ymhase.firsthibernate.model.address.AddressModel;


@Table(name = "user_five")
@Entity
public class UserFive {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name = "user_name")
	private String name;

	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "street", column = @Column(name = "home_street")),
			@AttributeOverride(name = "city", column = @Column(name = "home_city")),
			@AttributeOverride(name = "state", column = @Column(name = "home_state")),
			@AttributeOverride(name = "pin", column = @Column(name = "home_pin")) })
	private AddressModel homeAddress;

	@Embedded
	private AddressModel address;

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

	public AddressModel getAddress() {
		return address;
	}

	public void setAddress(AddressModel addr) {
		this.address = addr;
	}

	public AddressModel getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(AddressModel homeAddress) {
		this.homeAddress = homeAddress;
	}

}
