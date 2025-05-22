package com.mycommerce.ecommerce.respoitory;

import com.mycommerce.ecommerce.models.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {}

