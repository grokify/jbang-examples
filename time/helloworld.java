///usr/bin/env jbang "$0" "$@" ; exit $? 

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.ZoneOffset;
import java.lang.Thread;
import java.time.ZonedDateTime;

class helloworld { 
    public static void main(String[] args) {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssZZZZZ");
        String dtStr0 = fmt.format(ZonedDateTime.now());
        System.out.println(dtStr0);

        if(args.length==0) {
            System.out.println("Hello World!");
        } else {
            System.out.println("Hello " + args[0]);
        }

        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            System.out.println(e);
        }

        String dtStr1 = fmt.format(ZonedDateTime.now());
        System.out.println(dtStr1);
    }
}