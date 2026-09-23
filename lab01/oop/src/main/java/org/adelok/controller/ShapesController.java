package org.adelok.controller;

import lombok.RequiredArgsConstructor;
import org.adelok.dto.ShapesDto;
import org.adelok.service.ShapeService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/shapes")
@RequiredArgsConstructor
public class ShapesController {
    private final ShapeService shapeService;
    //CREATE ENDPOINT
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createShape(@RequestBody ShapesDto shapesDto){
        shapeService.createShape(shapesDto);
    }
    @GetMapping("/max-area")
    public ShapesDto findFirstByOrderByAreaDesc() {
        return shapeService.findFirstByOrderByAreaDesc();
    }
}
