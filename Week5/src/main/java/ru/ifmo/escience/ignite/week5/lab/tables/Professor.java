package ru.ifmo.escience.ignite.week5.lab.tables;

import org.apache.ignite.cache.query.annotations.QuerySqlField;
import org.apache.ignite.internal.util.typedef.internal.S;

public class Professor {
    @QuerySqlField (index = true)
    private final int prof_id;

    @QuerySqlField
    private final int dep_id;

    @QuerySqlField
    private final String prof_name;


    public Professor(int prof_id , int dep_id, String prof_name) {
        this.prof_id = prof_id;
        this.dep_id = dep_id;
        this.prof_name = prof_name;
    }

    @Override
    public String toString() {
        return prof_id + "," + dep_id + "," + prof_name;
    }
}
