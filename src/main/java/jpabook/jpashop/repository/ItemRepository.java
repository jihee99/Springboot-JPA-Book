package jpabook.jpashop.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jpabook.jpashop.domain.item.Item;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class ItemRepository {

	private final EntityManager entityManager;

	public void save(Item item){
		if(item.getId() == null){
			entityManager.persist(item);
		}else{
			entityManager.merge(item);
		}
	}

	public Item findOne(Long id){
		return entityManager.find(Item.class, id);
	}

	public List<Item> findAll(){
		return entityManager.createQuery("select i from Item i", Item.class)
			.getResultList();
	}

}
