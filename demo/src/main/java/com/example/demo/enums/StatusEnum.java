package com.example.demo.enums;

public enum StatusEnum {

    COMPRA(1), CANCELAMENTO(0);
    private Integer statusTypeId;
    StatusEnum(Integer statusId){
        this.statusTypeId = statusId;
    }

    public Integer getIdType(){
        return this.statusTypeId;
    }



}
