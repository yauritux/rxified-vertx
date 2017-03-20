package app;

import app.verticles.RxJavaWebVerticle;
import app.verticles.Service1;
import app.verticles.Service2;
import app.verticles.Service3;
import io.vertx.core.DeploymentOptions;
import io.vertx.core.Vertx;

public class VertxStarter {

    public static void main(String... args) {
        Vertx vertx = Vertx.vertx();

        DeploymentOptions options = new DeploymentOptions().setWorker(true);
        vertx.deployVerticle(new Service1(), 
            stringAsyncResult -> System.out.println("Successfully deployed Service1."));
        vertx.deployVerticle(new Service2(), 
            stringAsyncResult -> System.out.println("Successfully deployed Service2."));
        vertx.deployVerticle(new Service3(), 
            stringAsyncResult -> System.out.println("Successfully deployed Service3"));
        vertx.deployVerticle(new RxJavaWebVerticle(), options,
            stringAsyncResult -> System.out.println("Successfully deployed RxJavaWebVerticle."));
    }
}