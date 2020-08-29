package com.ferdingler.infrastructure.config;

import io.micronaut.context.annotation.ConfigurationProperties;

@ConfigurationProperties("flags")
public class FeatureFlags {

    private String skuGenerationStrategy;

    public String getSkuGenerationStrategy() {
        return skuGenerationStrategy;
    }

    public void setSkuGenerationStrategy(String skuGenerationStrategy) {
        this.skuGenerationStrategy = skuGenerationStrategy;
    }
}
