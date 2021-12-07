package com.bridgelabz.atmsystem.entity;

import java.time.LocalDateTime;
import javax.persistence.*;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

/**
 * Purpose : To contain the entities in the database
 *
 * @author SREELIPTA
 * @since 04-12-2021
 */
@Entity
@Table(name = "atm")
@Data
public class AtmEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(unique = true)
    private String cardNumber;

    private String cardName;
    private int cvv;

    @CreationTimestamp
    private LocalDateTime createdOn;
    @UpdateTimestamp
    private LocalDateTime updatedOn;
}
