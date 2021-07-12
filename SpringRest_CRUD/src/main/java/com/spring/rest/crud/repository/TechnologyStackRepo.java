package com.spring.rest.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.rest.crud.model.TechnologyStack;

@Repository
public interface TechnologyStackRepo extends JpaRepository<TechnologyStack, Long> {

}
