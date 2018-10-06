package com.ymhase.firsthibernate.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "user_three")
public class UserThree {

	@Id
	private int id;
	private String name;
	@Transient
	private String ignoreField;
	@Temporal(TemporalType.DATE)
	private Date joinedDate;
	@Temporal(TemporalType.TIME)
	private Date Checkintime;

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

	public String getIgnoreField() {
		return ignoreField;
	}

	public void setIgnoreField(String ignoreField) {
		this.ignoreField = ignoreField;
	}

	public Date getJoinedDate() {
		return joinedDate;
	}

	public void setJoinedDate(Date joinedDate) {
		this.joinedDate = joinedDate;
	}

	public Date getCheckintime() {
		return Checkintime;
	}

	public void setCheckintime(Date checkintime) {
		Checkintime = checkintime;
	}

}
