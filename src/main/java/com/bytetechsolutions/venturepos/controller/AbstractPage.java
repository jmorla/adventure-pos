package com.bytetechsolutions.venturepos.controller;

import java.io.IOException;
import java.util.Map;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.bytetechsolutions.venturepos.model.ViewDescriptor;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * The BaseController class provides basic functionalities for managing web page
 * content.
 */
public abstract class AbstractPage {

    private static final String DESCRIPTOR_PATH = "view_descriptor.json";
    protected static final String DEFAULT_VIEW = "index";

    /**
     * 
     * Initializes the common model attribute for all handlers a a controller
     * 
     * @param model the common model
     */
    @ModelAttribute
    private void setCommonModelAttributes(ModelAndView model) {
        var descriptors = loadViewDescriptors();
        
        var descriptor = descriptors.get(getDescriptorName());
        
        model.addObject("title", descriptor.getTitle());
        model.addObject("stylesheets", descriptor.getStylesheets());
        model.addObject("scripts", descriptor.getScripts());
        model.setViewName(DEFAULT_VIEW);
    }

    /**
     * Loads views descriptor json file configuration
    */
    private Map<String, ViewDescriptor> loadViewDescriptors() {
        try {
            Resource resource = new ClassPathResource(DESCRIPTOR_PATH);
            ObjectMapper mapper = new ObjectMapper();
            TypeReference<Map<String, ViewDescriptor>> typeRef = new TypeReference<Map<String,ViewDescriptor>>() {};
            return mapper.readValue(resource.getContentAsByteArray(), typeRef);
        } catch (IOException ex) {
            throw new RuntimeException(ex); // rethrow it for now
        }
    }

    public abstract String getDescriptorName();

}
