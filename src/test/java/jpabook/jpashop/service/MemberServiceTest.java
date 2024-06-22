package jpabook.jpashop.service;

import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class MemberServiceTest {

	@Autowired MemberService memberService;
	@Autowired MemberRepository memberRepository;
	@Autowired EntityManager em;

	@Test
	public void 회원가입() throws Exception {

		// given
	    Member member = new Member();
		member.setName("JIHEE");

	    // when
		Long savedId = memberService.join(member);

	    // then
		em.flush();
		assertEquals(member, memberRepository.findOne(savedId));

	}


	@Test
	public void 중복_회원_예외() throws Exception {

	    // given


	    // when


	    // then


	}
}
