package com.intercollab.monitoring.domain;


/**
 * Created by andrii on 6/24/17.
 */

public enum ActivityLogType {

    ACTIVITY_LOG_ID("activity_log_id"),
    COMPANY_ID("company_id"),
    USER_ID("user_id"),
    COMPANY_NAME("name"),
    EMAIL("email_login"),
    MESSAGE("message"),
    PAGE("page"),
    TYPE("type"),
    LEVEL("level"),
    POSTED("posted"),
    IP("ip");

    private String sql;

    ActivityLogType(String sqlName) {
        this.sql = sqlName;
    }


    public String getSqlName() {
        return sql;
    }

}
