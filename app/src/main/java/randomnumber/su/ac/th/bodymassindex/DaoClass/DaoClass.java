package randomnumber.su.ac.th.bodymassindex.DaoClass;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import randomnumber.su.ac.th.bodymassindex.EntityClass.UserModel;

@Dao
public interface DaoClass {

    @Insert
    void insertAllData(UserModel model);

    @Query("select * from user")
    List<UserModel> getAllData();
}
