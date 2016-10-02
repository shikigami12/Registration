package org.ua.deth.service;

import java.util.HashMap;
import java.util.Map;

public class CommandFactory {
    private static CommandFactory ourInstance = new CommandFactory();

    private Map<String, Command> stringCommandMap = new HashMap<>();

    public static CommandFactory getInstance() {
        return ourInstance;
    }

    private CommandFactory() {
        stringCommandMap.put("login", new LoginCommand());
        stringCommandMap.put("registration", new RegistrationCommand());
    }

    public Command getCommand(String commandName){
        return stringCommandMap.get(commandName);
    }


}
