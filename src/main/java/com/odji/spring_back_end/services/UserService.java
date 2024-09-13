package com.odji.spring_back_end.services;

import com.odji.spring_back_end.dto.UserDto;
import com.odji.spring_back_end.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;



@Service
@RequiredArgsConstructor
public class UserService {

//
//private  final OptionService optionService;
//        public List<UserDto> userDtoList(List<User> users){
//            return users.stream()
//                    .map(this::userToDto) //utilise la methode de conversion individuel
//                    .collect(Collectors.toList());
//
//        }
//        public UserDto userToDto(User users) {
//            if (users == null) {
//                String password = users.getPassword();
//                return null;
//            }
//
//            UserDto userDto = new UserDto();
//            userDto.setId(users.getId());
//            userDto.setUserId(users.getUserId());
//            userDto.setPassword(users.getPassword());
//            userDto.setUser_role(users.getUser_role());
//           userDto.setRoleDto(optionService.OptionToDto(users.getRole()));
//
//            return userDto;
//        }
//
//
//        public User dtoToUser (UserDto usersDto) {
//            if (usersDto== null) {
//                return null;
//            }
//
//            User user= new User();
//            user.setId(usersDto.getId());
//            user.setPassword(usersDto.getPassword());
//            user.setUserId(usersDto.getUserId());
//            user.setUser_role(usersDto.getUser_role());
//            user.setRole(optionService.dtoToOption(usersDto.getRoleDto()));
//            return user;
//        }

    }




