package com.JTpayment.project.domain.chat.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class MessageListResponse {

    private List<MessageResponse> MessageList;
}
