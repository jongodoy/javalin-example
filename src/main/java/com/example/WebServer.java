package com.example;

import com.google.common.net.MediaType;
import com.example.router.Router;
import com.example.router.ServerStartingHandler;
import io.javalin.Javalin;
import io.javalin.core.JavalinConfig;
import io.javalin.core.util.Header;
import lombok.Getter;

import javax.servlet.http.HttpServletResponse;
import java.util.function.Consumer;

public class WebServer {
    @Getter
    private final Javalin server;

    public WebServer(Consumer<JavalinConfig> config) {
        server = Javalin.create(config).events(event ->
                event.serverStarting(new ServerStartingHandler())
        );

        setPingHandler(server);
        server.routes(new Router());
    }

    public WebServer() {
        this(config -> {
        });
    }

    public void start(int port) {
        this.server.start(port);
    }

    public void stop() {
        this.server.stop();
    }

    private void setPingHandler(Javalin app) {
        app.get("/ping", context -> {
            context.status(HttpServletResponse.SC_OK);
            context.header(Header.CONTENT_TYPE, MediaType.PLAIN_TEXT_UTF_8.toString());
            context.result("pong");
        });
    }
}