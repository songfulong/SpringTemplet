package com.huawei.model;

import lombok.Data;
import org.springframework.data.neo4j.core.schema.*;


@Data
public class PersonEntity {

    @Id
    @Property("name")
    private final String name;

    @Property("born")
    private final Integer born;

}
