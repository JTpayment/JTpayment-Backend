package com.JTpayment.project.domain.chat.service;

import com.JTpayment.project.domain.chat.presentation.dto.request.MessageSendRequest;

public interface MessageSaveService {

    void execute(MessageSendRequest messageSendRequest);
}
