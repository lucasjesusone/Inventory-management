package com.ms.crud.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseModel {

    private int id;
    private int status;
    private String mensagem;
    private String error;
    private Date timestamp;
    private String path;

    public ResponseModel(int id, String mensagem) {
        this.id = id;
        this.mensagem = mensagem;
        this.timestamp = new Date();
    }

    public ResponseModel(int id, int status, String mensagem) {
        this.id = id;
        this.status = status;
        this.mensagem = mensagem;
        this.timestamp = new Date();
    }

    public ResponseModel(int id, int status, String mensagem, String path) {
        this.id = id;
        this.status = status;
        this.mensagem = mensagem;
        this.timestamp = new Date();
        this.path = path;
    }

    public ResponseModel(int id, int status, String mensagem, String erro, String path) {
        this.id = id;
        this.status = status;
        this.mensagem = mensagem;
        this.error = erro;
        this.timestamp = new Date();
        this.path = path;
    }
}