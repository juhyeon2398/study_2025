package org.joonzis.myprj.domain.owner.repository;

import org.joonzis.myprj.domain.owner.entity.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerRepository 
  extends JpaRepository<Owner, Integer> {
  
  
}
