package com.umakant.courier.api.service;

import java.util.Random;
import java.util.UUID;

import javax.management.ServiceNotFoundException;

import org.springframework.stereotype.Service;
import org.springframework.web.server.NotAcceptableStatusException;

import com.umakant.courier.api.dto.CourierRequest;
import com.umakant.courier.api.dto.CourierResponse;

import io.sentry.Sentry;

@Service
public class CourierService {

	public CourierResponse processCourier(CourierRequest request) {

		CourierResponse response = null;

		Sentry.init("https://c11910835dbb438ea13d26a8912748e1@o1144677.ingest.sentry.io/6209238");

		try {
			if (!isServiceAvailable(request.getPin())) {
				throw new ServiceNotFoundException("service not available for your location " + request.getPin());
			}
			if (request.getWeight() > 2) {
				throw new NotAcceptableStatusException("weight shouldn't be more than 1.5 kg");
			}

		} catch (Exception e) {
			Sentry.capture(e);
			return response = new CourierResponse("**", "failure", "couldn't process");

		}
		// if everything ok , then call rest API to dispatch courier
		response = new CourierResponse(UUID.randomUUID().toString(), "process", "21/12/2018");
		return response;
	}

	// check service availability

	public boolean isServiceAvailable(String pin) {
		return new Random().nextBoolean();
	}

}
