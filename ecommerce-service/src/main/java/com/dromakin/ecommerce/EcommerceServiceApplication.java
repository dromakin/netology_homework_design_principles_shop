package com.dromakin.ecommerce;

import com.dromakin.ecommerce.services.SampleJobService;
import org.jobrunr.scheduling.JobScheduler;
import org.jobrunr.scheduling.cron.Cron;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class EcommerceServiceApplication {

    @Autowired
    private JobScheduler jobScheduler;

    public static void main(String[] args) {
        SpringApplication.run(EcommerceServiceApplication.class, args);
    }


    @PostConstruct
    public void scheduleRecurrently() {
        jobScheduler.<SampleJobService>scheduleRecurrently(x -> x.execute("a recurring job"), Cron.minutely());
    }
}
