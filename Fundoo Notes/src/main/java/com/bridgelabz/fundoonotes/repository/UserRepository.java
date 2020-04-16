package com.bridgelabz.fundoonotes.repository;

import com.bridgelabz.fundoonotes.dto.UserDto;
import org.springframework.data.repository.CrudRepository;

//Interface extending the crud repository to access database values.
public interface UserRepository extends CrudRepository<UserDto, Integer> {
}
