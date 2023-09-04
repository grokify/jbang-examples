///usr/bin/env jbang "$0" "$@" ; exit $? 

import java.lang.Thread;
import java.time.format.DateTimeFormatter;
import java.time.Duration;
import java.time.ZonedDateTime;
import java.util.concurrent.TimeUnit;

class helloworld { 
    public static void main(String[] args) {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssZZZZZ");
        ZonedDateTime dt0 = ZonedDateTime.now();
        String dtStr0 = fmt.format(dt0);
        System.out.println(dtStr0);

        if (args.length==0) {
            System.out.println("Hello World!");
        } else {
            System.out.println("Hello " + args[0]);
        }

        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            System.out.println(e);
        }

        ZonedDateTime dt1 = ZonedDateTime.now();
        String dtStr1 = fmt.format(dt1);
        System.out.println(dtStr1);

        Duration dur = Duration.between(dt0,dt1);
        long durms = dur.toMillis();
        long durmn = TimeUnit.MILLISECONDS.toMinutes(durms)*60;
        // String time = String.format("%02d hours, %02d min, %02d sec",
        String time = String.format("%02d:%02d:%02d",
            TimeUnit.MILLISECONDS.toHours(durms),
            TimeUnit.MILLISECONDS.toMinutes(durms) - TimeUnit.MILLISECONDS.toHours(durms) * 60,
            TimeUnit.MILLISECONDS.toSeconds(durms) - durmn);
        System.out.println("time elapsed = " + time);
    }
}