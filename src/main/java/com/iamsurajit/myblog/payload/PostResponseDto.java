package com.iamsurajit.myblog.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostResponseDto {
    private List<PostDto> content;
    private int pageNo;
    private int pageSize;
    private long totalElement;
    private boolean isLast;
}
