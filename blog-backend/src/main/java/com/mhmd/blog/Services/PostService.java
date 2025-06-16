package com.mhmd.blog.Services;


import com.mhmd.blog.domain.CreatePostRequest;
import com.mhmd.blog.domain.UpdatePostRequest;
import com.mhmd.blog.domain.entities.Post;
import com.mhmd.blog.domain.entities.User;

import java.util.List;
import java.util.UUID;

public interface PostService {

    Post getPost(UUID id);
    List<Post> getAllPosts(UUID categoryId, UUID tagId);
    List<Post> getDraftPosts(User user);
    Post createPost(User user, CreatePostRequest createPostRequest);
    Post updatePost(UUID id, UpdatePostRequest updatePostRequest);
    void deletePost(UUID id);
}
