package com.seniors.domain.users.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.seniors.common.repository.BasicRepoSupport;
import com.seniors.domain.users.entity.QUsers;
import com.seniors.domain.users.entity.Users;
import jakarta.persistence.EntityManager;

public class UsersRepositoryImpl extends BasicRepoSupport implements UsersRepositoryCustom {

	protected UsersRepositoryImpl(JPAQueryFactory jpaQueryFactory, EntityManager em) {
		super(jpaQueryFactory, em);
	}

	private final static QUsers users = QUsers.users;

	@Override
	public Users getOneUsers(Long userId) {
		Users user = jpaQueryFactory
				.selectFrom(QUsers.users)
				.where(QUsers.users.id.eq(userId))
				.fetchOne();
		return user;
	}

}
