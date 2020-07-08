package com;

/**
 * @program: 第一组动态资源
 * @description:
 * @author: Mx
 * @create: 2020-07-05 17:38
 **/
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;

public class DBUtil {
    private static volatile DataSource dataSource = null;

    public DBUtil() {
    }

    public static Connection getConnection() throws SQLException {
        if (dataSource == null) {
            Class var0 = DBUtil.class;
            synchronized(DBUtil.class) {
                if (dataSource == null) {
                    dataSource = initDataSource();
                }
            }
        }

        return dataSource.getConnection();
    }

    private static DataSource initDataSource() {
        MysqlDataSource mysqlDataSource = new MysqlDataSource();
        mysqlDataSource.setUrl("jdbc:mysql://127.0.0.1:3306/hjb2_0705?useSSL=false&characterEncoding=utf8");
        mysqlDataSource.setUser("root");
        mysqlDataSource.setPassword("199846");
        return mysqlDataSource;
    }
}
