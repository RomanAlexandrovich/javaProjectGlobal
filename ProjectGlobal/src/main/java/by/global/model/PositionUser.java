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
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "position_users")
public @Data class PositionUser {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_position")
	private int idPosition;
	@Column(name = "name_position")
	private String namePosition;
	public int getIdPosition() {
		return idPosition;
	}
	public void setIdPosition(int idPosition) {
		this.idPosition = idPosition;
	}
	public String getNamePosition() {
		return namePosition;
	}
	public void setNamePosition(String namePosition) {
		this.namePosition = namePosition;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idPosition;
		result = prime * result + ((namePosition == null) ? 0 : namePosition.hashCode());
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
		PositionUser other = (PositionUser) obj;
		if (idPosition != other.idPosition)
			return false;
		if (namePosition == null) {
			if (other.namePosition != null)
				return false;
		} else if (!namePosition.equals(other.namePosition))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "PositionUser [idPosition=" + idPosition + ", namePosition=" + namePosition + "]";
	}
	
}
