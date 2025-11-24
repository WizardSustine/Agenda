package com.example.agenda;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.agenda.DAO.CategoriaDao;
import com.example.agenda.DAO.InstitucionDao;
import com.example.agenda.DAO.NotificaDao;
import com.example.agenda.DAO.SubcategoriaDao;
import com.example.agenda.DAO.TareaDao;
import com.example.agenda.basededatos.AppBaseDeDatos;
import com.example.agenda.entidades.Institucion;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        new Thread(() -> {
            AppBaseDeDatos db = AppBaseDeDatos.getDatabase(getApplicationContext());

            CategoriaDao cDao = db.categoriaDao();
            SubcategoriaDao sDao = db.subcategoriaDao();
            NotificaDao nDao = db.notificaDao();
            InstitucionDao iDao = db.institucionDao();
            TareaDao tDao = db.tareaDao();
            //iDao.insert(new Institucion("casa", "Luis Vila", "PRIVADA"));

        }).start();


    }
}