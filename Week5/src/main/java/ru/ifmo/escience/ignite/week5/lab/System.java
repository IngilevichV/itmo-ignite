package ru.ifmo.escience.ignite.week5.lab;


import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.apache.ignite.Ignition;
import org.apache.ignite.binary.BinaryObject;
import org.apache.ignite.cache.query.SqlFieldsQuery;
import org.apache.ignite.configuration.CacheConfiguration;
import org.apache.ignite.configuration.IgniteConfiguration;
import ru.ifmo.escience.ignite.Utils;
import ru.ifmo.escience.ignite.week5.lab.tables.Department;
import ru.ifmo.escience.ignite.week5.lab.tables.Faculty;
import ru.ifmo.escience.ignite.week5.lab.tables.University;
import ru.ifmo.escience.ignite.week5.lab.tables.Professor;

import java.io.IOException;

import static ru.ifmo.escience.ignite.Utils.print;
import static ru.ifmo.escience.ignite.Utils.readln;


public class System {
    @SuppressWarnings("ThrowFromFinallyBlock")
    public static void main(String[] args) throws IOException {

        try (Ignite node = Ignition.start("Week5/config/my_default.xml")) {
            //Cache Configuration

            //cache1, University
            IgniteCache cache1 = node.cache("mycache1");

            int univ_id = 1;
            University university = new University(1, "ITMO", "Birzhevaya", 1);

            cache1.put(univ_id, university);
            print(cache1.get(univ_id).toString());

            //cache2, Faculty
            IgniteCache cache2 = node.cache("mycache2");

            int fac_id = 3;
            Faculty itip = new Faculty(3, "ITIP", 1);

            cache2.put(fac_id, itip);
            print(cache2.get(fac_id).toString());

            //cache3, Department
            IgniteCache cache3 = node.cache("mycache3");

            int dep_id = 3;
            Department vpv = new Department(17, "vpv", 3);

            cache3.put(dep_id, vpv);
            print(cache3.get(dep_id).toString());


            //Create cache manually

            CacheConfiguration<Integer, Professor> ccache4 = new CacheConfiguration<>("Professor");
            ccache4.setIndexedTypes(Integer.class, Professor.class);
            IgniteConfiguration cache4 = new IgniteConfiguration();
            cache4.setClientMode(true);
            cache4.setCacheConfiguration(ccache4);
            node.getOrCreateCache(ccache4);

            node.cache("Professor").query(new SqlFieldsQuery("create  table \"PUBLIC\".Professor (prof_id INT, prof_name VARCHAR, dep_id INT "+
                    "PRIMARY KEY(prof_id)) " +
                    "WITH \"cache_name = professor, key_type = ProfessorKey, value_type = Professor\";")).getAll();
        }
    }
}

