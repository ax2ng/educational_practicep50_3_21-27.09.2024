package com.web_project.school.service.impl;

import com.web_project.school.repository.StudentRepository;
import com.web_project.school.service.GenericService;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.UUID;

public class GenericServiceImpl<T> implements GenericService<T> {


    private final JpaRepository<T, UUID> repository;

    public GenericServiceImpl(JpaRepository<T, UUID> repository) {
        this.repository = repository;
    }

    @Override
    public List<T> findAll() {
        return repository.findAll();
    }


    @Override
    public T findById(UUID id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public T add(T entity) {
        return repository.save(entity);
    }

    @Override
    public T update(T entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(UUID id) {
        repository.deleteById(id);
    }
}