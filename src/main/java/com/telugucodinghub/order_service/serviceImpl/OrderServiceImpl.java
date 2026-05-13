package com.telugucodinghub.order_service.serviceImpl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telugucodinghub.order_service.dto.OrderLineItemsDto;
import com.telugucodinghub.order_service.dto.OrderRequest;
import com.telugucodinghub.order_service.model.Order;
import com.telugucodinghub.order_service.model.OrderLineItems;
import com.telugucodinghub.order_service.repository.OrderRepository;
import com.telugucodinghub.order_service.service.OrderServices;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderServiceImpl implements OrderServices{
	@Autowired
	private OrderRepository orderRepository;
	
	public void placeOrder(OrderRequest orderRequest) {
		Order order= new Order();
		order.setOrderNumber(UUID.randomUUID().toString());
		
		List<OrderLineItems> orderLineItems=orderRequest.getOrderLineItemsDtoList()
		.stream().map(this::mapToDto).toList();
		order.setOrderLineItems(orderLineItems);
		orderRepository.save(order);
		
	}

	private OrderLineItems mapToDto(OrderLineItemsDto orderLineItemsDto) {
		OrderLineItems orderLineItems = new OrderLineItems();
		orderLineItems.setPrice(orderLineItemsDto.getPrice());
		orderLineItems.setQuantity(orderLineItemsDto.getQuantity());
		orderLineItems.setSkuCode(orderLineItemsDto.getSkuCode());
		return orderLineItems;
	}

}
