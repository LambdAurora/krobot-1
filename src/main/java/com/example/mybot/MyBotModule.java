package com.example.mybot;

import com.google.inject.AbstractModule;

public class MyBotModule extends AbstractModule
{
    @Override
    protected void configure()
    {
        // Configure some bindings
        bind(fr.litarvan.krobot.ExceptionHandler.class).to(ExceptionHandler.class);
    }
}
