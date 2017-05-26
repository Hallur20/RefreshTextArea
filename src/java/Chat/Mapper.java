package Chat;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Hallur
 */
public class Mapper {
    public void delAllMsg(){
        String delete = "truncate table msg";
        try{
            PreparedStatement p = DBConnector.getConnection().prepareStatement(delete);
            p.executeUpdate();
        }catch(Exception ex){   
        }
    }
    public String getMsg() {
        String fill = "";
        String select = "SELECT * FROM refresh.msg;";
        try {
            PreparedStatement p = DBConnector.getConnection().prepareStatement(select);
            ResultSet rs = p.executeQuery();
            while (rs.next()) {
                fill += rs.getString("msg") + "\n";
            }
        } catch (Exception ex) {

        }
        return fill;
    }

    public void insMsg(String name, String msg){
        String insert = "insert into msg()values(?);";
        try{
            PreparedStatement p = DBConnector.getConnection().prepareStatement(insert);
            p.setString(1, name + ": " + msg);
            p.executeUpdate();
        } catch(Exception ex){
            
        }
    }
    
}
