package com.together.dto.request;

import com.together.domain.MemberGrade;
import com.together.domain.RoleType;
import com.together.domain.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateMemberRequest {

    @NotNull
    private String username;

    @NotNull
    @Size(min = 8, max = 16, message = "비밀번호는 {min}자 이상 {max}자 이하여야 합니다.")
    private String password;

    @NotNull
    @Size(min = 2, max = 10, message = "닉네임은 {min}자 이상 {max}자 이하여야 합니다.")
    private String nickname;

    public Member toMemberEntity() {
        return Member.builder()
                .username(this.username)
                .password(this.password)
                .nickname(this.nickname)
                .role(RoleType.ROLE_USER)
                .grade(MemberGrade.NONE)
                .build();
    }
}
