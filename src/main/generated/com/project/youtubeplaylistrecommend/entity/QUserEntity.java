package com.project.youtubeplaylistrecommend.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QUserEntity is a Querydsl query type for UserEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUserEntity extends EntityPathBase<UserEntity> {

    private static final long serialVersionUID = -2044433836L;

    public static final QUserEntity userEntity = new QUserEntity("userEntity");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final DateTimePath<java.time.LocalDateTime> deletedAt = createDateTime("deletedAt", java.time.LocalDateTime.class);

    public final ComparablePath<Character> deleteFl = createComparable("deleteFl", Character.class);

    public final StringPath email = createString("email");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> firstCreatedAt = _super.firstCreatedAt;

    //inherited
    public final NumberPath<Long> firstCreatedUser = _super.firstCreatedUser;

    public final NumberPath<Long> iuser = createNumber("iuser", Long.class);

    public final StringPath kakaoId = createString("kakaoId");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> lastUpdatedAt = _super.lastUpdatedAt;

    //inherited
    public final NumberPath<Long> lastUpdatedUser = _super.lastUpdatedUser;

    public final ComparablePath<Character> leaveFl = createComparable("leaveFl", Character.class);

    public final StringPath name = createString("name");

    public final StringPath pic = createString("pic");

    public final StringPath pwd = createString("pwd");

    public final StringPath role = createString("role");

    public final DateTimePath<java.time.LocalDateTime> updatedAt = createDateTime("updatedAt", java.time.LocalDateTime.class);

    public final NumberPath<Integer> visit = createNumber("visit", Integer.class);

    public QUserEntity(String variable) {
        super(UserEntity.class, forVariable(variable));
    }

    public QUserEntity(Path<? extends UserEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUserEntity(PathMetadata metadata) {
        super(UserEntity.class, metadata);
    }

}

