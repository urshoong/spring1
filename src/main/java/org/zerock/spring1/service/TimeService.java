package org.zerock.spring1.service;

import org.springframework.transaction.annotation.Transactional;

//
@Transactional
public interface TimeService {

    void addAll(String str);

}
