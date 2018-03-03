package com.example.kevin.greendaoejemplo.Purposes;


import com.example.kevin.greendaoejemplo.utils.Core;
import com.example.kevin.greendaoejemplo.Purposes.DaoMaster;
import com.example.kevin.greendaoejemplo.Purposes.DaoSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Ariel on 03/03/2018.
 */

public class PurposesController implements PurposesOperations {

    DaoSession daoSession; ///Objeto de la sesion
    PurposesDao purposesDao;  //notasDao sera quien maneje las operaciones de la tabla


    public PurposesController(){
        Core.getInstance().DeleteAllBases(); //ESTO BORRA TODOS LOS DATOS DE LA BASE, QUITAR!!!!!!!
        daoSession = Core.getInstance().getDaoSession(); //Se recupera la sesion del singleton
        purposesDao = daoSession.getPurposesDao(); //se recupera el manejador de la sesion
        /*Aquí inserto una lista de datos en la base de datos*/

        purposesDao.insertInTx(getAllPurposes());
    }

    private List<Purposes> getAllPurposes(){
        return new ArrayList<Purposes>(){{
            add(new Purposes(1L,"Correr","Correr",50,new Date(),false));
            add(new Purposes(2L,"Aprender ingles","exit o",25,new Date(),false));
            add(new Purposes(3L,"Aprender linux","sudo su",75,new Date(),false));

        }};
    }


    @Override
    public boolean save(Purposes purposes) {
        try{
            purposesDao.save(purposes);
            return true;
        }
        catch(Exception e)
        {
            return false;
        }
    }

    @Override
    public boolean update(Purposes purposes) {
        try{
            purposesDao.update(purposes);
            return true;
        }
        catch(Exception e)
        {
            return false;
        }
    }

    @Override
    public boolean delete(Purposes purposes) {
        try{
            purposesDao.delete(purposes);
            return true;
        }
        catch(Exception e)
        {
             return false;
        }
    }

    @Override
    public List<Purposes> getAll() {
        return purposesDao.queryBuilder().orderAsc(PurposesDao.Properties.Percentage).list();
        ///purposesDao.loadAll();
    }

    @Override
    public Purposes get(Long ID) {
        return purposesDao.load(ID);
    }


}
