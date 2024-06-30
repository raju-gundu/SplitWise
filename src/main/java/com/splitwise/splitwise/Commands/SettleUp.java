package com.splitwise.splitwise.Commands;

import com.splitwise.splitwise.Controllers.SettleUpController;
import com.splitwise.splitwise.DTOs.SettleUpUserRequestDto;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class SettleUp implements Command{
    private SettleUpController settleUpController;

    @Autowired
    public SettleUp(SettleUpController settleUpController) {
        this.settleUpController = settleUpController;
    }

    @Override
    public boolean matches(String input) {
        List<String> words = List.of(input.split(" "));
        if (words.get(1).equals("SettleUp")){
            return true;
        }

        return false;
    }

    @Override
    public void execute(String input) {
        List<String> words = List.of(input.split(" "));
        Long userId = Long.valueOf(words.get(0));

        SettleUpUserRequestDto settleUpUserRequestDto = new SettleUpUserRequestDto();
        settleUpUserRequestDto.setUserId(userId);

        settleUpController = new SettleUpController();
        settleUpController.settleUpUser(settleUpUserRequestDto);

    }
}
