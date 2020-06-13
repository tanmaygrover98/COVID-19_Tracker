package com.example.covid_19tracker;

public class CountryModel {

    String flag, country, cases, deaths, casesToday, deathsToday, recovered, active, critical, casesPerMillion, deathsPerMillion,
            testsPerMillion, continent;

    public CountryModel() {
    }

    public CountryModel(String flag, String country, String cases, String deaths, String casesToday, String deathsToday, String recovered,
                        String active, String critical, String casesPerMillion, String deathsPerMillion, String testsPerMillion, String continent) {
        this.flag = flag;
        this.country = country;
        this.cases = cases;
        this.deaths = deaths;
        this.casesToday = casesToday;
        this.deathsToday = deathsToday;
        this.recovered = recovered;
        this.active = active;
        this.critical = critical;
        this.casesPerMillion = casesPerMillion;
        this.deathsPerMillion = deathsPerMillion;
        this.testsPerMillion = testsPerMillion;
        this.continent = continent;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCases() {
        return cases;
    }

    public void setCases(String cases) {
        this.cases = cases;
    }

    public String getDeaths() {
        return deaths;
    }

    public void setDeaths(String deaths) {
        this.deaths = deaths;
    }

    public String getCasesToday() {
        return casesToday;
    }

    public void setCasesToday(String casesToday) {
        this.casesToday = casesToday;
    }

    public String getDeathsToday() {
        return deathsToday;
    }

    public void setDeathsToday(String deathsToday) {
        this.deathsToday = deathsToday;
    }

    public String getRecovered() {
        return recovered;
    }

    public void setRecovered(String recovered) {
        this.recovered = recovered;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getCritical() {
        return critical;
    }

    public void setCritical(String critical) {
        this.critical = critical;
    }

    public String getCasesPerMillion() {
        return casesPerMillion;
    }

    public void setCasesPerMillion(String casesPerMillion) {
        this.casesPerMillion = casesPerMillion;
    }

    public String getDeathsPerMillion() {
        return deathsPerMillion;
    }

    public void setDeathsPerMillion(String deathsPerMillion) {
        this.deathsPerMillion = deathsPerMillion;
    }

    public String getTestsPerMillion() {
        return testsPerMillion;
    }

    public void setTestsPerMillion(String testsPerMillion) {
        this.testsPerMillion = testsPerMillion;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }
}
