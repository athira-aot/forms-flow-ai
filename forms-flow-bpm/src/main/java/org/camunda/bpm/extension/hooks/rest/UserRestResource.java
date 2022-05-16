package org.camunda.bpm.extension.hooks.rest;

import org.camunda.bpm.extension.hooks.rest.dto.UserProfileDto;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Map;

public interface UserRestResource extends RestResource{

    String PATH = "/user";

    @GetMapping(produces = MediaType.APPLICATION_JSON)
    EntityModel<List<UserProfileDto>> queryUsers(@RequestParam Map<String, Object> parameters);
}