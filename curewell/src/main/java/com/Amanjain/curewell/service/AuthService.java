package com.Amanjain.curewell.service;

import com.Amanjain.curewell.payload.LoginDto;
import com.Amanjain.curewell.payload.RegisterDto;
import org.springframework.stereotype.Service;


public interface AuthService {
    String login(LoginDto loginDto);
    String register(RegisterDto registerDto);
}
