package com.github.joostvdg.sunrise.controller;

import com.github.joostvdg.sunrise.model.Provider;
import com.github.joostvdg.sunrise.service.RegionsService;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Produces;
import io.micronaut.tracing.annotation.ContinueSpan;
import io.micronaut.tracing.annotation.SpanTag;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Controller("/regions")
public class RegionsController {

    private final RegionsService regionsService;

    public RegionsController(RegionsService regionsService) {
        this.regionsService = regionsService;
    }

    @Get("/")
    @Produces(MediaType.APPLICATION_JSON)
    @ContinueSpan
    public List<Provider> getRegions() {
        return regionsService.getProviders();
    }

    @Get("/sunrise")
    @Produces(MediaType.APPLICATION_JSON)
    @ContinueSpan
    public List<Provider> getRegionsNearSunrise() {
        return regionsService.getRegionsNearSunrises(0);
    }

    @Get("/sunrise/{minutesFromNow}")
    @Produces(MediaType.APPLICATION_JSON)
    @ContinueSpan
    public List<Provider> getRegionsNearSunriseByRange(@SpanTag("sunrise.minutesFromNow") @NotBlank int minutesFromNow) {
        return regionsService.getRegionsNearSunrises(minutesFromNow);
    }
}
