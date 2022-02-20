package top.jrl.springfamily.mybatisdemo.mapper;

import org.apache.ibatis.annotations.*;
import top.jrl.springfamily.mybatisdemo.model.Coffee;

/**
 * @author Joly
 */
@Mapper
public interface CoffeeMapper {
    /**
     * 保存Coffee
     * Options注解用于说明id是自动生成的
     *
     * @param coffee c
     * @return 更改了的行数
     */
    @Options(useGeneratedKeys = true,keyColumn = "id",keyProperty = "id")
    @Insert("insert into t_coffee (name,price,create_time,update_time) " +
            "values (#{name},#{price},now(),now())")
    int save(Coffee coffee);


    /**
     * 根据id查找coffee
     * TODO 确认一下是否需要自己写Results注解
     *
     * @param id coffee's id
     * @return Coffee
     */
    @Select("select * from t_coffee where id = #{id}")
    Coffee findById(@Param("id") Long id);


}
