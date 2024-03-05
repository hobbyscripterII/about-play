package com.project.youtubeplaylistrecommend.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QBoardCodeEntity is a Querydsl query type for BoardCodeEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QBoardCodeEntity extends EntityPathBase<BoardCodeEntity> {

    private static final long serialVersionUID = -616344400L;

    public static final QBoardCodeEntity boardCodeEntity = new QBoardCodeEntity("boardCodeEntity");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final StringPath boardName = createString("boardName");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> firstCreatedAt = _super.firstCreatedAt;

    //inherited
    public final NumberPath<Long> firstCreatedUser = _super.firstCreatedUser;

    public final NumberPath<Long> iboardcode = createNumber("iboardcode", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> lastUpdatedAt = _super.lastUpdatedAt;

    //inherited
    public final NumberPath<Long> lastUpdatedUser = _super.lastUpdatedUser;

    public QBoardCodeEntity(String variable) {
        super(BoardCodeEntity.class, forVariable(variable));
    }

    public QBoardCodeEntity(Path<? extends BoardCodeEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBoardCodeEntity(PathMetadata metadata) {
        super(BoardCodeEntity.class, metadata);
    }

}

