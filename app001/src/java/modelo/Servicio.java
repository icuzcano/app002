
package modelo;

import javax.naming.spi.DirStateFactory;

import java.sql.*;

public class Servicio {
    
    public int sumar(int a, int b){
    return a+b;
    }
    
    public double operacion(int a, int b, char c){
    double r=0;
    switch(c){
    case '+': r=a+b;break;
    case '-': r=a-b;break;
    case '*': r=a*b;break;
    case '/': r=a/b;break;
    }
    return r;
    }
    
    public ResultSet paisesPorRegion(int region) throws Exception{
    String sql="select * from countries where region_id=?";
    Class.forName("oracle.jdbc.OracleDriver");
    Connection cn= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE",
				"hr","oracle");
            PreparedStatement pst= cn.prepareStatement(sql);
            pst.setInt(1,region);
            return pst.executeQuery();
    
    
    }
    
}
