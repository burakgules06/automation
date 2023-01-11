package com.guvenpanjur.guvenpanjur.repository.jsonRepo;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.guvenpanjur.guvenpanjur.model.json.TryCurrency;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;

@Repository
public class TryCurrencyRepository {

    public TryCurrency getTryCurrency() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        TryCurrency tryCurrency = mapper.readValue(new File("src/main/resources/try_currency.json"), TryCurrency.class);
        return tryCurrency;
    }

}
