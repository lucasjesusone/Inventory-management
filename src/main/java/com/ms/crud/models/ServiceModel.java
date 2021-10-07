package com.ms.crud.models;


import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name="services")
public class ServiceModel implements Serializable {

    private static final long serialVersionUid = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_service;
    private String serviceName;
    private String description;
    private LocalDateTime createdAt;

}
