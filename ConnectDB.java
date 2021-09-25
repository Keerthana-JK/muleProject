    import java.sql.*;  
     
       
    public class ConnectDB {  
         /** 
         * Connect and perform DB Operations
         */  
        public static void connect() {  
            Connection conn = null;  
	    Statement stmt = null;
            try {  
                // db parameters 
		Class.forName("org.sqlite.JDBC"); 
                String url = "jdbc:sqlite:C:/Users/ACER/AppData/Local/Temp/Rar$EXa14116.6814/SQLiteStudio/MoviesDB";  
                // create a connection to the database  
                conn = DriverManager.getConnection(url);  
                  
                System.out.println("Connection to SQLite has been established.");  
		stmt = conn.createStatement();
		String sql = "CREATE TABLE IF NOT EXISTS Movies (movieName text PRIMARY KEY, actor text NOT NULL, actress text NOT NULL, year integer,director text)";  
		stmt.execute(sql);  
		System.out.println("Table Movies created");  
		
		stmt.executeUpdate("delete from Movies");
		System.out.println("Table Movies cleared");  

		sql = "INSERT INTO Movies (movieName, actor,actress,year,director) VALUES('Shershaah','Sidharth Malhotra','Kiara Advani',2021,'Vishnu Vardhan')";  
		int row=stmt.executeUpdate(sql);  
		if(row==1)
			System.out.println("Row Inserted Successfully");  
		else
			System.out.println("Row NOT inserted"); 
		sql = "INSERT INTO Movies (movieName, actor,actress,year,director) VALUES('La La Land','Ryan Gosling','Emma Stone',2016,'Damien Chazelle')";  
		row=stmt.executeUpdate(sql);  
		if(row==1)
			System.out.println("Row Inserted Successfully");  
		else
			System.out.println("Row NOT inserted");  
		sql = "INSERT INTO Movies (movieName, actor,actress,year,director) VALUES('Uri','Vicky Koushal','Yami Gautham',2019,'Aditya Dhar')";  
		row=stmt.executeUpdate(sql);  
		if(row==1)
			System.out.println("Row Inserted Successfully");  
		else
			System.out.println("Row NOT inserted");  
 		sql = "INSERT INTO Movies (movieName, actor,actress,year,director) VALUES('Life of Pi','Irrfan Khan','Shravanthi Sainath',2012,'Ang Nee')";  
		row=stmt.executeUpdate(sql);  
		if(row==1)
			System.out.println("Row Inserted Successfully");  
		else
			System.out.println("Row NOT inserted");  

		 sql = "SELECT * FROM Movies";  
		ResultSet rs = stmt.executeQuery(sql); 
		while (rs.next()) {  
                	System.out.println(rs.getString("movieName") +  "\t" +rs.getString("actor") + "\t" + rs.getString("actress")+ "\t" + rs.getString("year")+ "\t" + rs.getString("director"));  
            	}   
 
		stmt.close();
         	conn .close();
                  
            } catch (Exception e) {  
                System.out.println("Error 1 "+e.getMessage());  
            } finally {  
                try {  
                    if (conn != null) {  
                        conn.close(); 
 
                    }  
                } catch (SQLException ex) {  
                    System.out.println("Error 2 "+ex.getMessage());  
                }  
            }  
        }  
        /** 
         * @param args the command line arguments 
         */  
        public static void main(String[] args) {  
            connect();  
        }  
    }  