package jpabook.jpashop.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jpabook.jpashop.domain.Order;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class OrderRepository {

	private final EntityManager entityManager;

	public void save(Order order){
		entityManager.persist(order);
	}

	public Order findOne(Long id){
		return entityManager.find(Order.class, id);
	}

	//	검색
	// public List<Order> findAll(OrderSearch orderSearch){
	//
	// }

}
