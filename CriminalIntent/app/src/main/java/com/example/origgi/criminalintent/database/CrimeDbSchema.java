package com.example.origgi.criminalintent.database;

/**
 * Created by Emanuele on 04/05/2016.
 */
public class CrimeDbSchema {

    public static final class CrimeTable{
        public static final String NAME="criems";

        public static final class Cols {
            public static final String UUID = "uuid";
            public static final String TITLE = "title";
            public static final String DATE = "date";
            public static final String SOLVED = "solved";
        }
    }
}
