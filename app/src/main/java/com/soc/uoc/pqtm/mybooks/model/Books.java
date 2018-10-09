package com.soc.uoc.pqtm.mybooks.model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


//Classe que te la funció de emplenar una colecció d'objectes LLibre amb el identificador
public class Books {
    public static List<BookItem> ITEMS=new ArrayList<BookItem>();
    public static Map<Integer, BookItem> ITEM_MAP = new HashMap<Integer, BookItem>();
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");



    static{

        try{
            addBook(new BookItem(1,"Harry Potter","J.R.Rowling",dateFormat.parse("10/10/2000"),"Harry Potter is a series of fantasies","ha"));
            addBook(new BookItem(2,"En llamas","Suzanne Collins",dateFormat.parse("09/10/2004"),"Pero como ya sucediÃ³ en la primera parte de ","lla"));

        }catch(java.text.ParseException e){
            e.printStackTrace();
        }




    }

    private static void addBook(Books.BookItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.identificador, item);
    }

    public static class BookItem {

        private Integer identificador;
        private String titol;
        private String autor;
        private Date dataPublicacio;
        private String descripcio;
        private String urlImatge;



        public BookItem(Integer identificador, String titol, String autor, Date dataPublicacio, String descripcio, String urlImatge) {
            this.identificador = identificador;
            this.titol = titol;
            this.autor = autor;
            this.dataPublicacio = dataPublicacio;
            this.descripcio = descripcio;
            this.urlImatge = urlImatge;
        }

        public String getDescripcio() {
            return descripcio;
        }

        public void setDescripcio(String descripcio) {
            this.descripcio = descripcio;
        }

        public String getUrlImatge() {
            return urlImatge;
        }

        public void setUrlImatge(String urlImatge) {
            this.urlImatge = urlImatge;
        }

        public Integer getIdentificador() {

            return identificador;
        }

        public void setIdentificador(Integer identificador) {
            this.identificador = identificador;
        }

        public String getTitol() {
            return titol;
        }

        public void setTitol(String titol) {
            this.titol = titol;
        }

        public String getAutor() {
            return autor;
        }

        public void setAutor(String autor) {
            this.autor = autor;
        }

        public Date getDataPublicacio() {
            return dataPublicacio;
        }

        public void setDataPublicacio(Date dataPublicacio) {
            this.dataPublicacio = dataPublicacio;
        }

        @Override
        public String toString() {
            return "BookItem{" +
                    "identificador=" + identificador +
                    ", titol='" + titol + '\'' +
                    ", autor='" + autor + '\'' +
                    ", dataPublicacio=" + dataPublicacio +
                    ", descripcio='" + descripcio + '\'' +
                    ", urlImatge='" + urlImatge + '\'' +
                    '}';
        }
    }

}
