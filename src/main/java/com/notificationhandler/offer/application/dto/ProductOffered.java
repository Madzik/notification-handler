package com.notificationhandler.offer.application.dto;

import com.notificationhandler.offer.domain.model.UnitOfMeasurement;

public record ProductOffered(Integer productId, UnitOfMeasurement unitOfMeasurement, String unitType, Double units) {
}
