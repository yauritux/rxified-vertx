package app.verticles;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;

public class Service3 extends AbstractVerticle {

    public static final String ADDRESS = "service-3";
    private static final Logger LOG = LoggerFactory.getLogger(Service3.class);

    @Override
    public void start() {
        LOG.info("Starting service-3...");
        vertx.eventBus().consumer(ADDRESS, event -> {
            String message = (String) event.body();
            event.reply(message + "-[passed-through-service-3]");
        });
    }
}