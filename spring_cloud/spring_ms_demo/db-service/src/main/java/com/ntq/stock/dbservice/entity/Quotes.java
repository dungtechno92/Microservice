package com.ntq.stock.dbservice.entity;

import java.util.List;

/**
 * Created by DUNGDV on 9/26/2018.
 */
public class Quotes {
    private String userName;
    private List<String> quotes;

    public Quotes(String userName, List<String> quotes) {
        this.userName = userName;
        this.quotes = quotes;
    }

    public Quotes() {

    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<String> getQuotes() {
        return quotes;
    }

    public void setQuotes(List<String> quotes) {
        this.quotes = quotes;
    }
}
