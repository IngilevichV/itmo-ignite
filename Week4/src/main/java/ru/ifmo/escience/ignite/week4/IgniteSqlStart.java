package ru.ifmo.escience.ignite.week4;

import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.apache.ignite.Ignition;
import org.apache.ignite.binary.BinaryObjectBuilder;
import org.apache.ignite.cache.query.SqlFieldsQuery;

import java.io.IOException;
import java.util.List;

import static ru.ifmo.escience.ignite.Utils.readln;

public class IgniteSqlStart {
    public static void main(String[] args) throws IOException {
//        System.setProperty("IGNITE_H2_DEBUG_CONSOLE", "true");

        try (Ignite node = Ignition.start("Week4/config/default.xml")) {
//            node.cache("mycache").put(1, new Person("John", "Doe", 5000));
            IgniteCache dflt = node.getOrCreateCache("default");

            dflt.query(new SqlFieldsQuery("create  table \"PUBLIC\".Student (name VARCHAR, age INT, group_id INT, id_card INT, university_code INT,"+
            "PRIMARY KEY(id_card, university_code))" +
            "WITH \"cache_name = Student, key_type = StudentKey, value_type = Student\";")).getAll();


//            dflt.query(new SqlFieldsQuery("INSERT INTO Student(name, age, group_id, id_card, university_code)"));
            executeQuery(dflt, "INSERT INTO \"PUBLIC\".Student(name, age, group_id, id_card, university_code) VALUES ('Ivan', 23, 4115, 31, 15)");
            executeQuery(dflt, "INSERT INTO \"PUBLIC\".Student(name, age, group_id, id_card, university_code) VALUES ('Alina', 25, 4115, 33, 16)");
            System.out.println(executeQuery(dflt, "Select * from \"PUBLIC\".Student where name = ?", "Ivan"));
            IgniteCache StCache = node.cache("Student");
            BinaryObjectBuilder bldr = node.binary().builder("StudentKey");
            BinaryObjectBuilder bldr_v = node.binary().builder("Student");




            bldr.setField("ID_CARD", 34);
            bldr.setField("UNIVERSITY_CODE", 17);

            bldr_v.setField("NAME", "Petr");
            bldr_v.setField("AGE", 27);
            bldr_v.setField("GROUP_ID", 4117);

            StCache.put(bldr.build(), bldr_v.build());

//            bldr.build();
            System.out.println(StCache.withKeepBinary().get(bldr.build()));
//            System.out.println(StCache.withKeepBinary().get(bldr_v.build()));
            System.out.println(executeQuery(dflt, "Select * from \"PUBLIC\".Student where name = ?", "Petr"));

            readln();
        }
    }

    public static List<List<?>> executeQuery(IgniteCache cache, String query, Object...param) {
        return cache.query(new SqlFieldsQuery(query).setSchema("PUBLIC").setArgs(param)).getAll();
    }
}
