package jpabook.jpashop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import lombok.RequiredArgsConstructor;


@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {

	private final MemberRepository memberRepository;

	@Transactional
	public Long join(Member member){
		validateDuplicateMember(member);
		memberRepository.save(member);
		return member.getId();
	}

	private void validateDuplicateMember(Member member){
		List<Member> findMembers = memberRepository.findByName(member.getName());
		// EXCEPTION
		if(!findMembers.isEmpty()){
			throw new IllegalStateException("member already exist!!");
		}
	}

	public List<Member> findMembers(){
		return memberRepository.findAll();
	}

	public Member findOne(Long memberId){
		return memberRepository.findOne(memberId);
	}
}
