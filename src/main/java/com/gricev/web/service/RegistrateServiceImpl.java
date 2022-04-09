package com.gricev.web.service;

import com.gricev.web.models.RegistrateDto;
import com.gricev.web.models.RegistrateEntity;
import com.gricev.web.repo.RegistrateEntityRepository;
import org.springframework.stereotype.Service;

@Service
public class RegistrateServiceImpl implements RegistrateService {

    private final RegistrateEntityRepository registrateEntityRepository;

    public RegistrateServiceImpl(RegistrateEntityRepository registrateEntityRepository) {
        this.registrateEntityRepository = registrateEntityRepository;
    }

    @Override
    public RegistrateDto addUser(RegistrateDto registrateDto) {
        RegistrateEntity registrateEntity = registrateEntityRepository.save(fromRegistrateDto(registrateDto));
        return fromRegistrateEntity(registrateEntity);
    }

    private RegistrateEntity fromRegistrateDto(RegistrateDto registrateDto) {
        RegistrateEntity registrateEntity = new RegistrateEntity();
        registrateEntity.setEmail(registrateDto.getEmail());
        registrateEntity.setFirstName(registrateDto.getFirstName());
        registrateEntity.setLastName(registrateDto.getLastName());
        registrateEntity.setSex(registrateDto.getSex());
        registrateEntity.setCountry(registrateDto.getCountry());
        registrateEntity.setPassword(registrateDto.getPassword());
        registrateEntity.setPhoneNumber(registrateDto.getPhoneNumber());

        return registrateEntity;
    }

    private RegistrateDto fromRegistrateEntity(RegistrateEntity registrateEntity) {
        RegistrateDto registrateDto = new RegistrateDto();
        registrateDto.setEmail(registrateEntity.getEmail());
        registrateDto.setFirstName(registrateEntity.getFirstName());
        registrateDto.setLastName(registrateEntity.getLastName());
        registrateDto.setSex(registrateEntity.getSex());
        registrateDto.setCountry(registrateEntity.getCountry());
        registrateDto.setPassword(registrateEntity.getPassword());
        registrateDto.setPhoneNumber(registrateEntity.getPhoneNumber());

        return registrateDto;
    }
}
