package com.notificationhandler.offer.infrastructure.persistence;

import com.notificationhandler.offer.domain.model.Offer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OfferRepository extends JpaRepository<Offer, Integer> {
}
