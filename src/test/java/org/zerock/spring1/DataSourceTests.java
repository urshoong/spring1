package org.zerock.spring1;

import lombok.extern.log4j.Log4j2;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.sql.DataSource;
import java.sql.Connection;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {org.zerock.spring1.config.RootConfig.class})
@Log4j2
public class DataSourceTests {

    @Autowired
    DataSource dataSource;

    @Autowired
    SqlSessionFactory factory;

    @Test
    public void testMyBatis() {
        log.info(factory);
    }

    @Test
    public void testConnection()throws Exception {

        Connection connection = dataSource.getConnection();
        log.info(connection);
        connection.close();
    }

}
