package com.project.youtubeplaylistrecommend.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QBoardEntity is a Querydsl query type for BoardEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QBoardEntity extends EntityPathBase<BoardEntity> {

    private static final long serialVersionUID = 819126371L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QBoardEntity boardEntity = new QBoardEntity("boardEntity");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final QBoardCodeEntity boardCodeEntity;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> firstCreatedAt = _super.firstCreatedAt;

    //inherited
    public final NumberPath<Long> firstCreatedUser = _super.firstCreatedUser;

    public final QGenreCodeEntity genreCodeEntity;

    public final NumberPath<Integer> heart = createNumber("heart", Integer.class);

    public final NumberPath<Long> iboard = createNumber("iboard", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> lastUpdatedAt = _super.lastUpdatedAt;

    //inherited
    public final NumberPath<Long> lastUpdatedUser = _super.lastUpdatedUser;

    public final StringPath title = createString("title");

    public final QUserEntity userEntity;

    public final NumberPath<Integer> view = createNumber("view", Integer.class);

    public QBoardEntity(String variable) {
        this(BoardEntity.class, forVariable(variable), INITS);
    }

    public QBoardEntity(Path<? extends BoardEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QBoardEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QBoardEntity(PathMetadata metadata, PathInits inits) {
        this(BoardEntity.class, metadata, inits);
    }

    public QBoardEntity(Class<? extends BoardEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.boardCodeEntity = inits.isInitialized("boardCodeEntity") ? new QBoardCodeEntity(forProperty("boardCodeEntity")) : null;
        this.genreCodeEntity = inits.isInitialized("genreCodeEntity") ? new QGenreCodeEntity(forProperty("genreCodeEntity")) : null;
        this.userEntity = inits.isInitialized("userEntity") ? new QUserEntity(forProperty("userEntity")) : null;
    }

}

