package com.example.practice.service;

import com.example.practice.daointerface.DocRepository;
import com.example.practice.model.Doc;
import com.example.practice.serviceinterface.DocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocServiceImpl implements DocService {
    @Autowired
    private DocRepository docRepository;

    @Override
    public List<Doc> getAll() {
        return docRepository.getList();
    }
}
