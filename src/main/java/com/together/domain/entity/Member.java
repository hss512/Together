package com.together.domain.entity;

import com.together.domain.MemberGrade;
import com.together.domain.RoleType;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
public class Member extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(unique = true, nullable = false)
    private String nickname;

    @Enumerated(value = EnumType.STRING)
    private RoleType role;

    @Enumerated(value = EnumType.STRING)
    private MemberGrade grade;
}
