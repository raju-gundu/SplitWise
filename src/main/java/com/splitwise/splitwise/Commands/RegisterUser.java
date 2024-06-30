package com.splitwise.splitwise.Commands;

import com.splitwise.splitwise.Controllers.SettleUpController;
import com.splitwise.splitwise.DTOs.SettleUpUserRequestDto;

import java.util.List;

public class RegisterUser implements Command{
    @Override
    public boolean matches(String input) {


        return false;
    }

    @Override
    public void execute(String input) {

    }
}
