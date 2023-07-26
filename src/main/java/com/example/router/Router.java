package com.example.router;

import com.example.DependencyInjectionModule;
import com.google.common.base.Stopwatch;
import com.google.inject.Injector;
import io.javalin.apibuilder.EndpointGroup;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j
public class Router implements EndpointGroup {
    @Override
    public void addEndpoints() {
        Injector injector = DependencyInjectionModule.getInstance();
        Stopwatch stopwatch = Stopwatch.createStarted();

        long timeTakenToExecuteRouterInit = stopwatch.elapsed(TimeUnit.SECONDS);
        log.info("[init] Time taken to execute Router.init method: {}s", timeTakenToExecuteRouterInit);

    }
}
