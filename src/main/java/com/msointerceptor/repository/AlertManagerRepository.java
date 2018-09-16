package com.msointerceptor.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.msointerceptor.model.AlertManager;

@Repository
public interface AlertManagerRepository extends JpaRepository<AlertManager, Integer> {
	

/*	public Optional<AlertManager> findById(Integer id);
	
	public void deleteById(Integer id) ;*/
		
		

}
