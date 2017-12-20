package com.intercollab.monitoring.dao;


import com.intercollab.monitoring.domain.ActivityLog;
import com.intercollab.monitoring.domain.ActivityLogLevel;
import com.intercollab.monitoring.domain.UserType;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.intercollab.monitoring.domain.ActivityLogType.*;


/**
 * Created by andrii on 6/24/17.
 */

@Component
public class ActivityLogDao extends GlobalDao {


    public void startLog() {
        create(new ActivityLog(0, -1, "system", "System Start",
                "Start", UserType.SYSTEM, "", ActivityLogLevel.DEBUG));
    }


    public void shutDownLog() {
        create(new ActivityLog(0, -1, "system", "System Shutdown",
                "Shutdown", UserType.SYSTEM, "", ActivityLogLevel.ERROR));
    }


    public ActivityLog getByKey(String keyName, Object keyValue) {
        String SQL = "SELECT * FROM activity_log WHERE " + keyName + "=?";
        return jdbcTemplate.queryForObject(SQL, new Object[]{keyValue}, new ActivityLogMapper());
    }


    public Integer create(ActivityLog entity) {

        int id = getId("activity_log_seq");
        String SQL = "INSERT INTO activity_log (" +

                ACTIVITY_LOG_ID.getSqlName() + ", " +
                COMPANY_ID.getSqlName() + ", " +
                USER_ID.getSqlName() + ", " +
                EMAIL.getSqlName() + ", " +
                MESSAGE.getSqlName() + ", " +

                PAGE.getSqlName() + ", " +
                LEVEL.getSqlName() + ", " +
                IP.getSqlName() + ", " +
                TYPE.getSqlName() + ") " +

                " VALUES(?,?,?,?,?, ?,?,?,?)";

        jdbcTemplate.update(SQL, id
                , entity.getCompanyId()
                , entity.getUserId()
                , entity.getEmail()
                , entity.getMessage() == null ? "" : entity.getMessage()

                , entity.getPage()
                , entity.getLevel().toString()
                , entity.getIp()
                , entity.getType().toString()
        );
        return id;
    }


    public void update(ActivityLog entity) {
        throw new UnsupportedOperationException();
    }


    public void delete(Integer id) {
        throw new UnsupportedOperationException();
    }


    public List<ActivityLog> getAll(String clause) {

        String SQL = "SELECT * FROM activity_log WHERE " + ACTIVITY_LOG_ID.getSqlName() + " > 0 " + clause;
        return jdbcTemplate.query(SQL, new ActivityLogMapper());
    }

}
