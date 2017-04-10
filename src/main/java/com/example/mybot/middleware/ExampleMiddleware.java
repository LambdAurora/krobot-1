package com.example.mybot.middleware;

import fr.litarvan.krobot.command.Command;
import fr.litarvan.krobot.command.CommandContext;
import fr.litarvan.krobot.command.Middleware;
import fr.litarvan.krobot.util.Dialog;

public class ExampleMiddleware implements Middleware
{
    @Override
    public boolean handle(Command command, CommandContext context)
    {
        // Will be called before every command

        context.getChannel().sendMessage(Dialog.info("Example", "A command has been called")).queue();
        return true; // true = Continue command handling, false = stop command handling
    }
}
