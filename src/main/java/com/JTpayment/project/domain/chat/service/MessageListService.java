package com.JTpayment.project.domain.chat.service;

import com.JTpayment.project.domain.chat.presentation.dto.response.MessageListResponse;

public interface MessageListService {

    MessageListResponse execute(String roomId);
}
