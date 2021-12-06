package com.together.auth.email;

import com.together.auth.CustomUserDetails;
import com.together.domain.entity.Member;
import com.together.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Member findMember = memberRepository.findByUsername(username);

        if(findMember == null){
            System.out.println("로그인 오류");
            return null;
        }else{
            System.out.println("로그인 성공");
            return new CustomUserDetails(findMember);
        }
    }
}
