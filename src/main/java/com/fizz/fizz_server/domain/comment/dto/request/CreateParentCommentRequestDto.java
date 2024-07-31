package com.fizz.fizz_server.domain.comment.dto.request;

import com.fizz.fizz_server.domain.comment.domain.Comment;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Null;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class CreateParentCommentRequestDto {
    @NotBlank(message = "content은 빈값일 수 없습니다.")
    private String content;
}