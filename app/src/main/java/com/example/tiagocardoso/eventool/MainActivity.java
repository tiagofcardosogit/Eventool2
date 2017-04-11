package com.example.tiagocardoso.eventool;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void selectMainOpetion(View view){
        Intent intent = null;
        switch (view.getId()){
            case R.id.btnInserir:
                intent = new Intent(this,Criar_usuarioActivity.class);
                break;
            case R.id.btnListar:
                intent = new Intent(this,Listar_usuarioActivity.class);
                break;
        }
        if(intent != null){
            startActivity(intent);
        }
    }
}
