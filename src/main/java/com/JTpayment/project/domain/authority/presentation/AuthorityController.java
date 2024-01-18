package com.JTpayment.project.domain.authority.presentation;

import com.JTpayment.project.domain.authority.presentation.dto.request.AuthEmailReq;
import com.JTpayment.project.domain.authority.service.GrantAdminRoleService;
import com.JTpayment.project.domain.authority.service.MemberActiveService;
import com.JTpayment.project.domain.authority.service.MemberInactiveService;
import com.JTpayment.project.domain.authority.service.RevokeAdminRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AuthorityController {
    private final GrantAdminRoleService grantAdminRoleService;
    private final RevokeAdminRoleService revokeAdminRoleService;
    private final MemberActiveService memberActiveService;
    private final MemberInactiveService memberInactiveService;

    @PatchMapping("/role/grant")
    public ResponseEntity<Void> grantAdminRole(@RequestBody AuthEmailReq req) {
        grantAdminRoleService.execute(req.getEmail());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping("/role/revoke")
    public ResponseEntity<Void> revokeAdminRole(@RequestBody AuthEmailReq req) {
        revokeAdminRoleService.execute(req.getEmail());
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @PatchMapping("/ban")
    public ResponseEntity<Void> memberInactive(@RequestBody AuthEmailReq req) {
        memberInactiveService.execute(req.getEmail());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping("/unban")
    public ResponseEntity<Void> memberActive(@RequestBody AuthEmailReq req) {
        memberActiveService.execute(req.getEmail());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
