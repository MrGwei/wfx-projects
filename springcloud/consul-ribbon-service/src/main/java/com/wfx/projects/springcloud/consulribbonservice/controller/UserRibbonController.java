package com.wfx.projects.springcloud.consulribbonservice.controller;

import com.wfx.projects.springcloud.consulribbonservice.pojo.Result;
import com.wfx.projects.springcloud.consulribbonservice.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * @author Gwei
 */
@RestController
@RequestMapping("/user")
public class UserRibbonController {

    @Autowired
    private RestTemplate restTemplate;

//    @Value("${service-url.user-service}")
    @Value("${service-url.consul-user-service}")
    private String userServiceUrl;

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/{id}")
    public Result getUser(@PathVariable Long id) {
        System.out.println(discoveryClient.getInstances("consul-user-service"));
        return restTemplate.getForObject(userServiceUrl + "/user/{1}", Result.class, id);
    }

    @GetMapping("/getByUsername")
    public Result getByUsername(@RequestParam String username) {
        return restTemplate.getForObject(userServiceUrl + "/user/getByUsername?username={1}", Result.class, username);
    }

    @GetMapping("/getEntityByUsername")
    public Result getEntityByUsername(@RequestParam String username) {
        ResponseEntity<Result> entity = restTemplate.getForEntity(userServiceUrl + "/user/getByUsername?username={1}", Result.class, username);
        if (entity.getStatusCode().is2xxSuccessful()) {
            return entity.getBody();
        } else {
            return new Result("操作失败", 500);
        }
    }

    @PostMapping("/insert")
    public Result insert(@RequestBody User user) {
        return restTemplate.postForObject(userServiceUrl + "/user/insert", user, Result.class);
    }

    @PostMapping("/update")
    public Result update(@RequestBody User user) {
        return restTemplate.postForObject(userServiceUrl + "/user/update", user, Result.class);
    }

    @PostMapping("/delete/{id}")
    public Result delete(@PathVariable Long id) {
        return restTemplate.postForObject(userServiceUrl + "/user/delete/{1}", null, Result.class, id);
    }

}
