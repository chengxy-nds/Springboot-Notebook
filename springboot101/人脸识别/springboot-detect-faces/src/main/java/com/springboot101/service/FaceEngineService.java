package com.springboot101.service;


import com.springboot101.entity.User;

public interface FaceEngineService {

    User detectFaces(String file);
}
