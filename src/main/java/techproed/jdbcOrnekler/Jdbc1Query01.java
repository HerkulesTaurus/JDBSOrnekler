package techproed.jdbcOrnekler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Jdbc1Query01 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

	
	// 1) ilgili driver i yuklemeliyiz, tv nin fisini tak, baska birsey calismasin, ne calisacagini bilsin
			
		Class.forName("com.mysql.cj.jdbc.Driver");
	
	
	// 2) baglantı olusturmaliyiz. sifreleri girmaliyiz--  tırnak ıcın ıfade googledan alındı. sondaki iki tırnakici kullanıcı adı ve sıfresı
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys?serverTimezone=UTC", "root", "3680");
	
	
    // 3) SQL komutlari icin bir Statement nesnesi olustur her kanal icin kumanda da yer ayarlamak 
		
	    Statement st =	con.createStatement();
		

	// 4) SQL ifadeleri yazabilir ve calistirabiliriz
	    
	  ResultSet veri = st.executeQuery("SELECT isim, maas FROM personel WHERE id=123456789"); // sql den sonucları bu komut ıle cektık

	    
    // 5) sonucları aldık ve isledik
	    
	    while (veri.next()) {
	    	System.out.println(veri.getString("isim") + veri.getInt("maas"));
		
	    	System.out.println("Personel Adi :" + veri.getString(1)+" " + "Maas :"+ veri.getInt(2));
	    											// burda 1 istenenlerın sırasındakı verıyı karsılıyor
	    }
	    
	// 6) olusturulan nesneleri bellekten kaldıralım     *******KAPANIS******* 
	    
	    con.close();
	    st.close();
	    veri.close();
	
	
	
	
	
	}

}
