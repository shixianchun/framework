package com.jchj.config;


import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DBEncryptor {

    @Bean("jasyptStringEncryptor")
    public StringEncryptor stringEncryptor() {
        PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
        SimpleStringPBEConfig config = new SimpleStringPBEConfig();
        config.setPassword("fg976GH9876HJ98NM");
        config.setAlgorithm("PBEWITHHMACSHA512ANDAES_256");
        config.setKeyObtentionIterations("1000");
        config.setPoolSize("1");
        config.setProviderName("SunJCE");
        config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator");
        config.setIvGeneratorClassName("org.jasypt.iv.RandomIvGenerator");
        config.setStringOutputType("base64");
        encryptor.setConfig(config);
        return encryptor;
    }

    public static void main(String[] args) {
        StringEncryptor dbEncryptor=new DBEncryptor().stringEncryptor();
        String url = dbEncryptor.encrypt("jdbc:mysql://127.0.0.1:3306/jchj?characterEncoding=utf8&autoReconnect=true&useSSL=false");
        String name = dbEncryptor.encrypt("root");
        String password = dbEncryptor.encrypt("root");
        System.out.println(url);
        System.out.println(name);
        System.out.println(password);
        /**
         ADM3ib+psARoGTbU2McRh14KCFld6Jg/IVLrBGaE2NBqqq8Jp5K7K+N0P4B45sdJ5NNpattdvRjMwkWsjT7ve8DrxTtQTTCKfvIwsoqBAMEFTWXMi2pRkKdhIwiVwFbs4QvBi58M58fTb3GGtA+jdNvztcG55KYOsTuCZJw12z8=
         0jgsUFhtXHvCl7VN44yOV1jAa7de8Mw0R4Bol95RO7BZv/dIvvwcL2P9mxPdFuCV
         DlC0lB7yZjTJfRZb7xaZ3q0LOBzwmxlLaJele2cIxpGKYIQCFgJuuaggX4z3aD4N
         */
    }

}
