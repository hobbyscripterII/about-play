package com.project.youtubeplaylistrecommend.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QBoardHeartEntity is a Querydsl query type for BoardHeartEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QBoardHeartEntity extends EntityPathBase<BoardHeartEntity> {

    private static final long serialVersionUID = -463419575L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QBoardHeartEntity boardHeartEntity = new QBoardHeartEntity("boardHeartEntity");

    public final QBoardEntity boardEntity;

    public final QBoardHeartEntity_BoardHeartIds boardHeartIds;

    public final QUserEntity userEntity;

    public QBoardHeartEntity(String variable) {
        this(BoardHeartEntity.class, forVariable(variable), INITS);
    }

    public QBoardHeartEntity(Path<? extends BoardHeartEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QBoardHeartEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QBoardHeartEntity(PathMetadata metadata, PathInits inits) {
        this(BoardHeartEntity.class, metadata, inits);
    }

    public QBoardHeartEntity(Class<? extends BoardHeartEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.boardEntity = inits.isInitialized("boardEntity") ? new QBoardEntity(forProperty("boardEntity"), inits.get("boardEntity")) : null;
        this.boardHeartIds = inits.isInitialized("boardHeartIds") ? new QBoardHeartEntity_BoardHeartIds(forProperty("boardHeartIds")) : null;
        this.userEntity = inits.isInitialized("userEntity") ? new QUserEntity(forProperty("userEntity")) : null;
    }

}

