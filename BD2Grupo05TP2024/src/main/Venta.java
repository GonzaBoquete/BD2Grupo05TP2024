package main;

import java.time.LocalDateTime;

public class Venta {
	private int nroTicket;
	private LocalDateTime fecha;
	private float valorVenta;
	private String formaPago;
	private Cliente cliente;
	private Empleado atendidoPor;
	private Empleado cobradoPor;
	private DetalleVenta detalleVenta;

	// Constructor
	public Venta(int nroTicket, LocalDateTime fecha, float valorVenta, String formaPago, Cliente cliente,
			Empleado atendidoPor, Empleado cobradoPor, DetalleVenta detalleVenta) {
		this.nroTicket = nroTicket;
		this.fecha = fecha;
		this.valorVenta = valorVenta;
		this.formaPago = formaPago;
		this.cliente = cliente;
		this.atendidoPor = atendidoPor;
		this.cobradoPor = cobradoPor;
		this.detalleVenta = detalleVenta;
	}

	// Getters y Setters
	public int getNroTicket() {
		return nroTicket;
	}

	public void setNroTicket(int nroTicket) {
		this.nroTicket = nroTicket;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public float getValorVenta() {
		return valorVenta;
	}

	public void setValorVenta(float valorVenta) {
		this.valorVenta = valorVenta;
	}

	public String getFormaPago() {
		return formaPago;
	}

	public void setFormaPago(String formaPago) {
		this.formaPago = formaPago;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Empleado getAtendidoPor() {
		return atendidoPor;
	}

	public void setAtendidoPor(Empleado atendidoPor) {
		this.atendidoPor = atendidoPor;
	}

	public Empleado getCobradoPor() {
		return cobradoPor;
	}

	public void setCobradoPor(Empleado cobradoPor) {
		this.cobradoPor = cobradoPor;
	}

	public DetalleVenta getDetalleVenta() {
		return detalleVenta;
	}

	public void setDetalleVenta(DetalleVenta detalleVenta) {
		this.detalleVenta = detalleVenta;
	}

	@Override
	public String toString() {
		return "\n*****DETALLE DE VENTA*****\n" + "Nro de ticket: " + nroTicket + "\n" + "Fecha: " + fecha + "\n"
				+ "Valor de venta: " + valorVenta + "\n" + "Forma de pago: " + formaPago + "\n" + "Cliente: " + cliente
				+ "\n" + "Atendido por: " + atendidoPor + "\n" + "Cobrado por: " + cobradoPor + "\n"
				+ "Detalle de venta: " + detalleVenta;
	}

}
