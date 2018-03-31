package ru.ifmo.escience.ignite.week5.lab.tables;

import org.apache.ignite.cache.query.annotations.QuerySqlField;
import org.apache.ignite.internal.util.typedef.internal.S;

public class City {
    @QuerySqlField(index = true)
    private final int city_id;

    @QuerySqlField
    private final String city_name;

    public City(int city_id , String city_name) {
        this.city_id = city_id;
        this.city_name = city_name;
    }
}
