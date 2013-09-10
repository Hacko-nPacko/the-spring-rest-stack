package com.jl.crm.services;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
  * Repository for dealing with {@link Customer customer } records.
  *
  * @author Josh Long
  */

 public interface CustomerRepository extends PagingAndSortingRepository<Customer, Long> {

//   TODO  Disambiguate this endpoint from the other by specifying a RestResource annotation this is a side-effect of the
//    @RestResource(path = "findByUserIdPaged" )
//    Page<Customer> findByUserId(@Param("userId") Long userId, Pageable pageable);

	List<Customer> findByUserId(@Param("userId") Long userId);

	@Query ("SELECT c FROM Customer c WHERE  c.user.id = :userId AND (LOWER(concat(c.firstName, c.lastName)) LIKE :q   )")
	List<Customer> search(@Param("userId") Long userId,  @Param("q") String query);

}
