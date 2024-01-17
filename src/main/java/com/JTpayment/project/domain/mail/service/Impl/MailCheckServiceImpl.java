package com.JTpayment.project.domain.mail.service.Impl;

import com.JTpayment.project.domain.mail.service.MailCheckService;
import com.JTpayment.project.global.util.RedisUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MailCheckServiceImpl implements MailCheckService {
    private final RedisUtil redisUtil;

    @Override
    public Boolean execute(String email, String code) {
        if(redisUtil.getData(code)==null){
            return false;
        }
        else if(redisUtil.getData(code).equals(email)){
            return true;
        }
        else{
            return false;
        }
    }
}
