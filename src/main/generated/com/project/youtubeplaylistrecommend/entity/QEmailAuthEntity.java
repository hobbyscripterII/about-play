package com.project.youtubeplaylistrecommend.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QEmailAuthEntity is a Querydsl query type for EmailAuthEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QEmailAuthEntity extends EntityPathBase<EmailAuthEntity> {

    private static final long serialVersionUID = 885914977L;

    public static final QEmailAuthEntity emailAuthEntity = new QEmailAuthEntity("emailAuthEntity");

    public final StringPath authCode = createString("authCode");

    public final DateTimePath<java.time.LocalDateTime> authedAt = createDateTime("authedAt", java.time.LocalDateTime.class);

    public final ComparablePath<Character> authFl = createComparable("authFl", Character.class);

    public final StringPath email = createString("email");

    public final NumberPath<Long> iauth = createNumber("iauth", Long.class);

    public final DateTimePath<java.time.LocalDateTime> issuedAt = createDateTime("issuedAt", java.time.LocalDateTime.class);

    public QEmailAuthEntity(String variable) {
        super(EmailAuthEntity.class, forVariable(variable));
    }

    public QEmailAuthEntity(Path<? extends EmailAuthEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QEmailAuthEntity(PathMetadata metadata) {
        super(EmailAuthEntity.class, metadata);
    }

}

