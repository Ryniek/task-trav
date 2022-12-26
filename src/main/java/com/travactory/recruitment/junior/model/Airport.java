package com.travactory.recruitment.junior.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "airports")
public class Airport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, unique = true, columnDefinition = "VARCHAR(256)")
    private String code;
    @Column(columnDefinition = "VARCHAR(256)")
    private String name;
    private Integer gmtTimeZoneOffset;

    public Integer getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public Integer getGmtTimeZoneOffset() {
        return gmtTimeZoneOffset;
    }
}
