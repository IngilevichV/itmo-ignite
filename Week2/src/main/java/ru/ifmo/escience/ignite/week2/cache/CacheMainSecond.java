package ru.ifmo.escience.ignite.week2.cache;

import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.apache.ignite.Ignition;

import static ru.ifmo.escience.ignite.Utils.print;
import static ru.ifmo.escience.ignite.week2.cache.CacheUtils.printCacheStats;

public class CacheMainSecond {
    public static void main(String[] args) throws Exception {
        try (Ignite ignite = Ignition.start("Week2/config/default.xml")) {
            IgniteCache<Object, Object> cache = ignite.cache("mycache");

            print("Waiting for data to arrive...");

            while (!cache.remove("START"))
                Thread.sleep(500);

            int cnt = cache.size();

            print("Cache size: " + cnt);

            //TODO PUT DATA HERE
            for (int i = 0; i == 0; i++)
                ;

            long sum = sumFromCache(cache);

            printCacheStats(ignite);

            //TODO PUT SUM INTO CACHE WITH KEY 'FINISH' HERE
        }
    }

    private static long sumFromCache(IgniteCache<Object, Object> cache) {
        //TODO COMPUTE CORRECT SUM HERE
        return 0;
    }
}
