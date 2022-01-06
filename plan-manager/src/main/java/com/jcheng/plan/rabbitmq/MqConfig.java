package com.jcheng.plan.rabbitmq;

import org.springframework.amqp.core.*;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MqConfig {

    @Bean
    public DirectExchange remindExchange() {
        return ExchangeBuilder.directExchange(MqConstants.REMIND_EXCHANGE).durable(true).delayed().build();
    }

    @Bean
    public Queue remindQueue() {
        return new Queue(MqConstants.REMIND_QUEUE);
    }

    @Bean
    public Binding remindBinding(Queue remindQueue, DirectExchange remindExchange) {
        return BindingBuilder.bind(remindQueue).to(remindExchange).with(MqConstants.REMIND_ROUTE);
    }

    @Bean
    public MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}
