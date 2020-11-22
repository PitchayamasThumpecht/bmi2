package randomnumber.su.ac.th.bodymassindex.EntityClass;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "user")
public class UserModel {

    @PrimaryKey(autoGenerate = true)
    private String id;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "weight")
    private String weight;

    @ColumnInfo(name = "height")
    private String height;

    public String getKey(){
        return id;
    }
    public void setKey(String id){
        this.id = id;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getWeight(){
        return weight;
    }
    public void setWeight(String weight){
        this.weight = weight;
    }
    public String getHeight(){
        return height;
    }
    public void setHeight(String height){
        this.height = height;
    }
}
