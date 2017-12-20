package com.intercollab.monitoring.scheduler;

import com.intercollab.monitoring.dao.ActivityLogDao;
import com.intercollab.monitoring.dao.SystemStatusDao;
import com.intercollab.monitoring.domain.SystemStatus;
import com.intercollab.monitoring.service.EmailService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

import static com.intercollab.monitoring.domain.SystemStatusType.OFF;
import static com.intercollab.monitoring.domain.SystemStatusType.ON;

/**
 * Created by andrii on 12/16/17.
 */

@Component
@EnableScheduling
public class SchedulerTask {

    private static Logger LOG = Logger.getLogger(SchedulerTask.class);

    @Autowired
    private SystemStatusDao systemStatusDao;

    @Autowired
    private ActivityLogDao activityLogDao;

    @Autowired
    private EmailService emailService;

    private static final String CRON_TIME = "0/5 * * * * *"; // Every 5 seconds

    @Scheduled(cron = CRON_TIME)
    public void checkTime() {

        try {
            SystemStatus systemStatus = systemStatusDao.get();
            LocalTime time = systemStatus.getCreated().toLocalDateTime().toLocalTime();
            // LOG.info("--get ! + "+ systemStatus.toString());

            if (systemStatus.getSystemStatus() == ON) {
                if (time.plusSeconds(8L).isBefore(LocalTime.now())) {
                    activityLogDao.shutDownLog();
                    systemStatusDao.update(OFF);
                    emailService.sendMessages(
                            "PROISSUE SERVER TURN OFF",
                            "You received this message because proissue server was turned off. It can be system restart" +
                                    " for programs update in this case you have to receive SERVER START message in 2 minutes",
                            "a3060113@gmail.com");
                    LOG.info(" !! OFF");
                }
            } else {
                if (time.plusSeconds(8L).isAfter(LocalTime.now())) {
                    activityLogDao.startLog();
                    systemStatusDao.update(ON);
                    emailService.sendSimpleMessage(
                            "PROISSUE SERVER START",
                            "You received this message because proissue server was started. Maybe with some new updates )",
                            "a3060113@gmail.com");
                    LOG.info(" !! ON");
                }
            }
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
        }


    }
}
