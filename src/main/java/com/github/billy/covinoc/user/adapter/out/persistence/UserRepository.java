package com.github.billy.covinoc.user.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface UserRepository extends JpaRepository<UserJpaEntity, Integer> {

  void deleteByNumberId(String numberId);

  UserJpaEntity findByNumberId(String numberId);
}
