package dev.techdozo.payment.resource.mapper;

import dev.techdozo.payment.application.domain.model.Payment;
import dev.techdozo.payment.resource.model.PaymentRequest;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class PaymentMapper {
    public static final PaymentMapper MAPPER =
            Mappers.getMapper(PaymentMapper.class);


    public abstract Payment map(PaymentRequest paymentRequest);
}
