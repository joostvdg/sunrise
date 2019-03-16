package com.github.joostvdg.sunrise.model;

import java.util.ArrayList;
import java.util.List;

public class Provider {

    private String name;
    private List<Region> regions;

    public Provider(String name, List<Region> regions ) {
        this.name = name;
        this.regions = regions;
    }

    public String getName(){
        return this.name;
    }

    public List<Region> getRegions() {
        return new ArrayList<>(regions);
    }
}
