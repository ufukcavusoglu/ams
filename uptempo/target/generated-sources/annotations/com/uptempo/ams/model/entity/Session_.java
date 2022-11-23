package com.uptempo.ams.model.entity;

import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import java.util.UUID;
import javax.annotation.processing.Generated;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Session.class)
public abstract class Session_ {

	public static volatile SingularAttribute<Session, String> ipAddress;
	public static volatile SingularAttribute<Session, UUID> id;
	public static volatile SingularAttribute<Session, Account> account;

	public static final String IP_ADDRESS = "ipAddress";
	public static final String ID = "id";
	public static final String ACCOUNT = "account";

}

