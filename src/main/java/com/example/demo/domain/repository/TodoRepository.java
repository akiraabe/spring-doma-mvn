package com.example.demo.domain.repository;

import com.example.demo.domain.model.Todo;
import org.seasar.doma.Dao;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;

import java.util.List;

@Dao
@ConfigAutowireable
public interface TodoRepository {

    @Select
    List<Todo> findAll();

    @Insert
    int save(Todo todo);

    @Select
    Todo getOne(Integer id);
}
