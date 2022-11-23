package com.uptempo.ams.model.entity;

import jakarta.persistence.metamodel.ListAttribute;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import java.time.LocalDateTime;
import java.util.UUID;
import javax.annotation.processing.Generated;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Account.class)
public abstract class Account_ {

	public static volatile SingularAttribute<Account, String> password;
	public static volatile ListAttribute<Account, Session> sessions;
	public static volatile SingularAttribute<Account, LocalDateTime> registeredAt;
	public static volatile SingularAttribute<Account, UUID> id;
	public static volatile SingularAttribute<Account, Boolean> markedForDeletion;
	public static volatile SingularAttribute<Account, String> email;

	public static final String PASSWORD = "password";
	public static final String SESSIONS = "sessions";
	public static final String REGISTERED_AT = "registeredAt";
	public static final String ID = "id";
	public static final String MARKED_FOR_DELETION = "markedForDeletion";
	public static final String EMAIL = "email";

}

