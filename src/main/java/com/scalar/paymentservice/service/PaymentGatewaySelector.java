package com.scalar.paymentservice.service;

import org.springframework.stereotype.Service;

@Service
public class PaymentGatewaySelector {

    private RazorpayGateway razorpayGateway;
    private StripeGateway stripeGateway;

    public PaymentGatewaySelector(RazorpayGateway razorpayGateway, StripeGateway stripeGateway ) {
        this.razorpayGateway = razorpayGateway;
        this.stripeGateway = stripeGateway;
    }

    public PaymentGateway getPaymentGateway() {
        //here logic for to select proper gateway
        return razorpayGateway;
    }
}
