package com.pidevteam.repository;

import com.pidevteam.entity.Holiday;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HolidayRepository extends JpaRepository<Holiday, Long> {
    Holiday findByEndDate(String endDate);
}
