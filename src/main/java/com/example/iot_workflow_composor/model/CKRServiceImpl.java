package com.example.iot_workflow_composor.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CKRServiceImpl implements CKRService {
    
    @Autowired
    private CKRRepository ckrRepository;

    @Override
    public CKR findCKRById(long id) {
        return ckrRepository.findById(id);
    }

    @Override
    public CKR findCKRByIndex(String index) {
        return ckrRepository.findByIndex(index);
    }

    @Override
    public void save(CKR ckr) {
        ckrRepository.save(ckr);
    }

    @Override
    public void edit(CKR ckr) {
        ckrRepository.save(ckr);
    }

    @Override
    public void delete(long id) {
        ckrRepository.deleteById(id);
    }
}