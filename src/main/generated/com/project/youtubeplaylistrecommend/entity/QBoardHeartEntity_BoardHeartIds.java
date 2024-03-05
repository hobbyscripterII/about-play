package com.project.youtubeplaylistrecommend.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QBoardHeartEntity_BoardHeartIds is a Querydsl query type for BoardHeartIds
 */
@Generated("com.querydsl.codegen.DefaultEmbeddableSerializer")
public class QBoardHeartEntity_BoardHeartIds extends BeanPath<BoardHeartEntity.BoardHeartIds> {

    private static final long serialVersionUID = 896945043L;

    public static final QBoardHeartEntity_BoardHeartIds boardHeartIds = new QBoardHeartEntity_BoardHeartIds("boardHeartIds");

    public final NumberPath<Long> iboard = createNumber("iboard", Long.class);

    public final NumberPath<Long> iuser = createNumber("iuser", Long.class);

    public QBoardHeartEntity_BoardHeartIds(String variable) {
        super(BoardHeartEntity.BoardHeartIds.class, forVariable(variable));
    }

    public QBoardHeartEntity_BoardHeartIds(Path<? extends BoardHeartEntity.BoardHeartIds> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBoardHeartEntity_BoardHeartIds(PathMetadata metadata) {
        super(BoardHeartEntity.BoardHeartIds.class, metadata);
    }

}

