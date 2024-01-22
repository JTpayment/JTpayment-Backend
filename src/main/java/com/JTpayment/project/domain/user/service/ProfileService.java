package com.JTpayment.project.domain.user.service;

import com.JTpayment.project.domain.user.presentation.dto.request.ProfileReq;

public interface ProfileService {
    ProfileReq execute(String loginId);
}
