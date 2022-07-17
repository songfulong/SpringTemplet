package com.huawei.model;

import lombok.Data;
import org.springframework.data.neo4j.core.schema.*;

import java.util.List;

@RelationshipProperties
@Data
public class Roles {

    @Id
    @GeneratedValue
    private Long id;

    @Property("roles")
    private List<String> roles;

    @TargetNode
    private PersonEntity person;
}
