package com.gricev.web.repo;

import com.gricev.web.models.Post;
import com.gricev.web.models.RegistrateEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RegistrateEntityRepository extends CrudRepository<RegistrateEntity, Long> {

    List<RegistrateEntity> findByEmail(String email);
    List<RegistrateEntity> findByPassword(String password);
    List<RegistrateEntity> findByEmailAndPassword(String email, String password);

}
