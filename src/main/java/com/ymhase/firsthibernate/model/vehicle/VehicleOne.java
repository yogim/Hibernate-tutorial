package com.ymhase.firsthibernate.model.vehicle;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.ymhase.firsthibernate.model.UserEleven;

@Entity
@Table(name = "vehicle")
public class VehicleOne {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int VehicleId;
	private String vehicleName;
	@ManyToOne
	private UserEleven userDetails;

	public UserEleven getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(UserEleven userDetails) {
		this.userDetails = userDetails;
	}

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

}
