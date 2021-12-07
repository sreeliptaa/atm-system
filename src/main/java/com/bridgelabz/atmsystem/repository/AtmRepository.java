package com.bridgelabz.atmsystem.repository;

import com.bridgelabz.atmsystem.entity.AtmEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Purpose : To implement the interface which extends database operations
 *
 * @author SREELIPTA
 * @since 02-12-2021
 */
public interface AtmRepository extends JpaRepository<AtmEntity, Integer> {

}
