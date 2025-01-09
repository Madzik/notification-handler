package com.notificationhandler.infrastructure.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.sns.SnsClient;

@Configuration
@ConfigurationProperties(prefix = "aws")
public class AwsConfiguration {

    private String region;

    @Bean
    public SnsClient defaultSnsClient() {
        return SnsClient.builder()
                .region(Region.of(region))
                .build();
    }
}
