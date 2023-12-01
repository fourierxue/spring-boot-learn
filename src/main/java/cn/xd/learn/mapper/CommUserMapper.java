package cn.xd.learn.mapper;

import cn.xd.learn.entity.CommUser;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

//@Mapper
public interface CommUserMapper {
    @Select("select * from comm_user where id = #{id}")
    CommUser getUserById(String id);

    @Delete("delete from comm_user where id = #{id}")
    int deleteUserById(String id);

    @Insert("insert into comm_user(id, name, role_id) values(#{id}, #{name}, #{roleId})")
    int insertUser(CommUser commUser);
}
