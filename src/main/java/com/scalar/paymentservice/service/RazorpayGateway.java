package com.scalar.paymentservice.service;

import com.razorpay.PaymentLink;
import org.springframework.stereotype.Service;

import org.json.JSONObject;
import com.razorpay.RazorpayClient;
import java.util.Random;

@Service
public class RazorpayGateway implements PaymentGateway {

    @Override
    public String generatePaymentLink() {

        try {

            RazorpayClient razorpay = new RazorpayClient("rzp_test_QGBYyX84rMCvVM", "Q5nsPKhhuYsl3HAB0BFelAh1");
            JSONObject paymentLinkRequest = new JSONObject();
            paymentLinkRequest.put("amount", 100000);
            paymentLinkRequest.put("currency", "INR");
            paymentLinkRequest.put("accept_partial", false);
           // paymentLinkRequest.put("first_min_partial_amount", 100);
            paymentLinkRequest.put("expire_by",1717077884);
            Random random = new Random();
            int k =   random.nextInt(101);
            paymentLinkRequest.put("reference_id", "TS1989123"+k);
            paymentLinkRequest.put("description", "Payment for policy no #23456");
            JSONObject customer = new JSONObject();
            customer.put("name", "+918688241470");
            customer.put("contact", "Sohail Pasha");
            customer.put("email", "gajularakesh222@gmail.com");
            paymentLinkRequest.put("customer", customer);
            JSONObject notify = new JSONObject();
            notify.put("sms", true);
            notify.put("email", true);
            paymentLinkRequest.put("notify", notify);
            paymentLinkRequest.put("reminder_enable", true);
            JSONObject notes = new JSONObject();
            notes.put("policy_name", "Jeevan Bima");
            paymentLinkRequest.put("notes", notes);
            paymentLinkRequest.put("callback_url", "https://www.google.com/");
            paymentLinkRequest.put("callback_method", "get");

            PaymentLink payment = razorpay.paymentLink.create(paymentLinkRequest);

            return payment.toString();

        }catch(Exception ex){
           System.out.println(ex);
        }

        return null;
    }
}
