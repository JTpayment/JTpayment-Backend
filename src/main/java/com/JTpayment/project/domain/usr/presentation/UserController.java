package com.JTpayment.project.domain.usr.presentation;

import com.JTpayment.project.domain.usr.presentation.dto.request.ProfileReq;
import com.JTpayment.project.domain.usr.presentation.dto.response.ListBoardRes;
import com.JTpayment.project.domain.usr.service.MypageService;
import com.JTpayment.project.domain.usr.service.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final ProfileService profileService;
    private final MypageService mypageService;

    @GetMapping("/profile/{loginId}")
    public ResponseEntity<ProfileReq> getUserProfile(@PathVariable String loginId) {
        ProfileReq req = profileService.execute(loginId);
        return new ResponseEntity<>(req, HttpStatus.OK);
    }

    @GetMapping("/mypage")
    public ResponseEntity<ListBoardRes> getMypage() {
        ListBoardRes res = mypageService.execute();
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

}
