package com.msointerceptor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.msointerceptor.model.Quote;

@Repository
public interface QuoteRepository extends JpaRepository<Quote, Integer>{

}
