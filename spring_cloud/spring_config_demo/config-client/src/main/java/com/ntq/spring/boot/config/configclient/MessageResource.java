package com.ntq.spring.boot.config.configclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by DUNGDV on 9/26/2018.
 */
@RefreshScope
@RestController
@RequestMapping("/rest")
public class MessageResource {

    @Value("${message}")
    private String message;

    @GetMapping("/message")
    public String message() {
        return message;
    }
}
