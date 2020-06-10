package com.example.currencyconverter.dao;

import com.example.currencyconverter.models.Admin;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AdminRepository extends CrudRepository<Admin, Long> {

}
