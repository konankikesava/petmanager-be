package ee.cgi.kk.petmanager.repository;


import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import ee.cgi.kk.petmanager.domain.Pet;


@Repository("petRepository")
public interface PetRepository extends PagingAndSortingRepository<Pet, Long>, QuerydslPredicateExecutor {
}
