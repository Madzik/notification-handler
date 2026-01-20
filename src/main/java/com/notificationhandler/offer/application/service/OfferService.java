package com.notificationhandler.offer.application.service;

import com.notificationhandler.infrastructure.aws.sns.NotificationPublisher;
import com.notificationhandler.offer.application.dto.ProductOffered;
import com.notificationhandler.offer.domain.model.Offer;
import com.notificationhandler.offer.domain.model.OfferStatus;
import com.notificationhandler.offer.domain.model.OfferSubmitted;
import com.notificationhandler.offer.infrastructure.persistence.OfferRepository;
import com.notificationhandler.product.application.service.ProductService;
import com.notificationhandler.product.domain.model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class OfferService {

    private final NotificationPublisher notificationPublisher;
    private final OfferRepository offerRepository;
    private final ProductService productService;

    @Transactional
    public void submitOffer(ProductOffered productOffer) {
        Product productOffered = productService.findBy(productOffer.productId());

        Offer offer = new Offer(productOffered, productOffer.unitOfMeasurement(), productOffer.units(), OfferStatus.SUBMITTED);
        Offer offerSaved = offerRepository.save(offer);
        notificationPublisher.publishMessage(new OfferSubmitted(offerSaved.getId(), productOffered.getCategory()));
    }

    @Transactional
    public void reserveOffer(Integer offerId) {
        offerRepository.findById(offerId).ifPresent(Offer::reserve);
    }
}
