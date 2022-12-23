package com.guvenpanjur.guvenpanjur.model.dto.request;

import com.guvenpanjur.guvenpanjur.model.dto.CustomerDTO;
import lombok.Data;

@Data
public class RequestUpdateCustomerDTO extends CustomerDTO {
    private long id;
}
