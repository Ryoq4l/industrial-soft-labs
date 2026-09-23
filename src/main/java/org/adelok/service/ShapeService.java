package org.adelok.service;

import lombok.RequiredArgsConstructor;
import org.adelok.dto.ShapesDto;
import org.adelok.mapper.ShapesMapper;
import org.adelok.models.Shapes;
import org.adelok.repository.ShapesRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class ShapeService {
    private final ShapesRepository shapesRepository;
    private final ShapesMapper shapesMapper;

    //CREATE
    public void createShape(ShapesDto shapesDto) {
        Shapes shape = shapesMapper.map(shapesDto);
        shapesRepository.save(shape);
    }
    public ShapesDto findFirstByOrderByAreaDesc() {
        return shapesRepository.findFirstByOrderByAreaDesc()
                .map(shapesMapper::toDto)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "No shapes found"));
    }
}
