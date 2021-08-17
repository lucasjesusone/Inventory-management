package com.ms.crud.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ms.crud.enums.EnumClient;
import lombok.Data;
import org.apache.catalina.User;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name="clients")
public class ClientModel implements Serializable {

//    private static final long serialVersionUid = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_client;
    private String cnpj;
    private String inscricaoEstadual;
    private String inscricaoMunicipal;
    private String razaoSocial;
    private String endereco;
    private String bairro;
    private String cep;
    private Number telefone;
    private String cidade;
    private String uf;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    @Enumerated(EnumType.STRING)
    private EnumClient status;
    @ManyToOne
    @JoinColumn
    private UserModel userModel;

}
