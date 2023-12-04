package bda.supermercado;

public class Venta {
    private String nombre;
    private double cantidad;
    private double valorUnitario;
    
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public double getCantidad() {
        return cantidad;
    }
    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }
    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public double getValorTotal() {
        return this.valorUnitario * this.cantidad;
    }

    public Venta(String nombre, double cantidad, double valorUnitario) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.valorUnitario = valorUnitario;
    }

}
