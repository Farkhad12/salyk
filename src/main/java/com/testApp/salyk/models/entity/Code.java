package com.testApp.salyk.models.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "codes")
@Entity
public class Code {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String code;

    @CreationTimestamp
    Date startDate;
    Date endDate;


    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;
    }
