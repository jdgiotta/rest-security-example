package com.giotta.rest.security.examples.model;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;

/**
 * @author John D Giotta
 * @since 6/1/16
 */
@MappedSuperclass
public abstract class PublishableEntity {
    private AccessStatus status = AccessStatus.DRAFT;

    @Column
    @Enumerated(EnumType.STRING)
    public AccessStatus getStatus() {
        return status;
    }

    public void setStatus(AccessStatus status) {
        this.status = status;
    }
}

