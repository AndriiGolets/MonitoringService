package com.intercollab.monitoring.domain;



import java.sql.Timestamp;

/**
 * Created by andrii on 6/24/17.
 */
public class ActivityLog {

    private Integer activityLogId;
    private Integer companyId;
    private Integer userId;
    private String email;
    private String message;
    private String page;
    private String ip;
    private ActivityLogLevel level;
    private UserType type;
    private Timestamp created;

    public ActivityLog(Integer companyId, Integer userId,
                       String email, String message, String page, UserType type, String ip, ActivityLogLevel logLevel) {
        this.companyId = companyId;
        this.userId = userId;
        this.email = email;
        this.message = message;
        this.page = page;
        this.type = type;
        this.ip = ip;
        level = logLevel;
    }

    public ActivityLog() {
    }

    public Integer getActivityLogId() {
        return activityLogId;
    }

    public void setActivityLogId(Integer activityLogId) {
        this.activityLogId = activityLogId;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public UserType getType() {
        return type;
    }

    public void setType(UserType type) {
        this.type = type;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public ActivityLogLevel getLevel() {
        return level;
    }

    public void setLevel(ActivityLogLevel level) {
        this.level = level;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    @Override
    public String toString() {
        return "ActivityLog{" +
                "activityLogId=" + activityLogId +
                ", companyId=" + companyId +
                ", userId=" + userId +
                ", email='" + email + '\'' +
                ", message='" + message + '\'' +
                ", page='" + page + '\'' +
                ", ip='" + ip + '\'' +
                ", level=" + level +
                ", type=" + type +
                ", created=" + created +
                '}';
    }
}
