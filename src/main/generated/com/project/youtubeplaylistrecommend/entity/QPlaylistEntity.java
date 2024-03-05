package com.project.youtubeplaylistrecommend.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPlaylistEntity is a Querydsl query type for PlaylistEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPlaylistEntity extends EntityPathBase<PlaylistEntity> {

    private static final long serialVersionUID = -1839969253L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QPlaylistEntity playlistEntity = new QPlaylistEntity("playlistEntity");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final QBoardEntity boardEntity;

    public final StringPath description = createString("description");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> firstCreatedAt = _super.firstCreatedAt;

    //inherited
    public final NumberPath<Long> firstCreatedUser = _super.firstCreatedUser;

    public final NumberPath<Long> iplaylist = createNumber("iplaylist", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> lastUpdatedAt = _super.lastUpdatedAt;

    //inherited
    public final NumberPath<Long> lastUpdatedUser = _super.lastUpdatedUser;

    public final ComparablePath<Character> thumbnailFl = createComparable("thumbnailFl", Character.class);

    public final StringPath videoId = createString("videoId");

    public QPlaylistEntity(String variable) {
        this(PlaylistEntity.class, forVariable(variable), INITS);
    }

    public QPlaylistEntity(Path<? extends PlaylistEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QPlaylistEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QPlaylistEntity(PathMetadata metadata, PathInits inits) {
        this(PlaylistEntity.class, metadata, inits);
    }

    public QPlaylistEntity(Class<? extends PlaylistEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.boardEntity = inits.isInitialized("boardEntity") ? new QBoardEntity(forProperty("boardEntity"), inits.get("boardEntity")) : null;
    }

}

