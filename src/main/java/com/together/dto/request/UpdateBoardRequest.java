package com.together.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateBoardRequest {

    private String title;

    private String content;
}
