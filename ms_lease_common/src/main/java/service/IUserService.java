package service;

import config.FeignConfig;
import domain.User;
import dto.Result;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "CoreServer", configuration = FeignConfig.class)
public interface IUserService {
    @PostMapping(value = "/register/{username}/{password}")
    Result register(@PathVariable("username")String username,@PathVariable("password")String password);

    @PostMapping(value = "/login/{username}/{password}")
    Result login(@PathVariable("username")String username,@PathVariable("password")String password);

    @PostMapping(value = "/findByName/{username}")
    Result findByName(@PathVariable("username") String username);
}
