package com.scalar.paymentservice.service;

import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    private PaymentGatewaySelector paymentGatewaySelector;
    public PaymentService(PaymentGatewaySelector paymentGatewaySelector) {
        this.paymentGatewaySelector = paymentGatewaySelector;
    }
    public String generatePaymentLink(){

        //logic to store payment details in database


        return paymentGatewaySelector
                .getPaymentGateway()
                .generatePaymentLink();
    }
}
