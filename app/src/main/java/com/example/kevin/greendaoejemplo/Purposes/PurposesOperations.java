package com.example.kevin.greendaoejemplo.Purposes;

import com.example.kevin.greendaoejemplo.Purposes.Purposes;

import java.util.List;

/**
 * Created by Ariel on 03/03/2018.
 */

public interface PurposesOperations {

    boolean save(Purposes purposes);
    boolean update(Purposes purposes);
    boolean delete(Purposes purposes);
    List<Purposes> getAll();
    Purposes get(Long ID);
}
