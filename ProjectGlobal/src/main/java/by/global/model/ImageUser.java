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
@Table(name="image_user")
public @Data class ImageUser {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_image_av_user")
private int idImageUser;
	@Column(name="image_url_user")	
private String urlImageUser;
	
//	Get SET
	public int getIdImageUser() {
		return idImageUser;
	}
	public void setIdImageUser(int idImageUser) {
		this.idImageUser = idImageUser;
	}
	public String getUrlImageUser() {
		return urlImageUser;
	}
	public void setUrlImageUser(String urlImageUser) {
		this.urlImageUser = urlImageUser;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idImageUser;
		result = prime * result + ((urlImageUser == null) ? 0 : urlImageUser.hashCode());
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
		ImageUser other = (ImageUser) obj;
		if (idImageUser != other.idImageUser)
			return false;
		if (urlImageUser == null) {
			if (other.urlImageUser != null)
				return false;
		} else if (!urlImageUser.equals(other.urlImageUser))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "ImageUser [idImageUser=" + idImageUser + ", urlImageUser=" + urlImageUser + "]";
	}

	
}
