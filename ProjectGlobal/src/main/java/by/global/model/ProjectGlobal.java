package by.global.model;

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
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="project_main")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProjectGlobal {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_project")
	private int idProject;
	
	@Column(name = "project_name")
	private String nameProject;
	
	@Column(name = "project_descrptions")
	private String descriptionsProject;
	
	@Column(name = "project_name_key")
	private String keyNameProject;
	
//	статусы
	@ManyToOne
	@JoinColumn(name = "project_id_status")
	private StatusProject statusProject;
	/*
	 * project Manager
	 * (руководитель проекта)
	 */
	@ManyToOne
	@JoinColumn(name = "project_id_manager")
	private UserMY managerUser;
	/*
	 * avatar project
	 * (аватар проекта)
	 */
	@ManyToOne
	@JoinColumn(name = "project_id_image_av")
	private ImageProject imageAvatarProject;
	/*
	 * project task list
	 * (список задач проекта)
	 */
	@ManyToMany(fetch = FetchType.LAZY) //
	@JoinTable(name = "projectglobal_listtaskproject", joinColumns = { @JoinColumn(name = "project_id") },
	inverseJoinColumns = {@JoinColumn(name = "task_id") })
	private List<Task> listTask;
	/*
	 *list of users allowed to the project
	 *(список пользователей, допущенных к проекту)
	 */
	@ManyToMany(fetch = FetchType.LAZY) //
	@JoinTable(name = "projects_users", joinColumns = { @JoinColumn(name = "project_id") },
	inverseJoinColumns = {@JoinColumn(name = "user_id") })
	private List<UserMY> listUsers;
//	SET and GET
	public int getIdProject() {
		return idProject;
	}
	public void setIdProject(int idProject) {
		this.idProject = idProject;
	}
	public String getNameProject() {
		return nameProject;
	}
	public void setNameProject(String nameProject) {
		this.nameProject = nameProject;
	}
	public String getDescriptionsProject() {
		return descriptionsProject;
	}
	public void setDescriptionsProject(String descriptionsProject) {
		this.descriptionsProject = descriptionsProject;
	}
	public String getKeyNameProject() {
		return keyNameProject;
	}
	public void setKeyNameProject(String keyNameProject) {
		this.keyNameProject = keyNameProject;
	}
	public StatusProject getStatusProject() {
		return statusProject;
	}
	public void setStatusProject(StatusProject statusProject) {
		this.statusProject = statusProject;
	}
	public UserMY getManagerUser() {
		return managerUser;
	}
	public void setManagerUser(UserMY managerUser) {
		this.managerUser = managerUser;
	}
	public ImageProject getImageAvatarProject() {
		return imageAvatarProject;
	}
	public void setImageAvatarProject(ImageProject imageAvatarProject) {
		this.imageAvatarProject = imageAvatarProject;
	}
	public List<UserMY> getListUsers() {
		return listUsers;
	}
	public void setListUsers(List<UserMY> listUsers) {
		this.listUsers = listUsers;
	}
	public List<Task> getListTask() {
		return listTask;
	}
	public void setListTask(List<Task> listTask) {
		this.listTask = listTask;
	}
	@Override
	public String toString() {
		return "ProjectGlobal [idProject=" + idProject + ", nameProject=" + nameProject + ", descriptionsProject="
				+ descriptionsProject + ", keyNameProject=" + keyNameProject + ", statusProject=" + statusProject
				+ ", managerUser=" + managerUser + ", imageAvatarProject=" + imageAvatarProject + ", listTask="
				+ listTask + ", listUsers=" + listUsers + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descriptionsProject == null) ? 0 : descriptionsProject.hashCode());
		result = prime * result + idProject;
		result = prime * result + ((imageAvatarProject == null) ? 0 : imageAvatarProject.hashCode());
		result = prime * result + ((keyNameProject == null) ? 0 : keyNameProject.hashCode());
		result = prime * result + ((listTask == null) ? 0 : listTask.hashCode());
		result = prime * result + ((listUsers == null) ? 0 : listUsers.hashCode());
		result = prime * result + ((managerUser == null) ? 0 : managerUser.hashCode());
		result = prime * result + ((nameProject == null) ? 0 : nameProject.hashCode());
		result = prime * result + ((statusProject == null) ? 0 : statusProject.hashCode());
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
		ProjectGlobal other = (ProjectGlobal) obj;
		if (descriptionsProject == null) {
			if (other.descriptionsProject != null)
				return false;
		} else if (!descriptionsProject.equals(other.descriptionsProject))
			return false;
		if (idProject != other.idProject)
			return false;
		if (imageAvatarProject == null) {
			if (other.imageAvatarProject != null)
				return false;
		} else if (!imageAvatarProject.equals(other.imageAvatarProject))
			return false;
		if (keyNameProject == null) {
			if (other.keyNameProject != null)
				return false;
		} else if (!keyNameProject.equals(other.keyNameProject))
			return false;
		if (listTask == null) {
			if (other.listTask != null)
				return false;
		} else if (!listTask.equals(other.listTask))
			return false;
		if (listUsers == null) {
			if (other.listUsers != null)
				return false;
		} else if (!listUsers.equals(other.listUsers))
			return false;
		if (managerUser == null) {
			if (other.managerUser != null)
				return false;
		} else if (!managerUser.equals(other.managerUser))
			return false;
		if (nameProject == null) {
			if (other.nameProject != null)
				return false;
		} else if (!nameProject.equals(other.nameProject))
			return false;
		if (statusProject == null) {
			if (other.statusProject != null)
				return false;
		} else if (!statusProject.equals(other.statusProject))
			return false;
		return true;
	}	

	
	
	
}
