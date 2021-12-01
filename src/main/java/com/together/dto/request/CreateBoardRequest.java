package com.together.dto.request;

import com.together.domain.entity.Board;
import com.together.domain.entity.Category;
import com.together.domain.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateBoardRequest {

    private String title;

    private String content;

    public Board toBoardEntity(Member member, Category category){
        return Board.builder()
                .title(this.title)
                .content(this.content)
                .member(member)
                .category(category)
                .likeCount(0)
                .view(0)
                .build();
    }
}
