package com.sushimayo.models;

import java.util.List;

public class OrderModel extends NotaModel{


    private List<OrderMenuModel> orderMenuModel;
    public List<OrderMenuModel> getOrderMenuModel() {
        return orderMenuModel;
    }

    public void setOrderMenModel(List<OrderMenuModel> orderMenModel) {
        this.orderMenuModel = orderMenModel;
    }

}
