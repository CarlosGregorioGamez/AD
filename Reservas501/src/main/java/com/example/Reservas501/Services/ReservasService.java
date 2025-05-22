package com.example.Reservas501.Services;

import com.example.Reservas501.Repositories.ReservasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservasService {

    @Autowired
    private ReservasRepository repository;
}
