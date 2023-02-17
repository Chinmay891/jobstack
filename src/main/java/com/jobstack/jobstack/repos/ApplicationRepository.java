package com.jobstack.jobstack.repos;

import com.jobstack.jobstack.model.Application;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ApplicationRepository extends MongoRepository<Application,String> {
}
