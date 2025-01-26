package com.notificationhandler.infrastructure.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.AwsCredentialsProvider;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.sns.SnsClient;
import software.amazon.awssdk.services.sqs.SqsClient;

@Configuration
@ConfigurationProperties(prefix = "aws")
public class AwsConfiguration {

    @Bean
    public SnsClient defaultSnsClient(@Value("${aws.region}") String region,
                                      AwsCredentialsProvider awsCredentialsProvider) {
        return SnsClient.builder()
                .credentialsProvider(awsCredentialsProvider)
                .region(Region.of(region))
                .build();
    }

    @Bean
    public SqsClient defaultSqsClient(@Value("${aws.region}") String region,
                                      AwsCredentialsProvider awsCredentialsProvider) {
        return SqsClient.builder()
                .credentialsProvider(awsCredentialsProvider)
                .region(Region.of(region))
                .build();
    }

    @Bean
    public AwsCredentialsProvider awsCredentialsProvider(@Value("${aws.accessKey}") String accessKey,
                                                         @Value("${aws.secretKey}") String secretKey) {
        AwsBasicCredentials awsBasicCredentials = AwsBasicCredentials.builder()
                .accessKeyId(accessKey)
                .secretAccessKey(secretKey)
                .build();
        return StaticCredentialsProvider.create(awsBasicCredentials);
    }
}
