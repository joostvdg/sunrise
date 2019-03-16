package com.github.joostvdg.sunrise.controller;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.tracing.annotation.ContinueSpan;
import net.kearos.demomon.micronaut.graal.model.Conference;
import net.kearos.demomon.micronaut.graal.service.ConferenceService;

@Controller("/conferences")
public class ConferenceController {

    private final ConferenceService conferenceService;

    public ConferenceController(ConferenceService conferenceService) {
        this.conferenceService = conferenceService;
    }

    @Get("/random")
    @ContinueSpan
    public Conference randomConf() {
        return conferenceService.randomConf();
    }
}
