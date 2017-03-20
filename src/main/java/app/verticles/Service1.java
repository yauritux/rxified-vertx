package app.verticles;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;

public class Service1 extends AbstractVerticle {

    public static final String ADDRESS = "service-1";
    private static final Logger LOG = LoggerFactory.getLogger(Service1.class);

    @Override
    public void start() {
        LOG.info("Starting service-1...");
        vertx.eventBus().consumer(ADDRESS, message -> message.reply("[reply-from-service-1]"));
    }
}