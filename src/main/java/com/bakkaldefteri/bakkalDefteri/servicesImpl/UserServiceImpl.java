package com.bakkaldefteri.bakkalDefteri.servicesImpl;

import com.bakkaldefteri.bakkalDefteri.domain.User;
import com.bakkaldefteri.bakkalDefteri.dtos.UserDto;
import com.bakkaldefteri.bakkalDefteri.repositories.UserRepository;
import com.bakkaldefteri.bakkalDefteri.services.UserService;
import com.bakkaldefteri.bakkalDefteri.util.TPage;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.Arrays;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final ModelMapper modelMapper;
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(ModelMapper modelMapper, UserRepository userRepository){
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public UserDto save(UserDto userDto) {
        User user = modelMapper.map(userDto, User.class);
        userRepository.save(user);
        return userDto;
    }

    @Override
    public UserDto getById(Long id) {
        User user = userRepository.getById(id);
        return modelMapper.map(user, UserDto.class);
    }

    @Override
    public List<UserDto> getAll() {
        List<User> userList = userRepository.findAll();
        return Arrays.asList(modelMapper.map(userList, UserDto[].class));
    }

    @Override
    public UserDto getByUsername(String username) {
        User user = userRepository.findByUsername(username);
        return modelMapper.map(user, UserDto.class);
    }

    @Override
    public Boolean accessCheck(String username, String password) {
        User user = userRepository.findByUsernameAndPassword(username,password);
        if(user!= null){
            return true;
        } else {
            return false;
        }
    }
    /*
    @Override
    public TPage<UserDto> getAllPageable(Pageable pageable) {
        Page<User> data = userRepository.findAll(pageable);
        TPage<UserDto> respnose = new TPage<UserDto>();
        respnose.setStat(data, Arrays.asList(modelMapper.map(data.getContent(), UserDto[].class)));
        return respnose;
    }
     */
}
