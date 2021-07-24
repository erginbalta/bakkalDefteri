package com.bakkaldefteri.bakkalDefteri.api;

import com.bakkaldefteri.bakkalDefteri.dtos.UserDto;
import com.bakkaldefteri.bakkalDefteri.servicesImpl.UserServiceImpl;
import com.bakkaldefteri.bakkalDefteri.util.ApiPath;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(ApiPath.UserCTRL.CTRL)
@Slf4j
public class UserApi {
    private final UserServiceImpl userServiceImpl;

    @Autowired
    public UserApi(UserServiceImpl userServiceImpl){
        this.userServiceImpl = userServiceImpl;
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers(){
        log.info("Getting All Users ... ");
        log.debug("Getting All Users ... ");
        return ResponseEntity.ok(userServiceImpl.getAll());
    }

    @PostMapping
    public ResponseEntity<UserDto> saveUser(@Valid @RequestBody UserDto userDto){
        log.info("New User Added ... ");
        log.debug("New User Added ... ID -> " +userDto.getId());
        return ResponseEntity.ok(userServiceImpl.save(userDto));
    }

    @GetMapping("{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable(value = "id",required = true) Long id){
        log.info("Getting One User By Id ...");
        log.debug("Getting One User By Id ... ID -> " +id);
        return ResponseEntity.ok(userServiceImpl.getById(id));
    }
}
