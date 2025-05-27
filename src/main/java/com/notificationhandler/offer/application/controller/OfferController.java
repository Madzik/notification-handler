package com.notificationhandler.offer.application.controller;

import com.notificationhandler.offer.application.dto.ProductOffer;
import com.notificationhandler.offer.application.service.OfferService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/offers")
@RequiredArgsConstructor
public class OfferController {

    private final OfferService offerService;

    @PostMapping
    public ResponseEntity<Void> submitOffer(@RequestBody ProductOffer productOffer) {
        offerService.submitOffer(productOffer);
        return ResponseEntity.accepted().build();
    }
}
