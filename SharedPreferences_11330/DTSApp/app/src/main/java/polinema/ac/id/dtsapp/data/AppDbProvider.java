package polinema.ac.id.dtsapp.data;

import android.arch.persistence.room.Room;
import android.content.Context;

public class AppDbProvider {
    private static DTSAppsDatabase instance;

    public static DTSAppsDatabase getInstance (Context context){
        if (AppDbProvider.instance == null){
            AppDbProvider.instance = Room.databaseBuilder(context, DTSAppsDatabase.class, "dtsapp.db").build();
            // Maaf pak pakai allowMainThreadQuery malah error, aku buka di dokumentasi android pakai build() malah bisa
        }

        return AppDbProvider.instance;
    }
}
