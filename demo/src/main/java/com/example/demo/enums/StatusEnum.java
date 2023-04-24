package com.example.demo.enums;

public enum StatusEnum {

    CANCELAMENTO(0), COMPRA(1),  NEGADO(2);
    private Integer statusTypeId;
    StatusEnum(Integer statusId){
        this.statusTypeId = statusId;
    }

    public Integer getIdType(){
        return this.statusTypeId;
    }



}
