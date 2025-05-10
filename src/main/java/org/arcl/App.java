package org.arcl;

public class App 
{
    static String division = System.getProperty("config.division");
    public static void main( String[] args )
    {
        System.out.println( String.format("APP - Division is: %s", division) );
    }
}
