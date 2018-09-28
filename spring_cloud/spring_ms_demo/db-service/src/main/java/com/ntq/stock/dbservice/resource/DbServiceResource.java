package com.ntq.stock.dbservice.resource;

import com.ntq.stock.dbservice.entity.Quote;
import com.ntq.stock.dbservice.entity.Quotes;
import com.ntq.stock.dbservice.repository.QuoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by DUNGDV on 9/26/2018.
 */
@RestController
@RequestMapping("rest/db")
public class DbServiceResource {

    @Autowired
    QuoteRepository quoteRepository;

    @Autowired
    Environment environment;

    @GetMapping("/quote/{username}")
    public List<String> getQuotes(@PathVariable("username") final String username) throws UnknownHostException {
        String port = environment.getProperty("local.server.port");
        System.out.println("Done getQuotes on " + port);
        return getQuotesByUserName(username);
    }

    @PostMapping("/quote")
    public List<String> add(@RequestBody final Quotes quotes) throws UnknownHostException {
        String port = environment.getProperty("local.server.port");
        System.out.println("Done getQuotes on " + port);
        quotes.getQuotes()
            .stream().forEach(quote -> {
                quoteRepository.save(new Quote(quotes.getUserName(), quote));
            });
        return getQuotesByUserName(quotes.getUserName());
    }

    @DeleteMapping("/quote/{username}")
    public boolean deleteQuote(@PathVariable("username") final String username) throws UnknownHostException {
        String port = environment.getProperty("local.server.port");
        System.out.println("Done getQuotes on " + port);
        List<Quote> quotes = quoteRepository.findByUserName(username);
        quoteRepository.delete(quotes);

        return true;
    }

    private List<String> getQuotesByUserName(@PathVariable("username") String username) {
        List<String> quotes = quoteRepository.findByUserName(username).stream().map(Quote::getQuote).collect(Collectors.toList());
        return quotes;
    }
}
