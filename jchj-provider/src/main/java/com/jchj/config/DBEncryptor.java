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

//    public static void main(String[] args) {
//        StringEncryptor dbEncryptor=new DBEncryptor().stringEncryptor();
//        String url = dbEncryptor.encrypt("jdbc:mysql://192.168.110.140:3306/jchj?characterEncoding=utf8&autoReconnect=true&useSSL=false");
//        String name = dbEncryptor.encrypt("root");
//        String password = dbEncryptor.encrypt("root");
//        System.out.println(url);
//        System.out.println(name);
//        System.out.println(password);
//        /**
//         NrkSmz/3s1cgdNvTFfU7mOQwtEFjodV9ysO/bpB6imbFYH6nShpDExWnzNCKGVpLcES+wZ6e8TEArq83EP8LC592VutW87lyISBa74V4QliuGH9kr/fGiGg00ELPqkc6BsbDVblKc9ZRiUnpu4HWQoHYsrngwFy3TkdjI2t0FEQ=
//         LZmkNjmRG/4oce1AxSgvmofOPcyutyiB59hItqjdwTQPnMpQvns1zQ3PzX1xD8W3
//         cJ7sH0s5t1x/uHxDoZyVotVrSOXr9iWrkKv4Nqgeo0vsQ1aa3H3Xzs5G/PhnKeYu
//         */
//    }

}
