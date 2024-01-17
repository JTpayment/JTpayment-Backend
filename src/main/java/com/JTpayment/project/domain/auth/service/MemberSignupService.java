package com.JTpayment.project.domain.auth.service;

import com.JTpayment.project.domain.auth.presentation.dto.request.MemberSignupReq;

public interface MemberSignupService {
    public void execute(MemberSignupReq req);
}
