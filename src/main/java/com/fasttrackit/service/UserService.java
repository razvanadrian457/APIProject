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
    public void saveUser(UserDTO userDTO)
    {

        try
        {
            User user = convert(userDTO);
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

        userDTO.setPassword(user.getPassword());
        userDTO.setEmail(user.getEmail());
        userDTO.setId(user.getId());
        return userDTO;
    }

    private User convert(UserDTO userDTO)
    {
        User user1 = new User();

        user1.setPassword(userDTO.getPassword());
        user1.setEmail(userDTO.getEmail());
        user1.setId(userDTO.getId());
        return user1;
    }


    public UserDTO getUserById(long id)
    {
        User one = userRepository.findOne(id);
        if(one == null)
        {
            throw new IllegalArgumentException("The id is not valid");
        }
        return convertToDto(one);
    }

    public UserDTO getUserByEmailAndPassword(String email, String password)
    {
        User user = userRepository.findByEmailAndPassword(email, password);
        if(user == null)
        {
            throw new IllegalArgumentException("The user with email" + email + "is ont valid");
        }
        return convertToDto(user);
    }


    public UserDTO updateUser(long id, UserDTO dto)
    {
        User user = userRepository.findOne(id);
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());

        User save = userRepository.save(user);

        return convertToDto(save);
    }
}
