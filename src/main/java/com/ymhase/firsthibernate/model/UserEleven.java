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

import com.ymhase.firsthibernate.model.vehicle.VehicleOne;

@Entity
@Table(name = "USER_ELEVEN")
public class UserEleven {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String username;

	@OneToMany(cascade = { CascadeType.ALL })
	@JoinTable(name = "USER_VEHICLE", 
			   joinColumns = @JoinColumn(name = "USER_ID"), 
			   inverseJoinColumns = @JoinColumn(name = "VEHICLE_ID"))
	private Collection<VehicleOne> Vehiclelist = new ArrayList<VehicleOne>();

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

	public Collection<VehicleOne> getVehiclelist() {
		return Vehiclelist;
	}

	public void setVehiclelist(Collection<VehicleOne> vehiclelist) {
		Vehiclelist = vehiclelist;
	}

	
}
