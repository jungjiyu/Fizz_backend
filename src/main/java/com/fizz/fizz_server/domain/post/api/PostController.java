package com.fizz.fizz_server.domain.post.api;

import com.fizz.fizz_server.domain.post.dto.request.PostRequest;
import com.fizz.fizz_server.domain.post.dto.response.PostInfo;
import com.fizz.fizz_server.domain.post.service.PostService;
import com.fizz.fizz_server.domain.user.domain.CustomUserPrincipal;
import com.fizz.fizz_server.global.base.response.ResponseBody;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import static com.fizz.fizz_server.global.base.response.ResponseUtil.createSuccessResponse;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/posts")
public class PostController {

    private final PostService postService;

    /**
     * 게시글 업로드
     */
    @PostMapping("/challenges/{challengeId}")
    public ResponseEntity<ResponseBody<Void>> upload(@PathVariable Long challengeId,
                                                     @RequestBody @Valid PostRequest request,
                                                     @AuthenticationPrincipal CustomUserPrincipal user) {
        postService.upload(challengeId, request, user.getUserId());

        return ResponseEntity.ok(createSuccessResponse());
    }

    /**
     * 특정 게시글 정보 조회
     */
    @GetMapping("/{postId}")
    public ResponseEntity<ResponseBody<PostInfo>> getPost(@PathVariable Long postId) {
        PostInfo response = postService.getPost(postId);

        return ResponseEntity.ok(createSuccessResponse(response));
    }

    /**
     * 게시글 삭제
     */
    @DeleteMapping("/{postId}")
    public ResponseEntity<ResponseBody<Void>> deletePost(@PathVariable Long postId,
                                                         @AuthenticationPrincipal CustomUserPrincipal user) {
        postService.deletePost(user.getUserId(), postId);

        return ResponseEntity.ok(createSuccessResponse());
    }

    /**
     * 모든 게시글 받아오기
     */
    @GetMapping
    public ResponseEntity<ResponseBody<Page<PostInfo>>> getAllPosts(Pageable pageable) {
        Page<PostInfo> responses = postService.getAllPosts(pageable);

        return ResponseEntity.ok(createSuccessResponse(responses));
    }

    /**
     * 챌린지 기반 게시글 목록 조회
     */
    @GetMapping("/challenges/{challengeId}")
    public ResponseEntity<ResponseBody<Page<PostInfo>>> getPostsByChallenge(@PathVariable Long challengeId,
                                                                            Pageable pageable) {
        Page<PostInfo> responses = postService.getPostsByChallenge(challengeId, pageable);

        return ResponseEntity.ok(createSuccessResponse(responses));
    }

    /**
     * 사용자 기반 게시글 목록 조회
     */
    @GetMapping("/users/{userId}")
    public ResponseEntity<ResponseBody<Page<PostInfo>>> getPostsByUser(@PathVariable Long userId,
                                                                       Pageable pageable) {
        Page<PostInfo> responses = postService.getPostsByUser(userId, pageable);

        return ResponseEntity.ok(createSuccessResponse(responses));
    }

    /**
     * 제목, 내용 기반 검색
     */
    @GetMapping("/search")
    public ResponseEntity<ResponseBody<Page<PostInfo>>> searchPosts(@RequestParam("keyword") String keyword,
                                                                    Pageable pageable) {
        Page<PostInfo> responses = postService.searchPosts(keyword, pageable);

        return ResponseEntity.ok(createSuccessResponse(responses));
    }

    /**
     * 사용자가 좋아요한 글 목록 조회
     */
    @GetMapping("/users/like")
    public ResponseEntity<ResponseBody<Page<PostInfo>>> searchPosts(@AuthenticationPrincipal CustomUserPrincipal user,
                                                                    Pageable pageable) {
        Page<PostInfo> responses = postService.getPostsByUserLike(user.getUserId(), pageable);

        return ResponseEntity.ok(createSuccessResponse(responses));
    }
}
