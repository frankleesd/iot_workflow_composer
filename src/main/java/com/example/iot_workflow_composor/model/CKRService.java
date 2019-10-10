package com.example.iot_workflow_composor.model;

public interface CKRService {
    public CKR findCKRById(long id);

    public CKR findCKRByIndex(String index);

    public void save(CKR ckr);

    public void edit(CKR ckr);

    public void delete(long id);
}