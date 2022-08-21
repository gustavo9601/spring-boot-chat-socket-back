package com.gustavomp.springboot.chat.springbootchatsocketback;


import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker // Habilitar el socket en spring
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {


    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {

        // Registra el endpoint del socket
        registry.addEndpoint("/chat-websocket")
                .setAllowedOrigins("http://localhost:4200") // Habilitando cors
                .withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        // Configurando el broker de mensajes
        registry.enableSimpleBroker("/chat/"); // Prefijo del evento o canal
        registry.setApplicationDestinationPrefixes("/app"); // Prefijo destino donde se publicara
    }
}
