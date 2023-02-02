package com.jobstack.jobstack.repos;

import com.jobstack.jobstack.model.Post;

import java.util.List;

public interface SearchRepository {

    List<Post> findByText(String txt);
}
