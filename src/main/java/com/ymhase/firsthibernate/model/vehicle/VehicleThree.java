package com.ymhase.firsthibernate.model.vehicle;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.ymhase.firsthibernate.model.UserTwelve;

@Entity
@Table(name = "VEHICLE")
public class VehicleThree {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int VehicleId;
	
	private String vehicleName;
	
	@ManyToMany(mappedBy = "Vehiclelist")
	private Collection<UserTwelve> userList = new ArrayList<UserTwelve>();

	public int getVehicleId() {
		return VehicleId;
	}

	public void setVehicleId(int vehicleId) {
		VehicleId = vehicleId;
	}

	public String getVehicleName() {
		return vehicleName;
	}

	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}

	public Collection<UserTwelve> getUserList() {
		return userList;
	}

	public void setUserList(Collection<UserTwelve> userList) {
		this.userList = userList;
	}

}
