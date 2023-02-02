package com.jobstack.jobstack.repos;

import com.jobstack.jobstack.model.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<Post,String > {
}
