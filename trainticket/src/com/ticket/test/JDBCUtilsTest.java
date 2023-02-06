package com.ticket.test;

import com.ticket.utils.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;

public class JDBCUtilsTest {
    @Test
    public void testJDBCUtils(){
        for (int i = 0; i < 100; i++) {
            Connection connection = JDBCUtils.getConnection();
            System.out.println(connection);
            JDBCUtils.close(connection);
        }
    }
}
