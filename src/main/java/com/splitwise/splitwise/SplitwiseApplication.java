package com.splitwise.splitwise;

import com.splitwise.splitwise.Commands.CommandExecutor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class SplitwiseApplication implements CommandLineRunner {
    Scanner scanner = new Scanner(System.in);
    private CommandExecutor commandExecutor;

    public static void main(String[] args) {
        SpringApplication.run(SplitwiseApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        while (true){
            String input = scanner.nextLine();
            commandExecutor.execute(input);
        }
    }
}
