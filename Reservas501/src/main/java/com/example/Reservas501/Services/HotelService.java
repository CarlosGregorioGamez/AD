package com.example.Reservas501.Services;

import com.example.Reservas501.Repositories.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HotelService{

    @Autowired
    private HotelRepository repository;
}
