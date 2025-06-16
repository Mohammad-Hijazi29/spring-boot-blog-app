package com.mhmd.blog.Controllers;


import com.mhmd.blog.Services.TagService;
import com.mhmd.blog.domain.dtos.TagDto;
import com.mhmd.blog.domain.entities.Tag;
import com.mhmd.blog.mappers.TagMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/api/v1/tags")
@RequiredArgsConstructor
public class TagController {

    private final TagService tagService;
    private final TagMapper tagMapper;

    @GetMapping
    public ResponseEntity<List<TagDto>> getAllTags(){
        List<Tag> tags = tagService.getTags();
        List<TagDto> tagResponses =  tags.stream()
                .map(tagMapper::toTagResponse)
                .toList();

        return ResponseEntity.ok(tagResponses);
    }


    @PostMapping
    public ResponseEntity<List<TagDto>> createTags(@RequestBody com.devtiro.blog.domain.dtos.CreateTagsRequest createTagsRequest){
        List<Tag> savedTags = tagService.createTags(createTagsRequest.getNames());

       List<TagDto> createdTagResponses =  savedTags.stream().map(tagMapper::toTagResponse).toList();

       return new ResponseEntity<>(
               createdTagResponses,
               HttpStatus.CREATED
       );
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteTag(@PathVariable UUID id){
            tagService.deleteTag(id);

            return ResponseEntity.noContent().build();
    }

}
