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
@Table(name="task_status")
@AllArgsConstructor
@NoArgsConstructor
public @Data class StatusTask {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_task_status")
private int idStatusTask;
	@Column(name="name_task_status")	
private String nameStatusTask;
//	
	public int getIdStatusTask() {
		return idStatusTask;
	}
	public void setIdStatusTask(int idStatusTask) {
		this.idStatusTask = idStatusTask;
	}
	public String getNameStatusTask() {
		return nameStatusTask;
	}
	public void setNameStatusTask(String nameStatusTask) {
		this.nameStatusTask = nameStatusTask;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idStatusTask;
		result = prime * result + ((nameStatusTask == null) ? 0 : nameStatusTask.hashCode());
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
		StatusTask other = (StatusTask) obj;
		if (idStatusTask != other.idStatusTask)
			return false;
		if (nameStatusTask == null) {
			if (other.nameStatusTask != null)
				return false;
		} else if (!nameStatusTask.equals(other.nameStatusTask))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "StatusTask [idStatusTask=" + idStatusTask + ", nameStatusTask=" + nameStatusTask + "]";
	}
	

}
