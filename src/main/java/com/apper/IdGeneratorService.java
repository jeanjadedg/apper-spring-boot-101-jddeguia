package com.apper;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class IdGeneratorService {

    public String givenUsingApache_whenGeneratingRandomAlphanumericString_thenCorrect(int size) {
        String generatedString = RandomStringUtils.randomAlphanumeric(size);

        return generatedString;
    }

    public String nextId() {

        return UUID.randomUUID().toString();
    }
}