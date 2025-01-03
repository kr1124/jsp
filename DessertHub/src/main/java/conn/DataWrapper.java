package conn;

import java.sql.*;
import javax.sql.*;
import javax.naming.*;

public class DataWrapper {
    private int number;
    private ResultSet rs;

    // 생성자
    public DataWrapper(int number) {
        this.number = number;
    }
    public DataWrapper(int number, ResultSet rs) {
        this.number = number;
        this.rs = rs;
    }

    // Getter와 Setter
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public ResultSet getRs() {
        return rs;
    }

    public void setRs(ResultSet rs) {
        this.rs = rs;
    }

    public void close() {
        if(this.rs != null) {try {this.rs.close();} catch(SQLException e) {}}
    }
}
