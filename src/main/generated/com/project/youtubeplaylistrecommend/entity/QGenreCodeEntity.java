package com.project.youtubeplaylistrecommend.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QGenreCodeEntity is a Querydsl query type for GenreCodeEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QGenreCodeEntity extends EntityPathBase<GenreCodeEntity> {

    private static final long serialVersionUID = 2070843149L;

    public static final QGenreCodeEntity genreCodeEntity = new QGenreCodeEntity("genreCodeEntity");

    public final QBaseEntity _super = new QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> firstCreatedAt = _super.firstCreatedAt;

    //inherited
    public final NumberPath<Long> firstCreatedUser = _super.firstCreatedUser;

    public final StringPath genreName = createString("genreName");

    public final NumberPath<Long> igenre = createNumber("igenre", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> lastUpdatedAt = _super.lastUpdatedAt;

    //inherited
    public final NumberPath<Long> lastUpdatedUser = _super.lastUpdatedUser;

    public QGenreCodeEntity(String variable) {
        super(GenreCodeEntity.class, forVariable(variable));
    }

    public QGenreCodeEntity(Path<? extends GenreCodeEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QGenreCodeEntity(PathMetadata metadata) {
        super(GenreCodeEntity.class, metadata);
    }

}

