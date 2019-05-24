package com.github.zuratikaradze.dbfileupload.repository;

import com.github.zuratikaradze.dbfileupload.model.DBFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DBFileRepository extends JpaRepository<DBFile, Long> {
}
