package com.springdemo.demoSpring.controllers;

import com.springdemo.demoSpring.entity.classes.Like;
import com.springdemo.demoSpring.service.LikeService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/likes")
public class LikeController {

    private final LikeService likeService;

    public LikeController(LikeService likeService) {
        this.likeService = likeService;
    }

    @PostMapping(path = "/add")
    public Like likeOrDislike(@RequestBody Like like) {
        return likeService.likeOrDislikeArticle(like);
    }
}
