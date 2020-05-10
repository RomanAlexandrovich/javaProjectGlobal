package by.global.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "roles")
@AllArgsConstructor
@NoArgsConstructor
public @Data class Roles {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_role")
	private int idRole;
	@Column(name = "role_name")
	private String nameRole;
//	Получение списка пользователей по ролям
	@ManyToMany(fetch = FetchType.LAZY) //
	@JoinTable(name = "users_roles", joinColumns = { @JoinColumn(name = "role_id") }, inverseJoinColumns = {
			@JoinColumn(name = "user_id") })
	private List<UserMY> rolesUser = new ArrayList<UserMY>();
//GET and SET
	public int getIdRole() {
		return idRole;
	}
	public void setIdRole(int idRole) {
		this.idRole = idRole;
	}
	public String getNameRole() {
		return nameRole;
	}
	public void setNameRole(String nameRole) {
		this.nameRole = nameRole;
	}
	public List<UserMY> getRolesUser() {
		return rolesUser;
	}
	public void setRolesUser(List<UserMY> rolesUser) {
		this.rolesUser = rolesUser;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idRole;
		result = prime * result + ((nameRole == null) ? 0 : nameRole.hashCode());
		result = prime * result + ((rolesUser == null) ? 0 : rolesUser.hashCode());
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
		Roles other = (Roles) obj;
		if (idRole != other.idRole)
			return false;
		if (nameRole == null) {
			if (other.nameRole != null)
				return false;
		} else if (!nameRole.equals(other.nameRole))
			return false;
		if (rolesUser == null) {
			if (other.rolesUser != null)
				return false;
		} else if (!rolesUser.equals(other.rolesUser))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Roles [idRole=" + idRole + ", nameRole=" + nameRole + ", rolesUser=" + rolesUser + "]";
	}
	
	
	
}
