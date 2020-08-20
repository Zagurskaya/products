package com.gmail.zagurskaya.service.impl;

import com.gmail.zagurskaya.repository.ModelRepository;
import com.gmail.zagurskaya.repository.model.Model;
import com.gmail.zagurskaya.service.ModelService;
import com.gmail.zagurskaya.service.converter.ModelConverter;
import com.gmail.zagurskaya.service.model.ModelDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ModelServiceImpl implements ModelService {

    private final ModelConverter modelConverter;
    private final ModelRepository modelRepository;

    @Autowired
    public ModelServiceImpl(ModelConverter modelConverter, ModelRepository modelRepository) {
        this.modelConverter = modelConverter;
        this.modelRepository = modelRepository;
    }



    @Override
    @Transactional
    public List<ModelDTO> getModels() {
        List<Model> products = modelRepository.findAll(0, Integer.MAX_VALUE);
        List<ModelDTO> dtos = products.stream()
                .map(modelConverter::toDTO)
                .collect(Collectors.toList());
        return dtos;
    }

    @Override
    @Transactional
    public void add(ModelDTO modelDTO) {
        Model model = modelConverter.toEntity(modelDTO);
        modelRepository.persist(model);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Model model = modelRepository.findById(id);
        modelRepository.remove(model);
    }

    @Override
    @Transactional
    public void update(ModelDTO modelDTO) {
        Model model = modelConverter.toEntity(modelDTO);
        modelRepository.merge(model);
    }


}
