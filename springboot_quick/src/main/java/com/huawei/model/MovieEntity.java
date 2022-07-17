package com.huawei.model;

import lombok.Data;
import org.springframework.data.neo4j.core.schema.*;

import java.util.List;

@Data
public class MovieEntity {
    @Id
    @Property("title")
    private final String title;

    @Property("tagline")
    private final String description;

    @Property("released")
    private final Integer released;

}
