package com.fire.service;


import com.fire.entity.User;

public interface FaceEngineService {

    User detectFaces(String file);
}
