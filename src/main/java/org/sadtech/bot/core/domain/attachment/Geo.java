package org.sadtech.bot.core.domain.attachment;

import org.sadtech.bot.core.domain.content.GeoCoordinate;

import java.util.Objects;

public class Geo extends Attachment {

    private GeoCoordinate geoCoordinate;
    private String country;
    private String city;

    private Geo() {
        type = AttachmentType.GEO;
    }

    public GeoCoordinate getGeoCoordinate() {
        return geoCoordinate;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public static Builder builder() {
        return new Geo().new Builder();
    }

    public class Builder {
        private Builder() {

        }

        public Builder coordinate(Float lat, Float aLong) {
            Geo.this.geoCoordinate = new GeoCoordinate(lat, aLong);
            return this;
        }

        public Builder country(String countryName) {
            Geo.this.country = countryName;
            return this;
        }

        public Builder city(String cityName) {
            Geo.this.city = cityName;
            return this;
        }

        public Geo build() {
            return Geo.this;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Geo)) return false;
        Geo geo = (Geo) o;
        return Objects.equals(geoCoordinate, geo.geoCoordinate) &&
                Objects.equals(country, geo.country) &&
                Objects.equals(city, geo.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(geoCoordinate, country, city);
    }

    @Override
    public String toString() {
        return "Geo{" +
                "geoCoordinate=" + geoCoordinate +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
