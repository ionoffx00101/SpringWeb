package org.kdea.spring.websocket;

import org.springframework.context.annotation.*;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.socket.*;
import org.springframework.web.socket.config.annotation.*;
 
@Configuration
@EnableWebMvc
@EnableWebSocket
public class WebsocketConfig extends WebMvcConfigurerAdapter implements WebSocketConfigurer {
 
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        // /wsinit 요청이 들어오면 WebSocket 서버에 접속되도록 한다
        registry.addHandler(getHandler(), "/wsinit");
    }
 
    @Bean
    public WebSocketHandler getHandler() {
        return new HelloWebSocketHandler();
    }
 
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
}