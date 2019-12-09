package iinda.controller;

import iinda.common.Result;
import iinda.pojo.User;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @description:
 * @author: Mr.Z
 * @create: 2019-04-15 21:55
 */
@RestController
public class UserController {

    @PostMapping("/user")
    public Result addUser(@Valid @RequestBody User user, BindingResult br) {
        if (br.hasErrors()) {
            return Result.isFail().msg(br.getFieldError().getDefaultMessage());
        } else {
            return Result.isOk().data(user);
        }
    }
}
