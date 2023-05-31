package com.sushimayo.models;

import java.util.List;

public class OrderModel extends NotaModel{
    public List<OrderMenuModel> getOrderMenModel() {
        return orderMenModel;
    }

    public void setOrderMenModel(List<OrderMenuModel> orderMenModel) {
        this.orderMenModel = orderMenModel;
    }

    private List<OrderMenuModel> orderMenModel;
}
