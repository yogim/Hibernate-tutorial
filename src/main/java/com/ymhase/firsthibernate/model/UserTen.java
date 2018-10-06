package com.ymhase.firsthibernate.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.ymhase.firsthibernate.model.vehicle.Vehicle;

@Entity
@Table(name = "USER_TEN")
public class UserTen {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String username;
	@OneToMany(cascade = {CascadeType.ALL})
	//@JoinColumn(name = "VEHICLE_ID")
	@JoinTable(name="USER_VEHICLE",
			   joinColumns=@JoinColumn(name="USER_ID"),
			   inverseJoinColumns=@JoinColumn(name="VEHICLE_ID"))
	private Collection<Vehicle> Vehiclelist = new ArrayList<Vehicle>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Collection<Vehicle> getVehiclelist() {
		return Vehiclelist;
	}

	public void setVehiclelist(Collection<Vehicle> vehiclelist) {
		Vehiclelist = vehiclelist;
	}

	
}
