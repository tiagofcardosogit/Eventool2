package com.example.tiagocardoso.eventool;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;



public class Util {
    /**
     *Lê um arquivo da web via HTTP e converte o mesmo em String.
     *@param inputStream Stream do arquivo local no aplicativo
     *@return O arquivo convertido em String.
     */
    public static String webToString(InputStream inputStream) {
        InputStream localStream = inputStream;
        String localString = "";
        Writer writer = new StringWriter();
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(localStream, "UTF-8"));
            String line = reader.readLine();
            while (line != null) {
                writer.write(line);
                line = reader.readLine();
            }
            localString = writer.toString();
            writer.close();
            reader.close();
            localStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return localString;
    }

    public static List<Usuario> convertJSONtoUsuario(String jsonFile){
        List<Usuario> usuarios = new ArrayList<>();
        try {
            JSONArray mainObject = new JSONArray(jsonFile);

            for(int i = 0; i < mainObject.length(); i++){
                Usuario novoUsuario = new Usuario();
                JSONObject localObj = mainObject.getJSONObject(i);
                long id = localObj.getLong("ID_USUARIO");
                String nome = localObj.getString("NOME");
                String sobrenome = localObj.getString("SOBRENOME");
                String email = localObj.getString("EMAIL");
                int telefone = localObj.getInt("TELEFONE");
                novoUsuario.setID(id);
                novoUsuario.setNome(nome);
                novoUsuario.setSobrenome(sobrenome);
                novoUsuario.setEmail(email);
                novoUsuario.setTelefone();
                usuarios.add(novoUsuario);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return usuarios;
    }
}
