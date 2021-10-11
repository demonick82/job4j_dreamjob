package ru.job4j.dream.model;

import java.time.LocalDate;
import java.util.Objects;

public class Candidate {
    private int id;
    private String name;
    private String cityName;
    private LocalDate created;

    public Candidate(int id, String name, String cityName, LocalDate created) {
        this.id = id;
        this.name = name;
        this.cityName = cityName;
        this.created = created;
    }

    public int getId() {
        return id;
    }

    public String getCityName() {
        return cityName;
    }

    public LocalDate getCreated() {
        return created;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Candidate candidate = (Candidate) o;
        return id == candidate.id &&
                Objects.equals(name, candidate.name) &&
                Objects.equals(cityName, candidate.cityName) &&
                Objects.equals(created, candidate.created);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, cityName, created);
    }

    @Override
    public String toString() {
        return "Candidate{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city_id='" + cityName + '\'' +
                ", created=" + created +
                '}';
    }
}
