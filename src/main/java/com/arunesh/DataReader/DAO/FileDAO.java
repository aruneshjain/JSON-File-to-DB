package com.arunesh.DataReader.DAO;

import com.arunesh.DataReader.Model.JSONdata;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public interface FileDAO extends JpaRepository<JSONdata,String> {
}
