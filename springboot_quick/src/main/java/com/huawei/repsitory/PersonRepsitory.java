package com.huawei.repsitory;

import com.huawei.model.MovieEntity;
import com.huawei.model.PersonEntity;
import com.huawei.model.PersonNode;
import org.springframework.data.domain.Example;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepsitory extends Neo4jRepository<PersonNode, String> {
    @Override
    List<PersonNode> findAll();
}
