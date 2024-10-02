package com.web_project.school.service;

import java.util.List;
import java.util.UUID;

public interface GenericService<T> {
    List<T> findAll();
    T findById(UUID id);
    T add(T entity);
    T update(T entity);
    void delete(UUID id);
}