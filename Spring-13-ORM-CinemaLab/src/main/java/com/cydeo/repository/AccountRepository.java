package com.cydeo.repository;

import com.cydeo.entity.Account;
import com.cydeo.enums.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to list all accounts with a specific country or state
    List<Account> findByCountryOrState(String country, String state);

    //Write a derived query to list all accounts with age lower than or equal to a specific value
    List<Account> findAllByAgeLessThanEqual(Integer age);

    //Write a derived query to list all accounts with a specific role
    List<Account> findByRole(UserRole role);

    //Write a derived query to list all accounts between a range of ages
    List<Account> findByAgeIsBetween(Integer min, Integer max);

    //Write a derived query to list all accounts where the beginning of the address contains the keyword
    List<Account> findByAddressStartingWith(String prefix);

    //Write a derived query to sort the list of accounts with age
    List<Account> findAllByOrderByAgeDesc();

    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query that returns all accounts
    @Query("select a from Account a")
    List<Account> getAllAccount();

    //Write a JPQL query to list all admin accounts
    @Query("Select a from Account a Where a.role = 'ADMIN'")
    List<Account> adminAccounts();

    //Write a JPQL query to sort all accounts with age
    @Query("Select a from Account a order by a.age")
    List<Account> getAccountsInAgeOrder();

    // ------------------- Native QUERIES ------------------- //

    //Write a native query to read all accounts with an age lower than a specific value
    @Query(value="select * from account_details where age < ?1",
          nativeQuery = true)
    List<Account> accountsLowerThanThisAge(Integer age);

    @Query(value="select * from account_details where age < :x",
            nativeQuery = true)
    List<Account> accountsLowerThanThisParam(@Param("x") Integer age);


    //Write a native query to read all accounts that a specific value can be containable in the name, address, country, state city

    @Query(value="select * from account_details " +
            "where name ilike concat('%',?1,'%') " +
            "OR address ilike concat('%',?1,'%') " +
            "OR country ilike concat('%',?1,'%') " +
            "OR state ilike concat('%',?1,'%') " +
            "OR city ilike concat('%',?1,'%')",
            nativeQuery = true)
    List<Account> strInNameAddressCountryStateCity(String str);

}