package com.JTpayment.project.domain.auth.service;

import com.JTpayment.project.domain.auth.presentation.dto.request.MemberLoginReq;
import com.JTpayment.project.domain.auth.presentation.dto.response.TokenRes;

public interface MemberLoginService {
    TokenRes execute(MemberLoginReq req);
}
