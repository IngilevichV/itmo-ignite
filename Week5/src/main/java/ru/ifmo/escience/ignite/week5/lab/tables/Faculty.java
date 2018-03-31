package ru.ifmo.escience.ignite.week5.lab.tables;

import org.apache.ignite.cache.query.annotations.QuerySqlField;
import org.apache.ignite.internal.util.typedef.internal.S;

public class Faculty {
    private final int fac_id;

    private final String fac_name;

    private final int univ_id;

    public Faculty(int fac_id , String fac_name, int univ_id) {
        this.fac_id = fac_id;
        this.fac_name = fac_name;
        this.univ_id = univ_id;
    }

    @Override
    public String toString() {
        return fac_id+ "," + fac_name+ "," + univ_id;
    }

}

