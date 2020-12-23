package dts.id.caloriesdatabase.db.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.sql.Date;
import java.util.List;

import dts.id.caloriesdatabase.db.entity.LogCaloriesEntity;

@Dao
public interface LogCaloriesDao {
    //Todo 2 Melengkapi DAO
    @Insert
    void InsertLogCaloriesEntity(LogCaloriesEntity logCaloriesEntity);

    @Query("Select * from log_calories where tanggal = :date")
    LiveData<List<LogCaloriesEntity>> GetAllLogCalories(String date);



}
