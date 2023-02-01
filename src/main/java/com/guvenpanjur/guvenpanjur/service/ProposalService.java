package com.guvenpanjur.guvenpanjur.service;

import com.guvenpanjur.guvenpanjur.model.dto.request.RequestProposalSave;

import java.math.BigDecimal;

public interface ProposalService {
    BigDecimal saveProposal(RequestProposalSave requestProposalSave);
}
