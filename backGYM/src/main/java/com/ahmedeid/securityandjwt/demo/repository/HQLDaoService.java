package com.ahmedeid.securityandjwt.demo.repository;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ahmedeid.securityandjwt.demo.entities.Player;
import com.ahmedeid.securityandjwt.demo.uibean.Resubscription;

@Repository
@Transactional
public class HQLDaoService {

	@Autowired
	private EntityManager entityManager;

	public List<User> getByPassword() {

		Session session = entityManager.unwrap(Session.class);

		Query<User> userSQL = session.createQuery("from User where password=123456", User.class);

		List<User> users = userSQL.getResultList();

		return users;

	}

	public boolean updatePlayerImageByCode(String playerImage, long code) {

		boolean status = false;
		Session session = entityManager.unwrap(Session.class);

		Query updatePlayerImage = session
				.createQuery("update Player p set p.playerImage= :playerImage " + "where p.code= :code");

		updatePlayerImage.setParameter("playerImage", playerImage);
		updatePlayerImage.setParameter("code", code);

		int resultStatus = updatePlayerImage.executeUpdate();
		if (resultStatus != 0) {
			status = true;
			entityManager.close();
			session.close();
		}
		return status;
	}
	
	public boolean newSubscription(Resubscription resubscription, long code, int newSubscription) {

		boolean status = false;
		
		int amountPaid = resubscription.getAmountPaid();
		int amountRest = resubscription.getAmountRest();
		Date subscriptionDate = resubscription.getModifiedDate();
		Session session = entityManager.unwrap(Session.class);

		Query updatePlayerImage = session
				.createQuery("update Player p set p.amountPaid= :amountPaid , p.amountRest= :amountRest " 
							+ ", p.subscriptionNo= :newSubscription , p.dateModify= :subscriptionDate "
							+ " , p.hulfMonthNo=15 where p.code= :code");

		updatePlayerImage.setParameter("amountPaid", amountPaid);
		updatePlayerImage.setParameter("amountRest", amountRest);
		updatePlayerImage.setParameter("newSubscription", newSubscription);
		updatePlayerImage.setParameter("subscriptionDate", subscriptionDate);
		updatePlayerImage.setParameter("code", code);

		int resultStatus = updatePlayerImage.executeUpdate();
		if (resultStatus != 0) {
			status = true;
			entityManager.close();
			session.close();
		}
		return status;
	}
	
	public boolean updatePlayerHulfMonthNOByCode(int hulfMonthNO, long code) {

		boolean status = false;
		Session session = entityManager.unwrap(Session.class);

		Query updatePlayerImage = session
				.createQuery("update Player p set p.hulfMonthNo= :hulfMonthNO " + "where p.code= :code");

		updatePlayerImage.setParameter("hulfMonthNO", hulfMonthNO);
		updatePlayerImage.setParameter("code", code);

		int resultStatus = updatePlayerImage.executeUpdate();
		if (resultStatus != 0) {
			status = true;
			entityManager.close();
			session.close();
		}
		return status;
	}

}
