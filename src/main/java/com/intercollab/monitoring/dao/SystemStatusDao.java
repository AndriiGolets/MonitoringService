package com.intercollab.monitoring.dao;


import com.intercollab.monitoring.domain.SystemStatus;
import com.intercollab.monitoring.domain.SystemStatusType;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by andrii on 12/18/17.
 */

@Component
public class SystemStatusDao extends GlobalDao {


    public void update(SystemStatusType status) {
        jdbcTemplate.update("UPDATE system_status SET system_status=?::system_status_type WHERE system_status_id=0", status.toString());
    }

    public SystemStatus get(){
        return jdbcTemplate.queryForObject("SELECT * FROM system_status WHERE system_status_id=0", new RowMapper<SystemStatus>() {
            @Override
            public SystemStatus mapRow(ResultSet resultSet, int i) throws SQLException {
                return new SystemStatus(SystemStatusType.valueOf(resultSet.getString("system_status"))
                        , resultSet.getTimestamp("created"));
            }
        });
    }

}
