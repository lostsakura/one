package com.leavemails.one.task.config;

import com.leavemails.one.task.task.RefreshIpConnectionRecordTask;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import java.util.Objects;

/**
 * @author lostsakura
 * @date 2022-05-23 01:02
 */
@Configuration
public class QuartzConfig {

    @Bean(name = "refreshIpConnectionRecordJob")
    public MethodInvokingJobDetailFactoryBean refreshIpConnectionRecordJobDetail(RefreshIpConnectionRecordTask task) {
        MethodInvokingJobDetailFactoryBean jobDetailFactoryBean = new MethodInvokingJobDetailFactoryBean();
        jobDetailFactoryBean.setTargetObject(task);
        jobDetailFactoryBean.setTargetMethod("run");
        jobDetailFactoryBean.setConcurrent(false);
        return jobDetailFactoryBean;
    }

    @Bean(name = "refreshIpConnectionRecordTrigger")
    public CronTriggerFactoryBean refreshIpConnectionRecordCronTrigger(@Qualifier("refreshIpConnectionRecordJob") MethodInvokingJobDetailFactoryBean jobDetailFactoryBean) {
        CronTriggerFactoryBean cronTriggerFactoryBean = new CronTriggerFactoryBean();
        cronTriggerFactoryBean.setJobDetail(Objects.requireNonNull(jobDetailFactoryBean.getObject()));
        cronTriggerFactoryBean.setCronExpression("*/5 * * * * ?");
        return cronTriggerFactoryBean;
    }

    @Bean(name = "refreshIpConnectionRecordScheduler")
    public SchedulerFactoryBean refreshIpConnectionRecordScheduler(@Qualifier("refreshIpConnectionRecordTrigger") CronTriggerFactoryBean cronTriggerFactoryBean) {
        SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
        schedulerFactoryBean.setOverwriteExistingJobs(true);
        schedulerFactoryBean.setStartupDelay(5);
        schedulerFactoryBean.setTriggers(cronTriggerFactoryBean.getObject());
        return schedulerFactoryBean;
    }

}
