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
@Table(name="project_status")
@AllArgsConstructor
@NoArgsConstructor
public @Data class StatusProject {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="project_status_id")
private int idStatusProject;
	@Column(name="project_status_name")	
private String nameStatusProject;
//	GET and SET
	public int getIdStatusProject() {
		return idStatusProject;
	}
	public void setIdStatusProject(int idStatusProject) {
		this.idStatusProject = idStatusProject;
	}
	public String getNameStatusProject() {
		return nameStatusProject;
	}
	public void setNameStatusProject(String nameStatusProject) {
		this.nameStatusProject = nameStatusProject;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idStatusProject;
		result = prime * result + ((nameStatusProject == null) ? 0 : nameStatusProject.hashCode());
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
		StatusProject other = (StatusProject) obj;
		if (idStatusProject != other.idStatusProject)
			return false;
		if (nameStatusProject == null) {
			if (other.nameStatusProject != null)
				return false;
		} else if (!nameStatusProject.equals(other.nameStatusProject))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "StatusProject [idStatusProject=" + idStatusProject + ", nameStatusProject=" + nameStatusProject + "]";
	}
	

	
	
}