package backend.mapper;

import backend.datasource.ReadOperation;
import backend.datasource.WriteOperation;
import backend.model.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    @ReadOperation
    User selectById(int id);

    @WriteOperation
    void insert(User user);

    @WriteOperation
    void update(User user);

    @WriteOperation
    void delete(int id);
}
