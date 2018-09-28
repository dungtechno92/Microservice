package com.ntq.stock.stockservice.resource;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.net.UnknownHostException;
import java.util.List;

/**
 * Created by DUNGDV on 9/27/2018.
 */

@FeignClient(name="db-service" )
@RibbonClient(name="db-service")
public interface DbServiceProxy {
    @GetMapping("rest/db/quote/{username}")
    public List<String> getQuotes(@PathVariable("username") final String username);
}
