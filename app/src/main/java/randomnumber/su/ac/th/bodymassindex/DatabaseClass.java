package randomnumber.su.ac.th.bodymassindex;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import randomnumber.su.ac.th.bodymassindex.DaoClass.DaoClass;
import randomnumber.su.ac.th.bodymassindex.EntityClass.UserModel;

@Database(entities = (UserModel.class), version = 1)
public abstract class DatabaseClass extends RoomDatabase {

    public abstract DaoClass getDao();
    private static DatabaseClass instance;

    public static DatabaseClass getDatabase(final Context context){
        if(instance == null){
            synchronized (DatabaseClass.class){
                instance = Room.databaseBuilder
                        (context, DatabaseClass.class, "DATABASE").build();
            }
        }
        return instance;
    }
}
