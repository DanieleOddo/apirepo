package acme.oddo.trnsrv.model.repositories;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import acme.oddo.trnsrv.model.entities.TransactionEntity;

@Repository
public interface TransactionRepository extends CrudRepository<TransactionEntity, Integer> {

     //  I'm going to use a Native query!
     @Query(value = "SELECT SUM(IMP_VALUE) FROM T_TRANSACTION WHERE CUSTOMERID = :customerID AND ACCOUNTID = :accountID" , nativeQuery = true)
     public BigDecimal findByCustomerIDAndAccountID(@Param ("customerID") Integer customerID, @Param ("accountID") Integer accountID);
 
     public List<TransactionEntity> findAllByCustomerIDAndAccountID(Integer customerID, Integer accountID);    
     
 }
    
