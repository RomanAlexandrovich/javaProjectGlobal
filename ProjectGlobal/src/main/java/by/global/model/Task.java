package by.global.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "task_project")
@AllArgsConstructor
@NoArgsConstructor
public @Data class Task {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_task")
	private int idTask;

	@Column(name = "task_name")
	private String nameTask;
	@Column(name = "task_comment")
	private String commentTask;
	@Column(name = "task_time")
	private String timeTask;

	@Column(name = "task_descriptions")
	private String descriptionsTask;

	@Column(name = "task_attachment")
	private String attachmentTask;
	// status id
	@ManyToOne
	@JoinColumn(name = "task_status_id")
	private StatusTask taskStatus;
	/*
	 * Task creation in this project (создание задачи в этом проекте)
	 */
	@ManyToOne
	@JoinColumn(name = "task_id_project_main")
	private ProjectGlobal creationTaskProjectMain;
	/*
	 * urgency of the task (срочность задачи)
	 */
	@ManyToOne
	@JoinColumn(name = "task_id_urgency")
	private Urgency urgencyTask;
	/*
	 * User who created the task (пользователь, который создал задачу)
	 */
	@ManyToOne
	@JoinColumn(name = "task_id_user_manager")
	private UserMY taskUserManager;
	/*
	 * Which user was assigned the task (какому пользователю была назначена задача)
	 */
	@ManyToOne
	@JoinColumn(name = "task_id_user")
	private UserMY taskUser;
	public int getIdTask() {
		return idTask;
	}
	public void setIdTask(int idTask) {
		this.idTask = idTask;
	}
	public String getNameTask() {
		return nameTask;
	}
	public void setNameTask(String nameTask) {
		this.nameTask = nameTask;
	}
	public String getCommentTask() {
		return commentTask;
	}
	public void setCommentTask(String commentTask) {
		this.commentTask = commentTask;
	}
	public String getTimeTask() {
		return timeTask;
	}
	public void setTimeTask(String timeTask) {
		this.timeTask = timeTask;
	}
	public String getDescriptionsTask() {
		return descriptionsTask;
	}
	public void setDescriptionsTask(String descriptionsTask) {
		this.descriptionsTask = descriptionsTask;
	}
	public String getAttachmentTask() {
		return attachmentTask;
	}
	public void setAttachmentTask(String attachmentTask) {
		this.attachmentTask = attachmentTask;
	}
	public StatusTask getTaskStatus() {
		return taskStatus;
	}
	public void setTaskStatus(StatusTask taskStatus) {
		this.taskStatus = taskStatus;
	}
	public ProjectGlobal getCreationTaskProjectMain() {
		return creationTaskProjectMain;
	}
	public void setCreationTaskProjectMain(ProjectGlobal creationTaskProjectMain) {
		this.creationTaskProjectMain = creationTaskProjectMain;
	}
	public Urgency getUrgencyTask() {
		return urgencyTask;
	}
	public void setUrgencyTask(Urgency urgencyTask) {
		this.urgencyTask = urgencyTask;
	}
	public UserMY getTaskUserManager() {
		return taskUserManager;
	}
	public void setTaskUserManager(UserMY taskUserManager) {
		this.taskUserManager = taskUserManager;
	}
	public UserMY getTaskUser() {
		return taskUser;
	}
	public void setTaskUser(UserMY taskUser) {
		this.taskUser = taskUser;
	}
	@Override
	public String toString() {
		return "Task [idTask=" + idTask + ", nameTask=" + nameTask + ", commentTask=" + commentTask + ", timeTask="
				+ timeTask + ", descriptionsTask=" + descriptionsTask + ", attachmentTask=" + attachmentTask
				+ ", taskStatus=" + taskStatus + ", creationTaskProjectMain=" + creationTaskProjectMain
				+ ", urgencyTask=" + urgencyTask + ", taskUserManager=" + taskUserManager + ", taskUser=" + taskUser
				+ "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((attachmentTask == null) ? 0 : attachmentTask.hashCode());
		result = prime * result + ((commentTask == null) ? 0 : commentTask.hashCode());
		result = prime * result + ((creationTaskProjectMain == null) ? 0 : creationTaskProjectMain.hashCode());
		result = prime * result + ((descriptionsTask == null) ? 0 : descriptionsTask.hashCode());
		result = prime * result + idTask;
		result = prime * result + ((nameTask == null) ? 0 : nameTask.hashCode());
		result = prime * result + ((taskStatus == null) ? 0 : taskStatus.hashCode());
		result = prime * result + ((taskUser == null) ? 0 : taskUser.hashCode());
		result = prime * result + ((taskUserManager == null) ? 0 : taskUserManager.hashCode());
		result = prime * result + ((timeTask == null) ? 0 : timeTask.hashCode());
		result = prime * result + ((urgencyTask == null) ? 0 : urgencyTask.hashCode());
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
		Task other = (Task) obj;
		if (attachmentTask == null) {
			if (other.attachmentTask != null)
				return false;
		} else if (!attachmentTask.equals(other.attachmentTask))
			return false;
		if (commentTask == null) {
			if (other.commentTask != null)
				return false;
		} else if (!commentTask.equals(other.commentTask))
			return false;
		if (creationTaskProjectMain == null) {
			if (other.creationTaskProjectMain != null)
				return false;
		} else if (!creationTaskProjectMain.equals(other.creationTaskProjectMain))
			return false;
		if (descriptionsTask == null) {
			if (other.descriptionsTask != null)
				return false;
		} else if (!descriptionsTask.equals(other.descriptionsTask))
			return false;
		if (idTask != other.idTask)
			return false;
		if (nameTask == null) {
			if (other.nameTask != null)
				return false;
		} else if (!nameTask.equals(other.nameTask))
			return false;
		if (taskStatus == null) {
			if (other.taskStatus != null)
				return false;
		} else if (!taskStatus.equals(other.taskStatus))
			return false;
		if (taskUser == null) {
			if (other.taskUser != null)
				return false;
		} else if (!taskUser.equals(other.taskUser))
			return false;
		if (taskUserManager == null) {
			if (other.taskUserManager != null)
				return false;
		} else if (!taskUserManager.equals(other.taskUserManager))
			return false;
		if (timeTask == null) {
			if (other.timeTask != null)
				return false;
		} else if (!timeTask.equals(other.timeTask))
			return false;
		if (urgencyTask == null) {
			if (other.urgencyTask != null)
				return false;
		} else if (!urgencyTask.equals(other.urgencyTask))
			return false;
		return true;
	}


}
