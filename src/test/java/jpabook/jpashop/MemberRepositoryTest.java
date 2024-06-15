package jpabook.jpashop;

import static org.junit.Assert.*;

import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import jakarta.transaction.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MemberRepositoryTest {

	@Autowired MemberRepository memberRepository;

	@Test
	@Transactional
	public void testMember() throws Exception {
	    // given
		Member member = new Member();
		member.setUsername("memberA");

		// when
		Long id = memberRepository.save(member);
		// >>> opt + cmd + v >>> 변수 뽑아오기
		Member findMember = memberRepository.find(id);

	    // then
		Assertions.assertThat(findMember.getId()).isEqualTo(member.getId());
		Assertions.assertThat(findMember.getUsername()).isEqualTo(member.getUsername());

	}
}
