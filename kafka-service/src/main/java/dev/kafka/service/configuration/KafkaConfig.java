package dev.kafka.service.configuration;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaAdmin;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaConfig {
    private static final String BOOTSTRAP_SERVERS = "localhost:29092";
    private Topics topics = new Topics();

    @Bean
    public KafkaAdmin kafkaAdmin() {
        Map<String, Object> configs = new HashMap<>();
        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVERS);
        return new KafkaAdmin(configs);
    }

    @Bean
    public NewTopic security_action() {
        return new NewTopic(topics.SECURITY_ACTION, 3, (short) 1);
    }

    @Bean
    public NewTopic user_renew_membership_request() {
        return new NewTopic(topics.USER_RENEW_MEMBERSHIP_REQ , 3, (short) 1);
    }

    @Bean
    public NewTopic user_renew_membership_response() {
        return new NewTopic(topics.USER_SUBSCRIBE_SPORT_RES, 3, (short) 1);
    }

    @Bean
    public NewTopic user_subscribe_sport_request() {
        return new NewTopic(topics.USER_SUBSCRIBE_SPORT_REQ, 3, (short) 1);
    }

    @Bean
    public NewTopic user_subscribe_sport_response() {
        return new NewTopic(topics.USER_SUBSCRIBE_SPORT_RES, 3, (short) 1);
    }
}
