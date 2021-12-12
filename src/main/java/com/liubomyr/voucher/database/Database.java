package com.liubomyr.voucher.database;

import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    public static final String URL = "jdbc:mysql://localhost:3306/voucher_agency";
    public static final String USER = "root";
    public static final String PASSWORD = "root";

    static  Connection connection;

    public static DSLContext getDSLContextInstance() throws  SQLException {
        connection = DriverManager.getConnection(URL, USER, PASSWORD);

        return DSL.using(connection, SQLDialect.MYSQL);
    }


}
