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
@Table(name="image_project")
public @Data class ImageProject {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_image_av_project")
private int idImageProject;
	@Column(name="image_url_project")	
private String urlImageProject;
//Get Set
	public int getIdImageProject() {
		return idImageProject;
	}
	public void setIdImageProject(int idImageProject) {
		this.idImageProject = idImageProject;
	}
	public String getUrlImageProject() {
		return urlImageProject;
	}
	public void setUrlImageProject(String urlImageProject) {
		this.urlImageProject = urlImageProject;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idImageProject;
		result = prime * result + ((urlImageProject == null) ? 0 : urlImageProject.hashCode());
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
		ImageProject other = (ImageProject) obj;
		if (idImageProject != other.idImageProject)
			return false;
		if (urlImageProject == null) {
			if (other.urlImageProject != null)
				return false;
		} else if (!urlImageProject.equals(other.urlImageProject))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "ImageProject [idImageProject=" + idImageProject + ", urlImageProject=" + urlImageProject + "]";
	}
	
}
