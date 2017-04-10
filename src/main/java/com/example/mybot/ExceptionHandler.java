package com.example.mybot;

import fr.litarvan.krobot.command.Command;
import fr.litarvan.krobot.command.CommandContext;
import java.util.List;

public class ExceptionHandler extends fr.litarvan.krobot.ExceptionHandler
{
    @Override
    public void handle(Throwable throwable, Command command, List<String> args, CommandContext context)
    {
        // Handle the command exceptions

        // By default it has a dialog and a crash report system
        super.handle(throwable, command, args, context);
    }
}
