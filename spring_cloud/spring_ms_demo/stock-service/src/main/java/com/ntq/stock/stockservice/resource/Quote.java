package com.ntq.stock.stockservice.resource;

/**
 * Created by DUNGDV on 9/26/2018.
 */

public class Quote {
    Integer id;

    String userName;

    String quote;

    public Quote(String userName, String quote) {
        this.userName = userName;
        this.quote = quote;
    }

    public Quote() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }
}
