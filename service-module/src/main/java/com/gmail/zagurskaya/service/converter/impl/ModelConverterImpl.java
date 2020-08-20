package com.gmail.zagurskaya.service.converter.impl;

import com.gmail.zagurskaya.repository.model.Model;
import com.gmail.zagurskaya.service.converter.ModelConverter;
import com.gmail.zagurskaya.service.model.ModelDTO;
import org.springframework.stereotype.Component;

@Component
public class ModelConverterImpl implements ModelConverter {

    @Override
    public ModelDTO toDTO(Model model) {
        ModelDTO modelDTO = new ModelDTO();
        modelDTO.setId(model.getId());
        modelDTO.setName(model.getName());
        return modelDTO;
    }

    @Override
    public Model toEntity(ModelDTO modelDTO) {
        Model model = new Model();
        model.setId(modelDTO.getId());
        model.setName(modelDTO.getName());
        return model;
    }
}
