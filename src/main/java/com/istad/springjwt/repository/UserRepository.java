package com.istad.springjwt.repository;


import org.apache.catalina.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserRepository {
    @Select("SELECT username ,secret_key,role FROM users_tb"+
            "INNER JOIN user_role_tb urt on users_tb.id = urt.user_id"+
            "INNER JOIN role_tb rt on rt.id = urt.role_id"+
           " WHERE username LIKE #{username}")
    List<User>getUserByName(String name);
}
