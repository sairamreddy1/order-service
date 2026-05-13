package com.telugucodinghub.order_service.dto;

import java.util.List;

import com.telugucodinghub.order_service.model.OrderLineItems;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequest {
	
	private List<OrderLineItemsDto> orderLineItemsDtoList;
	

}
