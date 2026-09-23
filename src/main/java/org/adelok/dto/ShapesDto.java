package org.adelok.dto;

import lombok.Builder;
import org.adelok.models.Type;
@Builder
public record ShapesDto(
        Long id,
        Type type,
        Double area,
        Double perimeter) {
}
