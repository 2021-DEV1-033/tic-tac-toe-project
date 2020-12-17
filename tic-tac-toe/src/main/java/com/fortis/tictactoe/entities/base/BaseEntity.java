package com.fortis.tictactoe.entities.base;

import java.io.Serializable;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Objects;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fortis.tictactoe.tools.DateConstants;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(unique = true, nullable = false)
	private String uuid;

	@Column(name = "created_at", nullable = false)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DateConstants.OFFSET_DATE_TIME_PATTERN)
	protected OffsetDateTime createdAt;

	@Column(name = "updated_at", nullable = true)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DateConstants.OFFSET_DATE_TIME_PATTERN)
	protected OffsetDateTime updatedAt;

	/**
	 * On create.
	 */
	@PrePersist
	protected void onCreate() {
		this.uuid = UUID.randomUUID().toString();
		this.updatedAt = this.createdAt = OffsetDateTime.now(ZoneOffset.UTC);
	}

	/**
	 * On update.
	 */
	@PreUpdate
	protected void onUpdate() {
		updatedAt = OffsetDateTime.now();
	}

	/**
	 * @return the uuid
	 */
	public String getUuid() {
		return uuid;
	}

	/**
	 * @param uuid the uuid to set
	 */
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	/**
	 * @return the created offset date time
	 */
	public OffsetDateTime getCreatedAt() {
		return createdAt;
	}

	/**
	 * @param createdAt the create offset date time to set
	 */
	public void setCreatedAt(OffsetDateTime createdAt) {
		this.createdAt = createdAt;
	}

	/**
	 * @return the update offset date time
	 */
	public OffsetDateTime getUpdatedAt() {
		return updatedAt;
	}

	/**
	 * @param updatedAt the update date to set
	 */
	public void setUpdatedAt(OffsetDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	/**
	 * @return the serial version uid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(uuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof BaseEntity)) {
			return false;
		}
		BaseEntity other = (BaseEntity) obj;
		return Objects.equals(uuid, other.uuid);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BaseEntity [uuid=");
		builder.append(uuid);
		builder.append(", createdAt=");
		builder.append(createdAt);
		builder.append(", updatedAt=");
		builder.append(updatedAt);
		builder.append("]");
		return builder.toString();
	}

	
}
