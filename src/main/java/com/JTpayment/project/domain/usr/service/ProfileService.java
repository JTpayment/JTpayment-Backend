package com.JTpayment.project.domain.usr.service;

import com.JTpayment.project.domain.usr.presentation.dto.request.ProfileReq;

public interface ProfileService {
    ProfileReq execute(String loginId);
}
