package com.notificationhandler.offer.application.dto;

import com.notificationhandler.offer.domain.model.UnitOfMeasurement;

public record ProductOffer(Integer productId, UnitOfMeasurement unitOfMeasurement, String unitType, Double units) {
}
