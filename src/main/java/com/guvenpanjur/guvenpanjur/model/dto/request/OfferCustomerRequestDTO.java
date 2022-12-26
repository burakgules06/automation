package com.guvenpanjur.guvenpanjur.model.dto.request;

import com.guvenpanjur.guvenpanjur.model.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OfferCustomerRequestDTO {
    private Long customerId;
}
