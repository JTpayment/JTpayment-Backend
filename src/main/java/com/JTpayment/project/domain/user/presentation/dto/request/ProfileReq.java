package com.JTpayment.project.domain.user.presentation.dto.request;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProfileReq {
    private String nickname;

    private String email;
}
