package com.crio.xmeme.controllers;

import com.crio.xmeme.dtos.MemePostDTO;
import com.crio.xmeme.services.MemePostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/memes")
public class MemePostController {
    private final MemePostService memePostService;

    @Autowired
    public MemePostController(MemePostService memePostService) {
        this.memePostService = memePostService;
    }

    @GetMapping
    public List<MemePostDTO> getAllMemePosts() {
        return memePostService.getAllMemePosts();
    }

    @GetMapping("/{id}")
    public MemePostDTO getMemePostById(@PathVariable("id") Long id) {
        return memePostService.getMemePostById(id);
    }

    @PostMapping
    public ResponseEntity<?> addMemePost(@RequestBody Map<String, String> payload) {
        return new ResponseEntity<>(memePostService.addMemePost(payload), HttpStatus.CREATED);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> updateMemePost(@RequestBody  Map<String, String> payload, @PathVariable("id") Long id) {
        memePostService.updateMemePost(payload, id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMemePost(@PathVariable("id") Long id) {
        memePostService.deleteMemePost(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
