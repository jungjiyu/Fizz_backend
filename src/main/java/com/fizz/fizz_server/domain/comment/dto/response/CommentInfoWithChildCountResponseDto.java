package com.fizz.fizz_server.domain.comment.dto.response;

import com.fizz.fizz_server.domain.comment.domain.Comment;
import lombok.*;

@ToString
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class CommentInfoWithChildCountResponseDto {

    private Long commentId;
    private Long parentId;
    private Long userId;
    private String content;
    private Integer likeCount;
    private Long childCount;

    public static CommentInfoWithChildCountResponseDto toDTO(Comment comment, Long childCount){
        CommentInfoWithChildCountResponseDto dto = new CommentInfoWithChildCountResponseDto();
        dto.commentId = comment.getId();
        if(comment.getParent() != null ) dto.parentId = comment.getParent().getId();
        dto.userId = comment.getUser().getId();
        dto.content = comment.getContent();
        dto.likeCount = comment.getCommentLikes().size();
        dto.childCount = childCount;
        return dto;
    }
}