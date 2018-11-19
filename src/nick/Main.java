package nick;

import nick.model.Artist;
import nick.model.DataSource;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        DataSource dataSource = new DataSource();
        if (!dataSource.open()) {
            System.out.println("Couldn't connect to the database");
            return;
        }
        List<Artist> artists = dataSource.queryArtist(2);
        if (artists == null) {
            System.out.println("no artists");
            return;
        }

        for (Artist artist : artists) {
            System.out.println("ID = " + artist.getId() + ", Name = " + artist.getName());
        }

        List<String> albumsForArtist =
                dataSource.queryAlbumsForArtist("Iron Maiden", DataSource.ORDER_BY_ASC);
        for (String album : albumsForArtist) {
            System.out.println(album);
        }
        dataSource.close();
    }
}
