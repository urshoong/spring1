package org.zerock.spring1.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.zerock.spring1.dto.Member;

public interface MemberMapper {

    Member selectOne(String mid);

    //bad code
    @Insert("insert into tbl_member (mid, mpw, mname) values (#{mid}, #{mpw}, #{mname})")
    void insert (Member member);

    @Insert("insert into tbl_member_auth (mid, auth) values (#{mid}, #{auth})")
    //쿼리에 두개 이상의 인자를 넘겨야 하는 경우 @Param 을 이용해서 사용한다
    void insertAuth(@Param("mid") String mid, @Param("auth") String auth);

}
