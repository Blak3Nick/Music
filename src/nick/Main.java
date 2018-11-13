package nick;

import nick.model.DataSource;

public class Main {

    public static void main(String[] args) {
        DataSource dataSource = new DataSource();
        if (!dataSource.open()) {
            System.out.println("Couldn't connect to the database");
            return;
        }
        dataSource.close();
    }
}
