package com.ayman.Honor.Schools.repository;
import com.ayman.Honor.Schools.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface AddressRepository extends JpaRepository<Address,Integer> {
}
