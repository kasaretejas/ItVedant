package com.tejas.dto;

import lombok.Data;

@Data
public class CreateOrderRequest {
	private int amount;
    private String currency;
    private long customerId;

}
