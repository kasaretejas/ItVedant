package com.tejas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tejas.entities.BankAccount;

@Repository
public interface BankAccountRepository
extends JpaRepository<BankAccount, Long>{

}
