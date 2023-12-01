package cn.xd.learn.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.availability.AvailabilityChangeEvent;
import org.springframework.boot.availability.ReadinessState;
import org.springframework.boot.context.event.*;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class MyEventListener {

    Logger log = LoggerFactory.getLogger(MyEventListener.class);

    @EventListener
    public void applicationStartingEventListener(ApplicationStartingEvent event) {
        log.info(event.toString());
    }
    @EventListener
    public void applicationEnvironmentPreparedEventListener(ApplicationEnvironmentPreparedEvent event) {
        log.info(event.toString());
    }
    @EventListener
    public void applicationContextInitializedEventListener(ApplicationContextInitializedEvent event) {
        log.info(event.toString());
    }
    @EventListener
    public void applicationPreparedEventListener(ApplicationPreparedEvent event) {
        log.info(event.toString());
    }
    @EventListener
    public void applicationStartedEventListener(ApplicationStartedEvent event) {
        log.info(event.toString());
    }
    @EventListener
    public void applicationReadyEventListener(ApplicationReadyEvent event) {
        log.info(event.toString());
    }
    @EventListener
    public void onStateChange(AvailabilityChangeEvent<ReadinessState> event) {
        log.info(event.toString());
        log.info(event.getState().toString());
        switch (event.getState()) {
            case ACCEPTING_TRAFFIC:
                // create file /tmp/healthy
                break;
            case REFUSING_TRAFFIC:
                // remove file /tmp/healthy
                break;
        }
    }
}
