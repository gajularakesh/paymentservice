package com.scalar.paymentservice.service;

import org.springframework.stereotype.Service;

@Service
public class StripeGateway implements PaymentGateway{

    @Override
    public String generatePaymentLink() {
        return "";
    }
}
