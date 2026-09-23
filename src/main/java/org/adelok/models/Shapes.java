package org.adelok.models;

import jakarta.persistence.*;
import lombok.*;
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "shapes")
public class Shapes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private Type type;

    @Column (name = "area")
    private Double area;

    @Column (name = "perimeter")
    private Double perimeter;

}
