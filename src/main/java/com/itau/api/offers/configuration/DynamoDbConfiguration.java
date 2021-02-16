package com.itau.api.offers.configuration;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.model.CreateTableRequest;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
import com.amazonaws.services.dynamodbv2.util.TableUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itau.api.offers.model.OffersCustomerModel;
import com.itau.api.offers.model.OffersModel;
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.FileCopyUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Configuration
@EnableDynamoDBRepositories(basePackages = "com.itau.api.offers")
public class DynamoDbConfiguration {

    @Value("${amazon.dynamodb.endpoint}")
    private String amazonDynamoDBEndpoint;

    @Value("${amazon.dynamodb.region}")
    private String amazonAWSRegion;

    @Value("${amazon.dynamodb.key}")
    private String amazonKey;

    @Value("${amazon.dynamodb.secret}")
    private String amazonSecret;

    @Bean
    public AmazonDynamoDB amazonDynamoDB() throws IOException {
        AmazonDynamoDB amazonDynamoDB = AmazonDynamoDBClientBuilder
                .standard()
                .withCredentials(new AWSStaticCredentialsProvider(amazonAWSCredentials()))
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(amazonDynamoDBEndpoint, amazonAWSRegion))
                .build();

        DynamoDBMapper dynamoDBMapper = new DynamoDBMapper(amazonDynamoDB);

        createTableOffers(amazonDynamoDB, dynamoDBMapper);
        createTableOffersCustomer(amazonDynamoDB, dynamoDBMapper);

        return amazonDynamoDB;
    }

    @Bean
    public AWSCredentials amazonAWSCredentials() {
        return new BasicAWSCredentials(
                amazonKey, amazonSecret);
    }

    private void createTableOffersCustomer(AmazonDynamoDB amazonDynamoDB
            ,DynamoDBMapper dynamoDBMapper) {
        CreateTableRequest tableRequest = dynamoDBMapper
                .generateCreateTableRequest(OffersCustomerModel.class);
        tableRequest.setProvisionedThroughput(
                new ProvisionedThroughput(1L, 1L));
        TableUtils.createTableIfNotExists(amazonDynamoDB, tableRequest);
    }

    private void createTableOffers(AmazonDynamoDB amazonDynamoDB
            ,DynamoDBMapper dynamoDBMapper) throws IOException {
        CreateTableRequest tableRequest = dynamoDBMapper
                .generateCreateTableRequest(OffersModel.class);
        tableRequest.setProvisionedThroughput(
                new ProvisionedThroughput(1L, 1L));
        if(TableUtils.createTableIfNotExists(amazonDynamoDB, tableRequest)) {
            ClassLoader classLoader = getClass().getClassLoader();
            byte[] dataArr = FileCopyUtils.copyToByteArray(classLoader.getResourceAsStream("offers.json"));
            String content = new String(dataArr, StandardCharsets.UTF_8);
            List<OffersModel> listCustomers= new ObjectMapper().readValue(content, new TypeReference<List<OffersModel>>(){});
            if (!listCustomers.isEmpty()) {
                dynamoDBMapper.batchSave(listCustomers);
            }

        }
    }


}
