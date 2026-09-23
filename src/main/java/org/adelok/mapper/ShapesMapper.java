package org.adelok.mapper;

import org.adelok.dto.ShapesDto;
import org.adelok.models.Shapes;
import org.springframework.stereotype.Component;

@Component
public class ShapesMapper {
public Shapes map(ShapesDto shapesDto){
    if (shapesDto == null) return null;
return Shapes.builder()
        .type(shapesDto.type())
        .perimeter(shapesDto.perimeter())
        .area(shapesDto.area())
        .build();
}
    public ShapesDto toDto(Shapes entity){
        return ShapesDto.builder()
                .id(entity.getId())
                .type(entity.getType())
                .perimeter(entity.getPerimeter())
                .area(entity.getArea())
                .build();
    }

}
