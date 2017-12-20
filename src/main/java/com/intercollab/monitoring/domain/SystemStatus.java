package com.intercollab.monitoring.domain;

import java.sql.Timestamp;

/**
 * Created by andrii on 12/18/17.
 */
public class SystemStatus {

    private SystemStatusType systemStatus;
    private Timestamp created;


    public SystemStatus(SystemStatusType systemStatus, Timestamp created) {
        this.systemStatus = systemStatus;
        this.created = created;
    }

    public SystemStatus(){

    }

    public SystemStatusType getSystemStatus() {
        return systemStatus;
    }

    public void setSystemStatus(SystemStatusType systemStatus) {
        this.systemStatus = systemStatus;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    @Override
    public String toString() {
        return "SystemStatus{" +
                "systemStatus=" + systemStatus +
                ", created=" + created +
                '}';
    }
}
