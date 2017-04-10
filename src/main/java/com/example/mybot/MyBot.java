package com.example.mybot;

import com.example.mybot.command.ExampleCommand;
import fr.litarvan.krobot.IBot;
import fr.litarvan.krobot.Krobot;
import fr.litarvan.krobot.command.CommandManager;
import fr.litarvan.krobot.config.ConfigProvider;
import fr.litarvan.krobot.util.Dialog;
import javax.inject.Inject;
import javax.security.auth.login.LoginException;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.exceptions.RateLimitedException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MyBot implements IBot
{
    public static final String VERSION = "1.0.0";

    private static final Logger LOGGER = LogManager.getLogger("MyBot");

    @Inject
    private JDA jda;

    @Inject
    private CommandManager commands;

    @Inject
    private ConfigProvider configs;

    @Override
    public void init()
    {
        // Bot initializing
        LOGGER.info("Loading MyBot v" + VERSION);

        // Setting up configs
        configs.from("config/app.json");

        // Loading commands
        commands.group().prefix("!").apply(this::commands);

        LOGGER.info("-> Loaded !");
    }

    private void commands()
    {
        commands.make("version", (context, args) -> {
            context.getChannel().sendMessage(Dialog.info("MyBot", "v" + VERSION)).queue();
        }).register(); // Simple command ( !version )

        commands.make("hello [name]", ExampleCommand.class).register(); // !hello with optional arg "name"
    }

    public static void main(String[] args) throws LoginException, InterruptedException, RateLimitedException
    {
        if (args.length == 0)
        {
            LOGGER.fatal("You need to provide a bot token in argument");
            System.exit(1);
        }

        Krobot.start(args[0], MyBot.class);
    }
}
