package com.nds.ftm.users.service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nds.ftm.entity.Users;
import com.nds.ftm.repository.DaoUsers;
import com.nds.ftm.users.model.UsersInput;
import com.nds.ftm.users.model.UsersOutput;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UsersService {

    @Autowired
    private DaoUsers daoUsers;


    public List<Users> list() {
        return daoUsers.findAll();
    }

    public UsersOutput detail(UsersInput input) throws Exception {
        Optional<Users> usersOptional = daoUsers.findById(input.getId());

        Users user = usersOptional.orElseThrow(() -> new Exception("User not found"));

        UsersOutput output = new UsersOutput();
        output.setId(user.getId());
        output.setName(user.getName());
        output.setEmail(user.getEmail());
        output.setCreated_at(user.getCreated_at());

        return output;
    }

    @Transactional
    public UsersOutput insert(UsersInput input) throws Exception {
        log.debug("insert [{}]", input);

        String uuid = UUID.randomUUID().toString();

        Users users = new Users();
        users.setId(uuid);
        users.setPassword(input.getPassword());
        users.setEmail(input.getEmail());
        users.setName(input.getName());
        users.setCreated_at(LocalDateTime.now());

        daoUsers.save(users);

        UsersOutput output = new UsersOutput();
        output.setId(users.getId());
        output.setName(users.getName());
        output.setEmail(users.getEmail());
        output.setCreated_at(users.getCreated_at());

        return output;

    }

    @Transactional
    public UsersOutput update(UsersInput input) throws Exception {
        log.debug("update [{}]", input);

        Users users = daoUsers.findById(input.getId())
                .orElseThrow(() -> new Exception("User not found"));

        if (input.getPassword() != null && !input.getPassword().isEmpty()) {
            users.setPassword(input.getPassword());
        }

        if (input.getEmail() != null && !input.getEmail().isEmpty()) {
            users.setEmail(input.getEmail());
        }
        if (input.getName() != null && !input.getName().isEmpty()) {
            users.setName(input.getName());
        }

        users.setUpdated_at(LocalDateTime.now());

        daoUsers.save(users);

        UsersOutput output = new UsersOutput();
        output.setId(users.getId());
        output.setName(users.getName());
        output.setEmail(users.getEmail());
        output.setUpdated_at(users.getUpdated_at());

        return output;
    }

    @Transactional
    public Map<String, Object> delete(UsersInput input) throws Exception {

        Users user = daoUsers.findById(input.getId())
                .orElseThrow(() -> new Exception("User not found"));

        daoUsers.deleteById(input.getId());

        Map<String, Object> response = new HashMap<>();
        response.put("id", user.getId());
        response.put("message", "User successfully deleted");

        return response;
    }

}
