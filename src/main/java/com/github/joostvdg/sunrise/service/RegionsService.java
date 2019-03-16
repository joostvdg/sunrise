package com.github.joostvdg.sunrise.service;

import com.github.joostvdg.sunrise.model.Provider;
import com.github.joostvdg.sunrise.model.Region;

import javax.inject.Singleton;
import java.util.Arrays;
import java.util.List;

@Singleton
public class RegionsService {

    // converted via: https://www.latlong.net/convert-address-to-lat-long.html
    private static final List<Region> GCP_REGIONS = Arrays.asList(
         new Region("Changhua County, Taiwan", "asia-east1", 24.07, 120.54),
         new Region("Hong Kong", "asia-east2", 22.39, 114.10),
         new Region("Tokyo, Japan","asia-northeast1", 35.69, 139.69),
         new Region("Mumbai, India", "asia-south1", 19.08, 72.88),
         new Region("Jurong West, Singapore", "asia-southeast1", 1.35, 103.71),
         new Region("Sydney, Australia", "australia-southeast1", -33.87, 151.21),
         new Region("Hamina, Finland", "europe-north1", 60.57, 27.19),
         new Region("St. Ghislain, Belgium", "europe-west1", 50.45, 3.82),
         new Region("London, England, UK", "europe-west2", 51.50, -0.13),
         new Region("Frankfurt, Germany", "europe-west3", 50.11, 8.69),
         new Region("Eemshaven, Netherlands", "europe-west4", 53.44, 6.83),
         new Region("Zürich, Switzerland", "europe-west6", 47.38, 8.54),
         new Region("Montréal, Québec, Canada", "northamerica-northeast1", 45.50, -73.55),
         new Region("São Paulo, Brazil", "southamerica-east1 ", -23.55, -46.63),
         new Region("Council Bluffs, Iowa, USA", "us-central1", 41.25, -95.85),
         new Region("Moncks Corner, South Carolina, USA", "us-east1", 33.19, -80.01),
         new Region("Ashburn, Northern Virginia, USA", "us-east4", 38.41, -77.60),
         new Region("The Dalles, Oregon, USA", "us-west1", 45.60, -121.18),
         new Region("Los Angeles, California, USA","us-west2", 34.05, -118.24)
    );
    private static final Provider GCP;

    static {
        GCP = new Provider("GCP", GCP_REGIONS );
    }

    private static final List<Provider> PROVIDERS = Arrays.asList(
        GCP
    );

    public List<Provider> getProviders(){
        return PROVIDERS;
    }
}
