package com.jwtsecurity.jwt.controller;

import com.jwtsecurity.jwt.model.JwtUser;
import com.jwtsecurity.jwt.security.JwtGenrator;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/token")
public class TokenController {
    private JwtGenrator jwtGenrator;

    public TokenController(JwtGenrator jwtGenrator) {
        this.jwtGenrator = jwtGenrator;
    }

    @PostMapping
    public String genrate(@RequestBody final JwtUser jwtUser){
        return jwtGenrator.genrate(jwtUser);

    }
}
