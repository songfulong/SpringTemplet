package com.huawei.repsitory;

import com.huawei.model.MovieEntity;
import com.huawei.model.MovieNode;
import org.springframework.data.domain.Example;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepsitory extends Neo4jRepository<MovieNode, String> {
    @Override
    List<MovieNode> findAll();

}
