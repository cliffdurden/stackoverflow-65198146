package com.github.cliffdurden.stackoverflow65198146;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.*;
import lombok.*;

import java.util.*;

public class Test {

    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
//        mapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
        DataResponse metaResponse=mapper.readValue("{\n" +
                "  \"data\" : [ ],\n" +
                "  \"metadata\" : {}\n" +
                "}",DataResponse.class);
        System.out.println(metaResponse);
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Setter
    @Getter
    @ToString
    static class DataResponse {

        @JsonProperty
        private ArrayList<APIData>data;


        @JsonProperty
        private MetaData metadata;
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Setter
    @Getter
    @ToString
    static class MetaData {

        @JsonProperty
        private String transactionId;
    }


    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    @ToString
    static class APIData {


        @JsonProperty
        private Map<String,String> key;


        @JsonProperty
        private List<String> contacts;


    }
}
