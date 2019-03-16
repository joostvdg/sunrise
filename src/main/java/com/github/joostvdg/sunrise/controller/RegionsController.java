package com.github.joostvdg.sunrise.controller;

import com.github.joostvdg.sunrise.model.Provider;
import com.github.joostvdg.sunrise.service.RegionsService;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.tracing.annotation.ContinueSpan;

import java.util.List;

@Controller("/regions")
public class RegionsController {

    private final RegionsService regionsService;

    public RegionsController(RegionsService regionsService) {
        this.regionsService = regionsService;
    }

    @Get("/")
    @ContinueSpan
    public List<Provider> getRegions() {
        return regionsService.getProviders();
    }
}
