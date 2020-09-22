package com.devsuperior.dspesquisa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devsuperior.dspesquisa.entities.Record;

//TO REGISTER AS A COMPONENT MANAGED BY SPRINGBOOT. WE CAN ALSO USE @COMPONENT
@Repository

//JPA INTERFACE THAT PROVIDES ALL THE METHODS OF THE DATA ACCESS LAYER
public interface RecordRepository extends JpaRepository<Record, Long>{

}
