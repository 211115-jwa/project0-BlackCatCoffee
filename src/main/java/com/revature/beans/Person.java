package com.revature.beans;

import java.util.List;

public class Person {
	private String personName;
	private int id;
	private String personEmail;
	private String personPassword;
	private boolean personHasMoney;
	private List<Bike>bikes;
	
	
	public String getPersonName() {
		return personName;
	}
	public void setPersonName(String personName) {
		this.personName = personName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPersonEmail() {
		return personEmail;
	}
	public void setPersonEmail(String personEmail) {
		this.personEmail = personEmail;
	}
	public String getPersonPassword() {
		return personPassword;
	}
	public void setPersonPassword(String personPassword) {
		this.personPassword = personPassword;
	}
	
	public boolean isPersonHasMoney() {
		return personHasMoney;
	}
	public void setPersonHasMoney(boolean personHasMoney) {
		this.personHasMoney = personHasMoney;
	}
	public List<Bike> getBikes() {
		return bikes;
	}
	public void setBikes(List<Bike> bikes) {
		this.bikes = bikes;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((personName == null) ? 0 : personName.hashCode());
		result = prime * result + id;
		result = prime * result + ((personEmail == null) ? 0 : personEmail.hashCode());
		result = prime * result + ((personPassword == null) ? 0 : personPassword.hashCode());
		result = prime * result + ((personHasMoney == false) ? 0 : 1);
		result = prime * result + ((bikes == null) ? 0 : bikes.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (personName == null) {
			if (other.personName != null)
				return false;
		} else if (!personName.equals(other.personName))
			return false;
		if (id != other.id)
			return false;
		if (personEmail == null) {
			if (other.personEmail != null)
				return false;
		} else if (!personEmail.equals(other.personEmail))
			return false;
		if (personPassword == null) {
			if (other.personPassword != null)
				return false;
		} else if (!personPassword.equals(other.personPassword))
			return false;
		if (personHasMoney != other.personHasMoney)
			return false;
		if (bikes == null) {
			if (other.bikes != null)
				return false;
		} else if (!bikes.equals(other.bikes))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Person [id=" + id + ", personName=" + personName + ", personEmail=" + personEmail + ", personPassword=" + personPassword
				+ ", personHasMoney=" + personHasMoney + ", bikes=" + bikes + "]";
	}
}
