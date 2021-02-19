package com.abapp.survey.backend.entity.base.base;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;
import javax.persistence.PostLoad;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;
import javax.persistence.Transient;
import javax.persistence.Version;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@MappedSuperclass
public abstract class BaseEntity implements Serializable {

    @Version
    private Long version;

    @Enumerated(EnumType.STRING)
    private Status status;
    @Column(length = 100, nullable = false)
    private String updatedBy;
    private LocalDateTime updateDate;
    @Transient
    private String updateDateStr;

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }

    public String getUpdateDateStr() {
        return updateDateStr;
    }

    public void setUpdateDateStr(String updateDateStr) {
        this.updateDateStr = updateDateStr;
    }

    @PostLoad
    public void dateStr() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        if (updateDate != null) {
            updateDateStr = formatter.format(updateDate);
        }
    }

    @PreUpdate
    public void preUpdate() {
        setUpdateDate(LocalDateTime.now());
    }

    @PrePersist
    public void prePersist() {
        setUpdateDate(LocalDateTime.now());
        if (status == null) {
            this.status = Status.ACTIVE;
        }
    }

    @PreRemove
    public void preRemove() {
        status = Status.DELETED;
        setUpdateDate(LocalDateTime.now());
    }
}
