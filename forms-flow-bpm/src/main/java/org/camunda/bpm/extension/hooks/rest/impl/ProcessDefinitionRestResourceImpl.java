package org.camunda.bpm.extension.hooks.rest.impl;

import org.camunda.bpm.engine.rest.dto.repository.ProcessDefinitionDiagramDto;
import org.camunda.bpm.engine.rest.dto.repository.ProcessDefinitionDto;
import org.camunda.bpm.engine.rest.dto.runtime.ProcessInstanceDto;
import org.camunda.bpm.engine.rest.dto.runtime.StartProcessInstanceDto;
import org.camunda.bpm.extension.hooks.rest.ProcessDefinitionRestResource;
import org.springframework.hateoas.EntityModel;

import javax.ws.rs.core.UriInfo;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


public class ProcessDefinitionRestResourceImpl implements ProcessDefinitionRestResource {

    private final org.camunda.bpm.engine.rest.ProcessDefinitionRestService restService;

    public ProcessDefinitionRestResourceImpl(org.camunda.bpm.engine.rest.ProcessDefinitionRestService processEngineRestService) {
        restService = processEngineRestService;
    }

    @Override
    public  List<ProcessDefinitionDto> getProcessDefinitions(UriInfo uriInfo, Integer firstResult, Integer maxResults) {
        return restService.getProcessDefinitions(uriInfo, firstResult, maxResults);
    }

    @Override
    public EntityModel<ProcessDefinitionDto> getProcessDefinition(String key) {
        ProcessDefinitionDto dto = restService.getProcessDefinitionByKey(key).getProcessDefinition();
        return EntityModel.of(dto, linkTo(methodOn(ProcessDefinitionRestResourceImpl.class).getProcessDefinition(key)).withSelfRel());
    }

    @Override
    public EntityModel<ProcessDefinitionDiagramDto> getProcessDefinitionBpmn20Xml(String key) {
        ProcessDefinitionDiagramDto dto =  restService.getProcessDefinitionByKey(key).getProcessDefinitionBpmn20Xml();
        return EntityModel.of(dto, linkTo(methodOn(ProcessDefinitionRestResourceImpl.class).getProcessDefinitionBpmn20Xml(key)).withSelfRel());
    }

    @Override
    public EntityModel<ProcessInstanceDto> startProcessInstanceByKey(UriInfo context, StartProcessInstanceDto parameters, String key) {

        org.camunda.bpm.engine.rest.dto.runtime.ProcessInstanceDto processInstanceDto = restService.getProcessDefinitionByKey(key).startProcessInstance(context, parameters);

        return EntityModel.of(processInstanceDto,
                linkTo(methodOn(ProcessDefinitionRestResourceImpl.class).startProcessInstanceByKey(context, parameters, key)).withSelfRel());
    }
}
