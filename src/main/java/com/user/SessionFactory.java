package com.user;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;

public class SessionFactory {

    private static Logger logger = LoggerFactory.getLogger(SessionFactory.class);
    private static SqlSessionFactory sqlSessionFactory = null;

    private SessionFactory() {
    }

    public static SqlSessionFactory getInstance() {
        if (sqlSessionFactory == null) {
            try (InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml")) {
                sqlSessionFactory = SessionFactory.sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
                return sqlSessionFactory;
            } catch (IOException e) {
                logger.error("mybatis-config.xml not found", e);
            }
        }
        return sqlSessionFactory;
    }

}


