package com.intercollab.monitoring.dao;

/**
 * Created by andrii on 6/24/17.
 */

import com.intercollab.monitoring.domain.ActivityLog;
import com.intercollab.monitoring.domain.ActivityLogLevel;
import com.intercollab.monitoring.domain.UserType;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import static com.intercollab.monitoring.domain.ActivityLogType.*;

public class ActivityLogMapper implements RowMapper<ActivityLog> {

    @Override
    public ActivityLog mapRow(ResultSet rs, int rowNum) throws SQLException {

        ActivityLog log = new ActivityLog();

        log.setActivityLogId(rs.getInt(ACTIVITY_LOG_ID.getSqlName()));
        log.setCompanyId(rs.getInt(COMPANY_ID.getSqlName()));
        log.setUserId(rs.getInt(USER_ID.getSqlName()));
        log.setEmail(rs.getString(EMAIL.getSqlName()));
        log.setMessage(rs.getString(MESSAGE.getSqlName()));
        log.setPage(rs.getString(PAGE.getSqlName()));
        log.setIp(rs.getString(IP.getSqlName()));
        log.setType(UserType.valueOf(rs.getString(TYPE.getSqlName())));
        log.setLevel(ActivityLogLevel.valueOf(rs.getString(LEVEL.getSqlName())));
        log.setCreated(rs.getTimestamp(POSTED.getSqlName()));

        return log;
    }
}
