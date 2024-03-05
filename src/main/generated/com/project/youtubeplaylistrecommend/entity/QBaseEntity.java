package com.project.youtubeplaylistrecommend.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QBaseEntity is a Querydsl query type for BaseEntity
 */
@Generated("com.querydsl.codegen.DefaultSupertypeSerializer")
public class QBaseEntity extends EntityPathBase<BaseEntity> {

    private static final long serialVersionUID = -159340326L;

    public static final QBaseEntity baseEntity = new QBaseEntity("baseEntity");

    public final DateTimePath<java.time.LocalDateTime> firstCreatedAt = createDateTime("firstCreatedAt", java.time.LocalDateTime.class);

    public final NumberPath<Long> firstCreatedUser = createNumber("firstCreatedUser", Long.class);

    public final DateTimePath<java.time.LocalDateTime> lastUpdatedAt = createDateTime("lastUpdatedAt", java.time.LocalDateTime.class);

    public final NumberPath<Long> lastUpdatedUser = createNumber("lastUpdatedUser", Long.class);

    public QBaseEntity(String variable) {
        super(BaseEntity.class, forVariable(variable));
    }

    public QBaseEntity(Path<? extends BaseEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBaseEntity(PathMetadata metadata) {
        super(BaseEntity.class, metadata);
    }

}

