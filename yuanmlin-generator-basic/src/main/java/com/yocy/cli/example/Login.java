package com.yocy.cli.example;

import picocli.CommandLine;

import java.security.MessageDigest;
import java.util.Arrays;
import java.util.concurrent.Callable;

public class Login implements Callable<Integer> {
    @CommandLine.Option(names = {"-u", "--user"}, description = "User name")
    String user;

    @CommandLine.Option(names = {"-p", "--password"}, arity = "0..1", description = "Passphrase", interactive = true)
    String password;
    
    @CommandLine.Option(names = {"-cp", "--checkPassword"}, arity = "0..1", description = "Check Password", interactive = true)
    String checkPassword;

    public Integer call() throws Exception {
        System.out.println("password: " + password);
        System.out.println("checkPassword: " + checkPassword);
        return 0;
    }

    public static void main(String[] args) {
        new CommandLine(new Login()).execute("-u", "user111");
    }
}