package com.umakant.courier.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.umakant.courier.api.dto.CourierRequest;
import com.umakant.courier.api.dto.CourierResponse;
import com.umakant.courier.api.service.CourierService;

@SpringBootApplication
@RestController
public class CourierServiceApplication {

	@Autowired
	private CourierService service;

	@PostMapping("/processCourier")
	public CourierResponse dispacthCourier(@RequestBody CourierRequest request) {
		return service.processCourier(request);

	}

	public static void main(String[] args) {
		SpringApplication.run(CourierServiceApplication.class, args);
	}

}
