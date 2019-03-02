package com.fasttrackit.service;

import com.fasttrackit.domain.User;
import com.fasttrackit.dto.UserDTO;
import com.fasttrackit.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService
{
    @Autowired
    private UserRepository userRepository;

    @Transactional
    public void saveUser(User user)
    {
        if(user.getAge() < 18)
        {
            throw new IllegalArgumentException("Age cannot be under 18");
        }
        if(user.getFirstName() == null)
        {
            throw new IllegalArgumentException("First name cannot be null");
        }
        if(user.getName() == null)
        {
            throw new IllegalArgumentException("Name cannot be null");
        }
        try
        {
            userRepository.save(user);
        }
        catch (Exception e)
        {
            System.out.println("Error when saving user" + e);
        }
    }

    private UserDTO convertToDto(User user)
    {
        UserDTO userDTO = new UserDTO();
        userDTO.setFirstName(user.getFirstName());
        userDTO.setUsername(user.getUsername());
        userDTO.setPassword(user.getPassword());
        userDTO.setName(user.getName());
        userDTO.setAge(user.getAge());
        userDTO.setId(user.getId());
        return userDTO;
    }

    private User convert(UserDTO userDTO)
    {
        User user1 = new User();
        userDTO.setName(userDTO.getName());
        userDTO.setFirstName(userDTO.getFirstName());
        userDTO.setUsername(userDTO.getUsername());
        userDTO.setPassword(userDTO.getPassword());
        userDTO.setAge(userDTO.getAge());
        userDTO.setId(userDTO.getId());
        return user1;
    }


    public UserDTO getUserById(long id)
    {
        User one = userRepository.findOne(id);
        if(one == null)
        {
            throw new IllegalArgumentException("The id is not valid");
        }
        return null;
    }


    public UserDTO updateUser(long id, UserDTO dto)
    {
        User user = userRepository.findOne(id);
        user.setFirstName(dto.getFirstName());
        user.setUsername(dto.getUsername());
        user.setPassword(dto.getPassword());
        user.setName(dto.getName());
        user.setAge(dto.getAge());

        User save = userRepository.save(user);

        return convertToDto(save);
    }
}
