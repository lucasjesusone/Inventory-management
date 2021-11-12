package com.ms.crud.dtos;


import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

@Data
@NotBlank
@NotNull
public class InvoiceDto {

    private String natureOfOperation;
    private Date issuanceDate;
    private Date exitDate;
    private Timestamp exitHour;
    private Double icmsBaseCalc;
    private Double icmsValue;
    private String shippingName;
    private Integer invoiceNumber;
    private String senderAddress;
    private String senderNeighborhood;
    private String senderCep;
    private String senderCounty;
    private String senderPhone;
    private String senderUF;
    private String senderIE;
    private String senderCorporateName;
    private String recipientAddress;
    private String recipientNeighborhood;
    private String recipientCep;
    private String recipientCounty;
    private String recipientPhone;
    private String recipientUF;
    private String recipientIE;
    private String recipientCorporateName;
    private Double totalValueProducts;
    private Double totalValueInvoice;
    private String carrierCorporateName;
    private Integer freightCarrier;
    private String carrierVehiclePlate;
    private String carrierAddress;
    private String carrierCounty;
    private String carrierUF;
    private String carrierIE;
    private Double substIcmsBaseCalc;
    private Double substIcmsValue;
    private String justification;
    private String invoiceSeries;
    private Double grossWeight;
    private Double netWeight;

    private ArrayList<InvoiceProductDto> produtos;
}
