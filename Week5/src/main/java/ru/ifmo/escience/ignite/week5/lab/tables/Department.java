package ru.ifmo.escience.ignite.week5.lab.tables;

import org.apache.ignite.cache.query.annotations.QuerySqlField;
import org.apache.ignite.internal.util.typedef.internal.S;

public class Department {


    private final int dep_id;


    private final int fac_id;


    private final String dep_name;


    public Department(int dep_id , String dep_name, int fac_id) {
        this.fac_id = fac_id;
        this.dep_id = dep_id;
        this.dep_name = dep_name;
    }

    @Override
    public String toString() {
        return dep_id+ "," + dep_name+ "," + fac_id;
    }


}

