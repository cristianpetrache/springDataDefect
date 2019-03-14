package com.spring.data.bug.demo.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.io.Serializable;

public class ContactPK implements Serializable {

    private static final long serialVersionUID = 2552942475921227466L;

    private String userId;
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ContactPK contactPK = (ContactPK) o;

        return new EqualsBuilder()
                .append(userId, contactPK.userId)
                .append(type, contactPK.type)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(userId)
                .append(type)
                .toHashCode();
    }
}
