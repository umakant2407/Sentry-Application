package com.umakant.courier.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CourierResponse {

private String consignmentNumber;
private String deliveryStatus;
private String expectedDate;


public CourierResponse(String string, String string2, String string3) {
	// TODO Auto-generated constructor stub
	this.consignmentNumber = string;
	this.deliveryStatus=string2;
	this.expectedDate= string3;
}


}
