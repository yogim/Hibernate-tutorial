package com.ymhase.firsthibernate.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.ymhase.firsthibernate.model.vehicle.VehicleThree;

@Entity
@Table(name = "USER_TWELVE")
public class UserTwelve {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String username;
	@ManyToMany
	private Collection<VehicleThree> Vehiclelist = new ArrayList<VehicleThree>();

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

	public Collection<VehicleThree> getVehiclelist() {
		return Vehiclelist;
	}

	public void setVehiclelist(Collection<VehicleThree> vehicleList) {
		Vehiclelist = vehicleList;
	}

}
