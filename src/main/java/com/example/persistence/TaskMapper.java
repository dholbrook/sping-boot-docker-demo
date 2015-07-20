package com.example.persistence;

import com.example.domain.Task;
import org.apache.ibatis.annotations.*;

public interface TaskMapper {

    String SELECT_TASK_SQL =
            " SELECT t.id," +
            "        t.description," +
            "        t.complete" +
            " FROM task.task AS t" +
            " WHERE t.id = #{taskId}";

    String INSERT_TASK_SQL =
            " INSERT INTO task" +
            "   (description," +
            "   complete)" +
            " VALUES" +
            "   (#{description}," +
            "    #{complete})";

    String UPDATE_TASK_SQL =
            " UPDATE task " +
            " SET description = #{description}, " +
            "     complete =  #{complete} " +
            " WHERE id = #{id} ";

    @Select(SELECT_TASK_SQL)
    Task findTask(long taskId);

    @Insert(INSERT_TASK_SQL)
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int addTask(Task task);

    @Update(UPDATE_TASK_SQL)
    int updateTask(Task task);

}