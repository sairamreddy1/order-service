package com.telugucodinghub.order_service.service;

import com.telugucodinghub.order_service.dto.OrderRequest;

public interface OrderServices {

	void placeOrder(OrderRequest orderRequest);

}
