package com.bakkaldefteri.bakkalDefteri.dtos;

import com.bakkaldefteri.bakkalDefteri.domain.Categories;
import com.bakkaldefteri.bakkalDefteri.domain.Gender;
import com.bakkaldefteri.bakkalDefteri.domain.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductCardDto {
    private long id;

    private Categories category;

    private Size size;
    private String color;
    private Gender gender;
}