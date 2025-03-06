package com.nds.ftm.users;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.nds.ftm.entity.Users;
import com.nds.ftm.users.model.UsersInput;
import com.nds.ftm.users.model.UsersOutput;
import com.nds.ftm.users.service.UsersService;

@RequestMapping("/users")
@RestController
public class UsersController {

    @Autowired
    private UsersService usersService;

    @GetMapping(value = "/list")
    public List<Users> list() throws Exception {
        return usersService.list();
    }

    @PostMapping(value = "/detail")
    public UsersOutput detail(@RequestBody UsersInput input) throws Exception{
        return usersService.detail(input);
    }

    @PostMapping(value = "/insert")
    public UsersOutput insert(@RequestBody UsersInput input) throws Exception{
        return usersService.insert(input);
    }

    @PostMapping(value = "/update")
    public UsersOutput update (@RequestBody UsersInput input) throws Exception{
        return usersService.update(input);
    }

    @PostMapping(value = "/delete")
    public ResponseEntity<Map<String, Object>> delete(@RequestBody UsersInput input) throws Exception{
        Map<String, Object> response = usersService.delete(input);
        return ResponseEntity.ok(response);
    }
}
