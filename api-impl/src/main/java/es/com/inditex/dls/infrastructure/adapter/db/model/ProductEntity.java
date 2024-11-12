package es.com.inditex.dls.infrastructure.adapter.db.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Cascade;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "PRODUCT")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "BRAND_ID")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @NotNull
    private BrandEntity brand;
    @NotNull
    private String name;
}
