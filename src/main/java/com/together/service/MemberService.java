package com.together.service;

import com.together.dto.request.CreateMemberRequest;
import com.together.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class MemberService {

    private final MemberRepository repository;

    public void createMember(CreateMemberRequest memberRequest) {
        if(memberRequest == null){
            throw new NullPointerException("member == null");
        }else{
            try {
                repository.save(memberRequest.toMemberEntity());
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public void updateMember(){

    }


}
