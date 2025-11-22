package com.example.agenda;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.agenda.DAO.InstitucionDao;
import com.example.agenda.DAO.TrabajoDao;
import com.example.agenda.basededatos.AppBaseDeDatos;
import com.example.agenda.entidades.Institucion;
import com.example.agenda.entidades.Trabajo;

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

            TrabajoDao dao = db.trabajoDao();

            InstitucionDao iDao = db.institucionDao();
            iDao.insert(new Institucion("casa", "Luis Vila", "PRIVADA"));
            Trabajo trabajo = new Trabajo();
            trabajo.fecha = "12-12-2025";
            trabajo.descripcion = "alguna descripcion";
            trabajo.estado = "pendiente";
            trabajo.subcategoria = "una materia";
            trabajo.institucion = iDao.findByAddress("Luis Vila").i_id;
            trabajo.tienehora = false;
            trabajo.notifica = false;
            trabajo.inicio = "hora inicio";
            trabajo.fin = "hora fin";

            dao.insertAll(trabajo);
        }).start();
        //AppBaseDeDatos db = Room.databaseBuilder(getApplicationContext(),
          //      AppBaseDeDatos.class, "agenda_local").build();


    }
}