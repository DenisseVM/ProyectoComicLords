/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author denisse
 */
public class Manga{
    int codigo, precio, stock, nroTomo, mesesSerial;
    String nombre, autor, editorial, demografia;
    boolean estado;

    public Manga() {
    }

    public Manga(int codigo, int precio, int stock, int nroTomo, int mesesSerial, String nombre, String autor, String editorial, String demografia, boolean estado) {
        this.codigo = codigo;
        this.precio = precio;
        this.stock = stock;
        this.nroTomo = nroTomo;
        this.mesesSerial = mesesSerial;
        this.nombre = nombre;
        this.autor = autor;
        this.editorial = editorial;
        this.demografia = demografia;
        this.estado = estado;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getNroTomo() {
        return nroTomo;
    }

    public void setNroTomo(int nroTomo) {
        this.nroTomo = nroTomo;
    }

    public int getMesesSerial() {
        return mesesSerial;
    }

    public void setMesesSerial(int mesesSerial) {
        this.mesesSerial = mesesSerial;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getDemografia() {
        return demografia;
    }

    public void setDemografia(String demografia) {
        this.demografia = demografia;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Manga{" + "codigo=" + codigo + ", precio=" + precio + ", stock=" + stock + ", nroTomo=" + nroTomo + ", mesesSerial=" + mesesSerial + ", nombre=" + nombre + ", autor=" + autor + ", editorial=" + editorial + ", demografia=" + demografia + ", estado=" + estado + '}';
    }

}
