package ru.ifmo.escience.ignite.week5.lab.tables;

import org.apache.ignite.cache.query.annotations.QuerySqlField;
import org.apache.ignite.internal.util.typedef.internal.S;

public class University {

    private final int univ_id;


    private final String univ_name;


    private final String univ_address;


    private final int city_id;

    public University(int univ_id , String univ_name,String univ_address, int city_id) {
        this.univ_id = univ_id;
        this.univ_name = univ_name;
        this.univ_address = univ_address;
        this.city_id = city_id;
    }

    @Override
    public String toString() {
        return univ_id+ "," + univ_name+ "," + univ_address + "," + city_id;
    }
}
