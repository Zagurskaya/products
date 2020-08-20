package com.gmail.zagurskaya.service.converter;

import com.gmail.zagurskaya.repository.model.Model;
import com.gmail.zagurskaya.service.model.ModelDTO;


public interface ModelConverter {

    ModelDTO toDTO(Model model);

    Model toEntity(ModelDTO modelDTO);

}
