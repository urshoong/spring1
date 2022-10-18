package org.zerock.spring1.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface TimeMapper {

    @Select("select now()")
    String getTime();

    String getTime2();

    @Insert("insert into t1 (col1) values (#{str})")
    void addT1(String str);

    @Insert("insert into t2 (col2) values (#{str})")
    void addT2(String str);

}
