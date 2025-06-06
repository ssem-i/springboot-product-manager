package kr.ac.hansung.cse.hellospringdatajpa.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.validator.constraints.NotBlank;


@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)     // db에 저장할 때 id가 결정됨
    private Long id;

    @NotBlank(message = "제품 이름을 입력해주세요.")
    @Size(max = 30, message = "제품 이름은 30자 이하로 입력해주세요.")
    private String name;

    @NotBlank(message = "브랜드명을 입력해주세요.")
    @Size(max = 30, message = "브랜드명은 30자 이하로 입력해주세요.")
    private String brand;

    @NotBlank(message = "제조국을 입력해주세요.")
    @Size(max = 30, message = "제조국은 30자 이하로 입력해주세요.")
    private String madeIn;

    @NotNull(message = "가격을 입력해주세요.")
    @DecimalMin(value = "0.0", inclusive = true, message="가격이 올바르지 않습니다.")
    private Double price;

    public Product(String name, String brand, String madeIn, Double price) {
        this.name = name;
        this.brand = brand;
        this.madeIn = madeIn;
        this.price = price;
    }


}