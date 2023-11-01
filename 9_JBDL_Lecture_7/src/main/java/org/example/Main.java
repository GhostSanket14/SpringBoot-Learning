package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) throws SQLException {
        System.out.println("Hello world!");

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/testmaven",
                "jbdlsanket", "1414"); // here we give link with port, user name and password.
        // we can also make this using workbench UI. but use cmd for future ease.
        Statement statement = connection.createStatement(); // creating an empty statement
        statement.execute("create table iik (id int, name varchar(30))"); // filling statement obj with a query and then executing it

    }
}

//Extra
//
//	<properties>
//	<maven.compiler.source>8</maven.compiler.source> // sees the code in java 8
//	<maven.compiler.target>8</maven.compiler.target> // compiles in java 8
//	<project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
//	</properties>