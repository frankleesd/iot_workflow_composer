package com.example.iot_workflow_composor.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CKRRepository extends JpaRepository<CKR, Long> {
    CKR findById(long id);
    void deleteById(Long id);
    CKR findByIndex(String index);
}