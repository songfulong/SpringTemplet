package com.huawei.model;

import lombok.Data;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.List;

@Node(labels = "Movie")
@Data
public class MovieNode {
    @Id
    @Property("title")
    private final String title;

    @Property("tagline")
    private final String description;

    @Property("released")
    private final Integer released;

    //@Relationship(type = "ACTED_IN", direction = Relationship.Direction.INCOMING)
    private List<Roles> actorsAndRoles;

    //@Relationship(type = "DIRECTED", direction = Relationship.Direction.INCOMING)
    private List<Roles> directors;

    public MovieNode(String title, String description, Integer released, List<Roles> actorsAndRoles, List<Roles> directors) {
        this.title = title;
        this.description = description;
        this.released = released;
        this.actorsAndRoles = actorsAndRoles;
        this.directors = directors;
    }

}
