/*
package com.resenha.projetoresenha.mercadopago;

import com.mercadopago.MercadoPagoConfig;
import com.mercadopago.client.payment.PaymentClient;
import com.mercadopago.client.payment.PaymentCreateRequest;
import com.mercadopago.client.payment.PaymentPayerRequest;
import com.mercadopago.exceptions.MPApiException;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.payment.Payment;

import java.math.BigDecimal;

public class mercadoPago {
    public static void main(String[] args) {
        MercadoPagoConfig.setAccessToken("TEST-5322055524682863-051123-92f9750c60e13391075048d50c308a1b-289173301");

        PaymentClient client = new PaymentClient();

        PaymentCreateRequest createRequest =
                PaymentCreateRequest.builder()
                        .transactionAmount(new BigDecimal(1000))
                        .token("9b2d63e00d66a8c721607214ceda233a")
                        .description("fazendo um testezin bacaninha")
                        .installments(1)
                        .paymentMethodId("visa")
                        .payer(PaymentPayerRequest.builder().email("mathiasdesouzacarvalho088@gmail.com").build())
                        .build();

        try {
            Payment payment = client.create(createRequest);
            System.out.println(payment);
        } catch (MPApiException ex) {
            System.out.printf(
                    "MercadoPago Error. Status: %s, Content: %s%n",
                    ex.getApiResponse().getStatusCode(), ex.getApiResponse().getContent());
        } catch (MPException ex) {
            ex.printStackTrace();
        }
    }
}
*/
