package com.bakkaldefteri.bakkalDefteri.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoriesDto {
    private long id;
    private String categoryName;
}
