package bda.supermercado;

public class Producto {
    private String nombre;
    private double precio;
    private double cantidad;
    private String descripcion;
    private String codigoBarras;
    private String tipoVenta;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public String getTipoVenta() {
        return tipoVenta;
    }

    public void setTipoVenta(String tipoVenta) {
        this.tipoVenta = tipoVenta;
    }

    public Producto(String nombre, double precio, int cantidadDisp, String descripcion, String codigoBarras, String tipoVenta){
        this.nombre = nombre;
        this. precio = precio;
        this.cantidad = cantidadDisp;
        this.descripcion = descripcion;
        this.codigoBarras = codigoBarras;
        this.tipoVenta = tipoVenta;
    }
}
