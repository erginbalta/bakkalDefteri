package com.bakkaldefteri.bakkalDefteri.services;

import com.bakkaldefteri.bakkalDefteri.dtos.UserDto;
import com.bakkaldefteri.bakkalDefteri.util.TPage;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    UserDto save(UserDto user);

    UserDto getById(Long id);

    //TPage<UserDto> getAllPageable(Pageable pageable);

    List<UserDto> getAll();

    UserDto getByUsername(String username);

    Boolean accessCheck(String username, String password);
}
