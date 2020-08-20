package com.gmail.zagurskaya.service;

import com.gmail.zagurskaya.service.model.ModelDTO;
import java.util.List;

public interface ModelService {

    List<ModelDTO> getModels();

    void add(ModelDTO modelDTO);

    void delete(Long id);

    void update(ModelDTO modelDTO);

}
