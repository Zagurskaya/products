package com.gmail.zagurskaya.repository.impl;

import com.gmail.zagurskaya.repository.ModelRepository;
import com.gmail.zagurskaya.repository.model.Model;
import org.springframework.stereotype.Repository;

@Repository
public class ModelRepositoryImpl extends GenericRepositoryImpl<Long, Model> implements ModelRepository {


}
