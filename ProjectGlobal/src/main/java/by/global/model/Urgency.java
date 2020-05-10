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
@Table(name = "task_urgency")
@AllArgsConstructor
@NoArgsConstructor
public @Data class Urgency {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_urgency")
	private int idUrgency;

	@Column(name = "urgency_name")
	private String nameUrgency;

	public int getIdUrgency() {
		return idUrgency;
	}

	public void setIdUrgency(int idUrgency) {
		this.idUrgency = idUrgency;
	}

	public String getNameUrgency() {
		return nameUrgency;
	}

	public void setNameUrgency(String nameUrgency) {
		this.nameUrgency = nameUrgency;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idUrgency;
		result = prime * result + ((nameUrgency == null) ? 0 : nameUrgency.hashCode());
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
		Urgency other = (Urgency) obj;
		if (idUrgency != other.idUrgency)
			return false;
		if (nameUrgency == null) {
			if (other.nameUrgency != null)
				return false;
		} else if (!nameUrgency.equals(other.nameUrgency))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Urgency [idUrgency=" + idUrgency + ", nameUrgency=" + nameUrgency + "]";
	}

	
}
