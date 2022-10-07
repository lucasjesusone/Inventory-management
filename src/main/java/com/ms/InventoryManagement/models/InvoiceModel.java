package com.ms.InventoryManagement.models;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "invoices")
public class InvoiceModel {

    private static final long serialVersionUid = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long invoiceId;
    private String natureOfOperation;
    private Date issuanceDate;
    private Date exitDate;
    private Timestamp exitHour;
    private Double icmsBaseCalc;
    private Double icmsValue;
    private Integer invoiceNumber;
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
    private LocalDateTime updatedAt;


    //    @JsonIgnoreProperties("invoices")
    @ManyToMany(cascade = {CascadeType.REFRESH, CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(name = "invoice_product",
            joinColumns = {@JoinColumn(name = "invoice_id")},
            inverseJoinColumns = {@JoinColumn(name = "product_id")},
            foreignKey = @ForeignKey(name = "invoice_item_invoice_fk_fk"),
            inverseForeignKey = @ForeignKey(name = "invoice_item_invoice_item_fk"))
    @ToString.Exclude
    private Set<ProductModel> produtos = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        InvoiceModel that = (InvoiceModel) o;

        return Objects.equals(invoiceId, that.invoiceId);
    }

    @Override
    public int hashCode() {
        return 554252084;
    }
}
