package com.notificationhandler.offer.application.service;

import com.notificationhandler.infrastructure.aws.sns.NotificationPublisher;
import com.notificationhandler.offer.application.dto.ProductOffered;
import com.notificationhandler.offer.domain.model.Offer;
import com.notificationhandler.offer.domain.model.OfferSubmitted;
import com.notificationhandler.offer.infrastructure.persistence.OfferRepository;
import com.notificationhandler.product.application.service.ProductService;
import com.notificationhandler.product.domain.model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.lang.module.ResolutionException;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class OfferService {

    private final NotificationPublisher notificationPublisher;
    private final OfferRepository offerRepository;
    private final ProductService productService;

    public void submitOffer(ProductOffered productOffer) {
        Product productOffered = productService.findAll().stream()
                .filter(product -> Objects.equals(product.getId(), productOffer.productId()))
                .findFirst().orElseThrow(() -> new ResolutionException("Product not found."));

        Offer offer = new Offer(productOffered, productOffer.unitOfMeasurement(), productOffer.unitType(), productOffer.units());
        offerRepository.save(offer);
        notificationPublisher.publishMessage(new OfferSubmitted(productOffer.productId()));
    }
}
