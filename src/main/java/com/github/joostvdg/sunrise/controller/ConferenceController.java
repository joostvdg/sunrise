package com.github.joostvdg.sunrise.controller;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.tracing.annotation.ContinueSpan;
import com.github.joostvdg.sunrise.model.Conference;
import com.github.joostvdg.sunrise.service.ConferenceService;

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
