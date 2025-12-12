package com.charter.pinxt.recaptcha.service.config;

import com.charter.pinxt.common2.resttemplate.RestTemplateResponseErrorHandler;
import com.charter.pinxt.recaptcha.service.util.PropertyUtil;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;


@Configuration

public class AppConfig {

    private static final Logger logger = LoggerFactory.getLogger(AppConfig.class);
    @Autowired
    private PropertyUtil propertyUtil;

    @Value("${spring.redis.cluster.nodes}")
    private String redisNode;


    @Bean(name = "recaptchaObjectMapper")
    public ObjectMapper objectMapper() {

        return new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }


    @Bean(name = "recaptchaRestTemplate")
    public RestTemplate recaptchaRestTemplate(RestTemplateBuilder builder) {

        logger.info("Redis cluster node - {} ", redisNode);

        return buildRestTemplate("recaptchaRestTemplate", builder, propertyUtil.getCreateAssessmentRestConnectTimeout(),
            propertyUtil.getCreateAssessmentRestReadTimeout(), propertyUtil.getConnectRequestTimeout());
    }


    @Bean(name = "recoveryDomainServiceRestTemplate")
    public RestTemplate recoveryDomainServiceRestTemplate(RestTemplateBuilder builder) {

        return buildRestTemplate("recoveryDomainServiceRestTemplate", builder,
            propertyUtil.getRecoveryDomainServiceRestConnectTimeout(),
            propertyUtil.getRecoveryDomainServiceRestReadTimeout(), propertyUtil.getConnectRequestTimeout());
    }


    @Bean(name = "tdcsRestTemplate")
    public RestTemplate tdcsRestTemplate(RestTemplateBuilder builder) {

        return buildRestTemplate("tdcsRestTemplate", builder, propertyUtil.getTdcsRestConnectTimeout(),
            propertyUtil.getTdcsRestReadTimeout(), propertyUtil.getConnectRequestTimeout());
    }


    /**
     * Create a new RestTemplate with the given configuration
     *
     * @param label Name of the RestTemplate object.
     * @param connectTimeout Maximum time that is waited for a connection to be
     *            established.
     * @param readTimeout Maximum time that is waited until data is received when a
     *            connection is established.
     * @param connectRequestTimeout The timeout how long we are willing to wait to
     *            get the connection from pool.
     */
    private RestTemplate buildRestTemplate(String label, RestTemplateBuilder builder, int connectTimeout,
        int readTimeout, int connectRequestTimeout) {

        logger.info(
            "{} connect timeout: {} milliseconds, read timeout: {} milliseconds, connection request timeout: {} milliseconds",
            label, connectTimeout, readTimeout, connectRequestTimeout);

        return builder.errorHandler(new RestTemplateResponseErrorHandler())
            .requestFactory(() -> requestFactory(connectTimeout, readTimeout, connectRequestTimeout))
            .build();
    }


    private HttpComponentsClientHttpRequestFactory requestFactory(int connectTimeout, int readTimeout,
        int connectRequestTimeout) {

        RequestConfig requestConfig = RequestConfig.custom()
            .setConnectionRequestTimeout(connectRequestTimeout)
            .setSocketTimeout(readTimeout)
            .setConnectTimeout(connectTimeout)
            .build();

        int maxConnections = propertyUtil.getRestTemplateMaxConnections();
        int connectionsPerRoute = propertyUtil.getRestTemplateConnectionsPerRoute();

        PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager();
        connectionManager.setMaxTotal(maxConnections);
        connectionManager.setDefaultMaxPerRoute(connectionsPerRoute);

        CloseableHttpClient httpClient = HttpClientBuilder.create()
            .setConnectionManager(connectionManager)
            .setDefaultRequestConfig(requestConfig)
            .build();
        return new HttpComponentsClientHttpRequestFactory(httpClient);
    }
}
