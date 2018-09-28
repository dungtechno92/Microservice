package com.ntq.stock.dbservice.repository;

import com.ntq.stock.dbservice.entity.Quote;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by DUNGDV on 9/26/2018.
 */
public interface QuoteRepository extends JpaRepository<Quote, Integer> {
    List<Quote> findByUserName(String userName);
}
