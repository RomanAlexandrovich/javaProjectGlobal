package by.global.model;
import java.util.List;
import java.util.Set;

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
import javax.persistence.Transient;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name="usr")
@AllArgsConstructor
@NoArgsConstructor
public @Data class UserMY {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_user")
	private int idUser;
	
	@Column(name = "user_name")
	private String nameUser;
	
	@Column(name = "user_lastname")
	private String lastnameUser;
	@Column(name = "user_password")
	private String passwordUser;

	
	@Column(name = "user_email")
	private String emailUser;
	//время последнего входа
	//@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "user_last_used")
	private String lastUserdUser;
	@Transient
    private String passwordConfirm;
	@Column(name = "user_tel")
	private String telefonUser;
	
	@ManyToOne
	@JoinColumn(name = "user_id_status")
	private StatusUser statusUser;
	
	@ManyToOne
	@JoinColumn(name = "user_id_image_av")
	private ImageUser avatarImageUser;
	
	@ManyToOne
	@JoinColumn(name = "user_id_position")
	private PositionUser positionUser;
	/*
	 * List of roles a user is a member of 
	 * (Список ролей, членом которых является пользователь)
	*/
	@ManyToMany(fetch = FetchType.LAZY) //
	@JoinTable(name = "users_roles", joinColumns = { @JoinColumn(name = "user_id") },
	inverseJoinColumns = {@JoinColumn(name = "role_id") })
	private Set<Roles> rolesUser;
	
	@ManyToMany(fetch = FetchType.LAZY) //
	@JoinTable(name = "projects_users", joinColumns = { @JoinColumn(name = "user_id") },
	inverseJoinColumns = {@JoinColumn(name = "project_id") })
	private List<ProjectGlobal> listProject;
	
	public List<ProjectGlobal> getListProject() {
		return listProject;
	}
	public void setListProject(List<ProjectGlobal> listProject) {
		this.listProject = listProject;
	}
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public String getNameUser() {
		return nameUser;
	}
	public void setNameUser(String nameUser) {
		this.nameUser = nameUser;
	}
	public String getLastnameUser() {
		return lastnameUser;
	}
	public void setLastnameUser(String lastnameUser) {
		this.lastnameUser = lastnameUser;
	}
	public String getPasswordUser() {
		return passwordUser;
	}
	public void setPasswordUser(String passwordUser) {
		this.passwordUser = passwordUser;
	}
	public String getEmailUser() {
		return emailUser;
	}
	public void setEmailUser(String emailUser) {
		this.emailUser = emailUser;
	}
	public String getLastUserdUser() {
		return lastUserdUser;
	}
	public void setLastUserdUser(String lastUserdUser) {
		this.lastUserdUser = lastUserdUser;
	}
	public String getPasswordConfirm() {
		return passwordConfirm;
	}
	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}
	public String getTelefonUser() {
		return telefonUser;
	}
	public void setTelefonUser(String telefonUser) {
		this.telefonUser = telefonUser;
	}
	public StatusUser getStatusUser() {
		return statusUser;
	}
	public void setStatusUser(StatusUser statusUser) {
		this.statusUser = statusUser;
	}
	public ImageUser getAvatarImageUser() {
		return avatarImageUser;
	}
	public void setAvatarImageUser(ImageUser avatarImageUser) {
		this.avatarImageUser = avatarImageUser;
	}
	public PositionUser getPositionUser() {
		return positionUser;
	}
	public void setPositionUser(PositionUser positionUser) {
		this.positionUser = positionUser;
	}
	public Set<Roles> getRolesUser() {
		return rolesUser;
	}
	public void setRolesUser(Set<Roles> rolesUser) {
		this.rolesUser = rolesUser;
	}
	@Override
	public String toString() {
		return "UserMY [idUser=" + idUser + ", nameUser=" + nameUser + ", lastnameUser=" + lastnameUser
				+ ", passwordUser=" + passwordUser + ", emailUser=" + emailUser + ", lastUserdUser=" + lastUserdUser
				+ ", passwordConfirm=" + passwordConfirm + ", telefonUser=" + telefonUser + ", statusUser=" + statusUser
				+ ", avatarImageUser=" + avatarImageUser + ", positionUser=" + positionUser + ", rolesUser=" + rolesUser
				+ ", listProject=" + listProject + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((avatarImageUser == null) ? 0 : avatarImageUser.hashCode());
		result = prime * result + ((emailUser == null) ? 0 : emailUser.hashCode());
		result = prime * result + idUser;
		result = prime * result + ((lastUserdUser == null) ? 0 : lastUserdUser.hashCode());
		result = prime * result + ((lastnameUser == null) ? 0 : lastnameUser.hashCode());
		result = prime * result + ((listProject == null) ? 0 : listProject.hashCode());
		result = prime * result + ((nameUser == null) ? 0 : nameUser.hashCode());
		result = prime * result + ((passwordConfirm == null) ? 0 : passwordConfirm.hashCode());
		result = prime * result + ((passwordUser == null) ? 0 : passwordUser.hashCode());
		result = prime * result + ((positionUser == null) ? 0 : positionUser.hashCode());
		result = prime * result + ((rolesUser == null) ? 0 : rolesUser.hashCode());
		result = prime * result + ((statusUser == null) ? 0 : statusUser.hashCode());
		result = prime * result + ((telefonUser == null) ? 0 : telefonUser.hashCode());
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
		UserMY other = (UserMY) obj;
		if (avatarImageUser == null) {
			if (other.avatarImageUser != null)
				return false;
		} else if (!avatarImageUser.equals(other.avatarImageUser))
			return false;
		if (emailUser == null) {
			if (other.emailUser != null)
				return false;
		} else if (!emailUser.equals(other.emailUser))
			return false;
		if (idUser != other.idUser)
			return false;
		if (lastUserdUser == null) {
			if (other.lastUserdUser != null)
				return false;
		} else if (!lastUserdUser.equals(other.lastUserdUser))
			return false;
		if (lastnameUser == null) {
			if (other.lastnameUser != null)
				return false;
		} else if (!lastnameUser.equals(other.lastnameUser))
			return false;
		if (listProject == null) {
			if (other.listProject != null)
				return false;
		} else if (!listProject.equals(other.listProject))
			return false;
		if (nameUser == null) {
			if (other.nameUser != null)
				return false;
		} else if (!nameUser.equals(other.nameUser))
			return false;
		if (passwordConfirm == null) {
			if (other.passwordConfirm != null)
				return false;
		} else if (!passwordConfirm.equals(other.passwordConfirm))
			return false;
		if (passwordUser == null) {
			if (other.passwordUser != null)
				return false;
		} else if (!passwordUser.equals(other.passwordUser))
			return false;
		if (positionUser == null) {
			if (other.positionUser != null)
				return false;
		} else if (!positionUser.equals(other.positionUser))
			return false;
		if (rolesUser == null) {
			if (other.rolesUser != null)
				return false;
		} else if (!rolesUser.equals(other.rolesUser))
			return false;
		if (statusUser == null) {
			if (other.statusUser != null)
				return false;
		} else if (!statusUser.equals(other.statusUser))
			return false;
		if (telefonUser == null) {
			if (other.telefonUser != null)
				return false;
		} else if (!telefonUser.equals(other.telefonUser))
			return false;
		return true;
	}
	
}
