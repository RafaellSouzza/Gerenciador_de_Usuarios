package com.infnet.UsuariosAPI.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    public static final String QUEUE_USER = "userQueue";
    public static final String EXCHANGE_USER = "user.exchange";
    public static final String ROUTING_KEY_USER = "user.created";

    @Bean
    public Queue userQueue() {
        return new Queue(QUEUE_USER);
    }

    @Bean
    public TopicExchange userExchange() {
        return new TopicExchange(EXCHANGE_USER);
    }

    @Bean
    public Binding bindingUser() {
        return BindingBuilder.bind(userQueue()).to(userExchange()).with(ROUTING_KEY_USER);
    }
}
