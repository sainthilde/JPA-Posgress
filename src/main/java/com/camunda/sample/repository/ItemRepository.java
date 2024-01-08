package com.camunda.sample.repository;

import com.camunda.sample.models.ProcessCamunda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<ProcessCamunda,Long> {
    List<ProcessCamunda> findByUsername(String name);

}
