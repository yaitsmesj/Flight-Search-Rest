package com.nagarro.Repository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.nagarro.model.User;
import com.nagarro.model.UserRole;
import com.nagarro.utils.ConstantsUtil;

@Repository
public class LoginDaoImpl implements LoginDao {

	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public User findByUserName(String username) {

		List<User> users = null;
		try {
			Query query = entityManager.createQuery(ConstantsUtil.USER_QUERY + "'" + username + "'");
			users = query.getResultList();

		} catch (Exception e) {
			e.printStackTrace();
		}
		if (users.size() > 0)
			return users.get(0);
		else
			return null;
	}

	@Override
	@SuppressWarnings("unchecked")
	public Set<UserRole> findUserRole(String username) {

		Set<UserRole> roles = null;
		try {
			Query query = entityManager.createQuery(ConstantsUtil.USER_ROLE_QUERY + "'" + username + "'");
			roles = new HashSet<>(query.getResultList());

		} catch (Exception e) {
			e.printStackTrace();
		}
		return roles;
	}

}
