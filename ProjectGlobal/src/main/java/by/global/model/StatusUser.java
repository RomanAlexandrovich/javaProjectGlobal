package by.global.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="user_status")
@AllArgsConstructor
@NoArgsConstructor
public @Data class StatusUser {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_status_id")
private int idStatusUser;
	@Column(name="user_status_name")	
private String nameStatusUser;

//	Get and Set
	
	public int getIdStatusUser() {
		return idStatusUser;
	}
	public void setIdStatusUser(int idStatusUser) {
		this.idStatusUser = idStatusUser;
	}
	public String getNameStatusUser() {
		return nameStatusUser;
	}
	public void setNameStatusUser(String nameStatusUser) {
		this.nameStatusUser = nameStatusUser;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idStatusUser;
		result = prime * result + ((nameStatusUser == null) ? 0 : nameStatusUser.hashCode());
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
		StatusUser other = (StatusUser) obj;
		if (idStatusUser != other.idStatusUser)
			return false;
		if (nameStatusUser == null) {
			if (other.nameStatusUser != null)
				return false;
		} else if (!nameStatusUser.equals(other.nameStatusUser))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "StatusUser [idStatusUser=" + idStatusUser + ", nameStatusUser=" + nameStatusUser + "]";
	}
	
	
}
