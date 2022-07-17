package com.huawei.model;

import lombok.Data;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.List;

@Node(labels = "Person")
@Data
public class PersonNode {

    @Id
    @Property("name")
    private final String name;

    @Property("born")
    private final Integer born;


    @Relationship(type = "ACTED_IN", direction = Relationship.Direction.OUTGOING)
    private List<PersonRelationship> actorsAndRoles;

    @Relationship(type = "DIRECTED", direction = Relationship.Direction.OUTGOING)
    private List<PersonRelationship> directors;

    public PersonNode(String name, Integer born, List<PersonRelationship> actorsAndRoles, List<PersonRelationship> directors) {
        this.name = name;
        this.born = born;
        this.actorsAndRoles = actorsAndRoles;
        this.directors = directors;
    }
}
